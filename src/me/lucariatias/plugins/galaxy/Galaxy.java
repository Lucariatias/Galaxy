package me.lucariatias.plugins.galaxy;

import org.bukkit.plugin.java.JavaPlugin;

public class Galaxy extends JavaPlugin {
	
	private GalaxyUI frame;
	
	public void onEnable() {
		this.getLogger().info(this + " is now enabled!");
		this.openUI();
	}
	
	public void onDisable() {
		this.getLogger().info(this + " is now disabled.");
		this.closeUI();
	}
	
	public void openUI() {
		try {
			frame = new GalaxyUI(this);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeUI() {
		frame.dispose();
	}

}
