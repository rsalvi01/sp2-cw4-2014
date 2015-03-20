/**
 * 
 */
package cw4;

import java.util.Scanner;

/**
 * @author rsalvi01
 * Due date: 29/03/15 23:55h
 */
public class BattleshipGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		boolean playagain = true;
		
		while(playagain){
		Ocean a = new Ocean();
		a.placeAllShipsRandomly();

		
		System.out.println("WELCOME TO MY BATTLESHIP GAME");
		System.out.println("Ships sunk: "+a.getShipsSunk());
		System.out.println("Shots fired: "+a.getShotsFired());
		System.out.println("Shots hit: "+a.getHitCount());
		System.out.println();
		
		a.print();
		
			if(a.isGameOver()){
				System.out.println("Congratulations, you have sunk all ships firing "+a.getShotsFired()+" shots.");
				System.out.println("Please enter 1 if you would you like to play again."); 
				
				Scanner in = new Scanner(System.in);
				
				
				if(i != 1)
				playagain = false;			
			}
		
		}


	}

	static int getUserShots(String coord){
		
		Scanner in = new Scanner(System.in);
		int userInput = 10;
		
		while(userInput > 9 || userInput < 0){
			System.out.println("Please input your "+coord+" coordinate. It must be an integer from 0 to 9: ");
			
			if(in.hasNextInt()){
				userInput = in.nextInt();
				if(userInput > 9 || userInput < 0){
					System.out.println(userInput+" is outside the valid range (from 0 to 9).");
				}
			}
			else{
				System.out.println(in.next()+" is not a valid input.");
			}
		}
		in.close();
		return userInput;
	}
	
}
