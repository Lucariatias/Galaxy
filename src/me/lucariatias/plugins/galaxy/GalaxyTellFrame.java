package me.lucariatias.plugins.galaxy;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GalaxyTellFrame extends JFrame {

	private static final long serialVersionUID = -1733323916350571089L;
	
	private JPanel contentPane;
	private JTextField textFieldPlayer;
	private JTextField textFieldMessage;

	/**
	 * Create the frame.
	 */
	public GalaxyTellFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		textFieldPlayer = new JTextField();
		textFieldPlayer.setBounds(110, 6, 134, 28);
		contentPane.add(textFieldPlayer);
		textFieldPlayer.setColumns(10);
		
		JLabel lblPlayer = new JLabel("Player:");
		lblPlayer.setBounds(6, 12, 61, 16);
		contentPane.add(lblPlayer);
		
		JLabel lblMessage = new JLabel("Message:");
		lblMessage.setBounds(6, 52, 61, 16);
		contentPane.add(lblMessage);
		
		textFieldMessage = new JTextField();
		textFieldMessage.setBounds(110, 46, 334, 28);
		contentPane.add(textFieldMessage);
		textFieldMessage.setColumns(10);
		
		JButton btnTell = new JButton("Tell");
		btnTell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Bukkit.getServer().getPlayer(textFieldPlayer.getText()).sendMessage(ChatColor.GRAY + textFieldMessage.getText());
			}
		});
		btnTell.setBounds(6, 243, 438, 29);
		contentPane.add(btnTell);
	}

}
