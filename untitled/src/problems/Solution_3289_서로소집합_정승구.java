package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합_정승구 {

    static int[] parents;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case < T + 1; test_case++) {
            System.out.print("#" + test_case + " ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            makeParents();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                String order = st.nextToken();
                if (order.equals("0")) {
                    union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                } else if (order.equals("1")) {
                    if (findSet(Integer.parseInt(st.nextToken()))
                            == findSet(Integer.parseInt(st.nextToken()))) {
                        System.out.print("1");
                    } else {
                        System.out.print("0");
                    }
                }
            }
            System.out.println();
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
