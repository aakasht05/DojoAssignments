
public class StringManipulation {
	public String trimAndConcat(String word1, String word2) {
		String newString = word1.trim().concat(word2.trim());
		return newString;
	}
	
	public Integer getIndexOrNull(String word1, char x) {
		int result = word1.indexOf(x);
		return result;
	}
	
	public Integer getIndexOrNull(String word1, String subword1) {
		Integer x = subword1.indexOf(word1);
		System.out.println(x);
		return x;
	}
	
	public String concatSubstring(String word1, int x, int y, String subword1) {
		String subStringWord = word1.substring(x,y);
		String newString = subStringWord.concat(subword1);
		return newString;
	}
}
