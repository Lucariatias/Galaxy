package io.github.lucariatias.galaxy;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Planet {
	
	private JButton button;
	private Color colour;
	private JFrame frame;
	private int x;
	private int diameter;
	
	public Planet(String title, Color colour, JFrame frame) {
		this.button = new JButton(title);
		this.colour = colour;
		this.frame = frame;
	}
	
	public JButton getButton() {
		return this.button;
	}

	/**
	 * @return the colour
	 */
	public Color getColour() {
		return colour;
	}

	/**
	 * @param colour the colour to set
	 */
	public void setColour(Color colour) {
		this.colour = colour;
	}

	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @param frame the frame to set
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public void showWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getDiameter() {
		return diameter;
	}
	
	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

}
