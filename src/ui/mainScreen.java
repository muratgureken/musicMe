package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;

public class mainScreen extends JFrame{
	private JTextField txtMusicme;
	private JTextField txtCreatedByMgureken;
	JButton btnHistory1, btnHistory2, btnHistory3, btnHistroyBack, btnHistroyForward;
	JButton btnSearch, btnPlaylists;
	public mainScreen() {
		getContentPane().setBackground(new Color(0, 0, 0));
		getContentPane().setLayout(null);

		txtMusicme = new JTextField();
		txtMusicme.setForeground(new Color(255, 255, 255));
		txtMusicme.setEditable(false);
		txtMusicme.setBackground(new Color(128, 0, 128));
		txtMusicme.setHorizontalAlignment(SwingConstants.CENTER);
		txtMusicme.setFont(new Font("Tahoma", Font.BOLD, 30));
		txtMusicme.setText("musicMe");
		txtMusicme.setBounds(10, 11, 386, 99);
		getContentPane().add(txtMusicme);
		txtMusicme.setColumns(10);

		btnHistory1 = new JButton("");
		btnHistory1.setBounds(59, 121, 89, 99);
		getContentPane().add(btnHistory1);

		btnHistory2 = new JButton("");
		btnHistory2.setBounds(158, 121, 89, 99);
		getContentPane().add(btnHistory2);

		btnHistory3 = new JButton("");
		btnHistory3.setBounds(257, 121, 89, 99);
		getContentPane().add(btnHistory3);

		btnHistroyBack = new JButton("<");
		btnHistroyBack.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnHistroyBack.setBounds(10, 139, 39, 58);
		getContentPane().add(btnHistroyBack);

		JButton btnHistoryForward = new JButton(">");
		btnHistoryForward.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnHistoryForward.setBounds(357, 139, 39, 58);
		getContentPane().add(btnHistoryForward);

		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSearch.setBounds(59, 231, 287, 65);
		getContentPane().add(btnSearch);

		btnPlaylists = new JButton("Playlists");
		btnPlaylists.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnPlaylists.setBounds(59, 307, 287, 65);
		getContentPane().add(btnPlaylists);

		txtCreatedByMgureken = new JTextField();
		txtCreatedByMgureken.setEditable(false);
		txtCreatedByMgureken.setForeground(new Color(255, 255, 255));
		txtCreatedByMgureken.setText("Created by mgureken 26.03.2019");
		txtCreatedByMgureken.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCreatedByMgureken.setBackground(new Color(128, 0, 128));
		txtCreatedByMgureken.setBounds(10, 383, 386, 89);
		getContentPane().add(txtCreatedByMgureken);
		txtCreatedByMgureken.setColumns(10);
	}
}
