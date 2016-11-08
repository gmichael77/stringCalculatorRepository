
public class StringCalculator {

	private final String[] delimiters={",","\n"};
	
	
	//exception  
	public int add(String numbersString) throws Exception{
		
		//chaine vide -- useCase 1.1
		if(numbersString.isEmpty())
			return 0;
		
		
		for(String delimiter:delimiters){
			if(numbersString.endsWith(delimiter))
				throw new Exception("String chaine ending with a delimiter");
		}
		
		
		String delimiterRegex="";
		for(String delimiter:delimiters){
			delimiterRegex = delimiterRegex.concat("|").concat(delimiter);
		}
		delimiterRegex = delimiterRegex.substring(1);
		
		String[] numbers = numbersString.split(delimiterRegex);
		
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
