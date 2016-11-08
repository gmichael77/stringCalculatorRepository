
public class StringCalculator {

	public int add(String numbersString){
		
		//chaine vide -- useCase 1.1
		if(numbersString.isEmpty())
			return 0;
		
		String[] numbers = numbersString.split(",");
		
		//nombre unique -- useCase 1.2
		if(numbers.length==1)
			return Integer.parseInt(numbersString);
		
		
		int result=0;
		for(String uniqueNumber :numbers){
			result = sumStringNumber(result,uniqueNumber);
		}
		
		return result;
		
	}
	
	
	//addition d'un nombre supplementaire a la somme finale
	private int sumStringNumber(int sum,String number){
		return sum+Integer.parseInt(number);
	}
	
}
