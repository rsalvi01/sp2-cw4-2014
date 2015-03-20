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
	
	@Override public String toString(){
		//for testing
		return this.isSunk() ? "x" : "D";
		//return this.isSunk() ? "x" : "S";		
	}
	
}
