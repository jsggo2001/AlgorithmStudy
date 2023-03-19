package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.BiFunction;

public class Solution_1247_최적경로_정승구 {
    static List<List<Integer>> list;
    static BiFunction<Integer,Integer,Integer> add
            = (idx1,idx2) -> Math.abs(list.get(idx1).get(0) - list.get(idx2).get(0))
                                    + Math.abs(list.get(idx1).get(1) - list.get(idx2).get(1));
    static int[] p;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case < T + 1; test_case++) {
            n = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0 ; i < n + 2; i++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list.add(Arrays.asList(x,y));
            }
            list.add(list.get(1));
            list.remove(1);

            p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i + 1;
            }
            int min = (int) 1e9;
            do {
                int temp = add.apply(0,p[0]);
                for (int i = 0; i < p.length - 1; i++) {
                    if (temp > min) break;
                    temp += add.apply(p[i],p[i + 1]);
                }
                temp += add.apply(p[p.length - 1],n + 1);
                min = Math.min(min, temp);
            } while (np(p));
            System.out.println("#" + test_case + " " +min);
        }
    }
    private static boolean np(int[] input) {
        int n = input.length;

        int i = n - 1;
        while(i > 0 && input[i - 1] >= input[i]) --i;
        if (i == 0) return false;
        int j = n-1;
        while(input[i - 1] >= input[j]) --j;
        swap(input, i - 1, j);
        int k = n-1;
        while(i < k) swap(input, i++, k--);
        return true;
    }

    private static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}

/*
5
0 0 100 100 70 40 30 10 10 5 90 70 50 20
 */