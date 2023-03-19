package problems;

import java.util.*;

import org.w3c.dom.Node;

public class Main_13023_ABCDE_정승구 {

    static ArrayList<Integer>[] adjList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        adjList = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<Integer>();
        }

        int from, to;
        for (int i = 0; i < E; ++i) {
            from = sc.nextInt();
            to = sc.nextInt();

            adjList[from].add(to);
            adjList[to].add(from);
        }
        for(int i = 0; i < V; i++) {
            boolean[] visited = new boolean[V];
            if (solve(i, 0, visited) == true) {
                System.out.println(1);
                return ;
            }
        }
        System.out.println(0);
    }

    static boolean solve(int n, int cnt, boolean[] visited) {
        if (cnt == 4) return true;

        visited[n] = true;
        List<Integer> nowList = adjList[n];
        for (int i = 0; i < nowList.size(); i++) {
            int nowNode = nowList.get(i);
            if (visited[nowNode] != true) {
                visited[nowNode] = true;
                if(solve(nowNode,cnt + 1, visited) == true) return true;
                visited[nowNode] = false;
            }
        }
        return false;
    }
}
