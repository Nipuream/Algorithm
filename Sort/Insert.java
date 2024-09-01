package Sort;

import java.util.Arrays;

public class Insert {


    public static void InsertSort(int[] arr) {

        for(int i = 0; i < arr.length - 1; i++) {

            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if(minIndex != i) {
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 5, 8, 2, 9, 7, 3 };
        InsertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
}
