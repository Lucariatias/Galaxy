package io.github.lucariatias.galaxy;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSpinner;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

public class GalaxyTeleportFrame extends JFrame {

	private static final long serialVersionUID = -7874367397551169602L;
	
	private JPanel contentPane;
	private JTextField textFieldPlayer;
	private JTextField textFieldTo;
	private JSpinner spinnerX;
	private JSpinner spinnerY;
	private JSpinner spinnerZ;
	private JComboBox<?> comboBoxWorld;

	/**
	 * Create the frame.
	 */
	public GalaxyTeleportFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		textFieldPlayer = new JTextField();
		textFieldPlayer.setBounds(136, 6, 308, 28);
		contentPane.add(textFieldPlayer);
		textFieldPlayer.setColumns(10);
		
		textFieldTo = new JTextField();
		textFieldTo.setBounds(136, 46, 134, 28);
		contentPane.add(textFieldTo);
		textFieldTo.setColumns(10);
		
		JLabel lblPlayer = new JLabel("Player:");
		lblPlayer.setBounds(6, 12, 61, 16);
		contentPane.add(lblPlayer);
		
		JLabel lblTeleportTo = new JLabel("Teleport to:");
		lblTeleportTo.setBounds(6, 52, 118, 16);
		contentPane.add(lblTeleportTo);
		
		JButton btnGetLocation = new JButton("Get location");
		btnGetLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Location location = Bukkit.getServer().getPlayer(textFieldTo.getText()).getLocation();
				spinnerX.setValue((int) location.getX());
				spinnerY.setValue((int) location.getY());
				spinnerZ.setValue((int) location.getZ());
				comboBoxWorld.setSelectedItem(location.getWorld().getName());
			}
		});
		btnGetLocation.setBounds(282, 46, 162, 29);
		contentPane.add(btnGetLocation);
		
		JLabel lblX = new JLabel("X:");
		lblX.setBounds(6, 118, 61, 16);
		contentPane.add(lblX);
		
		spinnerX = new JSpinner();
		spinnerX.setBounds(79, 112, 191, 28);
		contentPane.add(spinnerX);
		
		JLabel lblY = new JLabel("Y:");
		lblY.setBounds(6, 146, 61, 16);
		contentPane.add(lblY);
		
		spinnerY = new JSpinner();
		spinnerY.setBounds(79, 140, 191, 28);
		contentPane.add(spinnerY);
		
		JLabel lblZ = new JLabel("Z:");
		lblZ.setBounds(6, 174, 61, 16);
		contentPane.add(lblZ);
		
		spinnerZ = new JSpinner();
		spinnerZ.setBounds(79, 168, 191, 28);
		contentPane.add(spinnerZ);
		
		JButton btnTeleport = new JButton("Teleport");
		btnTeleport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Bukkit.getServer().getPlayer(textFieldPlayer.getText()).teleport(new Location(Bukkit.getServer().getWorld((String) comboBoxWorld.getSelectedItem()), (Integer) spinnerX.getValue(), (Integer) spinnerY.getValue(), (Integer) spinnerZ.getValue()));
			}
		});
		btnTeleport.setBounds(6, 243, 438, 29);
		contentPane.add(btnTeleport);
		
		JLabel lblWorld = new JLabel("World:");
		lblWorld.setBounds(6, 90, 61, 16);
		contentPane.add(lblWorld);
		
		List<String> worldNames = new ArrayList<String>();
		if (Bukkit.getServer() != null) {
			for (World world : Bukkit.getServer().getWorlds()) {
				worldNames.add(world.getName());
			}
		}
		comboBoxWorld = new JComboBox<Object>(worldNames.toArray());
		comboBoxWorld.setBounds(79, 86, 191, 27);
		contentPane.add(comboBoxWorld);
	}
}
