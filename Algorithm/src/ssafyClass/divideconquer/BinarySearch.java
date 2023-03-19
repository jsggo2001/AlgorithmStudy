package ssafyClass.divideconquer;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] values = {3,15,26,3,2,34,77,9};
        Arrays.sort(values);
        System.out.println(binarySearch(values, 15));
        System.out.println(binarySearch2(values, 0, values.length - 1, 15));
        System.out.println(Arrays.binarySearch(values, 15));
        System.out.println(binarySearch(values, 25));
        System.out.println(binarySearch2(values, 0, values.length - 1, 25));
        System.out.println(Arrays.binarySearch(values, 25));
    }

    private static int binarySearch(int[] values, int key) {
        int start = 0, end = values.length - 1;
        while(start<=end) {
            int mid = (end + start) / 2;
            if (values[mid] == key) return mid;
            else if(values[mid] < key) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    private static int binarySearch2(int[] values, int start, int end, int key) {
        if (start > end) {
            return -1;
        }
        int mid = (end + start) / 2;
        if (values[mid] == key) return mid;
        else if(values[mid] < key) return binarySearch2(values, mid + 1, end, key);
        else return binarySearch2(values, start,mid - 1, key);
    }
}
