package me.lucariatias.plugins.galaxy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.bukkit.Bukkit;

public class GalaxyOpFrame extends JFrame {

	private static final long serialVersionUID = -2587399446698965230L;
	
	private JPanel contentPane;
	private JTextField txtPlayer;
	private JTextField txtMessage;
	private JButton btnDeop;

	/**
	 * Create the frame.
	 */
	public GalaxyOpFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		txtPlayer = new JTextField();
		txtPlayer.setBounds(79, 6, 134, 28);
		contentPane.add(txtPlayer);
		txtPlayer.setColumns(10);
		
		JLabel lblPlayer = new JLabel("Player: ");
		lblPlayer.setBounds(6, 12, 61, 16);
		contentPane.add(lblPlayer);
		
		JLabel lblMessage = new JLabel("Message:");
		lblMessage.setBounds(6, 52, 61, 16);
		contentPane.add(lblMessage);
		
		txtMessage = new JTextField();
		txtMessage.setText("\u00A7eYou are now op!");
		txtMessage.setBounds(79, 46, 134, 28);
		contentPane.add(txtMessage);
		txtMessage.setColumns(10);
		
		JButton btnOp = new JButton("Op");
		btnOp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Bukkit.getOfflinePlayer(txtPlayer.getText()).setOp(true);
				if (Bukkit.getOfflinePlayer(txtPlayer.getText()).isOnline()) {
					Bukkit.getServer().getPlayer(txtPlayer.getText()).sendMessage(txtMessage.getText());
				}
			}
		});
		btnOp.setBounds(6, 80, 207, 29);
		contentPane.add(btnOp);
		
		btnDeop = new JButton("Deop");
		btnDeop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bukkit.getOfflinePlayer(txtPlayer.getText()).setOp(false);
				if (Bukkit.getOfflinePlayer(txtPlayer.getText()).isOnline()) {
					Bukkit.getServer().getPlayer(txtPlayer.getText()).sendMessage(txtMessage.getText());
				}
			}
		});
		btnDeop.setBounds(225, 80, 219, 29);
		contentPane.add(btnDeop);
	}

}
