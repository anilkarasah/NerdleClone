package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.Equation;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.FlowLayout;

public class GameUI extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private static Equation equation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//				Game frame = new Game();
	//				frame.setVisible(true);
	//			} catch (Exception e) {
	//				e.printStackTrace();
	//			}
	//		}
	//	});
	}

	/**
	 * Create the frame.
	 */
	public GameUI() {
		equation = new Equation();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// INITIALIZE TEXT FIELDS FOR GUESSES
		int gapBetween = 10;
		int initX = 10, initY = 10;
		int tempX = 10;
		int width = 40, height = 40;
		for (int i = 0; i < 6; i++) {
			tempX = initX;
			for (int j = 0; j < equation.getLength(); j++) {
				JTextField newText = new JTextField();
				newText.setBounds(initX, initY, width, height);
			//	panel.add(newText);
				initX += gapBetween + width;
			}
			initY += gapBetween + height;
			initX = tempX;
		}
		
		Panel panel = new Panel();
		panel.setBounds(0, 310, 409, 105);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnPress1 = new JButton("1");
		btnPress1.setMargin(new Insets(0, 0, 0, 0));
		btnPress1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPress1.setBounds(5, 330, 40, 40);
		panel.add(btnPress1);
		
		JButton btnPress2 = new JButton("2");
		btnPress2.setMargin(new Insets(0, 0, 0, 0));
		btnPress2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPress2.setBounds(45, 330, 40, 40);
		panel.add(btnPress2);
		
		JButton btnPress3 = new JButton("3");
		btnPress3.setMargin(new Insets(0, 0, 0, 0));
		btnPress3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPress3.setBounds(85, 330, 40, 40);
		panel.add(btnPress3);
		
		JButton btnPress4 = new JButton("4");
		btnPress4.setMargin(new Insets(0, 0, 0, 0));
		btnPress4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPress4.setBounds(125, 330, 40, 40);
		panel.add(btnPress4);
		
		JButton btnPress5 = new JButton("5");
		btnPress5.setMargin(new Insets(0, 0, 0, 0));
		btnPress5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPress5.setBounds(165, 330, 40, 40);
		panel.add(btnPress5);
		
		JButton btnPress6 = new JButton("6");
		btnPress6.setMargin(new Insets(0, 0, 0, 0));
		btnPress6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPress6.setBounds(205, 330, 40, 40);
		panel.add(btnPress6);
		
		JButton btnPress7 = new JButton("7");
		btnPress7.setMargin(new Insets(0, 0, 0, 0));
		btnPress7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPress7.setBounds(245, 330, 40, 40);
		panel.add(btnPress7);
		
		JButton btnPress8 = new JButton("8");
		btnPress8.setMargin(new Insets(0, 0, 0, 0));
		btnPress8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPress8.setBounds(285, 330, 40, 40);
		panel.add(btnPress8);
		
		JButton btnPress9 = new JButton("9");
		btnPress9.setMargin(new Insets(0, 0, 0, 0));
		btnPress9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPress9.setBounds(325, 330, 40, 40);
		panel.add(btnPress9);
		
		JButton btnPress0 = new JButton("0");
		btnPress0.setMargin(new Insets(0, 0, 0, 0));
		btnPress0.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPress0.setBounds(365, 330, 40, 40);
		panel.add(btnPress0);
		
		JButton btnPlus = new JButton("+");
		btnPlus.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPlus.setBounds(65, 375, 40, 40);
		panel.add(btnPlus);
		
		JButton btnMinus = new JButton("-");
		btnMinus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMinus.setBounds(105, 375, 40, 40);
		panel.add(btnMinus);
		
		JButton btnMultiple = new JButton("*");
		btnMultiple.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMultiple.setBounds(145, 375, 40, 40);
		panel.add(btnMultiple);
		
		JButton btnDivide = new JButton("/");
		btnDivide.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDivide.setBounds(185, 375, 40, 40);
		panel.add(btnDivide);
		
		JButton btnEquals = new JButton("=");
		btnEquals.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnEquals.setBounds(225, 375, 120, 40);
		panel.add(btnEquals);
		
		//textField = new JTextField();
		//textField.setBounds(10, 11, 96, 20);
		//contentPane.add(textField);
		//textField.setColumns(10);
	}
}
