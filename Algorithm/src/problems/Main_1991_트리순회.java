package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1991_트리순회 {
    static int n;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[200][3];
        char[] st;
        for (int i = 0; i < n; i++) {
            st = br.readLine().toCharArray();
            int start = st[0];
            int left = st[2];
            int right = st[4];
            graph[start][0] = left;
            graph[left][2] = start;
            graph[start][1] = right;
            graph[right][2] = start;

        }
        front('A');
        System.out.println();
        middle('A');
        System.out.println();
        after('A');
    }

    private static void after(char now) {
        char left = (char)graph[now][0];
        char right = (char)graph[now][1];
        if (left != '.' && left != 0) {
            after(left);
        }
        if (right != '.' && right != 0) {
            after(right);
        }
        System.out.print(now);
    }

    private static void front(char now) {
        char left = (char)graph[now][0];
        char right = (char)graph[now][1];
        System.out.print(now);
        if (left != '.' && left != 0) {
            front(left);
        }
        if (right != '.' && right != 0) {
            front(right);
        }
    }

    private static void middle(char now) {
        char left = (char) graph[now][0];
        char right = (char) graph[now][1];
        if (left != '.' && left != 0) {
            middle(left);
        }
        System.out.print(now);
        if (right != '.' && right != 0) {
            middle(right);
        }
    }
}
