import java.util.ArrayList;

public class GenericLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Object> myList = new ArrayList<Object>();

		myList.add("13");
		myList.add("hello world");
		myList.add(48);
		myList.add("Goodbye World");

//		for (int i = 0; i < myList.size(); i++) {
//			try {
//				Integer castedValue = (Integer) myList.get(i);
//				System.out.println(castedValue);
//			} catch (ClassCastException e) {
//				System.out.println("ERROR ON INDEX: " + myList.get(i));
//			}
//		}

		for (int i = 0; i < myList.size(); i++) {
			Object castedValue = (Object) myList.get(i);
			System.out.println(castedValue);
		}

	}
}
