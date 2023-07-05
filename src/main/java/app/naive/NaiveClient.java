package app.naive;

import app.AppController;
import dom2app.SimpleTableModel;

public class NaiveClient {

	public static void main(String args[]) {
		AppController appController = new AppController();
		SimpleTableModel m = appController.load("./src/main/resources/input/EggsScrambled.tsv", "\t");
		
		System.out.println();System.out.println();
		System.out.println("----------");
		System.out.println(m.toString());
		System.out.println("----------");

		m = appController.getByPrefix("Put");
		System.out.println();System.out.println();
		System.out.println(m.toString());
	
		m = appController.getById(200);
		System.out.println();System.out.println();
		System.out.println(m.toString());
	
		m = appController.getTopLevel();
		System.out.println();System.out.println();
		System.out.println(m.toString());
		 
		appController.createReportText("./src/main/resources/output/Eggs.tsv");
		appController.createReportMd("./src/main/resources/output/Eggs.md");
		appController.createReportHtml("./src/main/resources/output/Eggs.html");
		System.out.println("End of dummy client");
	}

}
