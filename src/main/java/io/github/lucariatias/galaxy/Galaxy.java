package io.github.lucariatias.galaxy;

import java.awt.EventQueue;

import org.bukkit.plugin.java.JavaPlugin;

public class Galaxy extends JavaPlugin {
	
	private GalaxyFrame frame;
	
	public static void main(String[] args) {
		Galaxy galaxy = new Galaxy();
		galaxy.onEnable();
	}
	
	public void onEnable() {
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
