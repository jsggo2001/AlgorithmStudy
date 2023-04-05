package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_1786_찾기_정승구 {
    static int[] arr, arr2;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String t = br.readLine();
        String p = br.readLine();
        arr = new int[p.length()];
        solve1(p, p, arr);

        arr2 = new int[t.length()];
        solve2(t, p, arr2);


        List<Integer> answer = new ArrayList<>();
        int cnt = 0;
        int length = p.length();
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] == length) {
                cnt++;
                answer.add(i - (length - 2));
            }
        }

//        System.out.println(Arrays.toString(arr2));
        sb.append(cnt + "\n");
        if (answer.size() == 1) {
            sb.append(answer.get(0) + "\n");
        } else {
            for (int i = 0; i < answer.size(); i++) {
                sb.append(answer.get(i) + " ");
            }
        }
        System.out.println(sb);
    }

    private static void solve2(String t, String p, int[] arr2) {
        for (int i = 0; i < t.length(); i++) {
            int j = 0;
            while (j < p.length() && i < t.length()) {
                if (t.charAt(i) == p.charAt(j)) {
                    j++;
                    arr2[i] = j;
                    i++;
                    if (j == p.length()) j = arr[j - 1];
                } else {
                    if (j == 0) break;
                    j = arr[j - 1];
                }
            }
        }
    }

    private static void solve1(String t, String p, int[] arr) {
        for (int i = 1; i < t.length(); i++) {
            int j = 0;
            while (j < p.length() && i < t.length()) {
                if (t.charAt(i) == p.charAt(j)) {
                    j++;
                    arr[i] = j;
                    i++;
                } else {
                    if (j == 0) break;
                    j = arr[j - 1];
                }
            }
        }
    }
}

/*
ABC ABCDAB ABCDABCDABDEABCDABD
ABCDABD
 */
