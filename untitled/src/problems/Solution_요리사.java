package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_요리사 {

    static int n;
    static int[][] map;
    static int[] p;
    static int[] p2;
    static List<List<Integer>> maskings;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=Integer.parseInt(br.readLine());


        for(int test_case = 1; test_case <= T; test_case++) {


            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            p = new int[n];

            for (int i = n - 1; i > n - 1 - n / 2; i--) {
                p[i] = 1;
            }

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            maskings = new ArrayList<>();
            do {
                cnt++;
                List<Integer> temp = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if (p[i] == 1)
                        temp.add(i);
                }
                maskings.add(temp);
            } while (np(p));
            System.out.println(maskings);
            int size = maskings.size();
            int min = 20001;
            for (int i = 0; i < size; i++) {
                if (maskings.get(i).get(0) == 0) break;
                min = Math.min(min, makeFood(maskings.get(i), maskings.get(size - 1 - i)));
            }
            System.out.println("#" + test_case + " " + min);
            System.out.println(cnt);
        }
    }

    private static int makeFood(List<Integer> list, List<Integer> list2) {
        int length = list.size();
        p2 = new int[length];
        p2[length - 1] = 1;
        p2[length - 2] = 1;

        int val1 = 0;
        int val2 = 0;
        do {
            int[] temp = new int[2];
            int[] temp2 = new int[2];
            int cnt = 0;
            for (int i = 0; i < length; i++) {
                if (p2[i] == 1) {
                    temp[cnt] = list.get(i);
                    temp2[cnt] = list2.get(i);
                    cnt++;
                }
            }
            val1 += map[temp[0]][temp[1]] + map[temp[1]][temp[0]];
            val2 += map[temp2[0]][temp2[1]] + map[temp2[1]][temp2[0]];
        } while (np(p2));
        return Math.abs(val1 - val2);
    }


    private static boolean np(int[] input) {

        int n = input.length;

        int i = n - 1;
        while (i > 0 && input[i - 1] >= input[i]) --i;
        if (i == 0) return false;

        int j = n - 1;
        while (input[i - 1] >= input[j]) --j;

        swap(input, i - 1, j);

        int k = n - 1;
        while (i < k) {
            swap(input, i++, k--);
        }
        return true;
    }

    private static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
/*

4
0 5 3 8
4 0 4 1
2 5 0 3
7 2 3 0
 */