package charscounter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * The main entry for running the program
 * 
 * @author Braa'
 *
 */
public class CharsCounter {

	public static void main(String[] args) throws Exception {
		
		if (args.length == 0) {
			throw new IllegalArgumentException("Please provide a path for the folder");
		}

		FilesCollector filesCollector = new FilesCollector(args[0]);

		int numberOfProcessors = Runtime.getRuntime().availableProcessors();

		ExecutorService executor = Executors.newFixedThreadPool(numberOfProcessors);
		executor.submit(filesCollector);

		for (int i = 1; i < numberOfProcessors; i++) {
			FilesReader filesReader = new FilesReader();
			executor.submit(filesReader);
		}

		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.DAYS);
		
		printRsult();
	}

	private static void printRsult() {
		for (int i=0; i<26;i++) {
			System.out.println((char) (i+97) + "          " + CacheCenter.getCharsCountArray()[i]);
		}
	}
}
