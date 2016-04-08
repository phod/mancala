import static org.junit.Assert.assertEquals;
import org.junit.Test;
import gameLogic.BoardData;

public class BoardDataTest {
	
    
    @Test
    BoardData test = new BoardData(1, 1);
    //test.holes[0][0]=0;
    public void testIsEmptyBoard() {   	
    	assertEquals("Empty hole must be false",false, test.isHoleEmpty(0,0));
    }
}
