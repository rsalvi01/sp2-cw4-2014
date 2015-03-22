/**
 * 
 */
package cw4;

/**
 * @author rsalvi01
 * Due date: 29/03/15 23:55h
 */
public class BattleshipGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		boolean playAgain = true;
		
		while(playAgain){
			Ocean a = new Ocean();
			a.placeAllShipsRandomly();
			
			System.out.println("WELCOME TO MY BATTLESHIP GAME");
		
			while(!a.isGameOver()){			
				System.out.println("Ships sunk: "+a.getShipsSunk()+"          "+"Shots fired: "+a.getShotsFired()+"          "+"Shots hit: "+a.getHitCount());
				System.out.println();
				
				int row = a.getUserInput("row");
				int column = a.getUserInput("column");
				
				a.shootAt(row,column);
				
				a.print();		
			}
		
			System.out.println("Congratulations, you have sunk all ships firing "+a.getShotsFired()+" shots.");			 
			playAgain = a.getUserInput("") == 1 ? true : false;				
		}		
	}	
}
