
public class StringCalculator {

	public int add(String numbersString){
		
		//chaine vide -- useCase 1.1
		if(numbersString.isEmpty())
			return 0;
		
		String[] numbers = numbersString.split(",");
		
		//nombre unique -- useCase 1.2
		if(numbers.length==1)
			return Integer.parseInt(numbersString);
		
		
		return Integer.parseInt(numbers[0])+Integer.parseInt(numbers[1]);
		
	}
	
}
