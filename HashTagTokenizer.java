
public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String[] dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
		System.out.println(readDictionary(dictionary));
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);
		String read;
		// Your code here
		for (int i = 0; i < dictionary.length; i++) {
			read = in.readLine();
			dictionary[i] = read;
		}

		return dictionary;
	}

	public static boolean existInDictionary(String word, String[] dictionary) {
		// Your code here
		for (int i = 0; i < dictionary.length; i++) {
			if (dictionary[i].equals(word))
				return true;
		}
		return false;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {

		// Base case: do nothing (return) if hashtag is an empty string.
		if (hashtag.isEmpty())
			return "";
		else
			hashtag.toLowerCase();
		if (existInDictionary(hashtag, dictionary))
			return breakHashTag(hashtag.substring(1), dictionary);
		;

		int N = hashtag.length();

		for (int i = 1; i <= N; i++) {
			System.out.println(dictionary[i]);

		}
	}

}
