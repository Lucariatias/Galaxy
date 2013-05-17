package me.lucariatias.plugins.galaxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JEditorPane;

public class GalaxyGiveFrame extends JFrame {

	private static final long serialVersionUID = 1770533717458461234L;
	
	private JPanel contentPane;
	private JComboBox materialBox;
	private JSpinner spinnerData;
	private JTextField txtPlayer;
	private JSpinner spinnerAmount;
	private JLabel lblPlayer;
	private JLabel lblItem;
	private JLabel lblData;
	private JLabel lblAmount;
	private JLabel lblDisplayName;
	private JTextField txtDispName;
	private JLabel lblLore;
	private JEditorPane editorLore;

	/**
	 * Create the frame.
	 */
	public GalaxyGiveFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		List<String> materialList = new ArrayList<String>();
		for (Material material : Material.values()) {
			materialList.add(material.toString());
		}
		materialBox = new JComboBox(materialList.toArray());
		materialBox.setSelectedItem(0);
		materialBox.setBounds(139, 34, 134, 27);
		contentPane.add(materialBox);
		
		spinnerData = new JSpinner();
		spinnerData.setBounds(139, 60, 55, 28);
		contentPane.add(spinnerData);
		
		JButton btnGive = new JButton("Give");
		btnGive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ItemStack item = new ItemStack(Material.getMaterial((String) materialBox.getSelectedItem()), (Integer) spinnerAmount.getValue(), Short.parseShort(spinnerData.getValue().toString()));
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName(txtDispName.getText());
				meta.setLore(new ArrayList<String>(Arrays.asList(editorLore.getText().split("\n"))));
				item.setItemMeta(meta);
				Bukkit.getServer().getPlayer(txtPlayer.getText()).getInventory().addItem(item);
			}
		});
		btnGive.setBounds(6, 243, 438, 29);
		contentPane.add(btnGive);
		
		txtPlayer = new JTextField();
		txtPlayer.setBounds(139, 4, 134, 28);
		contentPane.add(txtPlayer);
		txtPlayer.setColumns(10);
		
		spinnerAmount = new JSpinner();
		spinnerAmount.setBounds(139, 88, 55, 28);
		contentPane.add(spinnerAmount);
		
		lblPlayer = new JLabel("Player:");
		lblPlayer.setBounds(6, 10, 61, 16);
		contentPane.add(lblPlayer);
		
		lblItem = new JLabel("Item:");
		lblItem.setBounds(6, 38, 61, 16);
		contentPane.add(lblItem);
		
		lblData = new JLabel("Data:");
		lblData.setBounds(6, 66, 61, 16);
		contentPane.add(lblData);
		
		lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(6, 94, 61, 16);
		contentPane.add(lblAmount);
		
		lblDisplayName = new JLabel("Display name:");
		lblDisplayName.setBounds(6, 122, 110, 16);
		contentPane.add(lblDisplayName);
		
		txtDispName = new JTextField();
		txtDispName.setBounds(139, 116, 134, 28);
		contentPane.add(txtDispName);
		txtDispName.setColumns(10);
		
		lblLore = new JLabel("Lore:");
		lblLore.setBounds(6, 150, 61, 16);
		contentPane.add(lblLore);
		
		editorLore = new JEditorPane();
		editorLore.setBounds(139, 150, 134, 84);
		contentPane.add(editorLore);
	}
}
