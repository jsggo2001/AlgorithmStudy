package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15961_회전초밥_정승구 {

    static int n, d, k, c, answer;
    static int[] visited;
    static int[] dishes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        visited = new int[d + 1];
        visited[c] = 1;
        answer = 1;
        dishes = new int[n];

        for (int i = 0; i < n; i++) {
            dishes[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < k; i++) {
            if (visited[dishes[i]] == 0) {
                answer++;
            }
            visited[dishes[i]]++;
        }

        int now = 0;
        int cnt = answer;
        for (int i = k; i < n; i++) {
            if (dishes[i] == dishes[now]) {
                now++;
                continue;
            }

            if (visited[dishes[now]] > 0) {
                visited[dishes[now]]--;
                if (visited[dishes[now]] == 0) cnt--;
            }
            now++;

            if (visited[c] == 0) {
                cnt++;
                visited[c] = 1;
            }

            if (visited[dishes[i]] == 0) {
                cnt++;
            }
            visited[dishes[i]]++;
            answer = Math.max(answer, cnt);
        }

        for (int i = 0; i < k; i++) {
            if (dishes[i] == dishes[now]) {
                now++;
                continue;
            }

            if (visited[dishes[now]] > 0) {
                visited[dishes[now]]--;
                if (visited[dishes[now]] == 0) cnt--;
            }
            now++;

            if (visited[c] == 0) {
                cnt++;
                visited[c] = 1;
            }

            if (visited[dishes[i]] == 0) {
                cnt++;
            }
            visited[dishes[i]]++;
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }
}
