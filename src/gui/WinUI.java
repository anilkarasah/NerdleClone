package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class WinUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	public WinUI() {
		setTitle("Kazand\u0131n\u0131z");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 316, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelWon = new JLabel("KAZANDINIZ");
		labelWon.setFont(new Font("Tahoma", Font.BOLD, 24));
		labelWon.setHorizontalAlignment(SwingConstants.CENTER);
		labelWon.setBounds(0, 52, 300, 58);
		contentPane.add(labelWon);
		
		JButton btnMainMenu = new JButton("Ana Men\u00FCye D\u00F6n");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeUI.hideWin();
				HomeUI.showHome();
			}
		});
		btnMainMenu.setBounds(75, 200, 150, 40);
		contentPane.add(btnMainMenu);
	}

}
