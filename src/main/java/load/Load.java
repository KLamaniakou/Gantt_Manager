package load;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.StringTokenizer;
import dom2app.SimpleTableModel;
import task.Task; 



public class Load {

	private String fileName ;
	private String delimiter ;
	private String[] data1 =new String[6] ;
	private ArrayList<Task> pData=new ArrayList<Task>();
	private List <String[]> ConvertTask =new ArrayList<String[]>();
	
	public Load(String fileName, String delimiter){
		this.fileName =fileName ;
		this.delimiter =delimiter ;
	}
	
	public ArrayList <Task> load(String fileName, String delimiter) {
		Scanner inputStream = null; 
	
		try {
			inputStream = new Scanner(new FileInputStream(fileName)); // Read-Load the file with a Scanner

		} catch (FileNotFoundException e) {
			System.out.println("Problem opening file.Is not in correct format: " + fileName); //check for exceptiion
			System.exit(0);
		}
		String line = "";
		
		while (inputStream.hasNextLine()) { // while loop for checking if the filename has other line
			line = inputStream.nextLine();
		 
			StringTokenizer tokenizer = new StringTokenizer(line,delimiter);
		
			int i = 0;
			while(tokenizer.hasMoreTokens()) { //while loop for checking if the line of the filename has other elements
				data1[i]=tokenizer.nextToken() ;
				i++ ;	
				
			}
			if (data1[0].equals("0")) {
				System.out.println("Problem with TaskId==" + data1[0]+ " .Is not allowed a task to have TaskId=0. Change your file."); //check for exceptiion
				System.exit(0);
			}
			if(data1[2].equals("0")) { // check if task is top level to call the right constructor
				Task tsk1 = new Task(Integer.parseInt(data1[0]),data1[1],Integer.parseInt(data1[2]));
				pData.add(tsk1);
				ConvertTask.add(tsk1.ConvertString());

			}else {
			Task tsk = new Task(Integer.parseInt(data1[0]),data1[1],Integer.parseInt(data1[2]),Integer.parseInt(data1[3]),Integer.parseInt(data1[4]),Integer.parseInt(data1[5] ) );
				pData.add(tsk);
				ConvertTask.add(tsk.ConvertString());
			}	
		}
		
		return pData ; //return the ArrayList of tasks
	}
	public List<String[]> getConvertTask() { // Method from converting ArrayList of Task to ArrayList of Strings .Use for testing while coding .
		return ConvertTask ;
	}
}