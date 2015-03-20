/**
 * 
 */
package cw4;

/**
 * @author RSALVI01
 *
 */
public class EmptySea extends Ship {

	EmptySea(){
		this.length = 1;
		this.hit = new boolean[1];
	}
	
	@Override boolean shootAt(int row, int column){
		this.hit[0] = true;
		return false;
	}
	
	@Override boolean isSunk(){
		return false;
	}
	
	@Override public String toString(int i, int j){
		return this.hit[0] ? "-" : ".";
	}
	
	@Override
	String getShipType(){
		return "EmptySea";
	}
}
