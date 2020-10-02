
/**
 * Lab 2: Debugging with an IDE and Prefix Tree)
 * 
 * @author Jenish
 */
class Trie {

	static final int ALPHABET_SIZE = 26;

	static class TrieNode {

		TrieNode[] child = new TrieNode[ALPHABET_SIZE];
		boolean isEndOfWord;

		TrieNode() {
			isEndOfWord = false;
			for (int i = 0; i < ALPHABET_SIZE; i++)
				child[i] = null;
		}

	}

	/**
	 * Root node of the Prefix Tree
	 */
	static TrieNode root;

	/**
	 * Inserts a word into a trie
	 * 
	 * @param word
	 */
	public static void insert(String word) {
		// length of word
		int length = word.length();
		// index representing node in array TrieNode[]
		int index = 0;

		// declare starting node as root
		TrieNode node = root;

		// Iterate over every character in word and checks if that character
		// is a child of predecessor node. If character does not exist in node
		// then that node is initialized by the character (index)
		for (int i = 0; i < length; i++) {
			// index is a the letter of word at index i
			index = word.charAt(i) - 'a';
			if (node.child[index] == null) {
				node.child[index] = new TrieNode();
			}
			// reference to node is traversed to new node
			// sort of like a node tracker
			node = node.child[index];
		}

		// node at which the last character of word is set to end of word
		node.isEndOfWord = true;
	}

	/**
	 * Searches for a string word in Trie
	 * 
	 * @param word
	 * @return true/false ; true if word exist or false otherwise
	 */
	public static boolean search(String word) {
		// length of string
		int length = word.length();
		// index representing node in array TrieNode[]
		int index = 0;

		// declares starting node as root
		TrieNode node = root;

		// Iterate over every character in word and checks if that character
		// is a child of predecessor node. If character is not a successor of
		// of any node, then no such word exists
		for (int i = 0; i < length; i++) {
			// index is a the letter of word at index i
			index = word.charAt(i) - 'a';
			if (node.child[index] == null) {
				return false;
			}
			// reference to node is traversed to new node
			// sort of like a node tracker
			node = node.child[index];
		}

		// checks if final node is not null and it is indeed a word by checking
		// the isEndofWord boolean is true
		if (node != null && node.isEndOfWord == true) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Returns if there is any word in the Prefix Tree that starts with the given
	 * prefix.
	 * 
	 * @param prefix
	 * @return true/false; true if any word starts with prefix
	 */
	public static boolean startWith(String prefix) {
		// length of prefix
		int length = prefix.length();
		// index representing node in array TrieNode[]
		int index = 0;
		boolean prefixExist = true;

		// declares starting node as root
		TrieNode node = root;

		// Iterate over every character in word and checks if that character
		// is a child of predecessor node. Similar to search, if a character
		// from string prefix is not a successor to prior node then prefix does not
		// exist
		for (int i = 0; i < length; i++) {
			index = prefix.charAt(i) - 'a';
			if (node.child[index] == null) {
				prefixExist = false;
				return false;
			}
			node = node.child[index];
		}

		return prefixExist;
	}

	/**
	 * Driver function
	 * 
	 * @param args
	 */
	public static void main(String args[]) {

		String words[] = { "ece", "lab", "java", "jar", "car", "cat", "care", "laboratory", "ebook" };

		String output[] = { "is NOT in the prefix tree", "is in the prefix tree" };

		root = new TrieNode();

		// Construct trie
		int i;
		for (i = 0; i < words.length; i++)
			insert(words[i]);

		// Search for different keys
		if (search("lab") == true)
			System.out.println("lab --- " + output[1]);
		else
			System.out.println("lab --- " + output[0]);

		if (search("java") == true)
			System.out.println("java --- " + output[1]);
		else
			System.out.println("java --- " + output[0]);

		if (startWith("eced") == true)
			System.out.println("eced --- " + output[1]);
		else
			System.out.println("eced --- " + output[0]);

		if (startWith("ca") == true)
			System.out.println("ca --- " + output[1]);
		else
			System.out.println("ca --- " + output[0]);

		if (search("book") == true)
			System.out.println("book --- " + output[1]);
		else
			System.out.println("book --- " + output[0]);

	}

}
