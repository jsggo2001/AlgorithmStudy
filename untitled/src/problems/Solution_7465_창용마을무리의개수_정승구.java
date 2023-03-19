package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_7465_창용마을무리의개수_정승구 {

    static int[] parents;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case < T + 1; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            makeParents();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            List<Integer> check = new ArrayList<>();
            int cnt = 0;
            for (int i = 1; i < parents.length; i++) {
                int parent = findSet(i);
                if (!check.contains(parents[i])) {
                    check.add(parents[i]);
                    cnt++;
                }
            }
            System.out.println("#" + test_case + " " + cnt);
        }
    }

    static private void makeParents() {
        parents = new int[n + 1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
    }

    private static int findSet(int i) {
        if (parents[i] == i) return i;
        else return parents[i] = findSet(parents[i]);
    }

    static private boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }
}
