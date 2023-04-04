package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2470_두용액_이진탐색 {
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        int ans1 = 0;
        int ans2 = 0;
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            int now = list[i];
            int target = now * -1;

            int tmp = binarySearch(i + 1, n, target);

            int sum = Math.abs(tmp + now);
            if (answer >= sum) {
                answer = sum;
                ans1 = now;
                ans2 = tmp;
            }
        }
        if (ans1 > ans2) {
            System.out.println(ans2 + " " + ans1);
        } else {
            System.out.println(ans1 + " " + ans2);
        }
    }

    private static int binarySearch(int start, int end, int target) {
        int min = Integer.MAX_VALUE;
        int answer = 0;
        while (start < end) {
            int mid = (start + end) / 2;


            if (Math.abs(target - list[mid]) < min) {
                min = Math.abs(target - list[mid]);
                answer = list[mid];
            }

            if (list[mid] == target) {
                return target;
            } else if (list[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }
}
