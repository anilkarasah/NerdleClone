package gui;

//import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.ContinueLater;
import utils.Statistics;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class HomeUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private static Statistics stats;
	private static HomeUI home;
	private static GameUI game;
	private static StatisticsUI statistics;
	private static WinUI win;
	private static LoseUI lose;
	private static TestUI test;

	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home = new HomeUI();
					showHome();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HomeUI() {
		stats = new Statistics();
		
		contentPane = new JPanel();
		statistics = new StatisticsUI();
		statistics.setVisible(false);
		win = new WinUI();
		win.setVisible(false);
		lose = new LoseUI();
		lose.setVisible(false);
		test = new TestUI();
		test.setVisible(false);
		
		setTitle("Nerdle");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel textHeader = new JLabel("M\u0131zm\u0131z Nerdle");
		textHeader.setBounds(97, 10, 240, 80);
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
				game = new GameUI(null);
				game.setVisible(true);
				
				hideHome();
			}
		});
		contentPane.add(btnStart);
		
		JButton btnContinue = new JButton("Devam Et");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("stats.txt");
				if (!file.exists()) {
					JOptionPane.showMessageDialog(null, "Yar\u0131m b\u0131rakt\u0131ğ\u0131n\u0131z oyun bulunamad\u0131.");
					return;
				}
				
				ContinueLater cl = ContinueLater.readFromFile();
				game = new GameUI(cl);
				game.setVisible(true);
				hideHome();
			}
		});
		
		btnContinue.setBounds(97, 170, 240, 40);
		contentPane.add(btnContinue);
		
		JButton btnTest = new JButton("Test");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTest();
				hideHome();
			}
		});
		btnTest.setBounds(97, 220, 240, 40);
		contentPane.add(btnTest);
		
		JButton btnStatistics = new JButton("\u0130statistikler");
		btnStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hideHome();
				showStats();
			}
		});
		btnStatistics.setBounds(97, 350, 115, 40);
		contentPane.add(btnStatistics);
		
		JButton btnExit = new JButton("\u00C7\u0131k\u0131\u015F");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stats.saveToFile();
				System.exit(0);
			}
		});
		btnExit.setBounds(220, 350, 115, 40);
		contentPane.add(btnExit);
		
		JButton btnStoryOfName = new JButton("?");
		btnStoryOfName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "\"M\u0131zm\u0131z Nerdle\" ismi Harry Potter evrenindeki M\u0131zm\u0131z Myrtle'dan esinlenildi :)");
			}
		});
		btnStoryOfName.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnStoryOfName.setToolTipText("Bu isim nereden geliyor?");
		btnStoryOfName.setBounds(335, 30, 40, 40);
		btnStoryOfName.setMargin(new Insets(0, 0, 0, 0));
		contentPane.add(btnStoryOfName);
	}
	
	public static void setStats(Statistics s) { stats = s; }
	public static Statistics getStats() { return stats; }

	public static void showHome() { home.setVisible(true); }
	public static void hideHome() { home.setVisible(false); }

	public static void showGame() { game.setVisible(true); }
	public static void hideGame() { game.setVisible(false); }

	public static void showStats() { statistics.setVisible(true); }
	public static void hideStats() { statistics.setVisible(false); }

	public static void showWin() { win.setVisible(true); }
	public static void hideWin() { win.setVisible(false); }

	public static void showLose() { lose.setVisible(true); }
	public static void hideLose() { lose.setVisible(false); }

	public static void showTest() { test.setVisible(true); }
	public static void hideTest() { test.setVisible(false); }
}
