package me.lucariatias.plugins.galaxy;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JSpinner;

public class GalaxyUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4627432936316660883L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtPlayer;
	private JTextField txtItem;
	private JTextField txtPlayer_1;
	private JTextField txtMessage;
	private JButton btnTell;
	private JTextField txtPlayer_2;
	private JToolBar toolBar;
	private JButton btnBan;
	private JButton btnUnban;
	private JTextField txtPlayer_3;
	private JTextField txtPlayer_4;
	private JButton btnTeleport;
	private JSeparator separator_2;
	private JButton btnWhitelist;
	private JButton btnUnwhitelist;
	private JToolBar toolBar_1;
	private JButton btnEnable;
	private JButton btnDisable;
	private JLabel lblTime;
	private JToolBar toolBar_2;
	private JButton btnAdd;
	private JButton btnSet;
	private JButton btnSetGamemode;
	private JTextField txtPlayer_5;
	private JTextField txtPlayer_6;
	private JTextField txtPlugin;
	private JTextField txtPlayer_7;
	private JSpinner spinner_2;
	private JLabel lblX;
	private JLabel lblY;
	private JSpinner spinner_3;
	private JLabel lblZ;
	private JSpinner spinner_4;
	private JButton btnTeleport_1;
	private JButton btnNewButton;
	private JTextField txtWorld;
	private JTextField txtWorld_1;
	private JSpinner spinner_5;
	private JButton btnReload;
	private JSpinner spinner_6;
	private JSpinner spinner;
	private JSpinner spinner_1;

	/**
	 * Create the frame.
	 */
	public GalaxyUI(final Galaxy plugin) {
		setTitle("Galaxy for Bukkit");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenDimensions = toolkit.getScreenSize();
		setBounds((int) ((screenDimensions.getWidth() / 2) - 320), (int) ((screenDimensions.getHeight() / 2) - 240), 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(6, 424, 320, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSay = new JButton("Say");
		btnSay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bukkit.getServer().broadcastMessage(textField.getText());
				textField.setText("");
			}
		});
		btnSay.setBounds(324, 424, 128, 28);
		contentPane.add(btnSay);
		
		JButton btnSendCommand = new JButton("Send command");
		btnSendCommand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), textField.getText());
				textField.setText("");
			}
		});
		btnSendCommand.setBounds(447, 424, 128, 28);
		contentPane.add(btnSendCommand);
		
		JButton button = new JButton("\u00A7");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "\u00A7");
			}
		});
		button.setBounds(570, 424, 64, 28);
		contentPane.add(button);
		
		txtPlayer = new JTextField();
		txtPlayer.setText("Player");
		txtPlayer.setBounds(6, 6, 134, 28);
		contentPane.add(txtPlayer);
		txtPlayer.setColumns(10);
		
		txtItem = new JTextField();
		txtItem.setText("Item");
		txtItem.setBounds(152, 6, 134, 28);
		contentPane.add(txtItem);
		txtItem.setColumns(10);
		
		spinner_6 = new JSpinner();
		spinner_6.setBounds(298, 6, 64, 28);
		contentPane.add(spinner_6);
		
		JButton btnGive = new JButton("Give");
		btnGive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plugin.getLogger().info("Giving " + txtPlayer.getText() + " " + (Integer) spinner_6.getValue() + " x " + Material.getMaterial(txtItem.getText()).toString() + "...");
				if (Bukkit.getServer().getPlayerExact(txtPlayer.getText()) != null) {
					if (Material.getMaterial(txtItem.getText()) != null) {
						Bukkit.getServer().getPlayerExact(txtPlayer.getText()).getInventory().addItem(new ItemStack(Material.getMaterial(txtItem.getText()), (Integer) spinner_6.getValue()));
						Bukkit.getServer().getPlayerExact(txtPlayer.getText()).sendMessage(ChatColor.AQUA + "You were given " + (Integer) spinner_6.getValue() + " x " + Material.getMaterial(txtItem.getText()).toString() + " from " + ChatColor.LIGHT_PURPLE + "Galaxy!");
					} else {
						plugin.getLogger().info("An incorrect material name was given in the item input box.");
					}
				} else {
					plugin.getLogger().warning(txtPlayer.getText() + " is not online!");
				}
			}
		});
		btnGive.setBounds(447, 6, 117, 28);
		contentPane.add(btnGive);
		
		txtPlayer_1 = new JTextField();
		txtPlayer_1.setText("Player");
		txtPlayer_1.setBounds(6, 46, 134, 28);
		contentPane.add(txtPlayer_1);
		txtPlayer_1.setColumns(10);
		
		txtMessage = new JTextField();
		txtMessage.setText("Message");
		txtMessage.setBounds(152, 46, 231, 28);
		contentPane.add(txtMessage);
		txtMessage.setColumns(10);
		
		btnNewButton = new JButton("\u00A7");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMessage.setText(txtMessage.getText() + "\u00A7");
			}
		});
		btnNewButton.setBounds(395, 46, 37, 28);
		contentPane.add(btnNewButton);
		
		btnTell = new JButton("Tell");
		btnTell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plugin.getLogger().info("Telling " + txtPlayer_1.getText() + " " + txtMessage.getText() + "...");
				if (Bukkit.getServer().getPlayerExact(txtPlayer_1.getText()) != null) {
					Bukkit.getServer().getPlayerExact(txtPlayer_1.getText()).sendMessage(txtMessage.getText());
				} else {
					plugin.getLogger().warning(txtPlayer_1.getText() + " is not online!");
				}
			}
		});
		btnTell.setBounds(447, 46, 117, 28);
		contentPane.add(btnTell);
		
		txtPlayer_2 = new JTextField();
		txtPlayer_2.setText("Player");
		txtPlayer_2.setBounds(6, 86, 134, 28);
		contentPane.add(txtPlayer_2);
		txtPlayer_2.setColumns(10);
		
		toolBar = new JToolBar();
		toolBar.setBounds(152, 86, 412, 28);
		contentPane.add(toolBar);
		
		btnBan = new JButton("Ban");
		btnBan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plugin.getLogger().info("Banning " + txtPlayer_2.getText() + "...");
				Bukkit.getOfflinePlayer(txtPlayer_2.getText()).setBanned(true);
				if (Bukkit.getPlayerExact(txtPlayer_2.getText()) != null) {
					Bukkit.getPlayerExact(txtPlayer_2.getText()).kickPlayer(ChatColor.AQUA + "You were banned using " + ChatColor.LIGHT_PURPLE + "Galaxy!");
				}
			}
		});
		toolBar.add(btnBan);
		
		btnUnban = new JButton("Unban");
		btnUnban.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plugin.getLogger().info("Unbanning " + txtPlayer_2.getText() + "...");
				Bukkit.getOfflinePlayer(txtPlayer_2.getText()).setBanned(false);
			}
		});
		toolBar.add(btnUnban);
		
		JSeparator separator = new JSeparator();
		toolBar.add(separator);
		
		JButton btnOp = new JButton("Op");
		btnOp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plugin.getLogger().info("Opping " + txtPlayer_2.getText() + "...");
				Bukkit.getOfflinePlayer(txtPlayer_2.getText()).setOp(true);
				if (Bukkit.getServer().getPlayerExact(txtPlayer_2.getText()) != null) {
					Bukkit.getServer().getPlayerExact(txtPlayer_2.getText()).sendMessage(ChatColor.AQUA + "You were opped using " + ChatColor.LIGHT_PURPLE + "Galaxy!");
				}
			}
		});
		toolBar.add(btnOp);
		
		JButton btnDeop = new JButton("Deop");
		btnDeop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plugin.getLogger().info("Deopping " + txtPlayer_2.getText() + "...");
				Bukkit.getOfflinePlayer(txtPlayer_2.getText()).setOp(false);
				if (Bukkit.getServer().getPlayerExact(txtPlayer_2.getText()) != null) {
					Bukkit.getServer().getPlayerExact(txtPlayer_2.getText()).sendMessage(ChatColor.AQUA + "You were deopped using " + ChatColor.LIGHT_PURPLE + "Galaxy!");
				}
			}
		});
		toolBar.add(btnDeop);
		
		JSeparator separator_1 = new JSeparator();
		toolBar.add(separator_1);
		
		JButton btnKick = new JButton("Kick");
		btnKick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plugin.getLogger().info("Kicking " + txtPlayer_2.getText() + "...");
				if (Bukkit.getServer().getPlayerExact(txtPlayer_2.getText()) != null) {
					Bukkit.getServer().getPlayerExact(txtPlayer_2.getText()).kickPlayer(ChatColor.AQUA + "You were kicked using " + ChatColor.LIGHT_PURPLE + "Galaxy!");
				} else {
					plugin.getLogger().warning(txtPlayer_2.getText() + " is not online!");
				}
			}
		});
		toolBar.add(btnKick);
		
		separator_2 = new JSeparator();
		toolBar.add(separator_2);
		
		btnWhitelist = new JButton("Whitelist");
		btnWhitelist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plugin.getLogger().info("Whitelisting " + txtPlayer_2.getText());
				Bukkit.getOfflinePlayer(txtPlayer_2.getText()).setWhitelisted(true);
			}
		});
		toolBar.add(btnWhitelist);
		
		btnUnwhitelist = new JButton("Unwhitelist");
		btnUnwhitelist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plugin.getLogger().info("Removing " + txtPlayer_2.getText() + " from the whitelist...");
				Bukkit.getOfflinePlayer(txtPlayer_2.getText()).setWhitelisted(false);
			}
		});
		toolBar.add(btnUnwhitelist);
		
		txtPlayer_3 = new JTextField();
		txtPlayer_3.setText("Player 1");
		txtPlayer_3.setBounds(6, 166, 134, 28);
		contentPane.add(txtPlayer_3);
		txtPlayer_3.setColumns(10);
		
		txtPlayer_4 = new JTextField();
		txtPlayer_4.setText("Player 2");
		txtPlayer_4.setBounds(152, 166, 134, 28);
		contentPane.add(txtPlayer_4);
		txtPlayer_4.setColumns(10);
		
		btnTeleport = new JButton("Teleport");
		btnTeleport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plugin.getLogger().info("Teleporting " + txtPlayer_3.getText() + " to " + txtPlayer_4.getText());
				if (Bukkit.getServer().getPlayerExact(txtPlayer_3.getText()) != null) {
					if (Bukkit.getServer().getPlayerExact(txtPlayer_4.getText()) != null) {
						Bukkit.getServer().getPlayerExact(txtPlayer_3.getText()).sendMessage(ChatColor.AQUA + "You were teleported to " + txtPlayer_4.getText() + " using " + ChatColor.LIGHT_PURPLE + "Galaxy!");
						Bukkit.getServer().getPlayerExact(txtPlayer_4.getText()).sendMessage(ChatColor.AQUA + txtPlayer_4.getText() + " was teleported to you using " + ChatColor.LIGHT_PURPLE + "Galaxy!");
						Bukkit.getServer().getPlayerExact(txtPlayer_3.getText()).teleport(Bukkit.getServer().getPlayerExact(txtPlayer_4.getText()).getLocation());
					} else {
						plugin.getLogger().warning(txtPlayer_4.getText() + " is not online!");
					}
				} else {
					plugin.getLogger().warning(txtPlayer_3.getText() + " is not online!");
				}
				
			}
		});
		btnTeleport.setBounds(447, 166, 117, 28);
		contentPane.add(btnTeleport);
		
		JLabel lblWhitelist = new JLabel("Whitelist");
		lblWhitelist.setBounds(16, 126, 61, 28);
		contentPane.add(lblWhitelist);
		
		toolBar_1 = new JToolBar();
		toolBar_1.setBounds(152, 126, 110, 28);
		contentPane.add(toolBar_1);
		
		btnEnable = new JButton("Enable");
		btnEnable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plugin.getLogger().info("Enabling whitelist...");
				Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "Whitelist enabled using " + ChatColor.LIGHT_PURPLE + "Galaxy!");
				Bukkit.getServer().setWhitelist(true);
			}
		});
		toolBar_1.add(btnEnable);
		
		btnDisable = new JButton("Disable");
		btnDisable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plugin.getLogger().info("Disabling whitelist...");
				Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "Whitelist disabled using " + ChatColor.LIGHT_PURPLE + "Galaxy!");
				Bukkit.getServer().setWhitelist(false);
			}
		});
		toolBar_1.add(btnDisable);
		
		lblTime = new JLabel("Time");
		lblTime.setBounds(16, 246, 61, 28);
		contentPane.add(lblTime);
		
		toolBar_2 = new JToolBar();
		toolBar_2.setBounds(447, 246, 110, 28);
		contentPane.add(toolBar_2);
		
		btnSet = new JButton("Set");
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plugin.getLogger().info("Setting time in " + txtWorld_1.getText() + " to " + (Integer) spinner_5.getValue() + "...");
				Bukkit.getServer().getWorld(txtWorld_1.getText()).setTime((Integer) spinner_5.getValue());
				Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "Time in " + txtWorld_1.getText() + " set to " + (Integer) spinner_5.getValue() + " using " + ChatColor.LIGHT_PURPLE + "Galaxy!");
			}
		});
		toolBar_2.add(btnSet);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plugin.getLogger().info("Adding " + (Integer) spinner_5.getValue() + " to time in " + txtWorld_1.getText() + "...");
				Bukkit.getServer().getWorld(txtWorld_1.getText()).setTime(Bukkit.getServer().getWorld(txtWorld_1.getText()).getTime() + (Integer) spinner_5.getValue());
				Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "Time in " + txtWorld_1.getText() + " set to " + (Bukkit.getServer().getWorld(txtWorld_1.getText()).getTime() + (Integer) spinner_5.getValue()) + " using " + ChatColor.LIGHT_PURPLE + "Galaxy!");
			}
		});
		toolBar_2.add(btnAdd);
		
		txtPlayer_5 = new JTextField();
		txtPlayer_5.setText("Player");
		txtPlayer_5.setBounds(6, 286, 134, 28);
		contentPane.add(txtPlayer_5);
		txtPlayer_5.setColumns(10);
		
		spinner = new JSpinner();
		spinner.setBounds(152, 286, 37, 28);
		contentPane.add(spinner);
		
		btnSetGamemode = new JButton("Set gamemode");
		btnSetGamemode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plugin.getLogger().info("Setting " + txtPlayer_5.getText() + "'s gamemode to " + (Integer) spinner.getValue() + "...");
				if (Bukkit.getServer().getPlayerExact(txtPlayer_5.getText()) != null) {
					Bukkit.getServer().getPlayerExact(txtPlayer_5.getText()).sendMessage("Gamemode changed to " + GameMode.getByValue((Integer) spinner.getValue()).toString() + " using " + ChatColor.LIGHT_PURPLE + "Galaxy!");
					Bukkit.getServer().getPlayerExact(txtPlayer_5.getText()).setGameMode(GameMode.getByValue((Integer) spinner.getValue()));
				} else {
					plugin.getLogger().warning(txtPlayer_5.getText() + " is not online!");
				}
			}
		});
		btnSetGamemode.setBounds(447, 286, 117, 28);
		contentPane.add(btnSetGamemode);
		
		txtPlayer_6 = new JTextField();
		txtPlayer_6.setText("Player");
		txtPlayer_6.setBounds(6, 327, 134, 28);
		contentPane.add(txtPlayer_6);
		txtPlayer_6.setColumns(10);
		
		spinner_1 = new JSpinner();
		spinner_1.setBounds(152, 327, 64, 28);
		contentPane.add(spinner_1);
		
		JButton btnGiveExp = new JButton("Give Exp");
		btnGiveExp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plugin.getLogger().info("Giving " + (Integer) spinner_1.getValue() + " exp to " + txtPlayer_6.getText() + "...");
				if (Bukkit.getServer().getPlayerExact(txtPlayer_6.getText()) != null) {
					Bukkit.getServer().getPlayerExact(txtPlayer_6.getText()).sendMessage(ChatColor.AQUA + "You were given " + (Integer) spinner_1.getValue() + " exp using " + ChatColor.LIGHT_PURPLE + "Galaxy!");
					Bukkit.getServer().getPlayerExact(txtPlayer_6.getText()).setExp(Bukkit.getServer().getPlayerExact(txtPlayer_6.getText()).getExp() + (Float) spinner_1.getValue());
				} else {
					plugin.getLogger().warning(txtPlayer_6.getText() + " is not online!");
				}
			}
		});
		btnGiveExp.setBounds(447, 327, 117, 28);
		contentPane.add(btnGiveExp);
		
		txtPlugin = new JTextField();
		txtPlugin.setText("Plugin");
		txtPlugin.setBounds(6, 369, 134, 28);
		contentPane.add(txtPlugin);
		txtPlugin.setColumns(10);
		
		JButton btnDisable_1 = new JButton("Disable");
		btnDisable_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plugin.getLogger().info("Disabling " + txtPlugin.getText() + "...");
				if (Bukkit.getPluginManager().getPlugin(txtPlugin.getText()) != null) {
					Bukkit.getPluginManager().disablePlugin(Bukkit.getPluginManager().getPlugin(txtPlugin.getText()));
				} else {
					plugin.getLogger().warning(txtPlugin.getText() + " is not installed!");
				}
			}
		});
		btnDisable_1.setBounds(447, 369, 117, 28);
		contentPane.add(btnDisable_1);
		
		txtPlayer_7 = new JTextField();
		txtPlayer_7.setText("Player");
		txtPlayer_7.setBounds(6, 206, 134, 28);
		contentPane.add(txtPlayer_7);
		txtPlayer_7.setColumns(10);
		
		spinner_2 = new JSpinner();
		spinner_2.setBounds(173, 206, 43, 28);
		contentPane.add(spinner_2);
		
		lblX = new JLabel("X:");
		lblX.setBounds(155, 206, 17, 28);
		contentPane.add(lblX);
		
		lblY = new JLabel("Y:");
		lblY.setBounds(228, 206, 17, 28);
		contentPane.add(lblY);
		
		spinner_3 = new JSpinner();
		spinner_3.setBounds(244, 206, 43, 28);
		contentPane.add(spinner_3);
		
		lblZ = new JLabel("Z:");
		lblZ.setBounds(298, 206, 17, 28);
		contentPane.add(lblZ);
		
		spinner_4 = new JSpinner();
		spinner_4.setBounds(315, 206, 43, 28);
		contentPane.add(spinner_4);
		
		btnTeleport_1 = new JButton("Teleport");
		btnTeleport_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plugin.getLogger().info("Teleporting " + txtPlayer_7.getText() + " to " + (Integer) spinner_2.getValue() + ", " + (Integer) spinner_3.getValue() + ", " + (Integer) spinner_4.getValue() + " in " + txtWorld.getText() + "...");
				if (Bukkit.getServer().getPlayerExact(txtPlayer_7.getText()) != null) {
					if (Bukkit.getServer().getWorld(txtWorld.getText()) != null) {
						Bukkit.getServer().getPlayerExact(txtPlayer_7.getText()).teleport(new Location(Bukkit.getServer().getWorld(txtWorld.getText()), (Integer) spinner_2.getValue(), (Integer) spinner_3.getValue(), (Integer) spinner_4.getValue()));
						Bukkit.getServer().getPlayerExact(txtPlayer_7.getText()).sendMessage(ChatColor.AQUA + "You were teleported using " + ChatColor.LIGHT_PURPLE + "Galaxy!");
					} else {
						plugin.getLogger().warning(txtWorld.getText() + " does not exist!");
					}
				} else {
					plugin.getLogger().warning(txtPlayer_7.getText() + " is not online!");
				}
			}
		});
		btnTeleport_1.setBounds(447, 206, 117, 28);
		contentPane.add(btnTeleport_1);
		
		txtWorld = new JTextField();
		txtWorld.setText("World");
		txtWorld.setBounds(370, 206, 74, 28);
		contentPane.add(txtWorld);
		txtWorld.setColumns(10);
		
		txtWorld_1 = new JTextField();
		txtWorld_1.setText("World");
		txtWorld_1.setBounds(152, 246, 134, 28);
		contentPane.add(txtWorld_1);
		txtWorld_1.setColumns(10);
		
		spinner_5 = new JSpinner();
		spinner_5.setBounds(308, 246, 124, 28);
		contentPane.add(spinner_5);
		
		JButton btnEnable_1 = new JButton("Enable");
		btnEnable_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				plugin.getLogger().info("Enabling " + txtPlugin.getText() + "...");
				if (Bukkit.getPluginManager().getPlugin(txtPlugin.getText()) != null) {
					Bukkit.getPluginManager().enablePlugin(Bukkit.getPluginManager().getPlugin(txtPlugin.getText()));
				} else {
					plugin.getLogger().warning(txtPlugin.getText() + " is not installed!");
				}
			}
		});
		btnEnable_1.setBounds(335, 369, 117, 28);
		contentPane.add(btnEnable_1);
		
		btnReload = new JButton("Reload");
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plugin.getLogger().info("Reloading " + txtPlugin.getText() + "...");
				if (Bukkit.getPluginManager().getPlugin(txtPlugin.getText()) != null) {
					Bukkit.getPluginManager().disablePlugin(Bukkit.getPluginManager().getPlugin(txtPlugin.getText()));
					Bukkit.getPluginManager().enablePlugin(Bukkit.getPluginManager().getPlugin(txtPlugin.getText()));
				} else {
					plugin.getLogger().warning(txtPlugin.getText() + " is not installed!");
				}
			}
		});
		btnReload.setBounds(223, 369, 117, 28);
		contentPane.add(btnReload);
	}
}
