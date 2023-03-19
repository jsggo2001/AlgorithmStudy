package ssafyClass.disjointSet;

import java.util.Arrays;

public class DisjointSet {
    static int N;
    static int[] parents;

    static void makeSet() {
        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = -1;
        }
    }

    static int findSet(int a) {
//        if (a == parents[a]) return a;
        if (parents[a] < 0) return a;
        return parents[a] = findSet(parents[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return false;

        parents[aRoot] += parents[bRoot];
        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) {
        N = 5;
        makeSet();

        System.out.println(Arrays.toString(parents));
        System.out.println(union(0,1));
        System.out.println(Arrays.toString(parents));
        System.out.println(union(2,1));
        System.out.println(Arrays.toString(parents));
        System.out.println(union(3,2));
        System.out.println(Arrays.toString(parents));
        System.out.println(union(4,3));
        System.out.println(Arrays.toString(parents));

        for (int i = 0; i < 4; i++) {
            System.out.println(findSet(i));
            System.out.println(Arrays.toString(parents));
        }
    }
}
