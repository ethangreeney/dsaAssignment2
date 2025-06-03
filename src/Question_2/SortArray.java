// Is quick sort the best way of finding median? Why?

// no, quick sort is not the best way of finding the median. once we have found where the pivot falls, 
// we only need to do one of the recursive calls, because the specific order of the other elements 
// no longer matters. This is called quickselect. This reduced that average time complexity from O(n log n), 
// to O(n), as we are able to discard about half of the elements each repetition. 

// The solution with theoretically the minimum number of CPU cycles 
// (though very inpractical for anything other than a small fixed n)
// is hard coding a sorting network, and performing all the swaps manually.
// for n = 9 (used in this assignment) the minimum number of comparators needed would be 25.

// What is another good way of finding median? Please provide your explanation.

// another good way to find the median value would be to use bin sort due to the fixed range
// of potential values (0-255). To implement this
// - create an int array of size 256
// - iterate through each value in the array and increase the value at the index of the rgb value by 1
// - once the arrray has been filled, iterate throught the array untill untill the
// median element (5th element) is found.
// This is highly efficient as it avoids the overhead associated with other methods.
// it has a time complexity of O(n + k), where k = 256.

package Question_2;

public class SortArray<E extends Comparable> {

    E[] array;

    public SortArray(E[] array) {
        this.array = array;
    }

    public void setArray(E[] array) {
        this.array = array;
    }

    public void quickSort() {
        // Lomuto scheme quicksort
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(E[] list, int h, int t) {

        // base case: if our low pointer is equal or greater than the high pointer, the
        // array is fully sorted or invalid. Return.

        if (h >= t) {
            return;
        }
        // set pivot as the last position in the current subarray
        E pivot = list[t];
        // set the initial low pointer to one position before the first element
        int lessThanPivotIndex = h - 1;
        // iterate through each element of the subarray except the pivot
        for (int i = h; i < t; i++) {
            // when we find a value less than the pivot, put it one position to the right of
            // the last value less than the pivot that was found
            if (list[i].compareTo(pivot) < 0) {
                swap(list, ++lessThanPivotIndex, i);
            }
        }
        // swap the pivot with the spot one to the right of the last value found that
        // was less than the pivot
        swap(list, ++lessThanPivotIndex, t);
        // reccursively call this method for the left and right subarray, the pivot is
        // now in its final sorted position
        quickSort(list, h, lessThanPivotIndex - 1);
        quickSort(list, lessThanPivotIndex + 1, t);
    }

    private void swap(E[] list, int a, int b) {
        // simple swap method
        E temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }
}
