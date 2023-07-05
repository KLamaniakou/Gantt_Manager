package backend;

import java.util.ArrayList;
import java.util.List;

import dom2app.SimpleTableModel;
import load.Compare;
import load.Load;
import report.type.ReportType1;
import searching.Searching;
import task.Task;

public class MainController implements IMainController {
	private String [] column = {"TaskId","TaskText","MamaId","Start","End","Cost"};
	private ArrayList<Task> pData1=new ArrayList<Task>();
	private List<String[]> pData2=new ArrayList<String[]>();
	private String filename;

		public SimpleTableModel load(String fileName, String delimiter) {
			Load loadfile = new Load(fileName ,delimiter);
			pData1=loadfile.load(fileName, delimiter);
			filename=fileName;
			Compare comparison = new Compare(pData1);
			pData2 = comparison.compareAllTasks(pData1) ;
			SimpleTableModel simple = new SimpleTableModel("Final",filename,column,pData2);
			return simple ;
		}
		public SimpleTableModel getTasksByPrefix(String prefix) {
			Searching tasksbyprefix = new Searching();
			
			SimpleTableModel simple2 = new SimpleTableModel("Prefix search for "+prefix, filename,column,tasksbyprefix.getByPrefix(prefix, pData1));
			return simple2;
		}
		public SimpleTableModel getTaskById(int id) {
			Searching tasksbyid = new Searching();
			SimpleTableModel simple3 = new SimpleTableModel("Id search for "+id,filename,column,tasksbyid.getById(id, pData1));
			return simple3 ;
			
		}
		public SimpleTableModel getTopLevelTasks() {
			Searching alltop = new Searching();
			SimpleTableModel simple1 = new SimpleTableModel("Top Tasks", filename,column,alltop.getTopLevelTasks(pData1));
			return simple1 ;
		}
		public int createReport(String path, ReportType type) {
			ReportType1 report = new ReportType1();
			report.mainReport(pData1, path, type);
			return 0;
		}

}
