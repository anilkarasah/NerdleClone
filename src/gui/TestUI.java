package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.Equation;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

public class TestUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textEquation;
	private JTextField txtUzunluk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestUI frame = new TestUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public TestUI() {
		Equation eq = new Equation();
		
		setTitle("Test Ekran\u0131");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textEquation = new JTextField();
		textEquation.setFont(new Font("Monospaced", Font.BOLD, 20));
		textEquation.setEditable(false);
		textEquation.setText(eq.generateEquation(""));
		textEquation.setHorizontalAlignment(SwingConstants.CENTER);
		textEquation.setBounds(80, 45, 270, 50);
		contentPane.add(textEquation);
		textEquation.setColumns(10);
		
		txtUzunluk = new JTextField();
		txtUzunluk.setHorizontalAlignment(SwingConstants.CENTER);
		txtUzunluk.setText("Uzunluk: " + eq.getLength());
		txtUzunluk.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtUzunluk.setBounds(140, 106, 150, 20);
		contentPane.add(txtUzunluk);
		txtUzunluk.setColumns(10);
		
		JButton btnRegenerate = new JButton("Yeniden \u00DCret");
		btnRegenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Equation equ = new Equation();
				textEquation.setText(equ.generateEquation(""));
				txtUzunluk.setText("Uzunluk: " + equ.getLength());
			}
		});
		btnRegenerate.setBounds(140, 150, 150, 30);
		contentPane.add(btnRegenerate);
		
		JButton btnGoBack = new JButton("Geri D\u00F6n");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeUI.showHome();
				HomeUI.hideTest();
			}
		});
		btnGoBack.setBounds(140, 200, 150, 30);
		contentPane.add(btnGoBack);
	}
}
