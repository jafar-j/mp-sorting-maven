package edu.grinnell.csc207.sorting;

import java.util.Comparator;

/**
 * Something that sorts using insertion sort.
 *
 * @param <T>
 *   The types of values that are sorted.
 *
 * @author Samuel A. Rebelsky
 * @author Jafar Jarrar
 */

public class InsertionSorter<T> implements Sorter<T> {
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
  public InsertionSorter(Comparator<? super T> comparator) {
    this.order = comparator;
  } // InsertionSorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array in place using insertion sort.
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
    insert(values);
  } // sort(T[])

  /**
   * Performs the insertion sort algorithm on an array of values.
   * It repeats the process of swapping elements to the left of the
   * array until they reach the correct location n times.
   * @param values
   * An array to sort.
   */
  public void insert(T[] values) {
    for (int i = 1; i < values.length; i++) {
      for (int j = i; j > 0; j--) {
        if (order.compare(values[j - 1], values[j]) > 0) {
          T temp = values[j - 1];
          values[j - 1] = values[j];
          values[j] = temp;
        } else {
          break;
        } // if
      } // for
    } // for
  } // insert(T[])
} // class InsertionSorter
