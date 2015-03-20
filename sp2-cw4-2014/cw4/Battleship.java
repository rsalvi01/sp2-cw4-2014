/**
 * 
 */
package cw4;

/**
 * @author RSALVI01
 *
 */
public class Battleship extends Ship {
	
	Battleship()
	{
		this.length = 4;
		this.hit = new boolean[4]; 
	}
	
	@Override
	String getShipType(){
		return "Battleship";
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
