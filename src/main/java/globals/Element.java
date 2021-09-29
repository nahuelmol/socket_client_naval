package globals;

import java.util.ArrayList;
import java.util.Iterator;

public class Element {
	public static ArrayList<Double> coordinates = new ArrayList<Double>();

	public void show_coordinates(){
		System.out.println(this.coordinates);
	}

	public void add_coordinates(double x, double y){
		Iterator<Double> itr = this.coordinates.iterator();
		while (itr.hasNext()) {
		    Double number = itr.next();
		       itr.remove();
		}
		
		this.coordinates.add(0,x);
		this.coordinates.add(1,y);
	}

}