package charscounter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class will read files from the array and count the charactars
 * 
 * @author Braa'
 *
 */
public class FilesReader implements Runnable {
	
	public void run() {
		
		while ( ! CacheCenter.getFilesQ().isEmpty() || ! CacheCenter.isAllFilesCollected()) {

			String fileDir = CacheCenter.getFilesQ().poll();

			if (fileDir == null && ! CacheCenter.isAllFilesCollected()) {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				continue;
			}
			
			BufferedReader br = null;
			try {
				File file = new File(fileDir); 
				FileReader fr = new FileReader(file);
				br = new BufferedReader(fr);
				int c = 0;
				while((c = br.read()) != -1) {
					pushCharacterToArray(c);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private void pushCharacterToArray(int character) {
		if (character > 96 && character < 123) {
			// 97 = a = first index in the array = 0
			CacheCenter.updateCharCounter(character-97);
		}
	}

}
