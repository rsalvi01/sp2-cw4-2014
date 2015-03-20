/**
 * 
 */
package cw4;

/**
 * @author RSALVI01
 *
 */
public class Cruiser extends Ship {

	Cruiser()
	{
		this.length = 3;
		this.hit = new boolean[3]; 
	}
	
	@Override
	String getShipType(){
		return "Cruiser";
	}
	
	@Override public String toString(int i, int j){	
		
		if(this.isSunk()){
			return "x";
		}
	
		if(!this.horizontal){
			return this.hit[i-this.getBowRow()] ? "S" : ".";
		}
		else{
			return this.hit[i-this.getBowColumn()] ? "S" : ".";
		}
	}	
}
