package ssafyClass.permutationProcessed;

import java.util.Arrays;
import java.util.Scanner;

public class PemutationNpTest {
    public static int n;
    public static int[] input;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        input = new int[n];

        for (int i =0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        // 전처리
        Arrays.sort(input);

        do {
            System.out.println(Arrays.toString(input));
        } while (np(input));

    }
    private static boolean np(int[] input) {

        int n = input.length;

        //step1. 뒤쪽부터 꼭대기를 찾는다. (꼭대기 바로 앞이 교환할 자리)
        int i = n - 1;
        while(i> 0 && input[i -1] >= input[i]) --i;
        if (i == 0) return false;

        //step2. 꼭대기 바로앞 (i-1)자리에 교환항 값을 뒤쪽부터 찾는다.
        int j = n - 1;
        while(input[i - 1] >= input[j]) --j;

        //step3. 꼭대기 바로앞(i-1)자리와 그 자리값보다 한단계 큰 자리(j) 수와 교환
        swap(input, i - 1, j);

        //step4. 꼭대기 부터 맨 뒤까지 오름차순 으로 정렬
        int k = n - 1;
        while(i < k) {
            swap(input, i++, k--);
        }
        return true;
    }
    private static void swap(int[] input, int i,int j ) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}

/*
조합 만들기
4
0 0 1 1
값을 주면 조합이 나오는데
같은 크기의 target배열의 값을 1인 위치의 값만 가져와서 조합을 만들 수 있다.
 */
