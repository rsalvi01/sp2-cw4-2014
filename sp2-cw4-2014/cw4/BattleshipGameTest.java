package cw4;

import static org.junit.Assert.*;

import org.junit.Test;

public class BattleshipGameTest {

	@Test
	public void testGetUserShots() {
	
		int temp = BattleshipGame.getUserShots("column");
		assertTrue(temp >= 0 && temp<=9);
		
	}
}
