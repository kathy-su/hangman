package Hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hangman {

	private static String[] listOfWords = new String[] { "happy", "brilliant", "weather", "hangman", "programming",
			"waterloo", "distribution", "mountain", "suggestion", "pollution", "organization", "opinion", "comparison", 			"quicksand", "arithmetic", "authority", "discussion", "tendency", "discussion", "observation", "toothpaste", 			"building", 	"rhythm", "experience", "pancake"
};

	public static void main(String[] args) {
// TODO Auto-generated method stub

		int randomWordNumber = (int) (Math.random() * listOfWords.length);
		String word = listOfWords[randomWordNumber];
		char[] wordc = new char[word.length()];
		for (int i = 0; i < word.length(); i++) {
			wordc[i] = '*';
		}

		int counter = 11;

		System.out.println("There are " + word.length() + " letters in this word. You have 11 tries.");
		System.out.println("  \\");
		System.out.println("   |");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String input;

		try {
			outer: while (counter > 0) {

				for (int i = 0; i < word.length(); i++) {
					System.out.print(wordc[i]);
				}
				System.out.println();
				System.out.println();
				System.out.println("choose a letter: ");
				input = reader.readLine();

				int test = 3;

				for (int i = 0; i < word.length(); i++) {
					if (input.charAt(0) == (word.charAt(i))) {
						wordc[i] = word.charAt(i);
						test = 1;
					}
				}
				if (test != 1) {
					counter--;
				}

				int counter2 = 0;
				for (int i = 0; i < word.length(); i++) {
					if (wordc[i] == '*') {
						counter2++;
					}
				}
				if (counter2 == 0 || counter == 0) {
					break outer;
				}
				man(counter);
				System.out.println("You have " + counter + " tries left.");

			}

			if (counter == 0) {
				System.out.println("  \\");
				System.out.println("   O ");
				System.out.println("  /|\\ ");
				System.out.println(" / | \\");
				System.out.println("  / \\");
				System.out.println(" /   \\");
				System.out.println("You lose!");
			} else {
				System.out.println("You win! The word was " + word + "!");
			}

		} catch (IOException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void man(int counter) {
		System.out.println("  \\");
		System.out.println("   |");
		if (counter == 10) {
			System.out.println("   O ");
		}
		if (counter == 9) {
			System.out.println("   O ");
			System.out.println("   | ");
		}
		if (counter == 8) {
			System.out.println("   O ");
			System.out.println("  /| ");
		}
		if (counter == 7) {
			System.out.println("   O ");
			System.out.println("  /|\\ ");
		}
		if (counter == 6) {
			System.out.println("   O ");
			System.out.println("  /|\\ ");
			System.out.println("   | ");
		}
		if (counter == 5) {
			System.out.println("   O ");
			System.out.println("  /|\\ ");
			System.out.println(" / | ");
		}
		if (counter == 4) {
			System.out.println("   O ");
			System.out.println("  /|\\ ");
			System.out.println(" / | \\ ");
		}
		if (counter == 3) {
			System.out.println("   O ");
			System.out.println("  /|\\ ");
			System.out.println(" / | \\");
			System.out.println("  / ");
		}
		if (counter == 2) {
			System.out.println("   O ");
			System.out.println("  /|\\ ");
			System.out.println(" / | \\");
			System.out.println("  / \\");
		}
		if (counter == 1) {
			System.out.println("   O ");
			System.out.println("  /|\\ ");
			System.out.println(" / | \\");
			System.out.println("  / \\");
			System.out.println(" /   ");
		}
	}

}