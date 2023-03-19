package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17471_게리멘더링_정승구 {
    static int n;
    static int[] population;
    static int[] parents;
    static List<Edge> edgeList;
    static int result = (int) 1e9;

    static class Edge {
        int from, to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        population = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        edgeList = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());

            for (int j = 0; j < length; j++) {
                int to = Integer.parseInt(st.nextToken());
                edgeList.add(new Edge(i,to));
            }
        }
        for (int i = 1; i < 1<<n; i++) {
            List<Integer> team1 = new ArrayList<>();
            List<Integer> team2 = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1<<j)) > 0) {
                    team1.add(j + 1);
                } else {
                    team2.add(j + 1);
                }
            }
            int one = teamCheck(team1);
            int two = teamCheck(team2);
            if (one >= 0 && two >= 0) {
                result = Math.min(result, Math.abs(one - two));
            }

        }

        if (result == (int) 1e9){
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    static int teamCheck(List<Integer> team) {
        makeSet();
        if (team.size() == 0) return -1;
        for (int i = 0; i < edgeList.size(); i++) {
            Edge now = edgeList.get(i);
            int from = now.from;
            int to = now.to;
            if (team.contains(from) && team.contains(to)) {
                union(from,to);
            }
        }
        int teamNum = findSet(team.get(0));
        int result = population[team.get(0)];
        for (int i = 1; i < team.size(); i++) {
            if (teamNum == findSet(team.get(i))) {
                result += population[team.get(i)];
            } else {
                return -1;
            }
        }
        return result;
    }

    static void makeSet() {
        parents = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parents[i] = i;
        }
    }

    static int findSet(int a) {
        if (parents[a] == a) return a;
        return parents[a] = findSet(parents[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }
}