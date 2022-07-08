package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JButton;

public class ContinueLater implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static final String filePath = "continue_later.txt";
	private int currentRow;
	private JButton[][] guessBtns;
	private Equation realEquation;
	private int cursor;
	
	public ContinueLater(Equation realEquation, int currentRow, JButton[][] guessBtns, int cursor) {
		this.realEquation = realEquation;
		this.currentRow = currentRow;
		this.guessBtns = guessBtns;
		this.cursor = cursor;
	}
	
	public static ContinueLater readFromFile() {
		File file = new File(filePath);
		try {
			file.createNewFile();
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			ContinueLater cl = (ContinueLater) in.readObject();
			in.close();
			return cl;
		} catch (IOException e) {
			System.out.println("Dosya okuma i\uc59fleminde s\u0131k\u0131nt\u0131 olu\uc59ftu.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void saveToFile(ContinueLater cl) {
		File file = new File(filePath);
		try {
			file.createNewFile();
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(cl);
			out.close();
		} catch (IOException e) {
			System.out.println("Dosyaya yazma i\uc59fleminde s\u0131k\u0131nt\u0131 olu\uc59ftu.");
			e.printStackTrace();
		}
	}

	public void setRealEquation(Equation realEquation) { this.realEquation = realEquation; }
	public void setCurrentRow(int currentRow) { this.currentRow = currentRow; }
	public void setGuessBtns(JButton[][] guessBtns) { this.guessBtns = guessBtns; }
	
	public Equation getRealEquation() { return this.realEquation; }
	public int getCurrentRow() { return this.currentRow; }
	public JButton[][] getGuessBtns() { return this.guessBtns; }
	public int getCursor() { return this.cursor; }
}
