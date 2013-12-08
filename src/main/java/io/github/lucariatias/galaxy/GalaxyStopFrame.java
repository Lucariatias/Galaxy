package io.github.lucariatias.galaxy;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.bukkit.Bukkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GalaxyStopFrame extends JFrame {

	private static final long serialVersionUID = 6196293733769179503L;
	
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public GalaxyStopFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Bukkit.getServer().shutdown();
			}
		});
		btnStop.setBounds(6, 6, 438, 29);
		contentPane.add(btnStop);
	}

}
