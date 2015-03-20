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
	
	@Override public String toString(){	
		int row = this.getBowRow(); 
		int column = this.getBowColumn();
		
		if(this.isSunk()){
			return "x";
		}
		
		if(!this.hit[0]){
			return ".";
		}
		else{
			return "S";
		}
	}

}
