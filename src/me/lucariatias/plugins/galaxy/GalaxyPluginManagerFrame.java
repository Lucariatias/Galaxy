package me.lucariatias.plugins.galaxy;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import javax.swing.JButton;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GalaxyPluginManagerFrame extends JFrame {

	private static final long serialVersionUID = 1213495508043729103L;
	
	private JPanel contentPane;
	private JComboBox comboBox;

	/**
	 * Create the frame.
	 */
	public GalaxyPluginManagerFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		List<String> pluginNames = new ArrayList<String>();
		if (Bukkit.getServer() != null) {
			for (Plugin plugin : Bukkit.getServer().getPluginManager().getPlugins()) {
				pluginNames.add(plugin.getName());
			}
		}
		comboBox = new JComboBox(pluginNames.toArray());
		comboBox.setBounds(6, 6, 438, 27);
		contentPane.add(comboBox);
		
		JButton btnEnable = new JButton("Enable");
		btnEnable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Bukkit.getServer().getPluginManager().enablePlugin(Bukkit.getServer().getPluginManager().getPlugin((String) comboBox.getSelectedItem()));
			}
		});
		btnEnable.setBounds(135, 45, 117, 29);
		contentPane.add(btnEnable);
		
		JButton btnDisable = new JButton("Disable");
		btnDisable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Bukkit.getServer().getPluginManager().disablePlugin(Bukkit.getServer().getPluginManager().getPlugin((String) comboBox.getSelectedItem()));
			}
		});
		btnDisable.setBounds(135, 86, 117, 29);
		contentPane.add(btnDisable);
		
		JButton btnEditConfig = new JButton("Edit config");
		btnEditConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							GalaxyConfigEditorFrame frame = new GalaxyConfigEditorFrame(Bukkit.getServer().getPluginManager().getPlugin((String) comboBox.getSelectedItem()));
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnEditConfig.setBounds(6, 45, 117, 29);
		contentPane.add(btnEditConfig);
		
		JButton btnReload = new JButton("Reload");
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Bukkit.getServer().getPluginManager().disablePlugin(Bukkit.getServer().getPluginManager().getPlugin((String) comboBox.getSelectedItem()));
				Bukkit.getServer().getPluginManager().enablePlugin(Bukkit.getServer().getPluginManager().getPlugin((String) comboBox.getSelectedItem()));
			}
		});
		btnReload.setBounds(135, 127, 117, 29);
		contentPane.add(btnReload);
		
		JButton btnReloadConfig = new JButton("Reload config");
		btnReloadConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Bukkit.getServer().getPluginManager().getPlugin((String) comboBox.getSelectedItem()).reloadConfig();
			}
		});
		btnReloadConfig.setBounds(6, 86, 117, 29);
		contentPane.add(btnReloadConfig);
	}
}
