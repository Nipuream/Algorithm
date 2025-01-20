package Sort;

import java.util.Arrays;
import java.util.LinkedList;

public class HeapSort {

    private static void heapify(int[] arr, int i, int n) { 

        int maxest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if(left < n && arr[left] > arr[maxest]) {
            maxest = left;
        }
        if(right < n && arr[right] > arr[maxest]) {
            maxest = right;
        }

        if(maxest != i) {
            int tmp = arr[i];
            arr[i] = arr[maxest];
            arr[maxest] = tmp;

            heapify(arr, maxest, n); //对新的节点做堆调整
        }
    }

    public static void heapSort(int[] arr) {

        //筛选法建堆
        for(int i = arr.length/2 -1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }

        for(int i = arr.length - 1; i > 0; i--) {
            //swap 堆顶和最后一个元素
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;

            heapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 8, 3, 6, 1, 7, 2};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
