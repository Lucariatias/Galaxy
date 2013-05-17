package me.lucariatias.plugins.galaxy;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.bukkit.Bukkit;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GalaxyBroadcastFrame extends JFrame {

	private static final long serialVersionUID = 875625482591698959L;
	
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public GalaxyBroadcastFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(6, 6, 309, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnBroadcast = new JButton("Broadcast");
		btnBroadcast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Bukkit.getServer().broadcastMessage(textField.getText());
			}
		});
		btnBroadcast.setBounds(327, 7, 117, 29);
		contentPane.add(btnBroadcast);
	}

}
