package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2559_수열 {
    static int n, k;
    static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        list = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < k; i++) {
            max += list[i];
        }
        int temp = 0;
        int pre = max;
        for(int i = k; i < n; i++) {
            temp = pre;
            temp -= list[i - k];
            temp += list[i];
            max = Math.max(max, temp);
            pre = temp;
        }
        System.out.println(max);
    }
}