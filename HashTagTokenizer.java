
public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String[] dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);

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

		hashtag = hashtag.toLowerCase();
		// Base case: do nothing (return) if hashtag is an empty string.
		if (hashtag.isEmpty())
			System.out.println(hashtag);

		int N = hashtag.length();

		for (int i = 1; i <= N; i++) {
			String prefix = hashtag.substring(0, i);
			if (existInDictionary(prefix, dictionary)) {
				breakHashTag(hashtag.substring(i), dictionary);
				System.out.println(prefix);
			}

		}

	}
}
