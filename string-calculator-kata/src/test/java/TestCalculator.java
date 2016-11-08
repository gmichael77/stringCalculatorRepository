import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestCalculator{

	private StringCalculator cal=null;
	
	
	@Before
	public void init(){
		cal=new StringCalculator();
	}
		
	
	//chaine vide --> 0
	@Test
	public void emptyStringReturnNull() throws Exception{
		assertEquals(0, cal.add(""));
	}
	
	
	
	private int myRandomInteger()
	{
	    return (int) (Math.random() * 10);
	}
	
	//chaine avec 1 seul nombre -->  retour du nombre
	@Test
	public void StringWithUniqueNumberReturn() throws Exception{
		
		//entre 0 et 9
		int entierRandom = myRandomInteger();
		assertEquals(entierRandom, cal.add(String.valueOf(entierRandom)));
	}
	
	
	//chaine avec 2 nombre a additionner (delimitée avec une virgule)
	@Test
	public void StringWithTwoNumbersDelimitedByCommaReturnSum() throws Exception{
		
		//entre 0 et 9
		int entierRandom1 = myRandomInteger();
		int entierRandom2 = myRandomInteger();
		int result = entierRandom1+entierRandom2;
		assertEquals(6, cal.add("2,4"));
		assertEquals(result, cal.add(String.valueOf(entierRandom1).concat(",").concat(String.valueOf(entierRandom2))));
	}
	
	
	//chaine avec  nombre illimité a additionner (delimitée avec une virgule)
		@Test
		public void StringWithUnknownNumbersDelimitedByCommaReturnSum() throws Exception{
			
			int result = myRandomInteger();
			String stringNumbers= String.valueOf(result);
			
			for(int i=20;i>0;i--){
				
				//entre 0 et 9
				int entierRandom = myRandomInteger();
				result = result + entierRandom;
				stringNumbers = stringNumbers.concat(",").concat(String.valueOf(entierRandom));
			}
			
			assertEquals(28, cal.add("1,2,3,4,5,6,7"));
			assertEquals(result, cal.add(stringNumbers));
		}
	
		
		@Test
		public void StringWithNumbersDelimitedByCommaOrNewLineReturnSum() throws Exception{
			
			assertEquals(6, cal.add("1\n2,3"));
			assertEquals(6, cal.add("2,3\n1"));
		}
		
		
		//si la chaine finit par plusieur delimiters --> encapsulé par l'exception sur la fin par 1 delimiter
		@Test(expected=Exception.class)
		public void StringWithNumbersAndEndingWithNewLineReturnException() throws Exception{
			
			assertEquals(6, cal.add("1,2,3\n"));
		}
		
		@Test(expected=Exception.class)
		public void StringWithNumbersAndEndingWithCommaReturnException() throws Exception{
			
			assertEquals(6, cal.add("1,2,3,"));
		}
		
		
		// changement de delimiter
		@Test
		public void StringWithDelimiterChangingReturnSum() throws Exception{
			
			assertEquals(3, cal.add("//;\n1;2"));
		}
		
		
		// input avec nombre negatif
		@Test(expected=Exception.class)
		public void StringWithNegativeNumbersReturnException() throws Exception{
			
			assertEquals(-1, cal.add("-1"));
		}
		
		
		// input avec nombre negatif
		@Test(expected=Exception.class)
		public void StringWithAllNegativeNumbersReturnException() throws Exception{
			
			try{
				assertEquals(-1, cal.add("-1,-2,-3,-4"));
			}catch(Exception e){
				
				assertEquals("negatives not allowed : -1 -2 -3 -4 ",e.getMessage());
				throw new Exception(e.getMessage());
			}
			fail();
		}
		
		
		// input avec nombre negatif
		@Test(expected=Exception.class)
		public void StringWithNegativeAndPositiveNumbersReturnException() throws Exception{
			
			try{
				assertEquals(-1, cal.add("-1,2,-5,8"));
			}catch(Exception e){
				
				assertEquals("negatives not allowed : -1 -5 ",e.getMessage());
				throw new Exception(e.getMessage());
			}
			fail();
		}
	
}
