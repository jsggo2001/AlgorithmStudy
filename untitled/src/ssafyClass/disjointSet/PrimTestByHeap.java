package ssafyClass.disjointSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PrimTestByHeap {

    static class Vertex implements Comparable<Vertex> {
        int no, weight;

        public Vertex(int no, int weight) {
            this.no = no;
            this.weight = weight;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(in.readLine());
        int[][] adjMatrix = new int[V][V];
        boolean[] visited = new boolean[V];
        PriorityQueue<Vertex> pq = new PriorityQueue<>();

        int[] minEdge = new int[V];
        StringTokenizer st = null;
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < V; j++) {
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
            minEdge[i] = Integer.MAX_VALUE;
        }
        int result = 0; // MST비용

        // 임의의 정점을 시작 정점으로 사용하기 위한 처리
        minEdge[0] = 0;
        pq.offer(new Vertex(0, 0));

        int c = 0;
        // V개의 정점을 모두 선택하면 신장트리 완성
        while (!pq.isEmpty()) {

            // step1 : 신장트리에 포함되지 않은 정점중 minEdge 비용이 최소인 정점 찾기
            Vertex minVertex = pq.poll();
            if (visited[minVertex.no]) continue;

            // step2 : 선택된 정점의 인접정점(신장트리에 포함되지 않은 정점)의 간선비용의 최소값 업데이트
            result += minVertex.weight;
            visited[minVertex.no] = true;
            if (++c == V) break;
            System.out.println(Arrays.toString(minEdge));
            // step3 : 선택된 정점 신장트리에 추가
            for (int i = 0; i < V; i++) {
                if (!visited[i] && adjMatrix[minVertex.no][i] != 0
                        && minEdge[i] > adjMatrix[minVertex.no][i]) {
                    minEdge[i] = adjMatrix[minVertex.no][i];

                    pq.offer(new Vertex(i, minEdge[i]));
                }
            }
        }

        System.out.println(c == V ? result : -1);
    }
}