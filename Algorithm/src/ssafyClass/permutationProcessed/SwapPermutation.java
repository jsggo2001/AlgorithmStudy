package ssafyClass.permutationProcessed;

import java.util.Arrays;
import java.util.Scanner;

public class SwapPermutation {
    static int[] input;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        input = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        perm(0);
    }

    private static void perm(int start) {
        if (start == n-1) {
            System.out.println(Arrays.toString(input));
            return;
        }

        for (int i = start; i < n; i++) {
//            System.out.println(start);
            swap(start, i);
            perm(start + 1);
            swap(i,start);
        }

    }

    private static void swap(int i,int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

}
