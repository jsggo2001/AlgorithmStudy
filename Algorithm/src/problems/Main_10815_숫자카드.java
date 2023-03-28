package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10815_숫자카드 {
    static int n,k;
    static int[] list;
    static int[] target;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        k = Integer.parseInt(br.readLine());
        target = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);

        for (int i = 0; i < k; i++) {
            sb.append(checkBinary(i) + " ");
        }
        System.out.println(sb);
    }

    private static int checkBinary(int i) {
        int start = 0;
        int end = n-1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (list[mid] == target[i]) return 1;
            if (list[mid] > target[i]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return 0;
    }
}
