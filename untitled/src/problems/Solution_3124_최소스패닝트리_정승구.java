package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Solution_3124_최소스패닝트리_정승구 {
    static int v, e;
    static int[] minEdge;
    static List<List<int[]>> list;
    static PriorityQueue<int[]> pq;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case < T + 1; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            minEdge = new int[v + 1];
            list = new ArrayList<>();
            for (int i = 0; i < v+1; i++) {
                list.add(new ArrayList<>());
            }
            visited = new boolean[v + 1];
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                list.get(from).add(new int[]{to,weight});
                list.get(to).add(new int[]{from,weight});
            }
            for (int i = 0; i < v + 1; i++) minEdge[i] = Integer.MAX_VALUE;

            pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
            pq.offer(new int[]{1, 0});
            minEdge[1] = 0;
            long result = 0;
            int c = 0;
            while (!pq.isEmpty()) {
                int[] minVertex = pq.poll();
                if (visited[minVertex[0]]) continue;
                visited[minVertex[0]] = true;
                result += minVertex[1];
                if (++c == v) break;

                List<int[]> nowList = list.get(minVertex[0]);
                for (int i = 0; i < nowList.size(); i++) {
                    int[] nowNode = nowList.get(i);
                    if (!visited[nowNode[0]] && nowNode[1] != 0
                     && nowNode[1] < minEdge[nowNode[0]]) {
                        minEdge[nowNode[0]] = nowNode[1];
                        pq.offer(nowNode);
                    }
                }
            }
            System.out.println("#" + test_case + " " + result);
        }
    }
}
