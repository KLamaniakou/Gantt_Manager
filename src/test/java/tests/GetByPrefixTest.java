package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import load.Load;
import searching.Searching;
import task.Task;

public class GetByPrefixTest {

	private String fileName = "./src/main/resources/input/EggsScrambled.tsv" ;
	private String delimiter = "\t";
	private ArrayList<Task> pData=new ArrayList<Task>();
	private Load load ;
	private Searching getbyprefix ;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//this runs once, before _all_ tests. Nothing todo here.
		//See CDTest for explanations
	}
	@Before
	public void setUp() throws Exception {
		load = new Load(fileName,delimiter);
		pData= load.load(fileName, delimiter) ;
		getbyprefix = new Searching();
		
	}
	@Test
	public void testPrefix() {
		//not null
		assertNotNull(getbyprefix.getByPrefix("Put",pData));
		//check happy day scenario
		assertEquals((getbyprefix.getByPrefix("Put",pData)).size(),4); //the size is n+2 because of the messages with add to list
	}

	@Test
	public final void testPrefixNull() {
		//See how this test intentionally fails. It gets a null file. 
		assertNull(getbyprefix.getByPrefix("Put",null));
	}
}
