package load;

import java.util.ArrayList;
import java.util.List;

import task.Task;

public interface ILoad {
	public  abstract ArrayList <Task> load(String fileName, String delimiter); 
	public abstract List<String[]> getConvertTask();
}
