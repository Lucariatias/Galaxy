package io.github.lucariatias.galaxy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSlider;

import org.bukkit.Bukkit;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GalaxyFrame extends JFrame {

	private static final long serialVersionUID = 7400673840343831810L;
	
	private JPanel contentPane;
	public GalaxyPanel panel;
	private JSlider slider;

	/**
	 * Create the frame.
	 */
	public GalaxyFrame() {
		if (Bukkit.getServer() != null) {
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		} else {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenDimensions = toolkit.getScreenSize();
		setBounds((int) ((screenDimensions.getWidth() / 2) - 320), (int) ((screenDimensions.getHeight() / 2) - 240), 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new GalaxyPanel();
		panel.setBounds(0, 0, 640, 429);
		panel.setBackground(Color.BLACK);
		panel.setForeground(Color.WHITE);
		panel.addPlanet(new Planet("Give", Color.RED, new GalaxyGiveFrame()));
		panel.addPlanet(new Planet("Tell", Color.ORANGE, new GalaxyTellFrame()));
		panel.addPlanet(new Planet("Ban/Unban", Color.YELLOW, new GalaxyBanFrame()));
		panel.addPlanet(new Planet("Op/Deop", Color.GREEN, new GalaxyOpFrame()));
		panel.addPlanet(new Planet("Kick", Color.BLUE, new GalaxyKickFrame()));
		panel.addPlanet(new Planet("Whitelist/Unwhitelist", Color.MAGENTA, new GalaxyWhitelistFrame()));
		panel.addPlanet(new Planet("Teleport", Color.RED, new GalaxyTeleportFrame()));
		panel.addPlanet(new Planet("Time", Color.ORANGE, new GalaxyTimeFrame()));
		panel.addPlanet(new Planet("Gamemode", Color.YELLOW, new GalaxyGamemodeFrame()));
		panel.addPlanet(new Planet("Experience", Color.GREEN, new GalaxyExperienceFrame()));
		panel.addPlanet(new Planet("Broadcast", Color.BLUE, new GalaxyBroadcastFrame()));
		panel.addPlanet(new Planet("Command", Color.MAGENTA, new GalaxyCommandFrame()));
		panel.addPlanet(new Planet("Plugin manager", Color.RED, new GalaxyPluginManagerFrame()));
		panel.addPlanet(new Planet("Stop", Color.ORANGE, new GalaxyStopFrame()));
		contentPane.setLayout(null);
		contentPane.add(panel);
		
		for (final Planet planet : panel.getPlanets()) {
			planet.getButton().setBounds(planet.getX() - panel.offset, 255, 128, 32);
			planet.getButton().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent event) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								planet.getFrame().setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
				
			});
			contentPane.add(planet.getButton());
		}
		
		for (Planet planet : panel.getPlanets()) {
			planet.setDiameter(255 - Math.abs(255 - (planet.getX() - panel.offset)) / 2);
			planet.getButton().setBounds(planet.getX() - planet.getDiameter() / 32 - panel.offset, 184, planet.getDiameter() / 2, 32);
			contentPane.setComponentZOrder(planet.getButton(), 0);
		}
		contentPane.repaint();
		
		slider = new JSlider();
		slider.setValue(0);
		slider.setMaximum(panel.getPlanets().size() * 255);
		slider.setBounds(0, 429, 640, 29);
		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent event) {
				for (Planet planet : panel.getPlanets()) {
					planet.setDiameter(255 - Math.abs(255 - (planet.getX() - panel.offset)) / 2);
					planet.getButton().setBounds(planet.getX() - planet.getDiameter() / 32 - panel.offset, 184, planet.getDiameter() / 2, 32);
					contentPane.setComponentZOrder(planet.getButton(), 0);
				}
				panel.offset = slider.getValue();
				contentPane.repaint();
			}
			
		});
		contentPane.add(slider);
	}
}
