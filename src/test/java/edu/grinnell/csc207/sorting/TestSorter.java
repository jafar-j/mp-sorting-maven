package edu.grinnell.csc207.sorting;

import edu.grinnell.csc207.util.ArrayUtils;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects. Please do not use this class directly.
 * Rather, you should subclass it and initialize stringSorter and
 * intSorter in a static @BeforeAll method.
 *
 * @author Your Name
 * @uathor Samuel A. Rebelsky
 */
public class TestSorter {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  /**
   * The sorter we use to sort arrays of strings.
   */
  static Sorter<String> stringSorter = null;

  /**
   * The sorter we use to sort arrays of integers.
   */
  static Sorter<Integer> intSorter = null;

  /**
   * Our random number generator.
   */
  static Random rand;

  // +-----------+---------------------------------------------------
  // | Utilities |
  // +-----------+

  /**
   * Given a sorted array and a permutation of the array, sort the
   * permutation and assert that it equals the original.
   *
   * @param <T>
   *   The type of values in the array.
   * @param sorted
   *   The sorted array.
   * @param perm
   *   The permuted sorted array.
   * @param sorter
   *   The thing to use to sort.
   */
  public <T> void assertSorts(T[] sorted, T[] perm, Sorter<? super T> sorter) {
    T[] tmp = perm.clone();
    sorter.sort(perm);
    assertArrayEquals(sorted, perm,
      () -> String.format("sort(%s) yields %s rather than %s",
          Arrays.toString(tmp), 
          Arrays.toString(perm), 
          Arrays.toString(sorted)));
  } // assertSorts

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  /**
   * A fake test. I've forgotten why I've included this here. Probably
   * just to make sure that some test succeeds.
   */
  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  /**
   * Ensure that an array that is already in order gets sorted correctly.
   */
  @Test
  public void orderedStringTest() {
    if (null == stringSorter) {
      return;
    } // if
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    assertSorts(expected, original, stringSorter);
  } // orderedStringTest

  /**
   * Ensure that an array that is ordered backwards gets sorted correctly.
   */
  @Test
  public void reverseOrderedStringTest() {
    if (null == stringSorter) {
      return;
    } // if
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    assertSorts(expected, original, stringSorter);
  } // orderedStringTest

  /**
   * Ensure that a randomly permuted version of a moderate-sized
   * array sorts correctly.
   */
  @Test 
  public void permutedIntegersTest() { 
    int SIZE = 100; 
    if (null == intSorter) { 
      return; 
    } // if
    Integer[] original = new Integer[SIZE];
    for (int i = 0; i < SIZE; i++) {
      original[i] = i;
    } // for
    Integer[] expected = original.clone();
    ArrayUtils.permute(original);
    assertSorts(expected, original, intSorter);
  } // permutedIntegers

  /**
   * Ensure that an array with dublicate String values sorts correctly.
   */
  @Test
  public void duplicateStringsTest() {
    String[] original = { "p", "a", "b", "b", "z", "b", "a", "t" };
    String[] expected = { "a", "a", "b", "b", "b", "p", "t", "z" };
    assertSorts(expected, original, stringSorter);
  } // duplicateStringsTest()

  /**
   * Ensures that all algorithms work on an empty array.
   */
  @Test
  public void emptyArrayTest() {
    String[] empty = {};
    String[] expected = {};
    assertSorts(expected, empty, stringSorter);
  } // emptyArray()

  /**
   * Ensures that all algorithms correctly sort negative Integers.
   */
  @Test
  public void negativeIntegersTest() {
    Integer[] original = { -1, 3, -2, 2, 6, -8 };
    Integer[] expected = { -8, -2, -1, 2, 3, 6 };
    assertSorts(expected, original, intSorter);
  } // negativeIntegersTest()

  /**
   * Ensures that all algorithms work on an array of negative
   * Integers in the worst case (when they are reversed).
   */
  @Test
  public void reverseNegativeIntegersTest() {
    Integer[] original = new Integer[1000];
    Integer[] expected = new Integer[1000];
    int counter = -999;
    int counter2 = 0;
    for (int i = 0; i < 1000; i++) {
      original[i] = counter2--;
      expected[i] = counter++;
    } // for
    assertSorts(expected, original, intSorter);
  } // negativeIntegersTest()

  /**
   * Ensures that an array with only the values on the edges unsorted
   * is sorted correctly.
   */
  @Test
  public void edgeValuesTest() {
    Integer[] original = { 9, 1, 2, 3, 4, 5, 6, 7, 8, -100 };
    Integer[] expected = { -100, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    assertSorts(expected, original, intSorter);
  } // edgeValuesTest()

  /**
   * Repeats the process of testing if a shuffled array of Integers
   * will be sorted correctly 100 times.
   */
  @Test
  public void permutedIntegersTestS() {
    Integer[] original = new Integer[1000];
    for (int i = 0; i < 1000; i++) {
      original[i] = i;
    } // for
    Integer[] expected = original.clone();
    for (int i = 0; i < 100; i++) {
      ArrayUtils.permute(original);
      assertSorts(expected, original, intSorter);
    } // for
  } // permutedIntegersTestsS()
} // class TestSorter
