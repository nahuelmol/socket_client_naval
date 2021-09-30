package globals;

import java.util.ArrayList;
import java.util.Iterator;

public class Element {
	public static ArrayList<Integer> coordinates = new ArrayList<Integer>();

	public void show_coordinates(){
		System.out.println(this.coordinates);
	}

	public void add_coordinates(int x, int y){
		Iterator<Integer> itr = this.coordinates.iterator();
		while (itr.hasNext()) {
		    Integer number = itr.next();
		    itr.remove();
		}
		
		this.coordinates.add(0,x);
		this.coordinates.add(1,y);
	}

}