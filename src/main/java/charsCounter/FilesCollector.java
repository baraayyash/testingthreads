package charsCounter;

import java.io.File;


public class FilesCollector implements Runnable {

	private String dirPath;
	
	public FilesCollector(String dirPath) {
		this.dirPath = dirPath;
	}

	public void run() {
		System.out.println("started FilesCollector");
		
		File folder = new File(dirPath);
		listFilesForFolder(folder);
		System.out.println("All files collected");
		CacheCenter.setAllFilesCollected(true);
	}

	public void listFilesForFolder(final File folder) {
		
		for (final File fileEntry : folder.listFiles()) {
			if (! fileEntry.isDirectory()) {
				CacheCenter.getFiles().add(fileEntry.getAbsolutePath());
			}
		}
		
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry);
			}
		}
	}
}
