package de.ad.sudoku;
import java.util.ArrayList;
import java.util.Iterator;
public class mydata {

	//private String inputs; 
	//private long time; 
	//private int inputs ;
	public ArrayList<Integer> inputs = new ArrayList<Integer>();
	public ArrayList<Double> time = new ArrayList<Double>();
	

	
	public void setdata(int inputs , double time) {
		 this.inputs.add(inputs) ; 
		 this.time.add(time) ; 
	}
	
	public ArrayList<Integer> getInput() {

       return inputs ;
     

		
	}
	
	public ArrayList<Double> getTime() {
		 return this.time ; 
	}
}
