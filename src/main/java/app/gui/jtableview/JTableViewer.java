package app.gui.jtableview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
//import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;

import app.SimpleRasterModel;
import dom2app.SimpleTableModel;


/**
 * Shamelessly stolen from
 * https://stackoverflow.com/questions/22864095/reading-data-from-a-specific-csv-file-and-displaying-it-in-a-jtable
 * 
 * TODO Check out again
 * https://docs.oracle.com/javase/tutorial/uiswing/components/table.html
 */

public class JTableViewer extends JPanel {

		private static final long serialVersionUID = 1L;
		private final JTable table;

	    public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public JTable getTable() {
			return table;
		}

		public JTableViewer(SimpleTableModel tableModel) {
	    	super(new BorderLayout(3, 3));	        
	        System.out.println("Rows: " + tableModel.getRowCount());
	        System.out.println("Cols: " + tableModel.getColumnCount());
	        this.table = new JTable(tableModel);
	    }//end constructor
	
		public JTableViewer(SimpleRasterModel rasterModel) {
	    	super(new BorderLayout(3, 3));	        
	        System.out.println("Rows: " + rasterModel.getRowCount());
	        System.out.println("Cols: " + rasterModel.getColumnCount());
	        //this.table = new JTable(rasterModel);
	        
	        this.table = new JTable(rasterModel){
	            /**
				 * 
				 */
				private static final long serialVersionUID = -4739863709303727277L;

				@Override
	            public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
	            	Color darkGreen = new Color(0, 128, 0, 255);
	                Component comp = super.prepareRenderer(renderer, row, col);
	                String value = rasterModel.getValueAt(row, col);
	                if (value==null) {
	                	comp.setBackground(Color.white);
	                	comp.setForeground(Color.black);
	                }
	                else {
	                //System.out.println("XXXX "+value);
//	                String value = (String) getModel().getValueAt(row, col);
	                //if (getSelectedRow() == row) 
	                
//	                for(int i=0; i<rasterModel.getRowCount();i++)
//	                	for(int j=0; j<rasterModel.getColumnCount();j++){
	                    if (value.equals("**")) {
	                        comp.setBackground(darkGreen);
	                        comp.setForeground(darkGreen);
	                    } else if (value.equals("*")) {
	                        comp.setBackground(Color.green);
	                        comp.setForeground(Color.green);
	                    } else {
	                        comp.setBackground(Color.white);
	                        comp.setForeground(Color.black);
	                    }
	                }
	                //} //else {
	                    //comp.setBackground(Color.white);
	                //}
	                return comp;
	            }
	        };
	    }//end constructor
		
	    public void createAndShowJTable() {
	        	
	        this.table.setPreferredScrollableViewportSize(new Dimension(800, 600));
	        this.table.setFillsViewportHeight(true);
	        JPanel ButtonOpen = new JPanel(new FlowLayout(FlowLayout.CENTER));
	        add(ButtonOpen, BorderLayout.SOUTH);
	        
	        // Create the scroll pane and add the table to it.
	        JScrollPane scrollPane = new JScrollPane(table);
	        
	        // Add the scroll pane to this panel.
	        add(scrollPane, BorderLayout.CENTER);
	        
	        // add a nice border
	        setBorder(new EmptyBorder(5, 5, 5, 5));
	    	
//	        //WHEN RUN INDIVIDUALLY, UNCOMMENT THIS
//	    	// Create and set up the window.
//	        JFrame frame = new JFrame("JTable for the data");
//	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//
//	        // Create and set up the content pane.
//	        frame.setContentPane(this);
//	        
//	        // Display the window.
//	        frame.pack();
//	        frame.setVisible(true);
	    }
}
