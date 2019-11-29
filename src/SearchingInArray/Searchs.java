package SearchingInArray;

import Uses.DoubleLinkedList;
import Uses.LinkedList;
import java.util.Iterator;

/**
 * <h3>
 * ESTG - Escola Superior de Tecnologia e Gestão<br>
 * IPP - Instituto Politécnico do Porto<br>
 * LEI - Licenciatura em Engenharia Informática<br>
 * PP - Paradigmas de Programação<br>
 * </h3>
 * <p>
 * <strong>Author: </strong><br>
 * Joao Sousa<br>
 * <strong>Description: </strong><br>
 * Class that represents
 * </p>
 */
public class Searchs {

    /**
     * Searches the specified array of objects using a linear search algorithm.
     *
     * @param data the array to be sorted
     * @param min the integer representation of the min value
     * @param max the integer representation of the max value
     * @param target the element being searched for
     * @return true if the desired element is found
     */
    public static <T extends Comparable<? super T>> boolean
            linearSearch(T[] data, int min, int max, T target) {
        int index = min;
        boolean found = false;
        while (!found && index <= max) {
            if (data[index].compareTo(target) == 0) {
                found = true;
            }
            index++;
        }
        return found;
    }

    public static <T extends Comparable<? super T>> boolean
            linearSearchInLinkedList(LinkedList data, T target) {
        boolean found = false;
        Iterator it = data.iterator();
        Comparable CTarget = (Comparable) target;
        while (it.hasNext() && !found) {
            if (CTarget.compareTo(it.next()) == 0) {
                found = true;
            }
        }
        return found;
    }

    public static <T extends Comparable<? super T>> boolean
            linearSearchInDoubleLinkedList(DoubleLinkedList data, T target) {
        boolean found = false;
        Iterator it = data.iterator();
        Comparable CTarget = (Comparable) target;
        while (it.hasNext() && !found) {
            if (CTarget.compareTo(it.next()) == 0) {
                found = true;
            }
        }
        return found;
    }

    /**
     * Searches the specified array of objects using a binary search algorithm.
     *
     * @param data the array to be sorted
     * @param min the integer representation of the minimum value
     * @param max the integer representation of the maximum value
     * @param target the element being searched for
     * @return true if the desired element is found
     */
    public static <T extends Comparable<? super T>> boolean
            binarySearch(T[] data, int min, int max, T target) {
        boolean found = false;
        int midpoint = (min + max) / 2; // determine the midpoint
        if (data[midpoint].compareTo(target) == 0) {
            found = true;
        } else if (data[midpoint].compareTo(target) > 0) {
            if (min <= midpoint - 1) {
                found = binarySearch(data, min, midpoint - 1, target);
            }
        } else if (midpoint + 1 <= max) {
            found = binarySearch(data, midpoint + 1, max, target);
        }
        return found;
    }

}
