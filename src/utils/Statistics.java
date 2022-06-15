package utils;

import java.io.*;

public class Statistics implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String filePath = "stats.txt";
	
	private int won;
	private int lost;
	private int left;
	private double avgGuesses;
	private double avgFinishTime;
	
	public Statistics() {
		File file = new File(filePath);
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
			Statistics s;
			s = (Statistics)input.readObject();
			input.close();
			this.won = s.won;
			this.lost = s.lost;
			this.left = s.left;
			this.avgGuesses = s.avgGuesses;
			this.avgFinishTime = s.avgFinishTime;
		} catch (IOException e) {
			this.won = this.lost = this.left = 0;
			this.avgGuesses = this.avgFinishTime = 0.0;
		} catch (ClassNotFoundException e) {
			System.out.println("Statistics sýnýfý bulunamadý.");
			e.printStackTrace();
			System.exit(0);
		}
	}

	public void saveToFile() {
		File file = new File(filePath);
		try {
			file.createNewFile();
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(this);
			out.close();
		} catch (Exception e) {
			System.out.println("Dosyaya yazma iþleminde sýkýntý oluþtu.");
		}
	}

	public int getWon() { return won; }
	public int getLost() { return lost; }
	public int getLeft() { return left; }
	public double getAvgGuesses() { return avgGuesses; }
	public double getAvgFinishTime() { return avgFinishTime; }

	public void setWon(int won) { this.won = won; }
	public void setLost(int lost) { this.lost = lost; }
	public void setLeft(int left) { this.left = left; }
	public void setAvgGuesses(double avgGuesses) { this.avgGuesses = avgGuesses; }
	public void setAvgFinishTime(double avgFinishTime) { this.avgFinishTime = avgFinishTime; }
}
