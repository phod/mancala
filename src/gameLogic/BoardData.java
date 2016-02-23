package gameLogic;

/**
 * BoardData contains the state of the Mancala board.
 *
 * @author Philip Hodder
 * @since 2015-08-23
 */

public class BoardData {

	private int[][] holes;
	private int[] points;

	/**
	 * Creates a board with 2 sides, 6 holes on each side, and 2 points holes.
	 * Each hole (excluding points) is filled with 4 pieces.
	 * 
	 * @param numOfPlayers The number of players
	 * @param numOfHoles The number of holes for each player
	 */
	public BoardData(int numOfPlayers, int numOfHoles) {
		this.holes = new int[numOfPlayers][numOfHoles];
		this.points = new int[numOfPlayers];
		// Add 4 pieces to each hole.
		for (int x = 0; x < numOfPlayers; x++) {
			for (int i = 0; i < numOfHoles; i++) {
				this.addPieces(x, i, 4);
			}
			this.points[x]=0;
		}
	}

	/**
	 * Adds the specified number of pieces to the specified hole. This method
	 * does <em>not</em> add to points.
	 *
	 * @param side The side of the board to add the pieces to.
	 * @param pos Which hole on the board to add the piece to.
	 * @param numPieces How many pieces to add to the hole.
	 * @throws InvalidSideException TODO
	 * @throws InvalidPositionException TODO
	 * @throws NegativePiecesException TODO
	 */
	public void addPieces(int side, int pos, int numPieces) {
		this.holes[side][pos] += numPieces;
	}
	
	/**
	 * Adds the specified number of peices to the specified points hole
	 * 
	 * @param side The side of the board
	 */
	public void addPoints(int side, int numPieces) {
		this.points[side] += numPieces;
	}

	/**
	 * Returns the number of pieces in the specified hole. This method does
	 * <em>not</em> retrieve from points.
	 *
	 * @param side The side of the board to see the number of pieces.
	 * @param pos Which hole on the board to see the number of pieces.
	 * @return The number of pieces in the request position.
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public int getPieces(int side, int pos) {
		if (side < 0 || side > 1) {
			throw new ArrayIndexOutOfBoundsException("invalid side");
		}
		if (pos < 0 || pos > 5) {
			throw new ArrayIndexOutOfBoundsException("invalid posistion");
		}
		return this.holes[side][pos];
	}
	
	
	/**
	 * Tests if hole is empty
	 * 
	 * @param side
	 *            The side of the board to see the number of pieces.
	 * @param pos
	 *            Which hole on the board to see the number of pieces.
	 * 
	 * @return True if hole is empty, else false
	 */
	public boolean isHoleEmpty(int side, int pos) {
		if (this.getPieces(side, pos) == 0) {
			return true;
		} else
			return false;
	}

	/**
	 * Returns the number of pieces int points
	 * 
	 * @param side
	 * 				The side of the board
	 * 
	 * @return
	 *			Number of peices in specified pointss
	 */
	public int getPoints(int side){
		return this.points[side];
	}
	
}
