package tests;

import static org.junit.Assert.*;
import java.io.*;
import org.junit.Before;
import org.junit.Test;
import app.AppController;



public class ReportTypeTest {
	private AppController appController ;
	public static void setUpBeforeClass() throws Exception {
		//this runs once, before _all_ tests. Nothing todo here.
		//See CDTest for explanations
	}
	@Before
	public void setUp() throws Exception {
		appController = new AppController();	
		appController.load("./src/main/resources/input/EggsScrambled.tsv", "\t");

	}
	
	public static void assertReaders(BufferedReader expected,
	          BufferedReader actual) throws IOException {
	    String line;
	    while ((line = expected.readLine()) != null) {
	        assertEquals(line, actual.readLine());
	    }

	    assertNull("Actual had more lines then the expected.", actual.readLine());
	    assertNull("Expected had more lines then the actual.", expected.readLine());
	}
	
	
	@Test
	public void testReportTxt() throws IOException{
		FileReader output = new FileReader("./src/main/resources/output/EggsTest.tsv");
		FileReader expected = new FileReader("./src/main/resources/output/Eggs.tsv");
		BufferedReader outputb = new BufferedReader(output);
		BufferedReader expectedb = new BufferedReader(expected);
		assertReaders(expectedb,outputb);
		assertNotNull(appController.createReportText("./src/main/resources/output/EggsTest.tsv"));
		
	}
	
	@Test
	public void testReportMd() throws IOException{
		FileReader output = new FileReader("./src/main/resources/output/EggsTest.md");
		FileReader expected = new FileReader("./src/main/resources/output/Eggs.md");
		BufferedReader outputb = new BufferedReader(output);
		BufferedReader expectedb = new BufferedReader(expected);
		assertReaders(expectedb,outputb);
		assertNotNull(appController.createReportMd("./src/main/resources/output/EggsTest.md"));
	}
	@Test
	public void testReportHtml()throws IOException {
		FileReader output = new FileReader("./src/main/resources/output/EggsTest.html");
		FileReader expected = new FileReader("./src/main/resources/output/Eggs.html");
		BufferedReader outputb = new BufferedReader(output);
		BufferedReader expectedb = new BufferedReader(expected);
		assertReaders(expectedb,outputb);
		assertNotNull(appController.createReportHtml("./src/main/resources/output/EggsTest.html"));
	}
}
