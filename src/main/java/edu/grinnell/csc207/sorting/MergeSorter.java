package edu.grinnell.csc207.sorting;

import java.util.Comparator;

/**
 * Something that sorts using merge sort.
 *
 * @param <T>
 *   The types of values that are sorted.
 *
 * @author Samuel A. Rebelsky
 * @author Jafar Jarrar
 */

public class MergeSorter<T> implements Sorter<T> {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The way in which elements are ordered.
   */
  Comparator<? super T> order;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter using a particular comparator.
   *
   * @param comparator
   *   The order in which elements in the array should be ordered
   *   after sorting.
   */
  public MergeSorter(Comparator<? super T> comparator) {
    this.order = comparator;
  } // MergeSorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array in place using merge sort.
   *
   * @param values
   *   an array to sort.
   *
   * @post
   *   The array has been sorted according to some order (often
   *   one given to the constructor).
   * @post
   *   For all i, 0 &lt; i &lt; values.length,
   *     order.compare(values[i-1], values[i]) &lt;= 0
   */
  @Override
  public void sort(T[] values) {
    if (values.length == 0) {
      return;
    } // if
    T[] newValues = sortHelper(values);
    for (int i = 0; i < values.length; i++) {
      values[i] = newValues[i];
    } // for
  } // sort(T[])

  /**
   * Recursively divides the array of values into two halves until
   * only one element remains in the divided array. When that case
   * is reached, the method calls the merge method to merge together
   * the divided arrays until the new array is formed.
   * @param values
   * The array to be sorted.
   * @return
   * A divided array of size 1 if the array has been divided into n
   * arrays of size 1.
   * An array containing two merged arrays through the call of the
   * merge helper method.
   */
  public T[] sortHelper(T[] values) {
    if (values.length == 1) {
      return values;
    } else {
      int midpoint = values.length / 2;
      T[] halfOne = (T[]) new Object[midpoint];
      T[] halfTwo = (T[]) new Object[values.length - midpoint];
      for (int i = 0; i < midpoint; i++) {
        halfOne[i] = values[i];
      } // for
      for (int i = 0; i < halfTwo.length; i++) {
        halfTwo[i] = values[i + midpoint];
      } // for
      halfOne = sortHelper(halfOne);
      halfTwo = sortHelper(halfTwo);
      return merge(halfOne, halfTwo);
    } // if
  } // sortHelper(T[])

  /**
   * Merges two arrays toegther in order by comparing each of their
   * values in order and adding them to a new array with a capacity
   * to hold all of their values.
   * @param halfOne
   * The first array to be merged.
   * @param halfTwo
   * The second array to be merged.
   * @return
   * An array containing both of the arrays' values merged in order.
   */
  public T[] merge(T[] halfOne, T[] halfTwo) {
    T[] newValues = (T[]) new Object[halfOne.length + halfTwo.length];
    int i = 0;
    int j = 0;
    int valuesAdded = 0;
    while (i < halfOne.length && j < halfTwo.length) {
      if (order.compare(halfOne[i], halfTwo[j]) < 1) {
        newValues[valuesAdded++] = halfOne[i++];
      } else {
        newValues[valuesAdded++] = halfTwo[j++];
      } // if
    } // while
    while (j < halfTwo.length) {
      newValues[valuesAdded++] = halfTwo[j++];
    } // while
    while (i < halfOne.length) {
      newValues[valuesAdded++] = halfOne[i++];
    } // while
    return newValues;
  } // merge(T[], T[])
} // class MergeSorter
