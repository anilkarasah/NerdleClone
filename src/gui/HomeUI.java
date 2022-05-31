package gui;

//import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.Statistics;

//import utils.Statistics;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private static Statistics stats;
	
	public static HomeUI home;
	public static GameUI game;
	public static StatisticsUI statistics;
	public static WinUI win;
	public static LoseUI lose;
	public static TestUI test;

	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home = new HomeUI();
					home.setVisible(true);
					
					stats = stats.readFromFile();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void openStatisticsPane() {
		StatisticsUI statsPanel = new StatisticsUI();
		statsPanel.setVisible(true);
	}

	public HomeUI() {
		contentPane = new JPanel();
		
		game = new GameUI();
		game.setVisible(false);
		statistics = new StatisticsUI();
		statistics.setVisible(false);
		win = new WinUI();
		win.setVisible(false);
		lose = new LoseUI();
		lose.setVisible(false);
		test = new TestUI();
		test.setVisible(false);
		
		stats = new Statistics();
		
		setTitle("Nerdle");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel textHeader = new JLabel("Nerdle Clone");
		textHeader.setBounds(5, 5, 424, 84);
		textHeader.setFont(new Font("Tahoma", Font.BOLD, 24));
		textHeader.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(textHeader);
		
		JLabel textFooter = new JLabel("Mehmet An\u0131l Kara\u015Fah  - 19011036 | Umut De\u015Fer - 19011013");
		textFooter.setBounds(5, 421, 424, 35);
		textFooter.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(textFooter);
		
		JButton btnStart = new JButton("Ba\u015Flat");
		btnStart.setBounds(97, 100, 240, 60);
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setVisible(true);
				home.setVisible(false);
			}
		});
		contentPane.add(btnStart);
		
		JButton btnContinue = new JButton("Devam Et");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnContinue.setBounds(97, 170, 240, 40);
		contentPane.add(btnContinue);
		
		JButton btnTest = new JButton("Test");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				test.setVisible(true);
				home.setVisible(false);
			}
		});
		btnTest.setBounds(97, 220, 240, 40);
		contentPane.add(btnTest);
		
		JButton btnStatistics = new JButton("\u0130statistikler");
		btnStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openStatisticsPane();
			}
		});
		btnStatistics.setBounds(97, 350, 115, 40);
		contentPane.add(btnStatistics);
		
		JButton btnExit = new JButton("\u00C7\u0131k\u0131\u015F");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(220, 350, 115, 40);
		contentPane.add(btnExit);
	}
}
