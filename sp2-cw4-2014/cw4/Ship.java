/**
 * 
 */
package cw4;

/**
 * @author rsalvi01
 *
 */
public class Ship {
	protected int bowRow;
	protected int bowColumn;
	protected int length;
	protected boolean horizontal;
	protected boolean hit[] = new boolean[4];
	
	//GETTER METHODS
	int getBowRow(){
		return this.bowRow;
	}
	
	int getBowColumn(){
		return this.bowColumn;
	}
	
	boolean isHorizonal(){
		return this.horizontal;
	}
	
	String getShipType(){
		return "";
	}
	
	int getLength(){
		return this.length;
	}
	
	//SETTER METHODS
	void setBowRow(int row){
		this.bowRow = row;
	}
	
	void setBowColumn(int column){
		this.bowColumn = column;
	}
	
	void setHorizontal(boolean horizontal){
		this.horizontal = horizontal;
	}
	
	//INSTANCE METHODS
	boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean){
		if(horizontal){
			for(int i = 0; i < this.getLength(); i++)
			{
				if((row < 0 || row > 9) || (column+i < 0 || column+i > 9)){
					return false;
				}
				
				if(ocean.isOccupied(row, column+i)){
					return false;
				}
			}						
		}
		else{
			for(int i = 0; i < this.getLength(); i++)
			{
				if((row+i < 0 || row+i > 9) || (column < 0 || column > 9)){
					return false;
				}
				
				if(ocean.isOccupied(row+i, column)){
					return false;
				}
			}
		}
		
		for(int i = row-1; i < this.getLength()+2; i++){
			for (int j = column-1; j < this.getLength()+2; j++ ){
				if(i >= 0 && i < 10 && j >= 0 && j > 10){
						if(ocean.isOccupied(i,j) && ocean.ships[i][j] != this){
							return false;
					}
				}
			}
		}
		
		return true;
	}//END OF METHOD
	
	void placeShipAt(int row, int column, boolean horizontal, Ocean ocean){
		
		this.setBowRow(row);
		this.setBowColumn(column);
		
		if(horizontal){
			for(int i = 0; i < this.length; i++){
				ocean.ships[row][column+i] = this;
			}			
		}
		else{
			for(int i = 0; i < this.length; i++){
				ocean.ships[row+i][column] = this;
			}
		}			
		
	}
	
	//TODO if I use this method, I need to modify the method with the same name in the class OCEAN 
	boolean shootAt(int row, int column){				
		return true;
	}
	
	boolean isSunk(){		
		for(int i = 0; i < this.getLength(); i++)
		{
			if(!this.hit[i])
			{
				return false;
			}
		}
		return true;
	}
	
	public String toString(){
		return "";
	}
	
} // END OF CLASS