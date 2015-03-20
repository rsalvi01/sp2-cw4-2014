/**
 * 
 */
package cw4;

/**
 * @author RSALVI01
 *
 */
public class Destroyer extends Ship {

	Destroyer()
	{
		this.length = 2;
		this.hit = new boolean[2]; 
	}
	
	@Override
	String getShipType(){
		return "Destroyer";
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
