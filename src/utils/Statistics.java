package utils;

import java.io.*;

public class Statistics implements FileIO,Serializable {
	private static final long serialVersionUID = 1L;
	private static final String statisticsFilePath = "stats.txt";
	private static final SaveDirectory dir = new SaveDirectory(statisticsFilePath);
	
	private int won;
	private int lost;
	private int left;
	private int avgGuesses;
	private int avgFinishTime;
	
	public Statistics() {
		this.won = this.lost = this.left = this.avgGuesses = this.setAvgFinishTime(0);
	}

	public Statistics(int won, int lost, int left, int avgGuesses, int avgFinishTime) {
		super();
		this.won = won;
		this.lost = lost;
		this.left = left;
		this.avgGuesses = avgGuesses;
		this.setAvgFinishTime(avgFinishTime);
	}

	@Override
	public void saveToFile() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dir.getPath()));
			out.writeObject(this);
			out.close();
		} catch (Exception e) {
			System.out.println("Dosyaya yazma iþleminde sýkýntý oluþtu.");
		}
	}

	@Override
	public Statistics readFromFile() throws Exception {
		Statistics s = null;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(dir.getPath()));
			s = (Statistics) in.readObject();
			in.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Class bulunamadý.");
			System.exit(-1);
		} catch (Exception e) {
			throw new Exception("Dosya iþleminde problem oluþtu.");
		}
		return s;
	}
	
	

	public int getWon() {
		return won;
	}

	public void setWon(int won) {
		this.won = won;
	}

	public int getLost() {
		return lost;
	}

	public void setLost(int lost) {
		this.lost = lost;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getAvgGuesses() {
		return avgGuesses;
	}

	public void setAvgGuesses(int avgGuesses) {
		this.avgGuesses = avgGuesses;
	}

	public int getAvgFinishTime() {
		return avgFinishTime;
	}

	public int setAvgFinishTime(int avgFinishTime) {
		this.avgFinishTime = avgFinishTime;
		return avgFinishTime;
	}
}
