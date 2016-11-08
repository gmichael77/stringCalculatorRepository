
public class StringCalculator {

	private final String[] delimiters={",","\n"};
	private final String newDelimiterChangingRegex = "^//.\n";
	
	
	//exception  
	public int add(String numbersString) throws Exception{
		
		//chaine vide -- useCase 1.1
		if(numbersString.isEmpty())
			return 0;
		

		String[] numbers = getNumbersTab(numbersString);
		
		
		//nombre unique -- useCase 1.2
		if(numbers.length==1)
			return StringToInt(numbersString);
		
		
		
		return	getStringSum(numbers);
	
		
	}
	
	
	
	private int StringToInt(String numberString){
		return Integer.parseInt(numberString);
	}
	
	
	private String[] getNumbersTab(String numbersString) throws Exception{
		if(numbersString.length()>4 && 
				numbersString.substring(0, 4).matches(newDelimiterChangingRegex)){
			//nouveau delimiter
			String newDelim = numbersString.substring(2, 3);
			numbersString = numbersString.substring(4);
			return  numbersString.split(newDelim);
		}else{
			return  numbersString.split(getDelimiterRegex(numbersString));
		}
	}
	
	
	
	//Somme d'une liste de string
	private int getStringSum(String[] numbers){
		int result=0;
		for(String uniqueNumber :numbers){
			result += StringToInt(uniqueNumber);
		}
		return result;
	}
	
	
	private String getDelimiterRegex(String numbersString) throws Exception{
		String delimiterRegex="";
		
		
		if(numbersString.startsWith(""))
		
		
		for(String delimiter:delimiters){
			
			if(numbersString.endsWith(delimiter))
				throw new Exception("String chaine ending with a delimiter");
			
			delimiterRegex = delimiterRegex.concat("|").concat(delimiter);
		}
		return delimiterRegex.substring(1);
	}
	
}
