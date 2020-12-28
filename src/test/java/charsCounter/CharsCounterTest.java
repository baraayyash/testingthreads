package charsCounter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import charscounter.CacheCenter;
import charscounter.FilesCollector;
import charscounter.FilesReader;

public class CharsCounterTest {
	
	@Test
	public void testFilesCollector() {
		ClassLoader loader = CharsCounterTest.class.getClassLoader();
		
		FilesCollector filesCollector = new FilesCollector(loader.getResource("test2").getPath());
		filesCollector.run();
		
		assertEquals(CacheCenter.getFilesQ().size(), 16);		
	}
	
	@Test
	public void testFilesReader() {
		FilesReader filesReader = new FilesReader();
		filesReader.run();
		
		// There are 19 a in the files.
		assertEquals(CacheCenter.getCharsCountArray()[0], 19);
		// All files must be done
		assertEquals(CacheCenter.getFilesQ().size(), 0);		
	}
}
