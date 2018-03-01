
public class Basics {

	public static void print255() {
		for(int i = 0; i <= 255; i++) {
			System.out.println(i);
		}
	}
	
	public static void printOdd() {
		for(int i = 0; i <= 255; i++) {
			if (i % 2 != 0)
				System.out.println(i);
		}
	}
	
	public static void printSum() {
		int sum = 0;
		
		for(int i = 0; i <= 255; i++) {
			sum += i;
			System.out.println("Number: " + i + " Sum: " + sum);
		}
	}
	
	public static void iterateArray() {
		int[] X = {1,3,5,7,9,13};
		
		for(int i = 0; i < X.length; i++) {
			System.out.println(X[i]);
		}
	}
	
	public static void findMax() {
		int[] x = {1,3,5,7,-9,2};
		int max = x[0];
		for (int i = 0; i < x.length; i++) {
			if (x[i] > max)
				max = x[i];
		}
		System.out.println(max);
	}
	
	public static void getAverage() {
		int[] x = {2,10,3};
		int sum = 0;
		double avg;
		
		for (int i = 0; i< x.length; i++) {
			sum += x[i];
		}
		avg = sum/x.length;
		System.out.println(avg);
	}
	
	public static void arrayOdd() {
		int[] x = new int[128];
		int counter = 0;
		
		for (int i=0; i<= 255; i++) {
			if (i % 2 != 0){
				x[counter] = i;
				System.out.println(x[counter]);
				counter++;
			}		
		}
	}
	
	public static void greaterThanY() {
		int[] x = {1,3,5,3,7,6,3,9,3};
		int y = 3;
		int counter = 0;
		
		for (int i = 0; i < x.length; i++) {
			if (x[i] == y)
				counter++;
		}
		
		System.out.println(counter);
	}
	
	public static void squareValues() {
		int[] x = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		for (int i = 0; i < x.length; i++) {
			x[i] = (x[i] * x[i]);
			System.out.println(x[i]);
		}
	}
	
	public static void removeNegative() {
		int[] x = {1, 9, 4, 2, -3, -1, 7, 10, -20, 5};
		
		for (int i = 0; i < x.length; i++) {
			if (x[i] < 0)
				x[i] = 0;
			System.out.println(x[i]);
		}
	}
	
	public static void maxMinAvg() {
		int[] x = {1, 5, 10, -2};
		int max = x[0];
		int min = x[0];
		int sum = 0;
		int avg;
		
		for (int i = 0; i < x.length; i++) {
			if (x[i] > max)
				max = x[i];
			if (x[i] < min)
				min = x[i];
			sum += x[i];
		}
		
		avg = sum/x.length;	
		System.out.println("Max: " + max + " Min: " + min + " Avg: " + avg);
	}
	
	public static void shiftValues() {
		int[] x = {-2, 1, 3, 5, 7, 9};
		int temp = x[0];
		
		for (int i = 0; i < x.length-1; i++) {
			x[i] = x[i+1];
		}
		
		x[x.length-1] = temp;
		
		
		//print statement for testing
		for (int i = 0; i < x.length; i++) {
			System.out.println(x[i]);
		}
	}
	
	public static void main(String[] args) {
		//print255();
		//printOdd();
		//printSum();
		//iterateArray();
		//findMax();
		//getAverage();
		//arrayOdd();
		//greaterThanY();
		//squareValues();
		//removeNegative();
		//maxMinAvg();
		shiftValues();
	}

}
