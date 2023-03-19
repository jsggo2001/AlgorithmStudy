package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15686_치킨배달_정승구 {
    static int[][] map;
    static List<List<Integer>> home;
    static List<List<Integer>> chicken;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        map = new int[n][n];

        home = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                String now = st.nextToken();
                if (now.equals("1")) {
                    home.add(Arrays.asList(i,j));
                } else if (now.equals("2")) {
                    chicken.add(Arrays.asList(i,j));
                }
            }
            map[i] = temp;
        }

        int length = chicken.size();
        int[] p = new int[length];

        for (int i = length - 1; i > length - m - 1; i--) {
            p[i] = 1;
        }
        int answer = (int) 1e9;
        do {
            answer = Math.min(answer, makeDistance(p));
        } while (np(p));
        System.out.println(answer);
    }

    private static int makeDistance(int[] p) {
        int result = 0;
        for (int i = 0; i < home.size(); i++) {
            int temp = (int) 1e9;
            for (int j = 0; j < p.length; j++) {
                if (p[j] == 1) {
                    temp = Math.min(temp, Math.abs(chicken.get(j).get(0) - home.get(i).get(0) ) +
                                                 Math.abs(chicken.get(j).get(1) - home.get(i).get(1)));
                }
            }
            result += temp;
        }
        return result;
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
