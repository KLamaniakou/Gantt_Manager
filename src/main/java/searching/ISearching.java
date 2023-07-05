package searching;

import java.util.ArrayList;
import java.util.List;

import task.Task;

public interface ISearching {
	public abstract List<String[]> getTopLevelTasks(ArrayList<Task> top);
	public abstract List<String[]> getByPrefix(String prefix,ArrayList<Task> tsk);
	public abstract List<String[]> getById(int id,ArrayList<Task> tsk);
	
}
