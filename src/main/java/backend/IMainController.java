package backend;

import dom2app.SimpleTableModel;

/**
 * Main contract between front- and back- end
 * 
 * @author pvassil
 * @since v.0.1
 */
public interface IMainController {

	/**
	 * Loads a delimited file in the prescribed format and represents
	 * its contents (i.e., a Gantt project's tasks) as objects in main memory
	 * Each row is a task; fields are separated by a delimiter
	 * The following columns are implicitly assummed: 
	 * COLUMN_NAMES = {"TaskId" , "TaskText", "MamaId","Start" , "End" , "Cost" }
	 * 
	 * @param fileName A path of the location of the tsv file
	 * @param delimiter A string that separates the columns of each row
	 * @return a SimpleTableModel (@see dom2app.SimpleTableModel) that represents the project tasks as a List of string arrays
	 */
	SimpleTableModel load(String fileName, String delimiter);

	/**
	 * Assuming a Gantt project has been loaded, it returns all the tasks whose TaskTest is prefixed by the method's argument
	 * 
	 * @param prefix A string with the prefix of the task description that we are looking for.
	 * @return a SimpleTableModel (@see dom2app.SimpleTableModel) that represents the retrieved tasks as a List of string arrays
	 */
	SimpleTableModel getTasksByPrefix(String prefix);

	/**
	 * Assuming a Gantt project has been loaded, it returns the task whose taskId is equal to the method's argument
	 * 
	 * @param id An int with the id of the task that we are looking for.
	 * @return a SimpleTableModel (@see dom2app.SimpleTableModel) that represents the retrieved task as a List of string arrays
	 */
	SimpleTableModel getTaskById(int id);

	/**
	 * Assuming a Gantt project has been loaded, it returns its top-level tasks 
	 * 
	 * @return the top-level tasks of the project as a SimpleTableModel (@see dom2app.SimpleTableModel) 
	 */
	SimpleTableModel getTopLevelTasks();

	/**
	 * Assuming a Gantt project has been loaded, it creates a report in a specified format
	 * The report lists, in a sorted fashion, all the tasks of the project.
	 * 
	 * @param path The path for the filename that will be produced
	 * @param type a ReportType (@see backend.ReportType) with the types of reports that can be produced.
	 * @return the number of tasks processed for the file creation and written as lines; -1 if sth goes wrong.  
	 */
	int createReport(String path, ReportType type);

}