package io.github.lucariatias.galaxy;

import java.awt.Color;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Galaxy extends JavaPlugin {
	
	private GalaxyFrame frame;
	
	public static void main(String[] args) {
		Galaxy galaxy = new Galaxy();
		galaxy.onEnable();
	}
	
	public void onEnable() {
		if (getServer() != null) {
			saveDefaultConfig();
			File themeDirectory = new File(getDataFolder().getPath() + File.separator + "themes");
			if (!themeDirectory.exists()) {
				themeDirectory.mkdir();
				saveResource("themes/dark.yml", false);
			}
			File themeFile = new File(themeDirectory.getPath() + File.separator + getConfig().getString("theme") + ".yml");
			if (themeFile.exists()) {
				YamlConfiguration themeConfig = new YamlConfiguration();
				try {
					themeConfig.load(themeFile);
					for (String key : themeConfig.getKeys(false)) {
						org.bukkit.Color bukkitColor = themeConfig.getColor(key);
						UIManager.put(key, new Color(bukkitColor.getRed(), bukkitColor.getGreen(), bukkitColor.getBlue()));
					}
				} catch (FileNotFoundException exception) {
					exception.printStackTrace();
				} catch (IOException exception) {
					exception.printStackTrace();
				} catch (InvalidConfigurationException exception) {
					exception.printStackTrace();
				}
			}
		}
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (UnsupportedLookAndFeelException exception) {
		    exception.printStackTrace();
		} catch (ClassNotFoundException exception) {
		    exception.printStackTrace();
		} catch (InstantiationException exception) {
		    exception.printStackTrace();
		} catch (IllegalAccessException exception) {
		    exception.printStackTrace();
		}
		this.openUI();
	}
	
	public void onDisable() {
		this.closeUI();
	}
	
	public void openUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new GalaxyFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void closeUI() {
		frame.dispose();
	}
	
	public void addPlanet(Planet planet) {
		frame.panel.addPlanet(planet);
	}

}
