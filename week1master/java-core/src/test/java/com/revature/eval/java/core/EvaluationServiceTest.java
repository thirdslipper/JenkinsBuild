package com.revature.eval.java.core;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class EvaluationServiceTest {

	private static final EvaluationService evaluationService = new EvaluationService();

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	/*******************************************************************
	 * Question 1
	 ******************************************************************/
	@Test(timeout=10000)
	public void testAnEmptyString() {
		assertEquals("", evaluationService.reverse(""));
	}

	@Test(timeout=10000)
	public void testAWord() {
		assertEquals("tobor", evaluationService.reverse("robot"));
	}

	@Test(timeout=10000)
	public void testACapitalizedWord() {
		assertEquals("nemaR", evaluationService.reverse("Ramen"));
	}

	@Test(timeout=10000)
	public void testASentenceWithPunctuation() {
		assertEquals("!yrgnuh m'I", evaluationService.reverse("I'm hungry!"));
	}

	@Test(timeout=10000)
	public void testAPalindrome() {
		assertEquals("racecar", evaluationService.reverse("racecar"));
	}

	/*******************************************************************
	 * Question 2
	 ******************************************************************/
	@Test(timeout=10000)
	public void basic() {
		final String phrase = "Portable Network Graphics";
		final String expected = "PNG";
		assertEquals(expected, evaluationService.acronym(phrase));
	}

	@Test(timeout=10000)
	public void punctuation() {
		final String phrase = "First In, First Out";
		final String expected = "FIFO";
		assertEquals(expected, evaluationService.acronym(phrase));
	}

	@Test(timeout=10000)
	public void NonAcronymAllCapsWord() {
		final String phrase = "GNU Image Manipulation Program";
		final String expected = "GIMP";
		assertEquals(expected, evaluationService.acronym(phrase));
	}

	@Test(timeout=10000)
	public void punctuationWithoutWhitespace() {
		final String phrase = "Complementary metal-oxide semiconductor";
		final String expected = "CMOS";
		assertEquals(expected, evaluationService.acronym(phrase));
	}

	/*******************************************************************
	 * Question 3
	 ******************************************************************/

	@Test(timeout=10000)
	public void trianglesWithNoEqualSidesAreNotEquilateral() {
		EvaluationService.Triangle triangle = new EvaluationService.Triangle(5, 4, 6);
		assertFalse(triangle.isEquilateral());
	}

	@Test(timeout=10000)
	public void verySmallTrianglesCanBeEquilateral() {
		EvaluationService.Triangle triangle = new EvaluationService.Triangle(0.5, 0.5, 0.5);
		assertTrue(triangle.isEquilateral());
	}

	@Test(timeout=10000)
	public void isoscelesTrianglesMustHaveAtLeastTwoEqualSides() {
		EvaluationService.Triangle triangle = new EvaluationService.Triangle(2, 3, 4);
		assertFalse(triangle.isIsosceles());
	}

	@Test(timeout=10000)
	public void verySmallTrianglesCanBeIsosceles() {
		EvaluationService.Triangle triangle = new EvaluationService.Triangle(0.5, 0.4, 0.5);
		assertTrue(triangle.isIsosceles());
	}

	@Test(timeout=10000)
	public void trianglesWithAllSidesEqualAreNotScalene() {
		EvaluationService.Triangle triangle = new EvaluationService.Triangle(4, 4, 4);
		assertFalse(triangle.isScalene());
	}

	@Test(timeout=10000)
	public void verySmallTrianglesCanBeScalene() {
		EvaluationService.Triangle triangle = new EvaluationService.Triangle(0.5, 0.4, 0.6);
		assertTrue(triangle.isScalene());
	}

	/*******************************************************************
	 * Question 4
	 ******************************************************************/
	@Test(timeout=10000)
	public void testAValuableLetter() {
		assertEquals(4, evaluationService.getScrabbleScore("f"));
	}

	@Test(timeout=10000)
	public void testAShortValuableWord() {
		assertEquals(12, evaluationService.getScrabbleScore("zoo"));
	}

	@Test(timeout=10000)
	public void testAMediumWord() {
		assertEquals(6, evaluationService.getScrabbleScore("street"));
	}

	@Test(timeout=10000)
	public void testAMediumValuableWord() {
		assertEquals(22, evaluationService.getScrabbleScore("quirky"));
	}

	@Test(timeout=10000)
	public void testALongMixCaseWord() {
		assertEquals(41, evaluationService.getScrabbleScore("OxyphenButazone"));
	}

	/*******************************************************************
	 * Question 5
	 ******************************************************************/
	@Test(timeout=10000)
	public void cleansTheNumber() {
		final String expectedNumber = "2234567890";
		final String actualNumber = evaluationService.cleanPhoneNumber("(223) 456-7890");
		assertEquals(expectedNumber, actualNumber);
	}

	@Test(timeout=10000)
	public void cleansNumbersWithDots() {
		final String expectedNumber = "2234567890";
		final String actualNumber = evaluationService.cleanPhoneNumber("223.456.7890");
		assertEquals(expectedNumber, actualNumber);
	}

	@Test(timeout=10000)
	public void cleansNumbersWithMultipleSpaces() {
		final String expectedNumber = "2234567890";
		final String actualNumber = evaluationService.cleanPhoneNumber("223 456   7890   ");
		assertEquals(expectedNumber, actualNumber);
	}

	@Test(timeout=10000)
	public void invalidWhenMoreThan11Digits() {
		expectedException.expect(IllegalArgumentException.class);
		evaluationService.cleanPhoneNumber("321234567890");
	}

	@Test(timeout=10000)
	public void invalidWithNonNumeric() {
		expectedException.expect(IllegalArgumentException.class);
		evaluationService.cleanPhoneNumber("123-abc-7890");
		expectedException.expect(IllegalArgumentException.class);
		evaluationService.cleanPhoneNumber("123-@:!-7890");
	}

	/*******************************************************************
	 * Question 6
	 ******************************************************************/
	@Test(timeout=10000)
	public void countOneWord() {
		Map<String, Integer> expectedWordCount = new HashMap<>();
		expectedWordCount.put("word", 1);

		Map<String, Integer> actualWordCount = evaluationService.wordCount("word");
		assertEquals(expectedWordCount, actualWordCount);
	}

	@Test(timeout=10000)
	public void countOneOfEachWord() {
		Map<String, Integer> expectedWordCount = new HashMap<>();
		expectedWordCount.put("one", 1);
		expectedWordCount.put("of", 1);
		expectedWordCount.put("each", 1);

		Map<String, Integer> actualWordCount = evaluationService.wordCount("one of each");
		assertEquals(expectedWordCount, actualWordCount);
	}

	@Test(timeout=10000)
	public void multipleOccurrencesOfAWord() {
		Map<String, Integer> expectedWordCount = new HashMap<>();
		expectedWordCount.put("one", 1);
		expectedWordCount.put("fish", 4);
		expectedWordCount.put("two", 1);
		expectedWordCount.put("red", 1);
		expectedWordCount.put("blue", 1);

		Map<String, Integer> actualWordCount = evaluationService.wordCount("one fish two fish red fish blue fish");
		assertEquals(expectedWordCount, actualWordCount);
	}

	@Test(timeout=10000)
	public void handlesCrampedLists() {
		Map<String, Integer> expectedWordCount = new HashMap<>();
		expectedWordCount.put("one", 1);
		expectedWordCount.put("two", 1);
		expectedWordCount.put("three", 1);

		Map<String, Integer> actualWordCount = evaluationService.wordCount("one,two,three");
		assertEquals(expectedWordCount, actualWordCount);
	}

	@Test(timeout=10000)
	public void handlesExpandedLists() {
		Map<String, Integer> expectedWordCount = new HashMap<>();
		expectedWordCount.put("one", 1);
		expectedWordCount.put("two", 1);
		expectedWordCount.put("three", 1);

		Map<String, Integer> actualWordCount = evaluationService.wordCount("one,\ntwo,\nthree");
		assertEquals(expectedWordCount, actualWordCount);
	}

	/*******************************************************************
	 * Question 7
	 ******************************************************************/
	@Test(timeout=10000)
	public void findsAValueInTheMiddleOfAnArray() {
		List<String> sortedList = Collections.unmodifiableList(Arrays.asList("1", "3", "4", "6", "8", "9", "11"));

		EvaluationService.BinarySearch<String> search = new EvaluationService.BinarySearch<>(sortedList);

		assertEquals(3, search.indexOf("6"));
	}

	@Test(timeout=10000)
	public void findsAValueAtTheBeginningOfAnArray() {
		List<Integer> sortedList = Collections.unmodifiableList(Arrays.asList(1, 3, 4, 6, 8, 9, 11));

		EvaluationService.BinarySearch<Integer> search = new EvaluationService.BinarySearch<>(sortedList);

		assertEquals(0, search.indexOf(1));
	}

	@Test(timeout=10000)
	public void findsAValueAtTheEndOfAnArray() {
		List<Integer> sortedList = Collections.unmodifiableList(Arrays.asList(1, 3, 4, 6, 8, 9, 11));

		EvaluationService.BinarySearch<Integer> search = new EvaluationService.BinarySearch<>(sortedList);

		assertEquals(6, search.indexOf(11));
	}

	@Test(timeout=10000)
	public void findsAValueInAnArrayOfOddLength() {
		List<Integer> sortedListOfOddLength = Collections
				.unmodifiableList(Arrays.asList(1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 634));

		EvaluationService.BinarySearch<Integer> search = new EvaluationService.BinarySearch<>(sortedListOfOddLength);

		assertEquals(9, search.indexOf(144));
	}

	@Test(timeout=10000)
	public void findsAValueInAnArrayOfEvenLength() {
		List<Integer> sortedListOfEvenLength = Collections
				.unmodifiableList(Arrays.asList(1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377));

		EvaluationService.BinarySearch<Integer> search = new EvaluationService.BinarySearch<>(sortedListOfEvenLength);

		assertEquals(5, search.indexOf(21));
	}

	/*******************************************************************
	 * Question 8
	 ******************************************************************/
	@Test(timeout=10000)
	public void testWordBeginningWithA() {
		assertEquals("appleay", evaluationService.toPigLatin("apple"));
	}

	@Test(timeout=10000)
	public void testThTreatedLikeAConsonantAtTheBeginningOfAWord() {
		assertEquals("erapythay", evaluationService.toPigLatin("therapy"));
	}

	@Test(timeout=10000)
	public void testSchTreatedLikeAConsonantAtTheBeginningOfAWord() {
		assertEquals("oolschay", evaluationService.toPigLatin("school"));
	}

	@Test(timeout=10000)
	public void testYTreatedLikeAConsonantAtTheBeginningOfAWord() {
		assertEquals("ellowyay", evaluationService.toPigLatin("yellow"));
	}

	@Test(timeout=10000)
	public void testAWholePhrase() {
		assertEquals("ickquay astfay unray", evaluationService.toPigLatin("quick fast run"));
	}

	/*******************************************************************
	 * Question 9
	 ******************************************************************/
	@Test(timeout=10000)
	public void singleDigitsAreArmstrongNumbers() {
		int input = 5;

		assertTrue(evaluationService.isArmstrongNumber(input));
	}

	@Test(timeout=10000)
	public void noTwoDigitArmstrongNumbers() {
		int input = 10;

		assertFalse(evaluationService.isArmstrongNumber(input));
	}

	@Test(timeout=10000)
	public void threeDigitNumberIsArmstrongNumber() {
		int input = 153;

		assertTrue(evaluationService.isArmstrongNumber(input));
	}

	@Test(timeout=10000)
	public void threeDigitNumberIsNotArmstrongNumber() {
		int input = 100;

		assertFalse(evaluationService.isArmstrongNumber(input));
	}

	@Test(timeout=10000)
	public void fourDigitNumberIsArmstrongNumber() {
		int input = 9474;

		assertTrue(evaluationService.isArmstrongNumber(input));
	}

	/*******************************************************************
	 * Question 10
	 ******************************************************************/

	@Test(timeout=10000)
	public void testPrimeNumber() {
		assertEquals(Collections.singletonList(2L), evaluationService.calculatePrimeFactorsOf(2L));
	}

	@Test(timeout=10000)
	public void testSquareOfAPrime() {
		assertEquals(Arrays.asList(3L, 3L), evaluationService.calculatePrimeFactorsOf(9L));
	}

	@Test(timeout=10000)
	public void testCubeOfAPrime() {
		assertEquals(Arrays.asList(2L, 2L, 2L), evaluationService.calculatePrimeFactorsOf(8L));
	}

	@Test(timeout=10000)
	public void testProductOfPrimesAndNonPrimes() {
		assertEquals(Arrays.asList(2L, 2L, 3L), evaluationService.calculatePrimeFactorsOf(12L));
	}

	@Test(timeout=10000)
	public void testProductOfPrimes() {
		assertEquals(Arrays.asList(5L, 17L, 23L, 461L), evaluationService.calculatePrimeFactorsOf(901255L));
	}

	/*******************************************************************
	 * Question 11
	 ******************************************************************/

	@Test(timeout=10000)
	public void rotateSingleCharacterWithWrapAround() {
		EvaluationService.RotationalCipher rotationalCipher = new EvaluationService.RotationalCipher(13);
		assertEquals("a", rotationalCipher.rotate("n"));
	}

	@Test(timeout=10000)
	public void rotateCapitalLetters() {
		EvaluationService.RotationalCipher rotationalCipher = new EvaluationService.RotationalCipher(5);
		assertEquals("TRL", rotationalCipher.rotate("OMG"));
	}

	@Test(timeout=10000)
	public void rotateNumbers() {
		EvaluationService.RotationalCipher rotationalCipher = new EvaluationService.RotationalCipher(4);
		assertEquals("Xiwxmrk 1 2 3 xiwxmrk", rotationalCipher.rotate("Testing 1 2 3 testing"));
	}

	@Test(timeout=10000)
	public void rotatePunctuation() {
		EvaluationService.RotationalCipher rotationalCipher = new EvaluationService.RotationalCipher(21);
		assertEquals("Gzo'n zvo, Bmviyhv!", rotationalCipher.rotate("Let's eat, Grandma!"));
	}

	@Test(timeout=10000)
	public void rotateAllLetters() {
		EvaluationService.RotationalCipher rotationalCipher = new EvaluationService.RotationalCipher(13);
		assertEquals("The quick brown fox jumps over the lazy dog.",
				rotationalCipher.rotate("Gur dhvpx oebja sbk whzcf bire gur ynml qbt."));
	}

	/*******************************************************************
	 * Question 12
	 ******************************************************************/
	@Test(timeout=10000)
	public void testFirstPrime() {
		assertThat(evaluationService.calculateNthPrime(1), is(2));
	}

	@Test(timeout=10000)
	public void testSecondPrime() {
		assertThat(evaluationService.calculateNthPrime(2), is(3));
	}

	@Test(timeout=10000)
	public void testSixthPrime() {
		assertThat(evaluationService.calculateNthPrime(6), is(13));
	}

	@Test(timeout=10000)
	public void testBigPrime() {
		assertThat(evaluationService.calculateNthPrime(10001), is(104743));
	}

	@Test(timeout=10000)
	public void testUndefinedPrime() {
		expectedException.expect(IllegalArgumentException.class);
		evaluationService.calculateNthPrime(0);
	}

	/*******************************************************************
	 * Question 13
	 ******************************************************************/

	@Test(timeout=10000)
	public void testEncodeYes() {
		assertEquals("bvh", EvaluationService.AtbashCipher.encode("yes"));
	}

	@Test(timeout=10000)
	public void testEncodeOmgInCapital() {
		assertEquals("lnt", EvaluationService.AtbashCipher.encode("OMG"));
	}

	@Test(timeout=10000)
	public void testEncodeMindBlowingly() {
		assertEquals("nrmwy oldrm tob", EvaluationService.AtbashCipher.encode("mindblowingly"));
	}

	@Test(timeout=10000)
	public void testEncodeNumbers() {
		assertEquals("gvhgr mt123 gvhgr mt", EvaluationService.AtbashCipher.encode("Testing,1 2 3, testing."));
	}

	@Test(timeout=10000)
	public void testEncodeDeepThought() {
		assertEquals("gifgs rhurx grlm", EvaluationService.AtbashCipher.encode("Truth is fiction."));
	}

	@Test(timeout=10000)
	public void testEncodeAllTheLetters() {
		assertEquals("gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt",
				EvaluationService.AtbashCipher.encode("The quick brown fox jumps over the lazy dog."));
	}

	/*******************************************************************
	 * Question 14
	 ******************************************************************/
	@Test(timeout=10000)
	public void testDecodeExercism() {
		assertEquals("exercism", EvaluationService.AtbashCipher.decode("vcvix rhn"));
	}

	@Test(timeout=10000)
	public void testDecodeASentence() {
		assertEquals("anobstacleisoftenasteppingstone",
				EvaluationService.AtbashCipher.decode("zmlyh gzxov rhlug vmzhg vkkrm thglm v"));
	}

	@Test(timeout=10000)
	public void testDecodeNumbers() {
		assertEquals("testing123testing", EvaluationService.AtbashCipher.decode("gvhgr mt123 gvhgr mt"));
	}

	@Test(timeout=10000)
	public void testDecodeAllTheLetters() {
		assertEquals("thequickbrownfoxjumpsoverthelazydog",
				EvaluationService.AtbashCipher.decode("gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt"));
	}

	/*******************************************************************
	 * Question 15
	 ******************************************************************/
	@Test(timeout=10000)
	public void validIsbnNumber() {
		assertTrue(evaluationService.isValidIsbn("3-598-21508-8"));
	}

	@Test(timeout=10000)
	public void invalidIsbnCheckDigit() {
		assertFalse(evaluationService.isValidIsbn("3-598-21508-9"));
	}

	@Test(timeout=10000)
	public void validIsbnNumberWithCheckDigitOfTen() {
		assertTrue(evaluationService.isValidIsbn("3-598-21507-X"));
	}

	@Test(timeout=10000)
	public void checkDigitIsACharacterOtherThanX() {
		assertFalse(evaluationService.isValidIsbn("3-598-21507-A"));
	}

	@Test(timeout=10000)
	public void invalidCharacterInIsbn() {
		assertFalse(evaluationService.isValidIsbn("3-598-2K507-0"));
	}

	/*******************************************************************
	 * Question 16
	 ******************************************************************/
	@Test(timeout=10000)
	public void emptySentenceIsNotPangram() {
		assertFalse(evaluationService.isPangram(""));
	}

	@Test(timeout=10000)
	public void recognizesPerfectLowerCasePangram() {
		assertTrue(evaluationService.isPangram("abcdefghijklmnopqrstuvwxyz"));
	}

	@Test(timeout=10000)
	public void pangramWithOnlyLowerCaseLettersIsRecognizedAsPangram() {
		assertTrue(evaluationService.isPangram("the quick brown fox jumps over the lazy dog"));
	}

	@Test(timeout=10000)
	public void phraseMissingCharacterXIsNotPangram() {
		assertFalse(evaluationService.isPangram("a quick movement of the enemy will jeopardize five gunboats"));
	}

	@Test(timeout=10000)
	public void phraseMissingAnotherCharacterIsNotPangram() {
		assertFalse(evaluationService.isPangram("five boxing wizards jump quickly at it"));
	}

	/*******************************************************************
	 * Question 17
	 ******************************************************************/
	@Test(timeout=10000)
	public void modernTime() {
		assertEquals(LocalDateTime.of(2043, Month.JANUARY, 1, 1, 46, 40),
				evaluationService.getGigasecondDate(LocalDate.of(2011, Month.APRIL, 25)));
	}

	@Test(timeout=10000)
	public void afterEpochTime() {
		assertEquals(LocalDateTime.of(2009, Month.FEBRUARY, 19, 1, 46, 40),
				evaluationService.getGigasecondDate(LocalDate.of(1977, Month.JUNE, 13)));
	}

	@Test(timeout=10000)
	public void beforeEpochTime() {
		assertEquals(LocalDateTime.of(1991, Month.MARCH, 27, 1, 46, 40),
				evaluationService.getGigasecondDate(LocalDate.of(1959, Month.JULY, 19)));
	}

	@Test(timeout=10000)
	public void withFullTimeSpecified() {
		assertEquals(LocalDateTime.of(2046, Month.OCTOBER, 2, 23, 46, 40),
				evaluationService.getGigasecondDate(LocalDateTime.of(2015, Month.JANUARY, 24, 22, 0, 0)));
	}

	@Test(timeout=10000)
	public void withFullTimeSpecifiedAndDayRollover() {
		assertEquals(LocalDateTime.of(2046, Month.OCTOBER, 3, 1, 46, 39),
				evaluationService.getGigasecondDate(LocalDateTime.of(2015, Month.JANUARY, 24, 23, 59, 59)));
	}

	/*******************************************************************
	 * Question 18
	 ******************************************************************/
	@Test(timeout=10000)
	public void testSumOfMultiplesOf4and6UpToFifteen() {

		int[] set = { 4, 6 };
		int output = evaluationService.getSumOfMultiples(15, set);
		assertEquals(30, output);

	}

	@Test(timeout=10000)
	public void testSumOfMultiplesOf5and6and8UpToOneHundredFifty() {

		int[] set = { 5, 6, 8 };
		int output = evaluationService.getSumOfMultiples(150, set);
		assertEquals(4419, output);

	}

	@Test(timeout=10000)
	public void testSumOfMultiplesOf5and25UpToFiftyOne() {

		int[] set = { 5, 25 };
		int output = evaluationService.getSumOfMultiples(51, set);
		assertEquals(275, output);

	}

	@Test(timeout=10000)
	public void testSumOfMultiplesOf43and47UpToTenThousand() {

		int[] set = { 43, 47 };
		int output = evaluationService.getSumOfMultiples(10000, set);
		assertEquals(2203160, output);

	}

	@Test(timeout=10000)
	public void testSumOfMultiplesOfOneUpToOneHundred() {

		int[] set = { 1 };
		int output = evaluationService.getSumOfMultiples(100, set);
		assertEquals(4950, output);

	}

	/*******************************************************************
	 * Question 19
	 ******************************************************************/
	@Test(timeout=10000)
	public void testThatAValidCanadianSocialInsuranceNumberIsIdentifiedAsValidV1() {
		assertTrue(evaluationService.isLuhnValid("046 454 286"));
	}

	@Test(timeout=10000)
	public void testThatAnInvalidCanadianSocialInsuranceNumberIsIdentifiedAsInvalid() {
		assertFalse(evaluationService.isLuhnValid("046 454 287"));
	}

	@Test(timeout=10000)
	public void testThatAnInvalidCreditCardIsIdentifiedAsInvalid() {
		assertFalse(evaluationService.isLuhnValid("8273 1232 7352 0569"));
	}

	@Test(timeout=10000)
	public void testThatAddingANonDigitCharacterToAValidStringInvalidatesTheString() {
		assertFalse(evaluationService.isLuhnValid("046a 454 286"));
	}

	@Test(timeout=10000)
	public void testThatStringContainingPunctuationIsInvalid() {
		assertFalse(evaluationService.isLuhnValid("055-444-285"));
	}

	/*******************************************************************
	 * Question 20
	 ******************************************************************/
	@Test(timeout=10000)
	public void testSingleAddition1() {
		assertEquals(2, evaluationService.solveWordProblem("What is 1 plus 1?"));
	}

	@Test(timeout=10000)
	public void testSingleAdditionWithNegativeNumbers() {
		assertEquals(-11, evaluationService.solveWordProblem("What is -1 plus -10?"));
	}

	@Test(timeout=10000)
	public void testSingleSubtraction() {
		assertEquals(16, evaluationService.solveWordProblem("What is 4 minus -12?"));
	}

	@Test(timeout=10000)
	public void testSingleMultiplication() {
		assertEquals(-75, evaluationService.solveWordProblem("What is -3 multiplied by 25?"));
	}

	@Test(timeout=10000)
	public void testSingleDivision() {
		assertEquals(-11, evaluationService.solveWordProblem("What is 33 divided by -3?"));
	}

}
