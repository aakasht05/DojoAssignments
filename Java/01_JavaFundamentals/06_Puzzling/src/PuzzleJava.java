import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class PuzzleJava {

	static int[] intArr = { 3, 5, 1, 2, 7, 9, 8, 13, 25, 32 };
	static ArrayList<String> stringArrayList = new ArrayList<String>();
	static ArrayList<Character> charArray = new ArrayList<Character>();
	static int[] randIntArray = new int[10];

	public static Integer printSum(int[] intArr) {
		int sum = 0;

		for (int i = 0; i < intArr.length; i++) {
			sum += intArr[i];
		}

		return sum;
	}

	public static int[] returnNewArray(int[] intArr) {
		int[] newArr = new int[255];
		int counter = 0;

		for (int i = 0; i < intArr.length; i++) {
			if (intArr[i] > 10) {
				newArr[counter] = intArr[i];
				System.out.println(newArr[counter]);
				counter++;
			}
		}
		return newArr;
	}

	public static ArrayList<String> japaneseArray(ArrayList<String> stringArrayList) {
		ArrayList<String> newStringArrayList = new ArrayList<String>();
		stringArrayList.add("Nancy");
		stringArrayList.add("Jinichi");
		stringArrayList.add("Fujibayashi");
		stringArrayList.add("Momochi");
		stringArrayList.add("Ishikawa");
		Collections.shuffle(stringArrayList);

		for (int i = 0; i < stringArrayList.size(); i++) {
			if (stringArrayList.get(i).length() > 5) {
				newStringArrayList.add(stringArrayList.get(i));
			}
		}

		return newStringArrayList;
	}

	public static ArrayList<Character> alphabetArray(ArrayList<Character> charArray) {
		char firstLetter;
		char lastLetter;

		for (char c = 'A'; c <= 'Z'; c++) {
			charArray.add(c);
		}
		Collections.shuffle(charArray);

		firstLetter = charArray.get(0);
		lastLetter = charArray.get(charArray.size() - 1);

		System.out.println(charArray);
		System.out.println("First Letter: " + firstLetter);
		System.out.println("Last Letter: " + lastLetter);

		if (firstLetter == ('A') || firstLetter == ('E') || firstLetter == ('I') || firstLetter == ('O')
				|| firstLetter == ('U')) {
			System.out.println("The first letter is a vowel.");
		}

		return charArray;
	}

	public static void printRandIntArray(int[] randIntArray) {
		for (int i = 0; i < randIntArray.length; i++) {
			System.out.println(randIntArray[i]);
		}
		System.out.println();
	}

	public static void createRandIntArray(int[] randIntArray) {
		Random rand = new Random();

		for (int i = 0; i < randIntArray.length; i++) {
			randIntArray[i] = 55 + rand.nextInt(((100 - 55) + 1));

		}
		printRandIntArray(randIntArray);
		Arrays.sort(randIntArray);
		printRandIntArray(randIntArray);

		int max = randIntArray[randIntArray.length - 1];
		int min = randIntArray[0];

		for (int i = 0; i < randIntArray.length; i++) {

			if (randIntArray[i] < min) {
				min = randIntArray[i];
			}

			if (randIntArray[i] > max) {
				max = randIntArray[i];
			}
		}

		System.out.println("The min is: " + min);
		System.out.println("The max is: " + max);

	}

	public static String fiveCharString() {
		String charString = "";
		Random rand = new Random();

		for (int i = 0; i < 5; i++) {
			charString += (char) (rand.nextInt(26) + 'a');
			;
		}

		return charString;
	}

	public static String[] charStringArray() {

		String[] csArray = new String[10];

		for (int i = 0; i < csArray.length; i++) {
			csArray[i] = fiveCharString();
			System.out.println(csArray[i]);
		}

		return csArray;

	}

	public static void main(String[] args) {

		// System.out.println(printSum(intArr));
		// returnNewArray(intArr);
		// System.out.println(japaneseArray(stringArrayList));
		// alphabetArray(charArray);
		// createRandIntArray(randIntArray);
		// System.out.println(fiveCharString());
		charStringArray();

	}

}
