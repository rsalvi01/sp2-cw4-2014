/**
 * 
 */
package cw4;

import java.util.Random;
import java.util.Scanner;

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
			if(!this.ships[row][column].hit[0]){
				this.ships[row][column].hit[0] = true;
			}
			return false;
		}
		else if(this.ships[row][column].isSunk()){
				this.hitCount++;
				return false;
		}
		else{ 
			this.hitCount++;
			this.ships[row][column].shootAt(row, column);
			if(this.ships[row][column].isSunk()){
				this.shipsSunk++;
				System.out.println();
				System.out.println("You have sunk a "+this.ships[row][column].getShipType()+".");
				System.out.println();
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
		System.out.println();
		System.out.println("   0  1  2  3  4  5  6  7  8  9");
		
		for(int i = 0; i < 10; i++){
			System.out.print(i+"  ");
			for (int j = 0; j < 10; j++){
				System.out.print(this.ships[i][j].toString(i,j)+"  ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	int getUserInput(String coord){
		Scanner in = new Scanner(System.in);
		int userInput = -1;

		if(coord.equals("row") || coord.equals("column")){
			while(userInput > 9 || userInput < 0){
				
				System.out.println("Please input your "+coord+" coordinate. It must be an integer from 0 to 9: ");
				
				while (!in.hasNextInt()){					
					System.out.println();
					System.out.println(in.next()+" is not a valid integer. Please try again");
					System.out.println();				
				}

				userInput = in.nextInt();

				if(userInput > 9 || userInput < 0){
					System.out.println();
					System.out.println(userInput+" is outside the valid range (from 0 to 9).");
					System.out.println();					
				}
			}
		}
		else{
			System.out.println("Please enter 1 if you would you like to play again.");
			userInput = in.next().equals("1") ? 1 : 0;
		}		
		return userInput;
	}	
}//END OF CLASS