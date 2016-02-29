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
	 * Used for printing board state to console. 
	 */
	public void printBoard(){
		for(int players = 0; players<numberOfPlayers; players++){
			for(int sides = 0; sides<numberOfHoles; sides++){
				System.out.print(board.getPieces(players, sides) + " ");
			}
			System.out.print(board.getPoints(players) + " ");
		}
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
	 * The player who still has pieces on his side of the board when the game ends captures all of those pieces.
	 * 
	 * @param losingPlayer The player who lost
	 */
	public void endGameCapture(int losingPlayer){
		for (int hole = 0; hole < numberOfHoles; hole++) {
			if(!board.isHoleEmpty(losingPlayer, hole)){
				int numberOfPiecesCaptured = board.getPieces(losingPlayer, hole);
				board.addPieces(losingPlayer, hole, -numberOfPiecesCaptured);
				board.addPoints(losingPlayer, numberOfPiecesCaptured);
			}
		}
	}
	
	
	/**
	 * Tests if game is over, the game ends when all six spaces on one side of the Mancala board are empty.
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
	
	/**
	 * Used test there is only one piece left, meaning it is the last hole to place a piece in
	 * 
	 * @parm piecesLeft the number of peices left
	 * 
	 * @return true if it is the last peice, else false.
	 */
	private boolean lastHole(int piecesLeft){
		if (piecesLeft==1){
			return true;
		}
		return false;
	}

	/**
	 * Used to capture if the last piece player places is in an empty hole on player's side.
	 * Player capture that piece and any pieces in the hole directly opposite.
	 * 
	 * @param hole The hole numbe that is being captured by player
	 */
	public void capture(int hole){
		int otherPlayer=(Math.abs(player-1));
		int numberOfPiecesCaptured = board.getPieces(otherPlayer, hole);	
		board.addPieces(otherPlayer, hole, -numberOfPiecesCaptured);
		board.addPieces(player, hole, -1);	
		board.addPoints(player, numberOfPiecesCaptured+1);
	
	}
	

	/**
	 * This methods takes the marbles from the specified hole, and places them
	 * one by one in the following holes. If it is not a players points, it will continue around the board.
	 * 
	 * Note how the placing wraps to go to other players
	 * 
	 * @param hole The hole player choiceds to empty
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
