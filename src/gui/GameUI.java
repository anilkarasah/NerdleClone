package gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.Calculate;
import utils.ContinueLater;
import utils.Equation;
import utils.Statistics;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.Insets;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JLabel;

public class GameUI extends JFrame implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static final int buttonWidth = 40;
	private static final int buttonGap = 10;

	private JPanel contentPane;
	private JLabel textFooter;
	private static Equation equation;
	private static JButton[][] guessBtns;
	
	private static int currentRow;
	private static int cursor = -1;
	private static Character[] guess;
	private static Equation[] guesses;
	private static Timer timer;

	public GameUI() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		currentRow = 0;
		equation = new Equation();
		equation.setEquation(equation.generateEquation(""));
		System.out.println(equation.getEquation());
		guess = new Character[equation.getLength()];
		guesses = new Equation[6];
		int panelWidth = (buttonWidth * equation.getLength()) + (buttonGap * (equation.getLength() + 2));
		panelWidth = panelWidth < 420 ? 425 : panelWidth + 5;
		int panelHeight = 600;
		setBounds(100, 100, panelWidth, panelHeight);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		guessBtns = new JButton[6][equation.getLength()];
		
		JLabel lblTimer = new JLabel("");
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimer.setBounds(20, 460, 100, 40);
		contentPane.add(lblTimer);
		
		timer = new Timer();
		
		TimerTask myTask = new TimerTask() {
			int seconds = 0;
			String sec;
			
			@SuppressWarnings("unused")
			public int getSeconds() {
				return seconds;
			}
			
			@Override
			public void run() {
				seconds++;
				sec = Integer.toString(seconds);
				lblTimer.setText(sec);
			}
		};
		
		timer.schedule(myTask, 0, 1000);
		
		// INITIALIZE TEXT FIELDS FOR GUESSES
		int initX = 10, initY = 10;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < equation.getLength(); j++) {
				guessBtns[i][j] = new JButton("");
				guessBtns[i][j].setBounds(initX, initY, buttonWidth, buttonWidth);
				guessBtns[i][j].setMargin(new Insets(0, 0, 0, 0));
				if (i != currentRow) {
					guessBtns[i][j].setEnabled(false);
				}
				contentPane.add(guessBtns[i][j]);
				initX += buttonGap + buttonWidth;
			}
			initY += buttonGap + buttonWidth;
			initX = buttonGap;
		}
		
		JButton btnPress1 = new JButton("1");
		btnPress1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar('1');
			}
		});
		btnPress1.setMargin(new Insets(0, 0, 0, 0));
		btnPress1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPress1.setBounds(5, 330, buttonWidth, buttonWidth);
		contentPane.add(btnPress1);

		JButton btnPress2 = new JButton("2");
		btnPress2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar('2');
			}
		});
		btnPress2.setMargin(new Insets(0, 0, 0, 0));
		btnPress2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPress2.setBounds(45, 330, buttonWidth, buttonWidth);
		contentPane.add(btnPress2);

		JButton btnPress3 = new JButton("3");
		btnPress3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar('3');
			}
		});
		btnPress3.setMargin(new Insets(0, 0, 0, 0));
		btnPress3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPress3.setBounds(85, 330, buttonWidth, buttonWidth);
		contentPane.add(btnPress3);

		JButton btnPress4 = new JButton("4");
		btnPress4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar('4');
			}
		});
		btnPress4.setMargin(new Insets(0, 0, 0, 0));
		btnPress4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPress4.setBounds(125, 330, buttonWidth, buttonWidth);
		contentPane.add(btnPress4);

		JButton btnPress5 = new JButton("5");
		btnPress5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar('5');
			}
		});
		btnPress5.setMargin(new Insets(0, 0, 0, 0));
		btnPress5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPress5.setBounds(165, 330, buttonWidth, buttonWidth);
		contentPane.add(btnPress5);

		JButton btnPress6 = new JButton("6");
		btnPress6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar('6');
			}
		});
		btnPress6.setMargin(new Insets(0, 0, 0, 0));
		btnPress6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPress6.setBounds(205, 330, buttonWidth, buttonWidth);
		contentPane.add(btnPress6);

		JButton btnPress7 = new JButton("7");
		btnPress7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar('7');
			}
		});
		btnPress7.setMargin(new Insets(0, 0, 0, 0));
		btnPress7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPress7.setBounds(245, 330, buttonWidth, buttonWidth);
		contentPane.add(btnPress7);

		JButton btnPress8 = new JButton("8");
		btnPress8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar('8');
			}
		});
		btnPress8.setMargin(new Insets(0, 0, 0, 0));
		btnPress8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPress8.setBounds(285, 330, buttonWidth, buttonWidth);
		contentPane.add(btnPress8);

		JButton btnPress9 = new JButton("9");
		btnPress9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar('9');
			}
		});
		btnPress9.setMargin(new Insets(0, 0, 0, 0));
		btnPress9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPress9.setBounds(325, 330, buttonWidth, buttonWidth);
		contentPane.add(btnPress9);

		JButton btnPress0 = new JButton("0");
		btnPress0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar('0');
			}
		});
		btnPress0.setMargin(new Insets(0, 0, 0, 0));
		btnPress0.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPress0.setBounds(365, 330, buttonWidth, buttonWidth);
		contentPane.add(btnPress0);

		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar('+');
			}
		});
		btnPlus.setMargin(new Insets(0, 0, 0, 0));
		btnPlus.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPlus.setBounds(25, 375, buttonWidth, buttonWidth);
		contentPane.add(btnPlus);

		JButton btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar('-');
			}
		});
		btnMinus.setMargin(new Insets(0, 0, 0, 0));
		btnMinus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMinus.setBounds(65, 375, buttonWidth, buttonWidth);
		contentPane.add(btnMinus);

		JButton btnMultiple = new JButton("*");
		btnMultiple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar('*');
			}
		});
		btnMultiple.setMargin(new Insets(0, 0, 0, 0));
		btnMultiple.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMultiple.setBounds(105, 375, buttonWidth, buttonWidth);
		contentPane.add(btnMultiple);

		JButton btnDivide = new JButton("/");
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar('/');
			}
		});
		btnDivide.setMargin(new Insets(0, 0, 0, 0));
		btnDivide.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDivide.setBounds(145, 375, buttonWidth, buttonWidth);
		contentPane.add(btnDivide);
		
		JButton btnEquals = new JButton("=");
		btnEquals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar('=');
			}
		});
		btnEquals.setMargin(new Insets(0, 0, 0, 0));
		btnEquals.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEquals.setBounds(185, 375, buttonWidth, buttonWidth);
		contentPane.add(btnEquals);
		
		JButton btnGuess = new JButton("Tahmin Et");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numberOfOperators = 0;
				int numberOfEqualsSign = 0;
				for (int i = 0; i < equation.getLength(); i++) {
					if (guess[i] == null) {
						JOptionPane.showMessageDialog(null, "Lütfen boþluk býrakmayýn.");
						return;
					}
					
					if (guess[i] == '+' || guess[i] == '-' || guess[i] == '*' || guess[i] == '/')
						numberOfOperators++;
					else if (guess[i] == '=')
						numberOfEqualsSign++;
				}
				
				if (numberOfOperators == 0 || numberOfEqualsSign != 1) {
					JOptionPane.showMessageDialog(null, "Tahmininizde en az bir adet matematiksel iþaret ve bir adet eþittir iþareti bulunmak zorundadýr.");
					return;
				}
				
				String temp = "";
				for (int i = 0; i < equation.getLength(); i++)
					temp += guessBtns[currentRow][i].getText();
				
				if (Calculate.isEquationValid(temp)) {
					JOptionPane.showMessageDialog(null, "Denklem eþit deðil.");
					return;
				}
				
				guesses[currentRow] = new Equation(temp, equation.getLength());
				boolean flag = guesses[currentRow].checkForCorrectness(equation.getEquation());
				for (int i = 0; i < equation.getLength(); i++) {
					int correctness = guesses[currentRow].getCorrectness(i);
					guessBtns[currentRow][i].setFont(new Font("Tahoma", Font.BOLD, 16));
					switch (correctness) {
					case 1:
						guessBtns[currentRow][i].setBackground(new Color(0, 255, 0));
						break;
					case 2:
						guessBtns[currentRow][i].setBackground(new Color(255, 255, 0));
						break;
					case -1:
						guessBtns[currentRow][i].setBackground(new Color(255, 0, 0));
						break;
					}
				}
				
				if (flag) {
					// Doðru tahmin edildi
					HomeUI.hideGame();
					HomeUI.showWin();
					
					Statistics s = HomeUI.getStats();
					s.setWon(s.getWon() + 1);
					if (s.getWon() == 0)
						s.setAvgGuesses((double) currentRow);
					else
						s.setAvgGuesses(((double)currentRow + s.getAvgGuesses()) / s.getWon());
					Random r = new Random();
					s.setAvgFinishTime(r.nextInt(60));
					HomeUI.setStats(s);
					
					s.saveToFile();
					
					return;
				}
				
				if (currentRow == 5) {
					// Son tahmin hakkýnda da yanlýþ girildi.
					
					HomeUI.hideGame();
					HomeUI.showLose();
					
					Statistics s = HomeUI.getStats();
					s.setLost(s.getLost() + 1);
					HomeUI.setStats(s);
					
					s.saveToFile();
					
					return;
				}
				
				cursor = -1;
				currentRow++;
				
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < equation.getLength(); j++) {
						guessBtns[i][j].setEnabled(i == currentRow);
					}
				}
			}
		});
		btnGuess.setMargin(new Insets(0, 0, 0, 0));
		btnGuess.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGuess.setBounds(225, 375, buttonWidth * 2, buttonWidth);
		contentPane.add(btnGuess);
		
		JButton btnContLater = new JButton("Sonra Devam Et");
		btnContLater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContinueLater later = new ContinueLater(/*guesses, */equation, currentRow, guessBtns, cursor);
				later.saveToFile(later);
				
				Statistics s = HomeUI.getStats();
				s.setLeft(s.getLeft() + 1);
				HomeUI.setStats(s);
				
				s.saveToFile();
				
				HomeUI.hideGame();
				HomeUI.showHome();
			}
		});
		int posX = (panelWidth - 150) / 2;
		btnContLater.setBounds(posX, 470, 150, 30);
		contentPane.add(btnContLater);
		
		JButton btnDelete = new JButton("Sil");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cursor == -1) return;
				if (cursor == equation.getLength()) cursor--;
				
				guess[cursor] = null;
				guessBtns[currentRow][cursor].setText(null);
				cursor--;
			}
		});
		btnDelete.setMargin(new Insets(0, 0, 0, 0));
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDelete.setBounds(305, 375, 80, 40);
		contentPane.add(btnDelete);
		
		textFooter = new JLabel("Mehmet An\u0131l Kara\u015Fah  - 19011036 | Umut De\u015Fer - 19011013");
		textFooter.setBounds(5, 515, 424, 35);
		textFooter.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(textFooter);
	}
	
	public static void addChar(Character newChar) {
		cursor++;
		
		if (cursor >= equation.getLength()) {
			JOptionPane.showMessageDialog(null, "Daha fazla karakter giremezsiniz.");
			return;
		}
		
		if (cursor == 0 && (newChar == '+' || newChar == '-' || newChar == '*' || newChar == '/' || newChar == '=')) {
			JOptionPane.showMessageDialog(null, "Ýlk karakter sayý olmalýdýr.");
			return;
		}
		
		guessBtns[currentRow][cursor].setText(newChar.toString());
		guess[cursor] = newChar;
	}
	
	public GameUI(ContinueLater cl) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		currentRow = 0;
		equation = new Equation();
		equation.setEquation(equation.generateEquation(""));
		guess = new Character[equation.getLength()];
		guesses = new Equation[6];
		int panelWidth = (buttonWidth * equation.getLength()) + (buttonGap * (equation.getLength() + 2));
		panelWidth = panelWidth < 420 ? 425 : panelWidth + 5;
		int panelHeight = 600;
		setBounds(100, 100, panelWidth, panelHeight);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		guessBtns = new JButton[6][equation.getLength()];
		
		JLabel lblTimer = new JLabel("");
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimer.setBounds(20, 460, 100, 40);
		contentPane.add(lblTimer);

		timer = new Timer();
		TimerTask myTask = new TimerTask() {
			int seconds = 0;
			String sec;
			
			@SuppressWarnings("unused")
			public int getSeconds() {
				return seconds;
			}
			
			@Override
			public void run() {
				seconds++;
				sec = Integer.toString(seconds);
				lblTimer.setText(sec);
			}
		};
		timer.schedule(myTask, 0, 1000);
		
		currentRow = cl.getCurrentRow();
		equation = cl.getRealEquation();
		cursor = cl.getCursor() - 1;
		JButton[][] temp = cl.getGuessBtns();
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < equation.getLength(); j++) {
				contentPane.add(temp[i][j]);
			}
		}
		
		JButton btnPress1 = new JButton("1");
		btnPress1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar('1');
			}
		});
		btnPress1.setMargin(new Insets(0, 0, 0, 0));
		btnPress1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPress1.setBounds(5, 330, buttonWidth, buttonWidth);
		contentPane.add(btnPress1);

		JButton btnPress2 = new JButton("2");
		btnPress2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar('2');
			}
		});
		btnPress2.setMargin(new Insets(0, 0, 0, 0));
		btnPress2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPress2.setBounds(45, 330, buttonWidth, buttonWidth);
		contentPane.add(btnPress2);

		JButton btnPress3 = new JButton("3");
		btnPress3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar('3');
			}
		});
		btnPress3.setMargin(new Insets(0, 0, 0, 0));
		btnPress3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPress3.setBounds(85, 330, buttonWidth, buttonWidth);
		contentPane.add(btnPress3);

		JButton btnPress4 = new JButton("4");
		btnPress4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar('4');
			}
		});
		btnPress4.setMargin(new Insets(0, 0, 0, 0));
		btnPress4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPress4.setBounds(125, 330, buttonWidth, buttonWidth);
		contentPane.add(btnPress4);

		JButton btnPress5 = new JButton("5");
		btnPress5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar('5');
			}
		});
		btnPress5.setMargin(new Insets(0, 0, 0, 0));
		btnPress5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPress5.setBounds(165, 330, buttonWidth, buttonWidth);
		contentPane.add(btnPress5);

		JButton btnPress6 = new JButton("6");
		btnPress6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar('6');
			}
		});
		btnPress6.setMargin(new Insets(0, 0, 0, 0));
		btnPress6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPress6.setBounds(205, 330, buttonWidth, buttonWidth);
		contentPane.add(btnPress6);

		JButton btnPress7 = new JButton("7");
		btnPress7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar('7');
			}
		});
		btnPress7.setMargin(new Insets(0, 0, 0, 0));
		btnPress7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPress7.setBounds(245, 330, buttonWidth, buttonWidth);
		contentPane.add(btnPress7);

		JButton btnPress8 = new JButton("8");
		btnPress8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar('8');
			}
		});
		btnPress8.setMargin(new Insets(0, 0, 0, 0));
		btnPress8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPress8.setBounds(285, 330, buttonWidth, buttonWidth);
		contentPane.add(btnPress8);

		JButton btnPress9 = new JButton("9");
		btnPress9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar('9');
			}
		});
		btnPress9.setMargin(new Insets(0, 0, 0, 0));
		btnPress9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPress9.setBounds(325, 330, buttonWidth, buttonWidth);
		contentPane.add(btnPress9);

		JButton btnPress0 = new JButton("0");
		btnPress0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar('0');
			}
		});
		btnPress0.setMargin(new Insets(0, 0, 0, 0));
		btnPress0.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPress0.setBounds(365, 330, buttonWidth, buttonWidth);
		contentPane.add(btnPress0);

		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar('+');
			}
		});
		btnPlus.setMargin(new Insets(0, 0, 0, 0));
		btnPlus.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPlus.setBounds(25, 375, buttonWidth, buttonWidth);
		contentPane.add(btnPlus);

		JButton btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar('-');
			}
		});
		btnMinus.setMargin(new Insets(0, 0, 0, 0));
		btnMinus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMinus.setBounds(65, 375, buttonWidth, buttonWidth);
		contentPane.add(btnMinus);

		JButton btnMultiple = new JButton("*");
		btnMultiple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar('*');
			}
		});
		btnMultiple.setMargin(new Insets(0, 0, 0, 0));
		btnMultiple.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMultiple.setBounds(105, 375, buttonWidth, buttonWidth);
		contentPane.add(btnMultiple);

		JButton btnDivide = new JButton("/");
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar('/');
			}
		});
		btnDivide.setMargin(new Insets(0, 0, 0, 0));
		btnDivide.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDivide.setBounds(145, 375, buttonWidth, buttonWidth);
		contentPane.add(btnDivide);
		
		JButton btnEquals = new JButton("=");
		btnEquals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChar('=');
			}
		});
		btnEquals.setMargin(new Insets(0, 0, 0, 0));
		btnEquals.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEquals.setBounds(185, 375, buttonWidth, buttonWidth);
		contentPane.add(btnEquals);
		
		JButton btnGuess = new JButton("Tahmin Et");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numberOfOperators = 0;
				int numberOfEqualsSign = 0;
				for (int i = 0; i < equation.getLength(); i++) {
					if (guess[i] == null) {
						JOptionPane.showMessageDialog(null, "Lütfen boþluk býrakmayýn.");
						return;
					}
					
					if (guess[i] == '+' || guess[i] == '-' || guess[i] == '*' || guess[i] == '/')
						numberOfOperators++;
					else if (guess[i] == '=')
						numberOfEqualsSign++;
				}
				
				if (numberOfOperators == 0 || numberOfEqualsSign != 1) {
					JOptionPane.showMessageDialog(null, "Tahmininizde en az bir adet matematiksel iþaret ve bir adet eþittir iþareti bulunmak zorundadýr.");
					return;
				}
				
				String temp = "";
				for (int i = 0; i < equation.getLength(); i++)
					temp += guessBtns[currentRow][i].getText();
				
				if (Calculate.isEquationValid(temp)) {
					JOptionPane.showMessageDialog(null, "Denklem eþit deðil.");
					return;
				}
				
				guesses[currentRow] = new Equation(temp, equation.getLength());
				boolean flag = guesses[currentRow].checkForCorrectness(equation.getEquation());
				for (int i = 0; i < equation.getLength(); i++) {
					int correctness = guesses[currentRow].getCorrectness(i);
					guessBtns[currentRow][i].setFont(new Font("Tahoma", Font.BOLD, 16));
					switch (correctness) {
					case 1:
						guessBtns[currentRow][i].setBackground(new Color(0, 255, 0));
						break;
					case 2:
						guessBtns[currentRow][i].setBackground(new Color(255, 255, 0));
						break;
					case -1:
						guessBtns[currentRow][i].setBackground(new Color(255, 0, 0));
						break;
					}
				}
				
				if (flag) {
					// Doðru tahmin edildi
					HomeUI.hideGame();
					HomeUI.showWin();
					
					Statistics s = HomeUI.getStats();
					s.setWon(s.getWon() + 1);
					if (s.getWon() == 0)
						s.setAvgGuesses((double) currentRow);
					else
						s.setAvgGuesses(((double)currentRow + s.getAvgGuesses()) / s.getWon());
					Random r = new Random();
					s.setAvgFinishTime(r.nextInt(60));
					HomeUI.setStats(s);
					
					s.saveToFile();
					
					return;
				}
				
				if (currentRow == 5) {
					// Son tahmin hakkýnda da yanlýþ girildi.
					
					HomeUI.hideGame();
					HomeUI.showLose();
					
					Statistics s = HomeUI.getStats();
					s.setLost(s.getLost() + 1);
					HomeUI.setStats(s);
					
					s.saveToFile();
					
					return;
				}
				
				cursor = -1;
				currentRow++;
				
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < equation.getLength(); j++) {
						guessBtns[i][j].setEnabled(i == currentRow);
					}
				}
			}
		});
		btnGuess.setMargin(new Insets(0, 0, 0, 0));
		btnGuess.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGuess.setBounds(225, 375, buttonWidth * 2, buttonWidth);
		contentPane.add(btnGuess);
		
		JButton btnContLater = new JButton("Sonra Devam Et");
		btnContLater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContinueLater later = new ContinueLater(equation, currentRow, guessBtns, cursor);
				later.saveToFile(later);
				
				Statistics s = HomeUI.getStats();
				s.setLeft(s.getLeft() + 1);
				HomeUI.setStats(s);
				
				s.saveToFile();
				
				HomeUI.hideGame();
				HomeUI.showHome();
			}
		});
		int posX = (panelWidth - 150) / 2;
		btnContLater.setBounds(posX, 470, 150, 30);
		contentPane.add(btnContLater);
		
		JButton btnDelete = new JButton("Sil");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cursor == -1) return;
				if (cursor == equation.getLength()) cursor--;
				
				guess[cursor] = null;
				guessBtns[currentRow][cursor].setText(null);
				cursor--;
			}
		});
		btnDelete.setMargin(new Insets(0, 0, 0, 0));
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDelete.setBounds(305, 375, 80, 40);
		contentPane.add(btnDelete);
		
		textFooter = new JLabel("Mehmet An\u0131l Kara\u015Fah  - 19011036 | Umut De\u015Fer - 19011013");
		textFooter.setBounds(5, 515, 424, 35);
		textFooter.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(textFooter);
	}
}
