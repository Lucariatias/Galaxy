package me.lucariatias.plugins.galaxy;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GalaxyWhitelistFrame extends JFrame {

	private static final long serialVersionUID = -1495288523548247090L;
	
	private JPanel contentPane;
	private JTextField textField;
	private DefaultListModel listModel;
	private JList list;

	/**
	 * Create the frame.
	 */
	public GalaxyWhitelistFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		listModel = new DefaultListModel();
		for (OfflinePlayer player : Bukkit.getServer().getWhitelistedPlayers()) {
			listModel.addElement(player.getName());
		}
		list = new JList(listModel);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(6, 6, 147, 225);
		contentPane.add(scrollPane);
		
		textField = new JTextField();
		textField.setBounds(165, 6, 134, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Bukkit.getOfflinePlayer(textField.getText()).setWhitelisted(true);
				if (!listModel.contains(textField.getText())) {
					listModel.addElement(textField.getText());
				}
			}
		});
		btnAdd.setBounds(165, 46, 134, 29);
		contentPane.add(btnAdd);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Bukkit.getOfflinePlayer((String) listModel.getElementAt(list.getSelectedIndex())).setWhitelisted(false);
				listModel.remove(list.getSelectedIndex());
			}
		});
		btnRemove.setBounds(6, 243, 134, 29);
		contentPane.add(btnRemove);
	}
}
