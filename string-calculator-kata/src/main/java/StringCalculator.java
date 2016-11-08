
public class StringCalculator {

	public int add(String numbers){
		
		//chaine vide -- useCase 1.1
		if(numbers.isEmpty())
			return 0;
		//nombre unique -- useCase 1.2
		return Integer.parseInt(numbers);
	}
	
}
