package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import load.Load;
import searching.Searching;
import task.Task;

public class GetByIdTest {

	private String fileName = "./src/main/resources/input/EggsScrambled.tsv" ;
	private String delimiter = "\t";
	private ArrayList<Task> pData=new ArrayList<Task>();
	private Load load ;
	private Searching getbyid ;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//this runs once, before _all_ tests. Nothing todo here.
		//See CDTest for explanations
	}
	@Before
	public void setUp() throws Exception {
		load = new Load(fileName,delimiter);
		pData= load.load(fileName, delimiter) ;
		getbyid = new Searching();
		
	}
	@Test
	public final void testId() {
		//not null
		assertNotNull(getbyid.getById(200,pData));
		//check happy day scenario
		assertEquals(getbyid.getById(200,pData).size(),2);
	}
	@Test
	public final void testIdneg() {
		//See how this test intentionally fails. It gets a negative id. 
		assertNull(getbyid.getById(-10,pData));
	}
	@Test
	public final void testIdnull() {
		//See how this test intentionally fails. It gets a null file. 
		assertNull(getbyid.getById(200,null));
	}
}
