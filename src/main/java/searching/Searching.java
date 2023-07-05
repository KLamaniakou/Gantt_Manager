package searching;
import java.util.ArrayList;
import java.util.List;
import load.Compare;
import task.Task;
public class Searching implements ISearching {
	
		private ArrayList<Task> toplevel ;
		private List<String[]> toplevel1 ;
		private ArrayList<Task> alltasks;
		private List <String[]> TasksByPrefix =new ArrayList<String[]>();
		private List <String[]> TasksById =new ArrayList<String[]>();
		private List <String[]> Alltop =new ArrayList<String[]>();
		public Searching() {
		
		}
		public List<String[]> getTopLevelTasks(ArrayList<Task> top){ 
			Compare top1 =new Compare (top) ; //Create an Object 
			toplevel1=top1.compareAllTasks(top); //Call the method compareAlltasks
			toplevel =top1.getTopLevel() ; //Call the method getTopLevel
			boolean flag=false;
			for(Task k3 : toplevel) {
				flag=true;
				Alltop.add(k3.ConvertString()); //Converting every Task to List of Strings
			}
			if(flag==false) {
				System.out.println("WARNING!!!,I can't find TopLevel Tasks.Check your file again please." ); //check for exceptiion
				System.exit(0);
			}
			 return Alltop ; // Return the List of String 
		}
		
		public List<String[]> getByPrefix(String prefix,ArrayList<Task> tsk){
			Compare tsk1 =new Compare (tsk) ;//Create an Object 
			toplevel1=tsk1.compareAllTasks(tsk); //Call the method compareAlltasks
			alltasks=tsk1.getAllTask(); //Call the method getAllTasks
			boolean flag=false;
			for(Task k4 : alltasks) {
				if(k4.getTaskText().startsWith(prefix)) { //Using a build in function to check if our Task starts with the given Prefix
					flag=true;
					TasksByPrefix.add(k4.ConvertString());	//Converting every Task to List of Strings
				}
			}
			if(flag==false) {
				System.out.println("WARNING!!!,I can't find Tasks with the given prefix.Check your file again please." ); //check for exceptiion
				System.exit(0);
			}
		
			return TasksByPrefix ; // Return the List of String 
		}
		public List<String[]> getById(int id,ArrayList<Task> tsk){
			Compare tsk2 =new Compare (tsk) ; //Create an Object 
			toplevel1=tsk2.compareAllTasks(tsk); //Call the method compareAlltasks
			alltasks=tsk2.getAllTask(); //Call the method getAllTasks
			boolean flag=false;
			for(Task k4 : alltasks) {
				if(k4.getTaskId()==id) {
					flag=true;
					TasksById.add(k4.ConvertString()); //Converting every Task to List of Strings 	
				}
			}
			if(flag==false) {
				System.out.println("WARNING!!!,I can't find Tasks with the given TaskId.Check your file again please." ); //check for exceptiion
				System.exit(0);
			}
		
			return TasksById ; // Return the List of String 
		}
		

}

