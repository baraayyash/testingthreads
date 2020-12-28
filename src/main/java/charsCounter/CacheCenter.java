package charscounter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CacheCenter {

	private static BlockingQueue<String> filesQ = new LinkedBlockingQueue<String>(10000);
	
	private static volatile boolean isAllFilesCollected = false;
	private static volatile int [] charsCountArray = new int[26];

	public static boolean isAllFilesCollected() {
		return isAllFilesCollected;
	}

	public static void setAllFilesCollected(boolean isAllFilesCollected) {
		CacheCenter.isAllFilesCollected = isAllFilesCollected;
	}
	
	public static int [] getCharsCountArray() {
		return charsCountArray;
	}

	public static synchronized void updateCharCounter(int index) {
		charsCountArray[index] = ++charsCountArray[index];
	}

	public static BlockingQueue<String> getFilesQ() {
		return filesQ;
	}

	public static void setFilesQ(BlockingQueue<String> filesQ) {
		CacheCenter.filesQ = filesQ;
	}
}
