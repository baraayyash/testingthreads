package charsCounter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class CharsCounter {

	public static void main(String[] args) throws InterruptedException {

		FilesCollector filesCollector = new FilesCollector("C:\\Users\\Braa'\\Desktop\\test");

		int numberOfProcessors = Runtime.getRuntime().availableProcessors();

		ExecutorService executor = Executors.newFixedThreadPool(numberOfProcessors);
		executor.submit(filesCollector);
//		Thread.sleep(5000);

//		System.out.println(CacheCenter.getFiles().size());
		for (int i = 5; i < numberOfProcessors; i++) {
			FilesReader filesReader = new FilesReader();
			executor.submit(filesReader);
		}

		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.DAYS);
		
		System.out.println(CacheCenter.isAllFilesCollected());
		System.out.println(CacheCenter.getFiles().isEmpty());
		System.out.println(CacheCenter.getFiles().size());
		
//		printRsult();
		
	}

	private static void printRsult() {
		
		for (Character character : CacheCenter.getCharsCount().keySet()) {
			System.out.println("Character #" + character +  " found #" + CacheCenter.getCharsCount().get(character) + " times");
		}
		
	}


}
