package charsCounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FilesReader implements Runnable {

	public void run() {

		System.out.println("------------> started FilesReader thread " + CacheCenter.isAllFilesCollected()); 
		
		while ( ! CacheCenter.getFiles().isEmpty() || ! CacheCenter.isAllFilesCollected()) {

			String fileDir = CacheCenter.pullFile();
			if (CacheCenter.isAllFilesCollected()) {
				System.out.println( " -------- > isAllFilesCollected");

			}

			if (fileDir == null && ! CacheCenter.isAllFilesCollected()) {
				
				// Try again
				continue;
			}
			

			File file = new File(fileDir); 
			Scanner sc;
			try {
				sc = new Scanner(file);
				while (sc.hasNextLine()) {
					String line = sc.nextLine();
					for (int i = 0; i < line.length(); i++){
					    char c = line.charAt(i);        
					    if (CacheCenter.getCharsCount().containsKey(c)) {
					    	int count = CacheCenter.getCharsCount().get(c);					    
					    	CacheCenter.getCharsCount().put(c, ++count);
					    }
					}
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

		}
				
		System.out.println("------------> ended FilesReader thread" ); 
	}

}
