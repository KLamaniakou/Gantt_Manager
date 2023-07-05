package load;
import task.Task;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List ;

public class Compare {
	private ArrayList<Task> task1 ;
	private ArrayList<Task> task4 = new ArrayList<Task>();
	private List <String[]> ConvertTask1 =new ArrayList<String[]>();
	private ArrayList <Task> TopLevelFinal = new ArrayList <Task>();
	

	public Compare(ArrayList<Task> task1 ) {
		this.task1 = task1 ;
	}
	public static Comparator<Task> StartComp = new Comparator<Task>() {
		  
        // Method for sorting.
        public int compare(Task s1, Task s2) {
        	if(s1.getStart()!=s2.getStart() && s1.getMamaId()==s2.getMamaId()) {
        		int k1 = s1.getStart();
        		int k2 = s2.getStart();
            	return k1-k2;
        	}else {
        		 int k1 = s1.getTaskId();
                 int k2 = s2.getTaskId();             
                 return k1-k2;
        	}

        }
    };
	
	public List<String[]> compareAllTasks(ArrayList<Task> task3){
		ArrayList<Task> toplevel =new ArrayList<Task>();
		
		for(Task i : task3) {
			if(i.getMamaId()==0) { // checking if the task is TopLevel 
				toplevel.add(i);	
			}
		}	
		
		for (Task j : toplevel) { // Setting to TopLevel Tasks the Start , End , Cost
			int minstart=100000000;
			int maxend=0;
			int cost=0;
			for(Task k : task3) {
				if(j.getTaskId()==k.getMamaId()) {
					if( minstart >= k.getStart()) {
						minstart = k.getStart() ;
						j.setStart(minstart);
					}
					if(maxend<=k.getEnd()) {
						maxend = k.getEnd() ;
						j.setEnd(maxend);	
					}				
						cost += k.getCost() ;
						j.setCost(cost);
						
					}
					
				}
				
			}
		
		Collections.sort(task3, StartComp); // Sorting the List of Tasks
		 task4 = task3 ;
		for(Task k4: task3) {
			if(k4.getMamaId()==0) {
				TopLevelFinal.add(k4);
			}
			ConvertTask1.add(k4.ConvertString()); //Converting every Task and adding it to List of Strings 
		}

		return  ConvertTask1;//return the List of Strings
	}
	public ArrayList<Task> getTopLevel(){ // Return TopLevel Tasks
		return TopLevelFinal;
	}
	public ArrayList<Task> getAllTask(){// Return AllTasks
		return task4 ;
	}
	
}