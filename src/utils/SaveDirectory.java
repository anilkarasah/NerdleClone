package utils;

import java.io.File;

public class SaveDirectory {
	private static String directory = System.getenv("USERPROFILE") + File.separator + "Desktop" + File.separator + "Nerdle";
	protected String path;
	
	public SaveDirectory(String path) {
		File dir = new File(directory);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		this.path = path;
	}
	
	public String getPath() {
		return this.path;
	}
	
	public void setPath(String path) {
		this.path = directory + File.separator + path;
	}
}
