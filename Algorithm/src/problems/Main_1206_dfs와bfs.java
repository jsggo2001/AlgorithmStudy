package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1206_dfs와bfs {
    static int n, m, start;
    static List<List<Integer>> list;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to);
            list.get(to).add(from);
        }

        for (int i = 0; i < n + 1; i++) {
            list.get(i).sort((a,b) -> a - b);
        }

        visited = new boolean[n + 1];
        dfs(start);
        sb.append("\n");
        visited = new boolean[n + 1];
        bfs(start);

        System.out.println(sb);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int nowNode = q.poll();
            sb.append(nowNode + " ");
            List<Integer> nowList = list.get(nowNode);
            for (int i = 0; i < nowList.size(); i++) {
                int now = nowList.get(i);
                if (visited[now]) continue;
                visited[now] = true;
                q.offer(now);
            }
        }
    }

    private static void dfs(int node) {
        visited[node] = true;
        sb.append(node + " ");
        List<Integer> now = list.get(node);

        for (int i = 0; i < now.size(); i++) {
            if (visited[now.get(i)]) continue;
            dfs(now.get(i));
        }

    }
}
