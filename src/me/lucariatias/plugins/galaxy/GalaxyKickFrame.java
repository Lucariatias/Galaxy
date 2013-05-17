package me.lucariatias.plugins.galaxy;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import org.bukkit.Bukkit;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GalaxyKickFrame extends JFrame {

	private static final long serialVersionUID = 3286268525191380103L;
	
	private JPanel contentPane;
	private JTextField txtPlayer;
	private JTextField txtReason;

	/**
	 * Create the frame.
	 */
	public GalaxyKickFrame() {
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
		
		JLabel lblReason = new JLabel("Reason:");
		lblReason.setBounds(6, 52, 61, 16);
		contentPane.add(lblReason);
		
		txtReason = new JTextField();
		txtReason.setBounds(79, 46, 134, 28);
		contentPane.add(txtReason);
		txtReason.setColumns(10);
		
		JButton btnKick = new JButton("Kick");
		btnKick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (Bukkit.getServer().getPlayer(txtPlayer.getText()) != null) {
					Bukkit.getServer().getPlayer(txtPlayer.getText()).kickPlayer("Kicked: " + txtReason.getText());
				}
			}
		});
		btnKick.setBounds(6, 80, 117, 29);
		contentPane.add(btnKick);
	}

}
