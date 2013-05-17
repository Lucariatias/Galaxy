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

public class GalaxyBanFrame extends JFrame {

	private static final long serialVersionUID = 322758644856606490L;
	
	private JPanel contentPane;
	private JTextField txtPlayer;
	private JTextField txtReason;

	/**
	 * Create the frame.
	 */
	public GalaxyBanFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPlayer = new JTextField();
		txtPlayer.setBounds(63, 6, 69, 28);
		contentPane.add(txtPlayer);
		txtPlayer.setColumns(10);
		
		JLabel lblPlayer = new JLabel("Player: ");
		lblPlayer.setBounds(6, 12, 45, 16);
		contentPane.add(lblPlayer);
		
		JButton btnBan = new JButton("Ban");
		btnBan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Bukkit.getOfflinePlayer(txtPlayer.getText()).setBanned(true);
				if (Bukkit.getOfflinePlayer(txtPlayer.getText()).isOnline()) {
					Bukkit.getServer().getPlayer(txtPlayer.getText()).kickPlayer("Banned: " + txtReason.getText());
				}
			}
		});
		btnBan.setBounds(331, 7, 117, 29);
		contentPane.add(btnBan);

		JButton btnUnban = new JButton("Unban");
		btnUnban.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Bukkit.getOfflinePlayer(txtPlayer.getText()).setBanned(false);
			}
		});
		btnUnban.setBounds(331, 45, 117, 29);
		contentPane.add(btnUnban);
		
		JLabel lblReason = new JLabel("Reason:");
		lblReason.setBounds(144, 12, 61, 16);
		contentPane.add(lblReason);
		
		txtReason = new JTextField();
		txtReason.setBounds(217, 6, 102, 28);
		contentPane.add(txtReason);
		txtReason.setColumns(10);
	}
}
