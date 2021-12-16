package sortingalgorithms;

import java.util.Arrays;

public class SortingAlgorithms {

    public static void main(String[] args) {
        
        // In this program, we will demonstrate some sorting algorithms for arrays. 
        int[] numbers = new int[1_000_000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = 1_000_000 - i;
        }
        mergeSort(numbers);
        System.out.println(Arrays.toString(numbers));

    }
    
    public static void selectionSort(int[] array) {
        
        for (int i = 0; i < array.length - 1; i++) {
            int minimum = Integer.MAX_VALUE;
            int minIdx = -1;
            for (int j = i; j < array.length; j++) {
                if (array[j] < minimum) {
                    minimum = array[j];
                    minIdx = j;
                }
            }
            for (int j = minIdx; j > i; j--) {
                array[j] = array[j - 1];
            }
            array[i] = minimum;
        }
        
    }
    
    public static void insertionSort(int[] array) {
        
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            for (int j = 0; j < i; j++) {
                if (temp < array[j]) {
                    for (int k = i; k > j; k--) {
                        array[k] = array[k - 1];
                    }
                    array[j] = temp;
                    break;
                }
            }
        }
        
    }
    
    public static void mergeSort(int[] array) {
        
        if(array.length == 1) {
            return;
        }
        boolean oddElements = array.length % 2 == 1;
        int[] subArray1 = oddElements ? new int[array.length / 2 + 1] : new int[array.length / 2];
        int[] subArray2 = new int[array.length / 2];
        System.arraycopy(array, 0, subArray1, 0, subArray1.length);
        System.arraycopy(array, subArray1.length, subArray2, 0, subArray2.length);
        mergeSort(subArray1);
        mergeSort(subArray2);
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < array.length; i++) {
            if (index1 >= subArray1.length) {
                System.arraycopy(subArray2, index2, array, i, subArray2.length - index2);
                break;
            }
            if (index2 >= subArray2.length) {
                System.arraycopy(subArray1, index1, array, i, subArray1.length - index1);
                break;
            }
            if (subArray1[index1] <= subArray2[index2]) {
                array[i] = subArray1[index1];
                index1++;
            } else {
                array[i] = subArray2[index2];
                index2++;
            }
        }
               
    }
    
}
