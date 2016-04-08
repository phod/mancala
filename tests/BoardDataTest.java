import static org.junit.Assert.assertEquals;
import org.junit.Test;
import gameLogic.BoardData;

public class BoardDataTest {
	
    
    @Test
    BoardData test = new BoardData(1, 1);
    test.sides[0][0]=0;
    public void testIsEmptyBoard() {   	
    	assertEquals("Empty hole must be true",true, test.isHoleEmpty(0,0));
    }
}
