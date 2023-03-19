package problems;

import java.util.Scanner;

public class Solution_nqueen {

    static boolean[] col;
    static boolean[] dig1;
    static boolean[] dig2;
    static int n;
    static int result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            result = 0;
            col = new boolean[n];
            dig1 = new boolean[(n * 2) - 1];
            dig2 = new boolean[(n * 2) - 1];

            solution(0);
            System.out.println("#" + test_case + " " + result);

        }
    }

    private static void solution(int cnt) {
        if (cnt == n) {
            result++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dig1[i + cnt] && !dig2[n - i + cnt - 1]) {
                col[i] = dig1[i + cnt] = dig2[n - i + cnt - 1] = true;
                solution(cnt + 1);
                col[i] = dig1[i + cnt] = dig2[n - i + cnt - 1] = false;
            }
        }
    }

}
