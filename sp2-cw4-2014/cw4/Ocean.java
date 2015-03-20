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
	Ship[] actualShips = new Ship[10];	
	int shotsFired;
	int hitCount;
	int shipsSunk;
	
	Ocean(){
		this.shotsFired = 0;
		this.hitCount = 0;
		this.shipsSunk = 0;
		
		actualShips[0] = new Battleship();
		actualShips[1] = new Cruiser();
		actualShips[2] = new Cruiser();
		actualShips[3] = new Destroyer();
		actualShips[4] = new Destroyer();
		actualShips[5] = new Destroyer();
		actualShips[6] = new Submarine();
		actualShips[7] = new Submarine();
		actualShips[8] = new Submarine();
		actualShips[9] = new Submarine();
		
		for (int i = 0; i < this.ships.length; i++) {
		    for (int j = 0; j < this.ships.length; j++) {
		        ships[i][j] = new EmptySea();
		    }
		}
	}
	
	//GETTER METHODS
	int getShotsFired(){
		return this.shotsFired;
	}
	
	int getHitCount(){
		return this.hitCount;
	}
	
	int getShipsSunk(){
		return this.shipsSunk;
	}
	
	//INSTANCE METHODS
	void placeAllShipsRandomly(){
				
		for (int i = 0; i < actualShips.length; i++){
			boolean placed = false;
			while (!placed){
				int row = getRandom(10);
				int column = getRandom(10);
				boolean horizontal = getRandom(2) == 0 ? true : false;
				
				if(actualShips[i].okToPlaceShipAt(row, column, horizontal, this)){				
					for(int j = 0; j < actualShips[i].getLength(); j++){					
						actualShips[i].placeShipAt(row, column, horizontal, this);
					}
					placed = true;
				}
			}
		}
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
		else{			//TODO Inform player when a ship is sunk, decide to use and understand Ship.shootAt() method 
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
			if(this.ships[row][column].isSunk()){
				System.out.println("You have sunk a "+this.ships[row][column].getShipType()+".");
			}
			return true;
		}			
	}//EMD OF METHOD
	
	int getRandom(int temp){
		return rand.nextInt(temp);
	}
	
	boolean isGameOver(){
		return this.getShipsSunk() == 10 ? true : false;
	}
		
	void print(){
		System.out.println("   0  1  2  3  4  5  6  7  8  9");
		
		for(int i = 0; i < 10; i++){
			System.out.print(i+"  ");
			for (int j = 0; j < 10; j++){
				System.out.print(this.ships[i][j].toString(i,j)+"  ");
			}
			System.out.println();
		}
	}
}//END OF CLASS