package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2512_예산 {
    static int[] list;
    static int n, x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(br.readLine());

        Arrays.sort(list);

        int start = 0;
        int end = list[n - 1] + 1;
        int mid = 0;
        int result = 0;
        while (start < end) {
            mid = (start + end) / 2;
            result = check(mid);
            if(result > x) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
//        System.out.println(start + " " + end + " " + mid + " " + result);
        System.out.println(end - 1);
    }

    private static int check(int mid) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (list[i] >= mid) {
                result += mid;
            } else {
                result += list[i];
            }
        }
        return result;
    }
}
