public class FizzBuzzTest {
	public static void main(String[] args) {
		int num = 50;
		FizzBuzz test1 = new FizzBuzz();

		for (int i = 1; i <= num; i++) {
			System.out.println(i + " " + test1.fizzBuzz(i));
		}
	}
}
