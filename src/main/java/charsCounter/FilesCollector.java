package charscounter;

import java.io.File;
import java.util.ArrayList;

/**
 * The class is responsible for collecting the files and store them in array
 * This class acts like a producer for the FilesReader
 * 
 * @author Braa'
 *
 */
public class FilesCollector implements Runnable {

	private String dirPath;
	
	public FilesCollector(String dirPath) {
		this.dirPath = dirPath;
	}

	public void run() {
		File folder = new File(dirPath);
		listFilesForFolder(folder);
		CacheCenter.setAllFilesCollected(true);
	}
	

	public void listFilesForFolder(final File folder) {
		
		ArrayList<File> subDirectories = new ArrayList<File>(); 
		
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				subDirectories.add(fileEntry);
			} else {
				CacheCenter.getFilesQ().add(fileEntry.getAbsolutePath());
			}
		}
		
		for (File subDir : subDirectories) {
			listFilesForFolder(subDir);
		}
	}
}
