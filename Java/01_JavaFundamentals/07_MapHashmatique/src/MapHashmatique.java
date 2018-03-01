import java.util.HashMap;

public class MapHashmatique {

	
	public static void trackList() {
		HashMap<String, String> userMap = new HashMap<>();
		String track;
		
		userMap.put("Hello Goodbye", "Why you say goodbye, I say hello");
		userMap.put("She's Leaving Home", "She's leaving home after living alone for so many years");
		userMap.put("She said She said", "She said, I know what it's like to be dead");
		userMap.put("Machine Gun Funk", "I live for the funk, I die for the funk");
		
		track = userMap.get("She's Leaving Home");
		System.out.println(track);
		System.out.println(userMap);
	}
	
	public static void main(String[] args) {
		trackList();  
	}

}
