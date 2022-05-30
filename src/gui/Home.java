package gui;

//import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {
	private static final long serialVersionUID = 1L;
	
//	private CardLayout cardLayout;
	private JPanel contentPane;
//	private StatisticsUI stats;
//	private GameUI game;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
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

	/**
	 * Create the frame.
	 */
	public Home() {
	//	cardLayout = new CardLayout();
		contentPane = new JPanel();
	//	stats = new StatisticsUI();
	//	game = new GameUI();
	//	contentPane.add(stats, "stats");
	//	contentPane.add(game, "game");
		
		setTitle("Nerdle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				GameUI screen = new GameUI();
				screen.setVisible(true);
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
