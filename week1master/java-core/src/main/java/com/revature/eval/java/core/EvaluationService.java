package com.revature.eval.java.core;

import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return String.valueOf(reversed);
	}


	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		System.out.println(phrase);
		// TODO Write an implementation for this method declaration

		// go through string, split it, get the first letter, append it to another 
		// String phrase, String expected 
		String[] split = phrase.split("\\s+|\\-"); 
		char[] acronym = new char[split.length];
		for (int i = 0; i < split.length; i++) { // go through a phrase using a for loop
			// skip if there is a space in the phrase
			acronym[i] = split[i].toUpperCase().charAt(0);
			// capitalize the first letter of each words and return it -> string.toUpperCase();
			//acronym += s.toUpperCase().charAt(0);
		}
		System.out.println(new String(acronym));
		return new String(acronym);
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() { // default constructor
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}


		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration
			if (sideOne == sideTwo && sideTwo == sideThree) {
				return true;
			} else
				return false;
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			if (sideOne == sideTwo && !(sideTwo == sideThree || sideOne == sideThree) 
					|| sideTwo == sideThree && !(sideOne == sideTwo || sideOne == sideThree)
					|| sideOne == sideThree && !(sideOne == sideTwo || sideTwo == sideThree)       
					) {
				return true;
			} else
				return false;
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			if (sideOne == sideTwo || sideTwo == sideThree || sideOne == sideThree) {
				return false;
			} else
				return true;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- 
	 * Letter Value A, E, I, O, U, L, N, R, S, T = 1; 
	 * D, G = 2; 
	 * B,C, M, P = 3; 
	 * F, H, V, W, Y = 4; 
	 * K = 5; 
	 * J, X = 8; 
	 * Q, Z = 10; 
	 * Example. "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration

		int sum = 0; // for adding the numbers together

		for (int i = 0; i < string.length(); i++) {
			// A, E, I, O, U, L, N, R, S, T = 1; 
			if (string.charAt(i) == 'A' || string.charAt(i) == 'a'|| string.charAt(i) == 'E' || string.charAt(i) == 'e'
					|| string.charAt(i) == 'I' || string.charAt(i) == 'i' || string.charAt(i) == 'O' || string.charAt(i) == 'o'
					|| string.charAt(i) == 'U' || string.charAt(i) == 'u' || string.charAt(i) == 'L' || string.charAt(i) == 'l'
					|| string.charAt(i) == 'N' || string.charAt(i) == 'n' || string.charAt(i) == 'R' || string.charAt(i) == 'r'
					|| string.charAt(i) == 'S' || string.charAt(i) == 's' || string.charAt(i) == 'T' || string.charAt(i) == 't') 
			{
				sum += 1;
			} else // D, G = 2;
				if (string.charAt(i) == 'D' || string.charAt(i) == 'd' || string.charAt(i) == 'G' || string.charAt(i) == 'g') {
					sum += 2;
				} else // B,C, M, P = 3; 
					if (string.charAt(i) == 'B' || string.charAt(i) == 'b' || string.charAt(i) == 'C' || string.charAt(i) == 'c'
					|| string.charAt(i) == 'M' || string.charAt(i) == 'm' || string.charAt(i) == 'P' || string.charAt(i) == 'p'
							) {
						sum += 3;
					} else // F, H, V, W, Y = 4; 
						if (string.charAt(i) == 'F' || string.charAt(i) == 'f'|| string.charAt(i) == 'H' || string.charAt(i) == 'h'
						|| string.charAt(i) == 'V' || string.charAt(i) == 'v' || string.charAt(i) == 'W' || string.charAt(i) == 'w'
						|| string.charAt(i) == 'Y' || string.charAt(i) == 'y'
								) {
							sum += 4;
						} else // K = 5;
							if (string.charAt(i) == 'K' || string.charAt(i) == 'k') {
								sum += 5;
							} else // J, X = 8;
								if (string.charAt(i) == 'J'|| string.charAt(i) == 'j' || 
								string.charAt(i) == 'X' || string.charAt(i) == 'x' ) {
									sum += 8;	
								} else // Q,Z = 10;
									sum += 10;	
		}
		return sum;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 
	 * 613-995-0253 
	 * 1 613 995 0253 
	 * 613.995.0253 
	 * should all produce the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration
		String value = string.replaceAll("[^0-9]", ""); // if characters doesn't matches the numbers
		// cases where the phone number has letters
		if (value.matches(".*[a-z].*")) {
			throw new IllegalArgumentException();
		}
		if (value.length() != 10) { 
			throw new IllegalArgumentException();
		}
		return value;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" 
	 * olly: 2 
	 * in: 1 
	 * come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount (String string) {
		//		System.out.println("word counter : " + string);
		// split the phrase up, put it into an array, and count each of them
		String[] arr = string.split("\\s+|\n|,\n|,");
		for (String s : arr)
			System.out.println(s);
		Map<String, Integer> expectedWordCount = new HashMap<String, Integer>();
		for (String s : arr) {

			if (!expectedWordCount.containsKey(s)) {  // first time seeing the string
				expectedWordCount.put(s, 1);
			}
			else {
				int count = expectedWordCount.get(s); // add to count other instances of the string
				expectedWordCount.put(s, count + 1);
			}
		}
		//		System.out.println("Expected Word Count : " + expectedWordCount);
		return expectedWordCount;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		// create a class variable list named sortedList 
		private List<T> sortedList;
		// <> means generic

		public int indexOf(T t) { // passing letter T into the list and finding what index t is at
			// TODO Write an implementation for this method declaration
			int i = sortedList.indexOf(t);
			return i;
		}

		public BinarySearch(List<T> sortedList) { // 
			super(); // Instantiating the class with one parameter, i.e. sortedList
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() { // basically getting sortList
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) { // basically setting sortList
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. 
	 * 
	 * Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		//		System.out.println("Pig Latin : " + string);
		StringBuilder sb = new StringBuilder();
		String[] sentence = string.split("\\s+");
		StringBuilder firstSound = new StringBuilder();

		boolean vowelFlag;
		int count;

		for (int i = 0; i < sentence.length; ++i) {
			vowelFlag = false;
			count = 0;
			firstSound.delete(0,  firstSound.length());

			//adds all the consonants leading a word, except for "qu"
			//Results in storing the consonants leading a word + qu into sb firstSound

			while (!vowelFlag) {
				if (sentence[i].charAt(count) != 'a' && sentence[i].charAt(count) != 'e' 
						&& sentence[i].charAt(count) != 'i' && sentence[i].charAt(count) != 'o' 
						&& sentence[i].charAt(count) != 'u') {
					firstSound.append(sentence[i].charAt(count++));
				} else { //else just qu
					if (firstSound.length() == 1 && sentence[i].length() > 1 && 
							firstSound.charAt(0) == 'q' && sentence[i].charAt(1) == 'u') {
						firstSound.append(sentence[i].charAt(count));
					}
					vowelFlag = !vowelFlag;
				}
			}
			//vowel case
			if (firstSound.equals("a") || firstSound.equals("e") || firstSound.equals("i") || firstSound.equals("o") 
					|| firstSound.equals("u") || sentence[i].length() == 1) {
				sb.append(sentence[i] + "ay ");
			}
			//single/multicluster consonants case
			else { 
				sb.append(sentence[i].substring(firstSound.length()) + firstSound.toString() + "ay ");
			} 
		}
		//		System.out.println("result : " + sb.toString().trim());
		return sb.toString().trim();
	}


	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 
	 * 10 is not an Armstrong number, because 10 != 1^2 + 0^2 = 2 
	 * 153 is an Armstrong number, because: 153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153 
	 * 154 is not an Armstrong number, because: 154!= 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 
	 * Write some code to determine whether a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration

		int numdigit = Integer.toString(input).length(), remainder, sum = 0, temp; 
		/*
		 * numdigit = get the number of digits in armstrong number
		 * total = 
		 * temp for storing the input
		 * 
		 * */ 

		temp = input;

		// count the digits
		while (temp != 0) {
			remainder = temp%10;
			// take the number and add up each digit to the respective powers
			sum += Math.pow(remainder, numdigit); 
			temp = temp/10;
			System.out.println(temp);
		}

		if (input == sum) {
			System.out.println(input + " is an Armstrong number.");
			return true;

		} else {
			System.out.println(input + " isn't an Armstrong number.");         
		}
		return false;
	}


	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration


		List<Long> primefactors = new ArrayList<Long>();
		long copyOfInput = l;

		for (long i = 2; i <= copyOfInput; i++) {
			if (copyOfInput % i == 0) {
				primefactors.add(i); // prime factor
				copyOfInput /= i;
				i--;
			}
		}

		return primefactors;

		//return null;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25 usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including spaces and punctuation.
	 * 
	 * Examples: 
	 * ROT5 omg gives trl 
	 * ROT0 c gives c 
	 * ROT26 Cool gives Cool 
	 * ROT13 The quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire gur ynml qbt. 
	 * ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super(); // access key in the RotationalCipher parent class
			this.key = key;
		}

		public String rotate(String string) {
			// TODO Write an implementation for this method declaration
			String lowercase = "abcdefghijklmnopqrstuvwxyz";
			String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			String reverseLower = lowercase.substring(key) + lowercase.substring(0, key);
			String reverseUpper = uppercase.substring(key) + uppercase.substring(0, key);
			StringBuilder result = new StringBuilder();

			int charIndex;
			for (int i = 0; i < string.length(); ++i) {
				charIndex = lowercase.indexOf(string.charAt(i));
				//if lowercase
				if (charIndex != -1) {
					result.append(reverseLower.charAt(charIndex));
					//if uppercase
				} else if ((charIndex = uppercase.indexOf(string.charAt(i))) != -1){
					result.append(reverseUpper.charAt(charIndex));
					//if numbers
				} else {
					result.append(string.charAt(i));
				}
			}
			System.out.println(result.toString());
			return result.toString();
		}
	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
//		System.out.println("Find the " + i + "th prime.");
		if (i == 0)
			throw new IllegalArgumentException("There is no 0th prime.");
		
		int nth, count = 0;
		
		for (nth = 2, count = 0; count < i; ++nth) {
			if (checkPrime(nth)) {
				count++;
			}
		}
//		System.out.println(nth-1);
		return nth-1;
	}
	// Brute force checking of all possible divisions for prime
	private boolean checkPrime(int nth) {
		for (int i = 2; i < nth; ++i)
			if (nth % i == 0)
				return false;
		return true;
	}
/*	public int calculateNthPrime(int i) {
		System.out.println("Find the " + i + "th prime.");
		if (i == 0)
			throw new IllegalArgumentException("There is no 0th prime.");
		int count = 0, n = 1, nth = i, j; 
		
		 * count for 
		 * n for starting
		 * nth for nth number, have it assign to i
		 * j for 
		 * 
		while (count < nth){
			n += 1;
			
			 * i = 1, count = 0, n = 2, nth = 1, j = 2, returns i
			 * 
			 * 
			 
			for (j = 2; j <= n; j++){
				if (n % j == 0) {
					count++;
					break;
				} else {
					if (j == n) {
						count += 1; 
					}
				}
			}
		}
		System.out.println(i);
		return i;
	}*/

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba 
	 * It is a very weak cipher because it only has one possible key, and it is a simple monoalphabetic substitution cipher. 
	 * However, this may not have been an issue in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples 
	 * Encoding test gives gvhg 
	 * Decoding gvhg gives test 
	 * Decoding gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		static final String encoded = "abcdefghijklmnopqrstuvwxyz";
		static final String decoded = "zyxwvutsrqponmlkjihgfedcba"; 

		public static String encode(String string) {
//			System.out.println("Base string : " + string);
			string = string.replaceAll("\\s+|\\.|\\,","");
			StringBuilder sb = new StringBuilder(string.toLowerCase());
			int numSpaces = string.length()/5;
			//if 5 words, /5 =1, space, unless total if 5 letters. 
			//if anything else, ie, 7/5 = 1.4, rounds to 1, 
			//11/5 = 2.2, rounds to 2. 
			for (int i = 0; i <= numSpaces; ++i) {
				sb.insert(i*6, ' ');
			}
			//Passes in same string with spaces.
			return cipherLetterSwap(true, sb); 
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
//			System.out.println("Base String : " + string);
			StringBuilder sb = new StringBuilder(string.replaceAll("\\s+", ""));
			return cipherLetterSwap(false, sb);
		}

		//Swaps all characters in the input to their reverse-alphabet equivalent, barring space.
		public static String cipherLetterSwap(boolean forward, StringBuilder sb) {
//			System.out.println("Passed string : " + sb.toString());

			String alphabet = forward? encoded : decoded;
			String reverseAlphabet = forward? decoded : encoded;

			for (int i = 0; i < sb.length(); ++i) {
				if (sb.charAt(i) != ' ' && !Character.isDigit(sb.charAt(i))) {
					System.out.print(sb.charAt(i));
					sb.replace(i, i+1, String.valueOf(reverseAlphabet.charAt(alphabet.indexOf(sb.charAt(i)))));
				}
			}
//			System.out.println("\nResult : " + sb.toString() +"\n");
			return sb.toString().trim();
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
//		System.out.println("ISBN");
		string = string.replaceAll("\\-", "");
		boolean hasX = false;
//		System.out.println("last char : " + string.charAt(string.length()-1));
		if (string.charAt(string.length()-1) == 'X'){
			hasX = true;
			string = string.replaceAll("X", "");
		}
//		System.out.println(string);
		try {
			Long.valueOf(string);
//			System.out.println(Long.valueOf(string));
			int sum = 0;
			for (int i = 10; i > 10-string.length(); --i) {
				sum += Character.getNumericValue(string.charAt(10-i))*i;
//				System.out.println(Character.getNumericValue(string.charAt(10-i)) + " x " + i);
			}
//			System.out.println("Sum = " + sum);
			if (hasX) {
//				System.out.println("hasx? : " + hasX);
				sum += 10;
			}
			if (sum%11 == 0) {
//				System.out.println(true);
				return true;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration

		// if string is empty return false
		// length of the panagram should be 26 if all the letters are used 

		// replaceAll(" ", ""); to get rid of spaces in the phrases that match




		return false;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		Temporal temp = given;
		//temp = temp.plus(amountToAdd, ChronoUnit.SECONDS);
		return null;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration
		return 0;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration
		return false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		System.out.println("Word prob");
		String[] sentence = string.split("\\s+|\\?");
		int[] contextVariables = new int[2];
		HashSet<String> mathKeywords = new HashSet<>();
		mathKeywords.add("plus");
		mathKeywords.add("minus");
		mathKeywords.add("multiplied");
		mathKeywords.add("divided");

		int varIndex = 0, temp;
		String operation = "";
		for (int i = 0; i < sentence.length; ++i) {
			try {
				temp = Integer.parseInt(sentence[i]);
				contextVariables[varIndex++] = temp;
				System.out.println(temp);
			} catch (NumberFormatException e) {
				if (mathKeywords.contains(sentence[i])) {
					operation = sentence[i];
					System.out.println(operation);
				}
			}
		}
		System.out.println("next");
		switch (operation) {
		case "plus" : return (contextVariables[0] + contextVariables[1]);
		case "minus" : return (contextVariables[0] - contextVariables[1]);
		case "multiplied" : return (contextVariables[0] * contextVariables[1]);
		case "divided" : return (contextVariables[0] / contextVariables[1]);
		}
		return 0;
	}
}
