package io.github.lucariatias.galaxy;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.bukkit.Bukkit;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

public class GalaxyCommandFrame extends JFrame {

	private static final long serialVersionUID = -3587928042507318685L;
	
	private JPanel contentPane;
	private JTextField txtCommand;
	private JLabel lblPlayer;
	private JTextField txtPlayer;
	private JCheckBox chckbxorUseConsole;

	/**
	 * Create the frame.
	 */
	public GalaxyCommandFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		txtCommand = new JTextField();
		txtCommand.setBounds(6, 41, 309, 28);
		contentPane.add(txtCommand);
		txtCommand.setColumns(10);
		
		JButton btnExecute = new JButton("Execute");
		btnExecute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (chckbxorUseConsole.isSelected()) {
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), txtCommand.getText());
				} else {
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getPlayer(txtPlayer.getText()), txtCommand.getText());
				}
			}
		});
		btnExecute.setBounds(327, 42, 117, 29);
		contentPane.add(btnExecute);
		
		lblPlayer = new JLabel("Player:");
		lblPlayer.setBounds(6, 13, 61, 16);
		contentPane.add(lblPlayer);
		
		txtPlayer = new JTextField();
		txtPlayer.setBounds(79, 7, 117, 28);
		contentPane.add(txtPlayer);
		txtPlayer.setColumns(10);
		
		chckbxorUseConsole = new JCheckBox("\u2026or use console?");
		chckbxorUseConsole.setSelected(true);
		chckbxorUseConsole.setBounds(208, 9, 236, 23);
		contentPane.add(chckbxorUseConsole);
	}
}
