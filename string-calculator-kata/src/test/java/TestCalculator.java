import static org.junit.Assert.*;
import org.junit.Test;


public class TestCalculator{

	
	
	
	//chaine vide --> 0
	@Test
	public void emptyStringReturnNull(){
		
		StringCalculator cal=new StringCalculator();
		assertEquals(0, cal.add(""));
	}
	
}
