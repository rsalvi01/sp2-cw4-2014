/**
 * 
 */
package cw4;

import java.util.Random;

/**
 * @author rsalvi01
 *
 */
public class Ocean {

	private final Random rand = new Random(); 
	Ship[][] ships = new Ship[10][10];
	int shotsFired;
	int hitCount;
	int shipsSunk;
	
	Ocean(){
		this.shotsFired = 0;
		this.hitCount = 0;
		this.shipsSunk = 0;
		
		for (int i = 0; i < this.ships.length; i++) {
		    for (int j = 0; j < this.ships.length; j++) {
		        ships[i][j] = new EmptySea();
		    }
		}
	}
	
	//GETTER METHODS
	private int getShotsFired(){
		return this.shotsFired;
	}
	
	private int getHitCount(){
		return this.getHitCount();
	}
	
	private int getShipsSunk(){
		return this.shipsSunk;
	}
	
	//INSTANCE METHODS
	void placeAllShipsRandomly(){
		
	}
		
	boolean isOccupied(int row, int column){
		return this.ships[row][column].getShipType().equals("EmptySea") ? false : true;	
	}

	boolean shootAt(int row, int column){
		this.shotsFired ++;
		
		if(!this.isOccupied(row, column)){
			if(!this.ships[row][column].hit[0]) this.ships[row][column].hit[0] = true;
			return false;
		}
		else if(this.ships[row][column].isSunk()){
				return false;
		}
		else{			
			if(!this.ships[row][column].isHorizonal()){
				int temp = this.ships[row][column].getBowRow();

				if(this.ships[row][column].hit[row - temp] = false){
				this.ships[row][column].hit[row - temp] = true;				
				}
			}
			else{
				int temp = this.ships[row][column].getBowColumn();

				if(this.ships[row][column].hit[column - temp] = false){
				this.ships[row][column].hit[column - temp] = true;				
				}			
			}
			return true;
		}			
	}//EMD OF METHOD
	
	int getRandom(){
		return rand.nextInt(10);
	}
	
	boolean isGameOver(){
		return this.getShipsSunk() == 10 ? true : false;
	}
		
	void print(){
		for(int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++){
				System.out.print(this.ships[i][j].toString()+" ");
			}
			System.out.println();
		}
	}

}//END OF CLASS
