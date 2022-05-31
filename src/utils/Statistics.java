package utils;

import java.io.*;

public class Statistics implements Serializable, SaveToFile {
	private static final long serialVersionUID = 1L;
	private static final String filePath = "stats.txt";
	
	private int won;
	private int lost;
	private int left;
	private int avgGuesses;
	private int avgFinishTime;
	
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
			this.won = this.lost = this.left = this.avgGuesses = this.avgFinishTime = 0;
		} catch (ClassNotFoundException e) {
			System.out.println("Statistics sýnýfý bulunamadý.");
			e.printStackTrace();
			System.exit(0);
		}
	}

	@Override
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
	public int getAvgGuesses() { return avgGuesses; }
	public int getAvgFinishTime() { return avgFinishTime; }

	public void setWon(int won) { this.won = won; }
	public void setLost(int lost) { this.lost = lost; }
	public void setLeft(int left) { this.left = left; }
	public void setAvgGuesses(int avgGuesses) { this.avgGuesses = avgGuesses; }
	public void setAvgFinishTime(int avgFinishTime) { this.avgFinishTime = avgFinishTime; }
}
