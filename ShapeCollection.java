package Exe.Ex4;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import Exe.Ex4.geo.Circle2D;
import Exe.Ex4.geo.Point2D;
import Exe.Ex4.geo.Polygon2D;
import Exe.Ex4.geo.Rect2D;
import Exe.Ex4.geo.Segment2D;
import Exe.Ex4.geo.Triangle2D;
import Exe.Ex4.gui.Ex4;

/**
 * This class represents a collection of GUI_Shape.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class ShapeCollection implements ShapeCollectionable{
	private ArrayList<GUI_Shapeable> _shapes;
	
	public ShapeCollection() {
		_shapes = new ArrayList<GUI_Shapeable>();
	}
	public ShapeCollection(ArrayList<GUI_Shapeable> shapes) {
		shapes = new ArrayList<GUI_Shapeable>();
	}
	@Override
	public GUI_Shapeable get(int i) {
		return _shapes.get(i);
	}
	public ArrayList<GUI_Shapeable> get_shapes(){return _shapes;}
	@Override
	public int size() {
		return _shapes.size();
	}

	@Override
	public GUI_Shapeable removeElementAt(int i) {
		return _shapes.remove(i);
	}

	@Override
	public void addAt(GUI_Shapeable s, int i) {
		ShapeCollection shapes = new ShapeCollection();
		for(int j=0;j<_shapes.size();j++)
		{
			if(j==i) {
				shapes.add(s);
			}
			shapes.add(_shapes.get(j));
		}
			_shapes=shapes.get_shapes();
			}
	@Override
	public void add(GUI_Shapeable s) {
		if(s!=null && s.getShape()!=null) {
			_shapes.add(s);
		}
	}
	@Override
	public ShapeCollectionable copy() {
		return new ShapeCollection(_shapes);
	}

	@Override
	public void sort(Comparator<GUI_Shapeable> comp) {
		Collections.sort(_shapes, comp);
	}

	@Override
	public void removeAll() {
		for(int i=_shapes.size()-1;i>=0;i--)
		{
			this.removeElementAt(i);
		}
	}

	@Override
	public void save(String file) {
		// Open a file chooser dialog to let the user choose the location to save the file
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = fileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            File file2 = fileChooser.getSelectedFile();
            // Save the file
            try (FileWriter writer = new FileWriter(file2)) {
                // Write the content of the file here
            	
            	if(this!=null) {
            	for(int i=0;i<this.size();i++) {
                writer.write(this.get(i).toString());
            	}
            	}
            } catch (IOException e) {
                e.printStackTrace();
            }        }
	}

	@Override
	    public void load(String file) {
		// Open a file chooser dialog to let the user choose the location to save the file
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = fileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            File file2 = fileChooser.getSelectedFile();
            
	        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
	            String row;
	            while ((row = br.readLine()) != null) {
	                System.out.println(row);
	                String[] details = row.split(",");
	                
	                if (details[4].equals("Circle2D")) {
	                   _shapes.add(new GUIShape( new Circle2D(new Point2D(Double.parseDouble(details[5]), Double.parseDouble(details[6])), Double.parseDouble(details[7])),
	                           Boolean.parseBoolean(details[2]),
	                           new Color(Integer.parseInt(details[1])),
	                           Integer.parseInt(details[3])));
	                   }
	                else if (details[4].equals("Rect2D")) {
	                	_shapes.add(new GUIShape(
	                			new Rect2D( new Point2D(Double.parseDouble(details[5]),Double.parseDouble(details[6])) , 
	                					    new Point2D(Double.parseDouble(details[7]), Double.parseDouble(details[8]))  
	                					    ),
	                            Boolean.parseBoolean(details[2]),
	                            new Color(Integer.parseInt(details[1])),
	                            Integer.parseInt(details[3])));
	                } 
	                else if (details[4].equals("Segment2D")) {
	                	_shapes.add(new GUIShape(
	                			new Segment2D( new Point2D(Double.parseDouble(details[5]),Double.parseDouble(details[6])) , 
	                					       new Point2D(Double.parseDouble(details[7]), Double.parseDouble(details[8]))  
	                					       ),
	                            Boolean.parseBoolean(details[2]),
	                            new Color(Integer.parseInt(details[1])),
	                            Integer.parseInt(details[3])));  	
	                } 
	                else if (details[4].equals("Triangle2D")) {
	                	_shapes.add(new GUIShape(
	                			new Triangle2D( new Point2D(Double.parseDouble(details[5]),Double.parseDouble(details[6])) , 
	                					        new Point2D(Double.parseDouble(details[7]),Double.parseDouble(details[8])) ,
	                					        new Point2D(Double.parseDouble(details[9]),Double.parseDouble(details[10])) 
	                					        ),
	                            Boolean.parseBoolean(details[2]),
	                            new Color(Integer.parseInt(details[1])),
	                            Integer.parseInt(details[3])));	
	                } 
	                else if (details[4].equals("Polygon2D")) {
	                	double []x = new double[(details.length-5)/2];
	                	double []y = new double[(details.length-5)/2];
	                	for(int i = 5; i< (details.length-5)/2+5; i=i+2) {
	                		x[i-5]=Double.parseDouble(details[i]);
	                	    y[i-5]=Double.parseDouble(details[i+1]);
	                	}
	                	_shapes.add(new GUIShape(
	                			new Polygon2D(x,y),
	                            Boolean.parseBoolean(details[2]),
	                            new Color(Integer.parseInt(details[1])),
	                            Integer.parseInt(details[3])));
	                }
	            }
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
        }
	}

	@Override
	public Rect2D getBoundingBox() {
		Rect2D ans = null;
		double xMinLeft=100000000;
		double xMinRight=0;
		double yMinDown=100000000;
		double yMinUp=0;

		for(int i=0;i<_shapes.size();i++)
		{
			for(int j=0;j<_shapes.get(i).getShape().getPoints().length;j++) {
			if(_shapes.get(i).getShape().getPoints()[j].x()<=xMinLeft)
				xMinLeft=_shapes.get(i).getShape().getPoints()[j].x();
			
			if(_shapes.get(i).getShape().getPoints()[j].x()>=xMinRight)
				xMinRight=_shapes.get(i).getShape().getPoints()[j].x();
			
			if(_shapes.get(i).getShape().getPoints()[j].x()<=yMinDown)
				yMinDown=_shapes.get(i).getShape().getPoints()[j].x();
			
			if(_shapes.get(i).getShape().getPoints()[j].x()>=yMinUp)
				yMinUp=_shapes.get(i).getShape().getPoints()[j].x();
			}
		}
		double Xmax=Math.max(xMinLeft, xMinRight);
		double Ymax=Math.max(yMinDown, yMinUp);
		double Xmin=Math.min(xMinLeft, xMinRight);
		double Ymin=Math.min(yMinDown, yMinUp);
		ans = new Rect2D(new Point2D(Xmin,Ymin),new Point2D(Xmax,Ymax));
		return ans;
	}
	@Override
	public String toString() {
		String ans = "";
		for(int i=0;i<size();i=i+1) {
			ans += this.get(i);
		}
		return ans;
	}
	

}
