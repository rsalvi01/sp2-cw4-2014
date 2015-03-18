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
	
	@Override public String toString(){
		return this.isSunk() ? "x" : "S";
	}
	
}
