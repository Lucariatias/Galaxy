package me.lucariatias.plugins.galaxy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import org.bukkit.plugin.Plugin;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GalaxyConfigEditorFrame extends JFrame {

	private static final long serialVersionUID = -9011063519795910413L;
	
	private JPanel contentPane;
	private JTextPane textPane;
	private JButton btnSave;

	/**
	 * Create the frame.
	 * @param plugin 
	 */
	public GalaxyConfigEditorFrame(final Plugin plugin) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textPane = new JTextPane();
		try {
			if (!plugin.getDataFolder().exists()) {
				plugin.getDataFolder().mkdir();
			}
			File file = new File(plugin.getDataFolder() + File.separator + "config.yml");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileReader reader = new FileReader(file);
			Scanner scanner = new Scanner(reader);
			while (scanner.hasNextLine()) {
				textPane.setText(textPane.getText() + scanner.nextLine() + "\n");
			}
		} catch (IOException exception) {
			for (StackTraceElement element : exception.getStackTrace()) {
				textPane.setText(textPane.getText() + element.toString() + "\n");
			}
		}
		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setBounds(6, 6, 438, 187);
		contentPane.add(scrollPane);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				textPane.setText(textPane.getText().replace("\t", "    "));
				try {
					if (!plugin.getDataFolder().exists()) {
						plugin.getDataFolder().mkdir();
					}
					File file = new File(plugin.getDataFolder() + File.separator + "config.yml");
					if (!file.exists()) {
						file.createNewFile();
					}
					FileOutputStream fileOutputStream = new FileOutputStream(file);
					Writer writer = new OutputStreamWriter(fileOutputStream);
					writer.write(textPane.getText());
					writer.close();
				} catch (IOException exception) {
					for (StackTraceElement element : exception.getStackTrace()) {
						textPane.setText(textPane.getText() + element.toString() + "\n");
					}
				}
			}
		});
		btnSave.setBounds(6, 205, 199, 29);
		contentPane.add(btnSave);
		
		JButton btnCloseWithoutSaving = new JButton("Close without saving");
		btnCloseWithoutSaving.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				GalaxyConfigEditorFrame.this.dispose();
			}
		});
		btnCloseWithoutSaving.setBounds(245, 243, 199, 29);
		contentPane.add(btnCloseWithoutSaving);
		
		JButton btnSaveAndReload = new JButton("Save and reload");
		btnSaveAndReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				textPane.setText(textPane.getText().replace("\t", "    "));
				try {
					if (!plugin.getDataFolder().exists()) {
						plugin.getDataFolder().mkdir();
					}
					File file = new File(plugin.getDataFolder() + File.separator + "config.yml");
					if (!file.exists()) {
						file.createNewFile();
					}
					FileOutputStream fileOutputStream = new FileOutputStream(file);
					Writer writer = new OutputStreamWriter(fileOutputStream);
					writer.write(textPane.getText());
					writer.close();
				} catch (IOException exception) {
					for (StackTraceElement element : exception.getStackTrace()) {
						textPane.setText(textPane.getText() + element.toString() + "\n");
					}
				}
				plugin.reloadConfig();
			}
		});
		btnSaveAndReload.setBounds(6, 243, 199, 29);
		contentPane.add(btnSaveAndReload);
		
		JButton btnRevertToLast = new JButton("Revert to last saved version");
		btnRevertToLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					if (!plugin.getDataFolder().exists()) {
						plugin.getDataFolder().mkdir();
					}
					File file = new File(plugin.getDataFolder() + File.separator + "config.yml");
					if (!file.exists()) {
						file.createNewFile();
					}
					FileReader reader = new FileReader(file);
					Scanner scanner = new Scanner(reader);
					textPane.setText("");
					while (scanner.hasNextLine()) {
						textPane.setText(textPane.getText() + scanner.nextLine() + "\n");
					}
				} catch (IOException exception) {
					for (StackTraceElement element : exception.getStackTrace()) {
						textPane.setText(textPane.getText() + element.toString() + "\n");
					}
				}
				textPane.setText(textPane.getText().replace("\t", "    "));
			}
		});
		btnRevertToLast.setBounds(245, 205, 199, 29);
		contentPane.add(btnRevertToLast);
	}
}
