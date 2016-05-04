import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import gameLogic.BoardData;

	
public class BoardDataTest {

	//private BoardData test;
	
	/*@Before
	public void excecutedBeforeEach() {
		BoardData test = new BoardData(1, 1);
	}
	*/
	// test.holes[0][0]=0;

	
	@Test
	public void testGetPeices() {
		BoardData test = new BoardData(1, 1);
		assertEquals("Hole starts with 4", 4, test.getPieces(0, 0));
	}

	@Test
	public void testIsEmptyBoard() {
		BoardData test = new BoardData(1, 1);
		assertFalse("Empty hole must be false", test.isHoleEmpty(0, 0));
	}

}
