package ssafyClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TopologySortTest {
    static class Node {
        int vertex;
        Node link;

        public Node(int vertex, Node link) {
            this.vertex = vertex;
            this.link = link;
        }
    }

    static int N, M;
    static Node[] adjList;
    static int[] indegree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new Node[N + 1];
        indegree = new int[N + 1];

        int from, to;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            adjList[from] = new Node(to, adjList[from]);
            indegree[to]++;
        }

        ArrayList<Integer> list = topologySort();
        if (list.size() == N) {
            for (Integer vertex : list) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        } else {
            System.out.println("cycle");
        }
    }
    static ArrayList<Integer> topologySort() {
        ArrayList<Integer> orderList = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) q.offer(i);
        } // 진입 차수가 0인 정점 큐에 넣기

        while(!q.isEmpty()) {
            int cur = q.poll();
            orderList.add(cur);

            // 현재 정점 기준으로 인접정점 처리
            for (Node temp = adjList[cur]; temp != null; temp = temp.link) {
                if (--indegree[temp.vertex] == 0) {
                    q.offer(temp.vertex);
                }
            }
        }

        return orderList;
    }
}
