package gameLogic;

/**
 * BoardData contains the state of the Mancala board.
 *
 * @author Philip Hodder
 * @since 2015-08-23
 */

public class BoardData {

	private final int SIDE_ONE = 0;
	private final int SIDE_TWO = 1;

	private int[][] holes;
	private int[] mancalas;

	/**
	 * Creates a board with 2 sides, 6 holes on each side, and 2 mancala holes.
	 * Each hole (excluding mancalas) is filled with 4 pieces.
	 */
	public BoardData() {
		this.holes = new int[2][6];
		this.mancalas = new int[] {0,0};
		// Add 4 pieces to each hole.
		for (int i = 0; i < this.holes.length; i++) {
			this.addPieces(SIDE_ONE, i, 4);
			this.addPieces(SIDE_TWO, i, 4);
		}
	}
	

	/**
	 * Adds the specified number of pieces to the specified hole. This method
	 * does <em>not</em> add to mancala holes.
	 *
	 * @param side
	 *            The side of the board to add the pieces to.
	 * @param pos
	 *            Which hole on the board to add the piece to.
	 * @param numPieces
	 *            How many pieces to add to the hole.
	 * @throws InvalidSideException
	 *             TODO
	 * @throws InvalidPositionException
	 *             TODO
	 * @throws NegativePiecesException
	 *             TODO
	 */
	public void addPieces(int side, int pos, int numPieces) {
		this.holes[side][pos] += numPieces;
	}
	
	/**
	 * Adds the specified number of peices to the specified mancala hole
	 * 
	 * @param side
	 * 				The side of the board
	 */
	public void addMancala(int side, int numPieces) {
		this.mancalas[side] += numPieces;
	}

	/**
	 * Returns the number of pieces in the specified hole. This method does
	 * <em>not</em> retrieve from mancala holes.
	 *
	 * @param side
	 *            The side of the board to see the number of pieces.
	 * @param pos
	 *            Which hole on the board to see the number of pieces.
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
	 * Returns the number of pieces a mancala hole
	 * 
	 * @param side
	 * 				The side of the board
	 * 
	 * @return
	 *			Number of peices in specified mancala
	 */
	public int getMancala(int side){
		return this.mancalas[side];
	}
	
}
