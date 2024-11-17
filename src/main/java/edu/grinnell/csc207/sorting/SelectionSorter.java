package edu.grinnell.csc207.sorting;

import java.util.Comparator;

/**
 * Something that sorts using selection sort.
 *
 * @param <T>
 *   The types of values that are sorted.
 *
 * @author Samuel A. Rebelsky
 * @author Jafar Jarrar
 */

public class SelectionSorter<T> implements Sorter<T> {
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
  public SelectionSorter(Comparator<? super T> comparator) {
    this.order = comparator;
  } // SelectionSorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array in place using selection sort.
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
    select(values);
  } // sort(T[])

  /**
   * Performs the selection sort algorithm on an array of values.
   * A value at an index is compared to all the other elements in
   * the array to be placed in the correct position. This process
   * is repeated for each element in the array.
   * @param values
   * The array to be sorted.
   */
  public void select(T[] values) {
    int indexOfMinimum = 0;
    for (int i = 0; i < values.length; i++) {
      T minimum = values[i];
      for (int j = i; j < values.length; j++) {
        if (order.compare(values[j], minimum) < 1) {
          minimum = values[j];
          indexOfMinimum = j;
        } // if
      } // for
      if (minimum != values[i]) {
        values[indexOfMinimum] = values[i];
        values[i] = minimum;
      } // if
    } // for
  } // select(T[])
} // class SelectionSorter
