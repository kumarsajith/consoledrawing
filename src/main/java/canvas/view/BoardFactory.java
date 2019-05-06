/**
 * 
 * BoardFactory.java
 * 
 * Factory class to create an instance of Board.
 * 
 */
package canvas.view;

/**
 * @author sarimbra
 * @date 29, Apr 2019
 */
public final class BoardFactory {
	
	/**
	 * create a new DrawingBoard implementation. 
	 * 
	 * @return
	 */
	public static DrawingBoard createBoard() {
		return new ConsoleBoard();
	}

}
