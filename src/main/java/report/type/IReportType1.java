package report.type;

import java.util.ArrayList;

import backend.ReportType;
import task.Task;

public interface IReportType1 {
	public abstract void reportOnHtml(ArrayList<Task> finaltask,String path, ReportType type);
	public abstract void reportOnTxt(ArrayList<Task> finaltask,String path, ReportType type) ;
	public abstract void reportOnMd(ArrayList<Task> finaltask,String path, ReportType type);
	public abstract void mainReport(ArrayList<Task> finaltask,String path, ReportType type);
}
