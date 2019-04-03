package ui;

import sun.audio.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.sun.media.jfxmedia.events.PlayerEvent;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class mainScreen extends JFrame{
	private JTextField txtMusicme;
	private JTextField txtCreatedByMgureken;
	JButton btnHistory1, btnHistory2, btnHistory3, btnHistroyBack, btnHistroyForward, btnHistoryForward;
	JButton btnSearch, btnPlaylists, btnBack ;
	int windowType;
	private JTextField txtSearch;
	private JTable tableSearch;
	JScrollPane scrollSeach;
	private JButton btnPlay;
	private JButton btnAddToPlaylist;
	private JButton btnRepeat;
	JLabel lblPlayPhoto;
	String images = "/image/rsz_solanahtari.png";
	private JLabel lblPlayedPhoto;
	private JButton btnHome;

	public mainScreen() {
		getContentPane().setLayout(null);
		setBounds(100, 100, 421, 521);
		setResizable(false);
		getContentPane().setBackground(new Color(0, 0, 0));

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
		btnHistory1.setBounds(59, 135, 89, 99);

		btnHistory2 = new JButton("");
		btnHistory2.setBounds(158, 135, 89, 99);

		btnHistory3 = new JButton("");
		btnHistory3.setBounds(257, 135, 89, 99);

		btnHistroyBack = new JButton("<");
		btnHistroyBack.setFont(new Font("Tahoma", Font.BOLD, 6));
		btnHistroyBack.setBounds(10, 153, 39, 58);

		btnHistoryForward = new JButton(">");
		btnHistoryForward.setFont(new Font("Tahoma", Font.BOLD, 6));
		btnHistoryForward.setBounds(357, 153, 39, 58);

		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtMusicme.setText("");
				txtMusicme.setText("SEARCH");
				windowType = 1;
				windowChangeControl(windowType);
			}
		});
		btnSearch.setBounds(59, 256, 287, 65);

		btnPlaylists = new JButton("Playlists");
		btnPlaylists.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowType = 2;
				txtMusicme.setText("");
				txtMusicme.setText("PLAYLISTS");
				windowChangeControl(2);
			}
		});
		btnPlaylists.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnPlaylists.setBounds(59, 346, 287, 65);

		txtCreatedByMgureken = new JTextField();
		txtCreatedByMgureken.setEditable(false);
		txtCreatedByMgureken.setForeground(new Color(255, 255, 255));
		txtCreatedByMgureken.setText("Created by mgureken 26.03.2019");
		txtCreatedByMgureken.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCreatedByMgureken.setBackground(new Color(128, 0, 128));
		txtCreatedByMgureken.setBounds(148, 422, 248, 50);
		txtCreatedByMgureken.setColumns(10);
		getContentPane().add(txtCreatedByMgureken);

		lblPlayPhoto = new JLabel("");
		lblPlayPhoto.setBounds(153, 159, 105, 137);
		lblPlayPhoto.setIcon(new ImageIcon(getClass().getResource(images)));

		btnPlay = new JButton(">");
		btnPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AudioStream as = null;
				try {
					as = new AudioStream(this.getClass().getResourceAsStream("/OneRepublic-CountingStars.mp3"));
					AudioPlayer.player.start(as);
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				//as = new AudioStream(this.getClass().getResourceAsStream("/Musics/OneRepublic-CountingStars.mp3"));
				/*AudioPlayer.player.stop(as);
				try {
					as = new AudioStream(this.getClass().getResourceAsStream("/Musics/OneRepublic-CountingStars.mp3"));
					AudioPlayer.player.stop(as);
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}*/
				
				
			}
		});
		btnPlay.setToolTipText("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnPlay.getText().equals(">"))
				{
					btnPlay.setText("||");
					btnPlay.setToolTipText("Pause");
				}
				else if(btnPlay.getText().equals("||"))
				{
					btnPlay.setText(">");
					btnPlay.setToolTipText("Play");
				}
			}
		});
		btnPlay.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPlay.setBounds(178, 354, 57, 43);

		btnAddToPlaylist = new JButton("+");
		btnAddToPlaylist.setToolTipText("Add to playlist");
		btnAddToPlaylist.setBounds(81, 360, 44, 32);

		btnRepeat = new JButton("-");
		btnRepeat.setToolTipText("No repeat");
		btnRepeat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnRepeat.getText().equals("-"))
				{
					btnRepeat.setText("1");
					btnRepeat.setToolTipText("Repeat song");
				}
				else if(btnRepeat.getText().equals("1"))
				{
					btnRepeat.setText("A");
					btnRepeat.setToolTipText("Repeat all songs");
				}
				else if(btnRepeat.getText().equals("A"))
				{
					btnRepeat.setText("-");
					btnRepeat.setToolTipText("No repeat");
				}
			}
		});
		btnRepeat.setBounds(284, 360, 44, 32);

		txtSearch = new JTextField();
		txtSearch.setBounds(10, 121, 285, 20);
		txtSearch.setColumns(10);

		lblPlayedPhoto = new JLabel("");
		lblPlayedPhoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayedPhoto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPlayedPhoto.setForeground(Color.WHITE);
		lblPlayedPhoto.setBackground(Color.BLACK);
		lblPlayedPhoto.setBounds(10, 321, 386, 14);

		scrollSeach = new JScrollPane();
		scrollSeach.setBounds(10, 149, 386, 262);
		scrollSeach.setBackground(Color.black);

		tableSearch = new JTable();
		tableSearch.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				String str="";
				//System.out.println("key: "+(arg0.getKeyCode()));
				lblPlayedPhoto.setText("");
				//if enter is pressed
				if(arg0.getKeyCode()==10)
				{
					if(windowType==1)
					{
						windowType = 3;
						windowChangeControl(windowType);
						str = str+tableSearch.getValueAt(tableSearch.getSelectedRow(), 0);
						str = str+" ("+tableSearch.getValueAt(tableSearch.getSelectedRow(), 1)+")";
						txtMusicme.setText("musicMe");
						lblPlayedPhoto.setText(str);
					}
					else if(windowType==2)
					{
						windowType = 4;
						str = ""+tableSearch.getValueAt(tableSearch.getSelectedRow(), 0);
						txtMusicme.setText("musicMe");
						windowChangeControl(windowType);
					}
				}
			}
		});
		
		tableSearch.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("mouse:"+arg0.getButton());
				if(arg0.getButton()==3)
				{
					int returnValue;
					returnValue = JOptionPane.showConfirmDialog(mainScreen.this, "Delete form playlist?");
				}
			}
		});
		scrollSeach.setViewportView(tableSearch);
		tableSearch.setBounds(10, 146, 386, 265);
		tableSearch.setForeground(Color.white);
		tableSearch.setBackground(Color.black);

		btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtMusicme.setText("musicMe");
				windowType = 0;
				windowChangeControl(windowType);
			}
		});
		btnBack.setBackground(new Color(128, 0, 128));
		btnBack.setBounds(78, 422, 70, 50);

		//ADD TO CONTENT PANE
		getContentPane().add(btnHistory1);
		getContentPane().add(btnHistory2);
		getContentPane().add(btnHistory3);
		getContentPane().add(btnHistroyBack);
		getContentPane().add(btnHistoryForward);
		getContentPane().add(btnSearch);
		getContentPane().add(btnPlaylists);
		getContentPane().add(txtSearch);
		getContentPane().add(scrollSeach);
		getContentPane().add(lblPlayPhoto);
		getContentPane().add(btnPlay);
		getContentPane().add(btnRepeat);
		getContentPane().add(btnAddToPlaylist);
		getContentPane().add(btnBack);
		getContentPane().add(lblPlayedPhoto);
		
		btnHome = new JButton("Home");
		btnHome.setForeground(Color.WHITE);
		btnHome.setBackground(new Color(128, 0, 128));
		btnHome.setBounds(10, 422, 70, 50);
		getContentPane().add(btnHome);

		windowChangeControl(0);
	}

	void windowChangeControl(int i)
	{
		if(i==0)
		{
			btnHistory1.setVisible(true);
			btnHistory2.setVisible(true);
			btnHistory3.setVisible(true);
			btnHistroyBack.setVisible(true);
			btnHistoryForward.setVisible(true);
			btnSearch.setVisible(true);
			btnPlaylists.setVisible(true);

			tableSearch.setVisible(false);
			scrollSeach.setVisible(false);
			txtSearch.setVisible(false);

			lblPlayPhoto.setVisible(false);
			btnPlay.setVisible(false);
			btnRepeat.setVisible(false);
			btnAddToPlaylist.setVisible(false);
			lblPlayedPhoto.setVisible(false);
		}
		else if(i==1)
		{
			btnHistory1.setVisible(false);
			btnHistory2.setVisible(false);
			btnHistory3.setVisible(false);
			btnHistroyBack.setVisible(false);
			btnHistoryForward.setVisible(false);
			btnSearch.setVisible(false);
			btnPlaylists.setVisible(false);

			tableSearch.setVisible(true);

			String[][] data = new String[2][2];
			data[0][0] = "Counting Stars";
			data[0][1] = "One Republic";
			data[1][0] = "Highway to Hell";
			data[1][1] = "AC/DC";			
			tableSearch.setModel(new DefaultTableModel(data, new String[]{"Song", "Singer"}));

			scrollSeach.setVisible(true);
			txtSearch.setVisible(true);

			lblPlayPhoto.setVisible(false);
			btnPlay.setVisible(false);
			btnRepeat.setVisible(false);
			btnAddToPlaylist.setVisible(false);
			lblPlayedPhoto.setVisible(false);
		}
		else if(i==2)
		{
			btnHistory1.setVisible(false);
			btnHistory2.setVisible(false);
			btnHistory3.setVisible(false);
			btnHistroyBack.setVisible(false);
			btnHistoryForward.setVisible(false);
			btnSearch.setVisible(false);
			btnPlaylists.setVisible(false);
			txtSearch.setVisible(false);

			tableSearch.setVisible(true);
			String[][] data = new String[2][2];
			data[0][0] = "Turkish Pop";
			data[0][1] = "10";
			data[1][0] = "Classic Musics";
			data[1][1] = "3";			
			tableSearch.setModel(new DefaultTableModel(data, new String[]{"Playlist","No# Song"}));

			scrollSeach.setVisible(true);

			lblPlayPhoto.setVisible(false);
			btnPlay.setVisible(false);
			btnRepeat.setVisible(false);
			btnAddToPlaylist.setVisible(false);
			lblPlayedPhoto.setVisible(false);
		}
		else if(i==3)
		{
			btnHistory1.setVisible(false);
			btnHistory2.setVisible(false);
			btnHistory3.setVisible(false);
			btnHistroyBack.setVisible(false);
			btnHistoryForward.setVisible(false);
			btnSearch.setVisible(false);
			btnPlaylists.setVisible(false);
			txtSearch.setVisible(false);

			tableSearch.setVisible(false);
			scrollSeach.setVisible(false);

			lblPlayPhoto.setVisible(true);
			btnPlay.setVisible(true);
			btnRepeat.setVisible(true);
			btnAddToPlaylist.setVisible(true);
			lblPlayedPhoto.setVisible(true);
		}
		else if(i==4)
		{
			btnHistory1.setVisible(false);
			btnHistory2.setVisible(false);
			btnHistory3.setVisible(false);
			btnHistroyBack.setVisible(false);
			btnHistoryForward.setVisible(false);
			btnSearch.setVisible(false);
			btnPlaylists.setVisible(false);
			txtSearch.setVisible(false);

			tableSearch.setVisible(true);
			String[][] data = new String[3][2];
			data[0][0] = "Moment Musical";
			data[0][1] = "Schubert";
			data[1][0] = "Turkish March";
			data[1][1] = "Mozart";			
			data[2][0] = "Für Elise";
			data[2][1] = "Beethoven";			
			tableSearch.setModel(new DefaultTableModel(data, new String[]{"Song","Singer"}));
			
			scrollSeach.setVisible(true);

			lblPlayPhoto.setVisible(false);
			btnPlay.setVisible(false);
			btnRepeat.setVisible(false);
			btnAddToPlaylist.setVisible(false);
			lblPlayedPhoto.setVisible(false);
		}
	}
}
