package edu.grinnell.csc207.sorting;

import java.util.Comparator;

/**
 * My own sorting implementation involving a mix of bubble
 * sort and insertion sort.
 *
 * @param <T>
 *   The types of values that are sorted.
 *
 * @author Samuel A. Rebelsky
 * @author Jafar Jarrar
 */
public class JarrarJafarSort<T> implements Sorter<T> {

  /**
   * The way in which elements are ordered.
   */
  Comparator<? super T> order;

  /**
   * Create a sorter using a particular comparator.
   *
   * @param comparator
   *   The order in which elements in the array should be ordered
   *   after sorting.
   *
   * @author Jafar Jarrar
   */
  public JarrarJafarSort(Comparator<? super T> comparator) {
    this.order = comparator;
  } // MergeSorter(Comparator)

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
    partialBubbleSort(values);
    insert(values);
  } // sort(T[])

  /**
   * Performs bubble sort on the array of values n / 8 times. I took
   * inspiration from claude.ai to know how many times to perform bubble
   * sort in order to have the most efficient implementation by lowering
   * the number of swaps of insertion sort.
   * @param values
   * An array to sort.
   */
  public void partialBubbleSort(T[] values) {
    int bubbleIterations = values.length / 8;
    for (int i = 0; i < bubbleIterations; i++) {
      for (int j = 0; j < values.length - 1; j++) {
        if (order.compare(values[j], values[j + 1]) > 0) {
          T temp = values[j];
          values[j] = values[j + 1];
          values[j + 1] = temp;
        } // if
      } // for
    } // for
  } // partialBubbleSort(T[])

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
} // class JarrarJafarSort<T>
