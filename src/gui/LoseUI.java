package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LoseUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	public LoseUI() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 316, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelWon = new JLabel("KAYBETTÝNÝZ");
		labelWon.setFont(new Font("Tahoma", Font.BOLD, 24));
		labelWon.setHorizontalAlignment(SwingConstants.CENTER);
		labelWon.setBounds(0, 52, 300, 58);
		contentPane.add(labelWon);
		
		JButton btnMainMenu = new JButton("Ana Men\u00FCye D\u00F6n");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeUI.hideLose();
				HomeUI.showHome();
			}
		});
		btnMainMenu.setBounds(75, 200, 150, 40);
		contentPane.add(btnMainMenu);
	}

}
