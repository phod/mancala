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
	 * Tests if game is over
	 * 
	 * @return Returns 1 if game is over, else returns 0
	 */
	public int gameOver() {
		boolean finished = true;
		for (int hole = 0; hole < 6; hole++) {
			if (board.getPieces(player, hole) != 0) {
				finished = false;
				break;
			}
		}
		if (finished == true) {
			return 1;
		} else
			return 0;
	}

	/**
	 * Tests if hole is empty
	 * 
	 * @param hole
	 *            The hole number that is checked
	 * 
	 * @return True if hole is empty, else false
	 */
	public boolean isHoleEmpty(int hole) {
		if (board.getPieces(player, hole) == 0) {
			return true;
		} else
			return false;
	}

	/**
	 * This methods takes the marbles from the specified hole, and places them
	 * one by one in the following holes. Because of how this mehtod is
	 * structures, the holes must be like so when implemented
	 * m,p1h1,p1h2,p1h3,p1h4,p1h5,p1h6
	 */
	public void pickHole(int hole) {
		int numberOfMarbles = board.getPieces(player, hole);
		board.addPieces(player, hole, -numberOfMarbles);
		for (int placing = numberOfMarbles; placing > 0; placing--) {
			hole++;

			// Checks if it has reached the other player's side (excpet mancala)
			if ((hole / 6) % 2 == 1) {
				// Checks if it has reached Mancala for player
				if (hole % 6 == 0) {
					board.addMancala(player, 1);
				} else {
					// The absolute of player-1 is the other player
					board.addPieces(Math.abs(player - 1), hole % 6, 1);
				}
			}
			// Checks if it has reached Mancala for other player
			else if (hole % 6 == 0) {
				// The absolute of player-1 is the other player
				board.addMancala(Math.abs(player - 1), 1);
			}
			// Adds peics to the players hole
			else {
				board.addPieces(player, hole % 6, 1);
			}

		}

	}
}
