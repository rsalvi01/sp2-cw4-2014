/**
 * 
 */
package cw4;

/**
 * @author RSALVI01
 *
 */
public class Submarine extends Ship {

	Submarine()
	{
		this.length = 1;
		this.hit = new boolean[1]; 
	}
	
	@Override
	String getShipType(){
		return "Submarine";
	}
	
	@Override public String toString(int i, int j){	
		
		if(this.isSunk()){
			return "x";
		}
	
		if(!this.horizontal){
			return this.hit[i-this.getBowRow()] ? "S" : ".";
		}
		else{
			return this.hit[j-this.getBowColumn()] ? "S" : ".";
		}
	}
	
}
