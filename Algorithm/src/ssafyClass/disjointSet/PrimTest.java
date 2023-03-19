package ssafyClass.disjointSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrimTest {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(in.readLine());
        int[][] adjMatrix = new int[V][V];
        boolean[] visited = new boolean[V];

        int[] minEdge = new int[V];
        StringTokenizer st = null;
        for(int i = 0; i < V; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < V; j++) {
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
            minEdge[i] = Integer.MAX_VALUE;
        }
        int result = 0; //MST비용

        // 임의의 정점을 시작 정점으로 사용하기 위한 처리
        minEdge[0] = 0;
        int c = 0;
        // V개의 정점을 모두 선택하면 신장트리 완성
        for (c = 0; c < V; c++) {

            // step1 : 신장트리에 포함되지 않은 정점중 minEdge 비용이 최소인 정점 찾기
            int min = Integer.MAX_VALUE;
            int minVertex = -1;
            for (int i = 0; i < V; i++) {
                if (!visited[i] && min > minEdge[i]) {
                    min = minEdge[i];
                    minVertex = i;
                }
            }
            if (minVertex == -1) break;

            // step2 : 선택된 정점의 인접정점(신장트리에 포함되지 않은 정점)의 간선비용의 최소값 업데이트
            result += min;
            visited[minVertex] = true;

            // step3 : 선택된 정점 신장트리에 추가
            for (int i = 0; i < V; i++) {
                if(!visited[i] && adjMatrix[minVertex][i] != 0
                        && minEdge[i] > adjMatrix[minVertex][i]) {
                    minEdge[i] = adjMatrix[minVertex][i];
                }
            }
        }
        System.out.println(c==V?result:-1);
    }
}
