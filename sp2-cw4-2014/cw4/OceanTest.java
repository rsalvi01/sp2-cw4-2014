/**
 * 
 */
package cw4;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author RSALVI01
 *
 */
public class OceanTest {

	@Test
	public void constructorTesting() {
		Ocean a = new Ocean();
		
		assertTrue(a.hitCount == 0);
		assertTrue(a.shipsSunk == 0);
		assertTrue(a.shotsFired == 0);
		
		int filled = 0;
		
		for(int i = 0; i < a.ships.length; i++){			
		    for (int j = 0; j < a.ships.length; j++) {
		        filled += a.ships[i][j] != null ? 0 : 1;
		    }		    
		}	
		assertTrue(filled<=0);
	}
	
	@Test
	public void placeAllShipsRandomly(){
		Ocean a = new Ocean();
		
		a.placeAllShipsRandomly();
		
		
	}
	
	@Test
	public void isOccupied() {
		Ocean a = new Ocean();
		
		assertFalse(a.isOccupied(0, 0));
	}
	
	@Test
	public void shootAt() {
		Ocean a = new Ocean();
		
		a.shootAt(0,9);
				
		assertTrue(a.ships[0][9].hit[0]);
	}	
	
	@Test
	public void getRandom(){
		Ocean a = new Ocean();
				
		for (int i = 0; i < 10; i++){
			System.out.print(a.getRandom(10));			
		}
		System.out.println();
	}
	
	@Test
	public void isGameOver(){
		Ocean a = new Ocean();
		
		assertFalse(a.isGameOver());
		
		a.shipsSunk = 10;
		
		assertTrue(a.isGameOver());
	}
	
	@Test
	public void getUserInput() {
	
		Ocean a = new Ocean();
		int temp = a.getUserInput("row");
		int temp1 = a.getUserInput("column");
		assertTrue(temp >= 0 && temp<=9);
		assertTrue(temp1 >= 0 && temp1<=9);
		
	}
}
