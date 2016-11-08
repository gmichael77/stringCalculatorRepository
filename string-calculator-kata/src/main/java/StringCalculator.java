
public class StringCalculator {

	private final String delimiter=",|\n";
	
	public int add(String numbersString){
		
		//chaine vide -- useCase 1.1
		if(numbersString.isEmpty())
			return 0;
		
		String[] numbers = numbersString.split(delimiter);
		
		//nombre unique -- useCase 1.2
		if(numbers.length==1)
			return Integer.parseInt(numbersString);
		
		
		
		return	getStringSum(numbers);
	
		
	}
	
	
	//Somme d'une liste de string
	private int getStringSum(String[] numbers){
		int result=0;
		for(String uniqueNumber :numbers){
			result = result + Integer.parseInt(uniqueNumber);
		}
		return result;
	}
	
}
