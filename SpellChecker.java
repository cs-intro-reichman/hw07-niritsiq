
public class SpellChecker {

	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}

	public static String tail(String str) {
		// Your code goes here
		if (str.length() == 1)
			return "";
		else
			return str.substring(1, str.length());

	}

	public static int levenshtein(String word1, String word2) {
		// Your code goes here
		word1 = word1.toLowerCase();
		word2 = word2.toLowerCase();
		int countDelete = 0;
		int countSub = 0;
		int countIns = 0;
		if (word1.isEmpty())
			return word2.length();

		if (word2.isEmpty())
			return word1.length();

		else if (word1.charAt(0) == word2.charAt(0))
			return levenshtein(tail(word1), tail(word2));

		else {
			countIns = levenshtein(tail(word1), word2);
			countDelete = levenshtein(word1, tail(word2));
			countSub = levenshtein(tail(word1), tail(word2));
			int min = Math.min(Math.min(countDelete, countIns), countSub);
			return (min + 1);
		}

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

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		// Your code goes here
		int smallestDis = threshold + 1;
		String similString = word;
		for (int i = 0; i < dictionary.length; i++) {
			if (smallestDis > levenshtein(word, dictionary[i])) {
				smallestDis = levenshtein(word, dictionary[i]);
				similString = dictionary[i];

			}

		}
		if (smallestDis <= threshold) {
			return similString;
		}
		return word;
	}

}
