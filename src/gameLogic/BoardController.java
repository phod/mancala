package gameLogic;

/**
 * BoardController receives requests to act on a particular hole It contains
 * game rules, moving pieces appropriately It acts on BoardData instance
 * 
 * @author Ross Hanson
 * @since 2016-02-23
 */

public class BoardController {

	private int numberOfPlayers= 2;
	private int numberOfHoles =6;
	BoardData board;
	int player;

	/**
	 * Creates a new BoardController, sets up a board, and defaults player to
	 * player 0
	 */
	public BoardController() {
		board = new BoardData(numberOfPlayers, numberOfHoles);
		player = 0;

	}

	/**
	 * Sets the current player
	 * 
	 * @param nextPlayer Sets the current player for the board
	 */
	public void setPlayer(int nextPlayer) {
		player = nextPlayer;
	}

	/**
	 * Tests if game is over
	 * 
	 * @return Returns true if game is over, else returns false
	 */
	public boolean gameOver() {
		boolean finished = true;
		for (int hole = 0; hole < numberOfHoles; hole++) {
			if (!board.isHoleEmpty(player, hole)) {
				finished = false;
				break;
			}
		}
		if (finished == true) {
			return true;
		} else
			return false;
	}
	
	public boolean lastHole(int piecesLeft){
		if (piecesLeft==1){
			return true;
		}
		return false;
	}

	public void capture(int hole){
		
	
	}
	
	
	/**
	 * This methods takes the marbles from the specified hole, and places them
	 * one by one in the following holes. If it is not a players points, it will continue around the board.
	 * 
	 * Note how the placing wraps to go to other players
	 * 
	 * @parm hole The hole player choiceds to empty
	 * 
	 * @return True means player gets another turn, False means, it goes to next player
	 */
	public boolean pickHole(int hole) {
		int numberOfMarbles = board.getPieces(player, hole);
		board.addPieces(player, hole, -numberOfMarbles);
		for (int placing = numberOfMarbles; placing > 0; placing--) {
			hole++;
			// Checks side of the board it is on
			int tempPlayer = (hole / numberOfHoles) % numberOfPlayers;
			if (hole % numberOfHoles == 0) {
				if (tempPlayer != player) {
					placing++;
				} else {
					board.addPoints(player, 1);
					if(lastHole(placing)){
						return true;
					}
				}
			} else {
				board.addPieces(tempPlayer, hole % numberOfHoles, 1);
				if(lastHole(placing)){
					capture(hole);
				}
			}
		}
		return false;
	}
}
