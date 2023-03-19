package problems;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main_1697_숨바꼭질_정승구 {
    static int n;
    static int k;
    static boolean[] visited = new boolean[100001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        if (n > k) {
            System.out.println(n - k);
            return;
        }
        System.out.println(bfs());
    }
    private static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        int[] arr = {n,0};
        visited[n] = true;
        q.add(arr);

        while (!q.isEmpty()) {
            int[] nowArr = q.poll();
            int val = nowArr[0];
            int cnt = nowArr[1];
            if (val == k) return cnt;
            if (val + 1 >= 0 && val + 1 < 100001 && !visited[val + 1]) {
                visited[val + 1] = true;
                int[] next = {val + 1,cnt + 1};
                q.add(next);
            }
            if (val - 1 >= 0 && val - 1 < 100001 && !visited[val - 1]) {
                visited[val - 1] = true;
                int[] next = {val - 1, cnt + 1};
                q.add(next);
            }
            if (val * 2 >= 0 && val * 2 < 100001 && !visited[val * 2]) {
                visited[val * 2] = true;
                int[] next = {val * 2, cnt + 1};
                q.add(next);
            }
        }
        return 0;
    }
}
