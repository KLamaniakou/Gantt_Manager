package app;


import java.util.List;
import java.util.ArrayList;
import backend.IMainController;
import backend.MainControllerFactory;
import backend.ReportType;
import dom2app.SimpleTableModel;

public final class AppController {
	private static IMainController mainEngine;
	
	public AppController() {
		MainControllerFactory mcFactory = new MainControllerFactory(); 
		mainEngine = mcFactory.createMainController();	
	}
	
	public SimpleTableModel load(String fileName, String delimiter) {
		SimpleTableModel tableModel = mainEngine.load(fileName, delimiter);
		return tableModel;
	}//end load()

	public SimpleTableModel getByPrefix(String prefix) {
		SimpleTableModel tableModel = mainEngine.getTasksByPrefix(prefix);
		return tableModel;
	}//end byPrefix()

	public SimpleTableModel getById(int id) {
		SimpleTableModel tableModel = mainEngine.getTaskById(id);
		return tableModel;
	}//end byId()
	
	public SimpleTableModel getTopLevel() {
		SimpleTableModel tableModel = mainEngine.getTopLevelTasks();
		return tableModel;
	}//end topLevel()
	
	public int createReportText(String path) {
		return mainEngine.createReport(path, ReportType.TEXT);
	}
	public int createReportMd(String path) {
		return mainEngine.createReport(path, ReportType.MD);
	}
	public int createReportHtml(String path) {
		return mainEngine.createReport(path, ReportType.HTML);
	}
	public SimpleRasterModel translateTableModelToRaster(SimpleTableModel tblModel) {
		int inputTblRows = tblModel.getRowCount();
		List<String[]> inputData = tblModel.getData();
		
		int end = Integer.MIN_VALUE;
		int start = Integer.MAX_VALUE;
		for (String[] ss: inputData) {
			int localStart = Integer.valueOf(ss[3].trim());
			int localEnd = Integer.valueOf(ss[4].trim());
			if(localStart < start) start = localStart;
			if(localEnd > end) end = localEnd;
		}

		int rasterNumRows = inputTblRows + 1;
		int rasterNumCols = end - start + 1 + 1; //[end-start+1] to include all the dates + 1 for the 0th col with the labels
		String [][] data = new String[rasterNumRows][rasterNumCols];
		
		//header line
		List<String> header = new ArrayList<String>();
		data[0][0] = "";
		header.add(data[0][0]);
		for (int j=1; j< rasterNumCols; j++) {
			String s = String.valueOf(start -1 + j);
			data[0][j] = s;
			header.add(s);
		}
		
		List<String> zeroColumn = new ArrayList<String>();
		int currentRow = 1;
		for (String[] ss: inputData) {
			zeroColumn.add(ss[0]);
			data[currentRow][0] = ss[0];
			int localMama = Integer.valueOf(ss[2].trim());
			int localStart = Integer.valueOf(ss[3].trim());
			int localEnd = Integer.valueOf(ss[4].trim());
			for(int j = localStart; j<localEnd+1; j++) {
				if(localMama==0)
					data[currentRow][j] = "**";
				else
					data[currentRow][j] = "*";
			}
			currentRow++;
		}
		
		return new SimpleRasterModel(header, zeroColumn, data);
	}//end translate()
		
	
}//end class
