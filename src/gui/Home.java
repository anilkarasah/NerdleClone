package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import utils.Equation;

import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.awt.event.ActionEvent;

public class Home extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private static Equation equation;

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
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, equation.getEquation());
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		
		setTitle("Nerdle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
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
				Game screen = new Game(equation);
				screen.setVisible(true);
			}
		});
		contentPane.add(btnStart);
		
		JButton btnContinue = new JButton("Devam Et");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		ObjectInputStream input;
		try {
			input = new ObjectInputStream(new FileInputStream("previousGame.txt"));
			btnContinue.setVisible(true);
			equation = (Equation) input.readObject();
			input.close();
		} catch (IOException e) {
			System.out.println("previousGame.txt: Dosya bulunamadý.");
			btnContinue.setVisible(false);
		} catch (ClassNotFoundException e) {
			System.out.println("Equation sýnýfý bulunamadý.");
			btnContinue.setVisible(false);
		}
		
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
