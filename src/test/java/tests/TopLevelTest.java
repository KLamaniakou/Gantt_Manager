package tests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import load.Load;
import searching.Searching;
import task.Task;

public class TopLevelTest {
	private String fileName = "./src/main/resources/input/EggsScrambled.tsv" ;
	private String delimiter = "\t";
	private ArrayList<Task> pData=new ArrayList<Task>();
	private Load load ;
	private Searching toplevel ;
	private ArrayList<Task> tests=new ArrayList<Task>(); //empty array list 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//this runs once, before _all_ tests. Nothing todo here.
		//See CDTest for explanations
	}
	@Before
	public void setUp() throws Exception {
		load = new Load(fileName,delimiter);
		pData= load.load(fileName, delimiter) ;
		toplevel = new Searching();
		
	}
	@Test
	public void ToplevelTest() {
		//not null
		assertNotNull(toplevel.getTopLevelTasks(pData));
		//check happy day scenario
		assertEquals(toplevel.getTopLevelTasks(pData).size(),6); //the size is n+3 because of the messages with add to list
	}
	@Test
	public final void ToplevelEmpty() {
		//See how this test intentionally fails. It gets a empty array list. 
		assertNull(toplevel.getTopLevelTasks(tests));
	}

}
