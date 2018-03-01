
public class FizzBuzz {
	public String fizzBuzz(int number) {
		String word;
		if ((number % 5 == 0) && (number % 3 == 0))
			word = "FizzBuzz";
		else if (number % 3 == 0)
			word = "Fizz";
		else
			word = "Buzz";
		return word;
	}
}
