package gameLogic;

/**
 * BoardController receives requests to act on a particular hole It contains
 * game rules, moving pieces appropriately It acts on BoardData instance
 * 
 * @author Ross Hanson
 * @since 2016-02-23
 */

public class BoardController {

	BoardData board;
	int player;

	/**
	 * Creates a new BoardController, sets up a board, and defaults player to
	 * player 0
	 */
	public BoardController() {
		board = new BoardData();
		player = 0;

	}

	/**
	 * Sets the current player
	 * 
	 * @param nextPlayer
	 *            Sets the current player for the board
	 */
	public void setPlayer(int nextPlayer) {
		player = nextPlayer;
	}

	/**
	 * Tests if player has one
	 * 
	 * @return Returns 1 if player has won, else returns 0
	 */
	public int hasWon() {
		boolean winning = true;
		for (int hole = 0; hole < 6; hole++) {
			if (board.getPieces(player, hole) != 0) {
				winning = false;
				break;
			}
		}
		if (winning == true) {
			return 1;
		} else
			return 0;
	}
	
	/**
	 * Tests if hole is empty
	 * 
	 * @return
	 * 		True if hole is empty, else false
	 */
	public boolean isHoleEmpty(hole){
		if(board.getPieces(player, hole)==0){
			return true;
		}
		else return false;
	}

	public void pickHole(int hole){

	}

}
