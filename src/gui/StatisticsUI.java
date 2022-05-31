package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.Statistics;

import javax.swing.JLabel;
import java.awt.Font;

public class StatisticsUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private Statistics s;

	public StatisticsUI() {
		s = HomeUI.getStats();
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 316, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGoBack = new JButton("Geri D\u00F6n");
		btnGoBack.setBounds(100, 204, 100, 30);
		contentPane.add(btnGoBack);
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeUI.showHome();
				HomeUI.hideStats();
			}
		});
		
		JLabel lblTotalGames = new JLabel("Toplam oynanýlan oyun: " + (s.getWon() + s.getLost()));
		lblTotalGames.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotalGames.setBounds(10, 20, 280, 20);
		contentPane.add(lblTotalGames);
		
		JLabel lblWonGames = new JLabel("Kazanýlan toplam oyun: " + s.getWon());
		lblWonGames.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWonGames.setBounds(10, 50, 280, 20);
		contentPane.add(lblWonGames);
		
		JLabel lblLostGames = new JLabel("Kaybedilen toplam oyun: " + s.getLost());
		lblLostGames.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLostGames.setBounds(10, 80, 280, 20);
		contentPane.add(lblLostGames);
		
		JLabel lblAvgGuess = new JLabel("Ortalama tahmin: " + s.getAvgGuesses());
		lblAvgGuess.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAvgGuess.setBounds(10, 110, 280, 20);
		contentPane.add(lblAvgGuess);
		
		JLabel lblAvgTime = new JLabel("Ortalama tahmin: " + s.getAvgFinishTime());
		lblAvgTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAvgTime.setBounds(10, 140, 280, 20);
		contentPane.add(lblAvgTime);
	}

}
