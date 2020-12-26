package charsCounter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CacheCenter {

	
	private static ArrayList<String> files = new ArrayList<String>();
	private static Map<Character, Integer> charsCount =  Collections.synchronizedMap(new HashMap<Character, Integer>());
	private static volatile boolean isAllFilesCollected = false;
	
	static {
		charsCount.put('a', 0);
		charsCount.put('b', 0);
		charsCount.put('c', 0);
		charsCount.put('d', 0);
		charsCount.put('e', 0);
		charsCount.put('f', 0);
		charsCount.put('g', 0);
		charsCount.put('h', 0);
		charsCount.put('i', 0);
		charsCount.put('j', 0);
		charsCount.put('k', 0);
		charsCount.put('l', 0);
		charsCount.put('m', 0);
		charsCount.put('n', 0);
		charsCount.put('o', 0);
		charsCount.put('p', 0);
		charsCount.put('q', 0);
		charsCount.put('r', 0);
		charsCount.put('s', 0);
		charsCount.put('t', 0);
		charsCount.put('u', 0);
		charsCount.put('v', 0);
		charsCount.put('w', 0);
		charsCount.put('x', 0);
		charsCount.put('y', 0);
		charsCount.put('z', 0);
	}
	
	public synchronized static String pullFile() {
		if (files.isEmpty()) return null;
		return files.remove(0);
	}

	public static ArrayList<String> getFiles() {
		return files;
	}

	public static void setFiles(ArrayList<String> files) {
		CacheCenter.files = files;
	}

	public static Map<Character, Integer> getCharsCount() {
		return charsCount;
	}
	
	public static void setCharsCount(Map<Character, Integer> charsCount) {
		CacheCenter.charsCount = charsCount;
	}

	public static boolean isAllFilesCollected() {
		return isAllFilesCollected;
	}

	public static void setAllFilesCollected(boolean isAllFilesCollected) {
		CacheCenter.isAllFilesCollected = isAllFilesCollected;
	}
	
}
