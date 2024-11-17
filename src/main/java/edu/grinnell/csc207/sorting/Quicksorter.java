package edu.grinnell.csc207.sorting;

import java.util.Comparator;

/**
 * Something that sorts using Quicksort.
 *
 * @param <T>
 *   The types of values that are sorted.
 *
 * @author Samuel A. Rebelsky
 * @author Jafar Jarrar
 */

public class Quicksorter<T> implements Sorter<T> {
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
  public Quicksorter(Comparator<? super T> comparator) {
    this.order = comparator;
  } // Quicksorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array in place using Quicksort.
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
    sortHelper(values, 0, values.length - 1);
  } // sort(T[])

  /**
   * Repeatedly sorts area of an array between a lower and upper bound
   * until the lower bound exceeds the upper bound. Sets a new pivot point
   * after each recursive call to repeat the process of sorting on the new
   * area in the array.
   * @param values
   * The array to be sorted.
   * @param lb
   * The lower bound of the area in the array in which values are sorted.
   * @param ub
   * The upper bound of the area in the array in which values are sorted.
   */
  public void sortHelper(T[] values, int lb, int ub) {
    if (lb < ub) {
      // The pivot will be made to be at the position between the small and upper bounds.
      int pivotIndex = partition(values, lb, ub);
      sortHelper(values, lb, pivotIndex - 1);
      sortHelper(values, pivotIndex + 1, ub);
    } // if
  } // sortHelper(T[], int, int)

  /**
   * Creates a partition in the array by setting a pivot point there. Values
   * less than the pivot are placed to the left of the pivot, and values
   * larger than the pivot are placed to the right of the pivot.
   * @param values
   * The array to be sorted.
   * @param lb
   * The lower bound of the area in the array in which values are sorted.
   * @param ub
   * The upper bound of the area in the array in which values are sorted.
   * @return
   * The index of the pivot point in the array in which values are sorted around.
   */
  public int partition(T[] values, int lb, int ub) {
    T pivotValue = values[lb];
    int smallBound = lb;
    for (int i = lb + 1; i <= ub; i++) {
      if (order.compare(values[i], pivotValue) < 0) {
        T temp = values[i];
        values[i] = values[++smallBound];
        values[smallBound] = temp;
      } // if
    } // for
    // Swaps pivot with value at small bound.
    T temp = values[smallBound];
    values[smallBound] = values[lb];
    values[lb] = temp;
    return smallBound;
  } // divide(T[], int, int)
} // class Quicksorter
