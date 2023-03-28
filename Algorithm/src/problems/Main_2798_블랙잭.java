package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2798_블랙잭 {
    static int n, m;
    static int[] list;
    static int result;
    static int answer = 0;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0;i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        solve(0);
        System.out.println(answer);

    }

    private static void solve(int level) {
        if (level == 3) {
            if (result <= m) {
                if (answer < result) {
                    answer = result;
                }
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == true) continue;
            result += list[i];
            visited[i] = true;
            solve(level + 1);
            result -= list[i];
            visited[i] = false;
        }
    }

}
