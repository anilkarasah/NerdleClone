package gui;

import javax.swing.JPanel;

import utils.Statistics;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;

public class StatisticsUI extends JPanel {
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public StatisticsUI() {
		Statistics s = new Statistics();
		try {			
			s.readFromFile();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		setLayout(null);
		
		JButton btnNewButton = new JButton("Geri D\u00F6n");
		btnNewButton.setBounds(179, 266, 89, 23);
		add(btnNewButton);
		
		JTextArea txtrAsd = new JTextArea();
		txtrAsd.setRows(5);
		txtrAsd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		float avgFinishRate;
		try {
			avgFinishRate = s.getWon() / (s.getLost() + s.getWon());
		} catch (ArithmeticException e) {
			avgFinishRate = 0;
		}
		txtrAsd.setText(s.getWon() + "\tKazanýlan oyunlar\n" + s.getLost() + "\tKaybedilen oyunlar\n" + s.getLeft() + 
				"\tYarým býrakýlan oyunlar\n" + avgFinishRate + "\tKazanma oraný\n" + 
				s.getAvgFinishTime() + "\tOrtalama bitirme süresi");
		txtrAsd.setBounds(10, 11, 430, 230);
		add(txtrAsd);
	}
}
