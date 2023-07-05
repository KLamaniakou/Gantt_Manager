package task;

import java.util.ArrayList;
import java.util.List;
public class Task {
	private int TaskId ;
	private String TaskText ;
	private int MamaId ;
	private int Start ;
	private int End ;
	private int Cost ;
	private ArrayList<Task> pTask =new ArrayList<Task>();
	private List <String[]> ConvertTask =new ArrayList<String[]>();
	private String[] tester = new String[6] ;
	
	public Task(int TaskId ,String TaskText ,int MamaId , int Start , int End ,int Cost ){
		this.TaskId = TaskId ;
		this.TaskText = TaskText ;
		this.MamaId = MamaId ;
		this.Start = Start ;
		this.End = End ;
		this.Cost = Cost ;		
	}
	public Task(int TaskId,String TaskText,int MamaId) {
		this.TaskId = TaskId ;
		this.TaskText = TaskText ;
		this.MamaId = MamaId ;
		this.Start = 0 ;
		this.End = 0 ;
		this.Cost = 0;
				
	}
	public int getTaskId(){
		return TaskId ;
	}
	public String getTaskText() {
		return TaskText ;
	}
	public int getMamaId() {
		return MamaId ;
	}
	public int getStart() {
		return Start ;
	}
	public int getEnd() {
		return End ;
	}
	public int getCost() {
		return Cost ;
	}
	public String getShortReport(){
		
		return getTaskId()+" \t " + getTaskText()+" \t " + getMamaId()+" \t " + getStart()+" \t " + getEnd()+" \t " + getCost();
	}
	public String getReportOnMd() {
		return "**"+getTaskId()+"** \t " +"**"+ getTaskText()+"** \t " +"**"+ getMamaId()+"** \t " +"**" +getStart()+"** \t " +"**" +getEnd()+"** \t "+"**" + getCost()+"**";
	}
	public void setStart(int Start) {
		this.Start = Start ;
	}
	public void setEnd(int End) {
		this.End = End  ;
	}
	public void setCost(int Cost) {
		this.Cost = Cost ;
	}
	
	public  String[] ConvertString(){ //Converting Object of type Task(Integer) to Strings and adding it to an array 
		
			tester[0]=(Integer.toString(this.TaskId));
			tester[1]=(this.TaskText);
			tester[2]=(Integer.toString(this.MamaId));
			tester[3]=(Integer.toString(this.Start));
			tester[4]=(Integer.toString(this.End));
			tester[5]=(Integer.toString(this.Cost));
		
		return tester; //return the array of Strings
	}
		
	
	
	

}
