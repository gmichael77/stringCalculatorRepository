
public class StringCalculator {

	private final String[] delimiters={",","\n"};
	
	
	//exception  
	public int add(String numbersString) throws Exception{
		
		//chaine vide -- useCase 1.1
		if(numbersString.isEmpty())
			return 0;
		
		String delimiterRegex = getDelimiterRegex(numbersString);		
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
			result += Integer.parseInt(uniqueNumber);
		}
		return result;
	}
	
	
	private String getDelimiterRegex(String numbersString) throws Exception{
		String delimiterRegex="";
		for(String delimiter:delimiters){
			
			if(numbersString.endsWith(delimiter))
				throw new Exception("String chaine ending with a delimiter");
			
			delimiterRegex = delimiterRegex.concat("|").concat(delimiter);
		}
		return delimiterRegex.substring(1);
	}
	
}
