package me.lucariatias.plugins.galaxy;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import org.bukkit.Bukkit;
import org.bukkit.World;

public class GalaxyTimeFrame extends JFrame {

	private static final long serialVersionUID = 4899347347323005132L;
	
	private JPanel contentPane;
	private JComboBox comboBoxWorld;
	private JSpinner spinner;

	/**
	 * Create the frame.
	 */
	public GalaxyTimeFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		spinner = new JSpinner();
		spinner.setBounds(6, 47, 438, 28);
		contentPane.add(spinner);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Bukkit.getServer().getWorld((String) comboBoxWorld.getSelectedItem()).setTime(Bukkit.getServer().getWorld((String) comboBoxWorld.getSelectedItem()).getTime() + (Integer) spinner.getValue());
			}
		});
		btnAdd.setBounds(6, 87, 438, 29);
		contentPane.add(btnAdd);
		
		JButton btnSet = new JButton("Set");
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Bukkit.getServer().getWorld((String) comboBoxWorld.getSelectedItem()).setTime((Integer) spinner.getValue());
			}
		});
		btnSet.setBounds(6, 128, 438, 29);
		contentPane.add(btnSet);
		
		List<String> worldNames = new ArrayList<String>();
		for (World world : Bukkit.getServer().getWorlds()) {
			worldNames.add(world.getName());
		}
		comboBoxWorld = new JComboBox(worldNames.toArray());
		comboBoxWorld.setBounds(6, 8, 438, 27);
		contentPane.add(comboBoxWorld);
	}

}
