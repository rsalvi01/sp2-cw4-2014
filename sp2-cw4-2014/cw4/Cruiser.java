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
	
	@Override public String toString(){
		return this.isSunk() ? "x" : "S";
	}
	
}
