package me.lucariatias.plugins.galaxy;

import java.awt.Graphics;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;

public class GalaxyPanel extends JPanel {

	private static final long serialVersionUID = -115412069210452359L;
	
	private Set<Planet> planets = new HashSet<Planet>();
	public int offset;

	/**
	 * Create the panel.
	 */
	public GalaxyPanel() {
		
	}
	
	public Set<Planet> getPlanets() {
		return planets;
	}
	
	public void addPlanet(Planet planet) {
		this.planets.add(planet);
		planet.setX(this.planets.size() * 255);
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		for (Planet planet : this.getPlanets()) {
			graphics.setColor(planet.getColour());
			graphics.fillOval(planet.getX() - offset - (planet.getDiameter() / 4), 192 - (planet.getDiameter() / 2), planet.getDiameter(), planet.getDiameter());
		}
	}

}
