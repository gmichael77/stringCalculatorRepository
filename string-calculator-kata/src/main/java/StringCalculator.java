
public class StringCalculator {

	private final String[] delimiters={",","\n"};
	private final String newDelimiterChangingRegex = "^//.\n";
	private final int numberLimitMax =1000;
	private final int numberLimitMin =0;
	
	
	//exception  
	public int add(String numbersString) throws Exception{
		
		//chaine vide -- useCase 1.1
		if(numbersString.isEmpty())
			return 0;
		
		return	getStringSum(getNumbersTab(numbersString));
	
		
	}
	
	
	
	private int StringToInt(String numberString) throws Exception{		
		int i = Integer.parseInt(numberString);
		if(i>numberLimitMax){
			i=0;
		}
		
		return i;
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
	private int getStringSum(String[] numbers) throws Exception{
		int result=0;
		boolean InputisOk = true;
		String errorMessageInput ="";
		
		for(String uniqueNumber :numbers){
			int num = StringToInt(uniqueNumber);
			if(num<numberLimitMin){
				InputisOk = InputisOk && false;
				errorMessageInput = errorMessageInput.concat(uniqueNumber).concat(" ");
			}
			result += StringToInt(uniqueNumber);
		}
		
		
		if(!InputisOk)
			throw new Exception("negatives not allowed : "+errorMessageInput);
		
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
