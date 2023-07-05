package report.type;
import load.Compare;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import backend.ReportType;
import load.Compare;
import task.Task;
public class ReportType1 implements IReportType1 {
	private List<String[]> toplevel1 ;
	private ArrayList<Task> alltasks;
	
	public void reportOnTxt(ArrayList<Task> finaltask,String path, ReportType type) {
		PrintWriter outputStream = null;
		String outputFileName = path;
		try {
			outputStream = new PrintWriter(new FileOutputStream(outputFileName));
		} catch (FileNotFoundException e) {
			System.out.println("Problem opening report.");
			System.exit(0);
		}
		
		Compare tsk2 =new Compare (finaltask) ; //Create an Object
		toplevel1=tsk2.compareAllTasks(finaltask); //Call the method compareAlltasks
		alltasks=tsk2.getAllTask(); //Call the method getAllTasks
		outputStream.println("TaskId Tasktext \t  MamaId  Start \t End \t Cost \n ");
		for(Task e: alltasks){
			
			outputStream.println(e.getShortReport()); //Call the method getShortReport 
		}
		
		outputStream.close();
		return;
	}
	
	public void rasterToHTML(String fileName,String[][] raster, int numRows, int numCols) { //Creating the html file  
		String header = new String("");
		header.concat("<!doctype html>");
		header.concat("\n");
		header.concat("<html>");
		header.concat("\n");
		header.concat("<head>");
		header.concat("\n");
		header.concat("<meta http-equiv=\"Content-Type\" content\"text/html; charset=windows-1253\">");
		header.concat("\n");
		header.concat("\n");
		header.concat("</head>");
		header.concat("\n");
		header.concat("<body>");
		header.concat("\n");
		try {
			PrintWriter outputStream = new PrintWriter(new FileOutputStream(fileName)); 
			outputStream.println(header);

			outputStream.println("<table>");

			for(int i =0; i < numRows; i++){
				outputStream.println("<tr>");
				for(int j =0; j < numCols; j++){
					outputStream.print("<td>"+raster[i][j]+"</td>");
				}
				outputStream.println("\n</tr>");
			}
			outputStream.println("</table>");
			outputStream.println("</body>\n</html>");
			outputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Problem opening files.");
			System.exit(0);
		}

	}
	
	public void reportOnHtml(ArrayList<Task> finaltask,String path, ReportType type) { // Creating the Report of Html file by using rasterToHTML method
		Compare tsk3 =new Compare (finaltask) ;
		toplevel1=tsk3.compareAllTasks(finaltask);
		alltasks=tsk3.getAllTask();
		DecimalFormat df = new DecimalFormat("###.##");
		DecimalFormatSymbols dfs=new DecimalFormatSymbols();			
		dfs.setDecimalSeparator('.');	
		df.setDecimalFormatSymbols(dfs);
		int numCols = 6;
		int numRows = alltasks.size()+1;
		String [][]raster = new String[numRows][numCols];
		raster[0][0] = "TaskId"; raster[0][1] = "TaskText"; raster[0][2] = "MamaId"; raster[0][3] = "Start"; raster[0][4] = "End"; raster[0][5] = "Cost";
		int i = 1;
		for(Task e: alltasks){
			raster[i][0] = Integer.toString(e.getTaskId()); 
			raster[i][1] = (e.getTaskText()); 
			raster[i][2] = Integer.toString(e.getMamaId()); 
			raster[i][3] = Integer.toString(e.getStart());  
			raster[i][4] = Integer.toString(e.getEnd());
			raster[i][5] = Integer.toString(e.getCost());
			i++;			
		}
		rasterToHTML(path, raster, numRows, numCols);
	}
	public void reportOnMd(ArrayList<Task> finaltask,String path, ReportType type) { //Creating the report of MD (Mark Down)file 
		PrintWriter outputStream = null;
		String outputFileName = path;
		try {
			outputStream = new PrintWriter(new FileOutputStream(outputFileName));
		} catch (FileNotFoundException e) {
			System.out.println("Problem opening report.");
			System.exit(0);
		}
		Compare tsk2 =new Compare (finaltask) ;
		toplevel1=tsk2.compareAllTasks(finaltask);
		alltasks=tsk2.getAllTask();
		outputStream.println("*TaskId* *Tasktext*  *MamaId*  *Start*  *End* *Cost* \n ");
		for(Task e: alltasks){
			if(e.getMamaId()==0) {
				outputStream.println(e.getReportOnMd());
			}else {
				outputStream.println(e.getShortReport());
			}
		}
		
		outputStream.close();
		return;

	}
	public void mainReport(ArrayList<Task> finaltask,String path, ReportType type) { //Choosing the right Report type 
		if (type.equals(ReportType.TEXT)) {
			reportOnTxt(finaltask,path,type);
		}else if(type.equals(ReportType.HTML)){
			reportOnHtml(finaltask,path,type);
		}else if(type.equals(ReportType.MD)) {
			reportOnMd(finaltask,path,type);
		}else {
			System.out.println("Problem with the type of the report.");
		}
	}
	
}
