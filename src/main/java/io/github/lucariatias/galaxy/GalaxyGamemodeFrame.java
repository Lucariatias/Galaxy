package io.github.lucariatias.galaxy;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class GalaxyGamemodeFrame extends JFrame {

	private static final long serialVersionUID = -4790917034413183258L;
	
	private JPanel contentPane;
	private JTextField txtPlayer;
	private JComboBox<?> comboBox;

	/**
	 * Create the frame.
	 */
	public GalaxyGamemodeFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		txtPlayer = new JTextField();
		txtPlayer.setBounds(6, 6, 134, 28);
		contentPane.add(txtPlayer);
		txtPlayer.setColumns(10);
		
		List<String> gamemodes = new ArrayList<String>();
		for (GameMode gamemode : GameMode.values()) {
			gamemodes.add(gamemode.toString());
		}
		comboBox = new JComboBox<Object>(gamemodes.toArray());
		comboBox.setBounds(152, 8, 163, 27);
		contentPane.add(comboBox);
		
		JButton btnSet = new JButton("Set");
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Bukkit.getServer().getPlayer(txtPlayer.getText()).setGameMode(GameMode.valueOf((String) comboBox.getSelectedItem()));
			}
		});
		btnSet.setBounds(327, 7, 117, 29);
		contentPane.add(btnSet);
	}

}
