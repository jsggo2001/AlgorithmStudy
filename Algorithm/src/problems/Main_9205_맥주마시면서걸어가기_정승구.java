package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9205_맥주마시면서걸어가기_정승구 {
    static int n;
    static int[][] list;
    static boolean[] visited;
    static boolean result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            list = new int[n + 2][];
            visited = new boolean[n + 2];
            result = false;

            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list[i] = new int[]{x,y};
            }

            Queue<int[]> q = new LinkedList<>();
            q.offer(list[0]);
            visited[0] = true;

            while(!q.isEmpty()) {
                int[] now = q.poll();
                int x = now[0];
                int y = now[1];

                if (x == list[n + 1][0] && y == list[n + 1][1]) {
                    result = true;
                    break;
                }

                for (int i = 0; i < n + 2; i++) {
                    if (visited[i]) continue;
                    if (Math.abs(x - list[i][0]) + Math.abs(y - list[i][1]) <= 1000) {
                        q.offer(list[i]);
                        visited[i] = true;
                    }
                }
            }
            if(result) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
    }
}
