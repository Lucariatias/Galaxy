package io.github.lucariatias.galaxy;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JButton;

import org.bukkit.Bukkit;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GalaxyExperienceFrame extends JFrame {

	private static final long serialVersionUID = -8935437511453385425L;
	
	private JPanel contentPane;
	private JTextField textField;
	private JSpinner spinner;

	/**
	 * Create the frame.
	 */
	public GalaxyExperienceFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setBounds(73, 6, 371, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPlayer = new JLabel("Player:");
		lblPlayer.setBounds(6, 12, 61, 16);
		contentPane.add(lblPlayer);
		
		JLabel lblExperience = new JLabel("Experience:");
		lblExperience.setBounds(6, 40, 72, 16);
		contentPane.add(lblExperience);
		
		spinner = new JSpinner();
		spinner.setBounds(90, 34, 107, 28);
		contentPane.add(spinner);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (Bukkit.getServer().getPlayer(textField.getText()) != null) {
					Bukkit.getServer().getPlayer(textField.getText()).setExp(Bukkit.getServer().getPlayer(textField.getText()).getExp() + (Integer) spinner.getValue());
				}
			}
		});
		btnAdd.setBounds(6, 243, 117, 29);
		contentPane.add(btnAdd);
		
		JButton btnSet = new JButton("Set");
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Bukkit.getServer().getPlayer(textField.getText()).setExp((Integer) spinner.getValue());
			}
		});
		btnSet.setBounds(327, 243, 117, 29);
		contentPane.add(btnSet);
	}
}
