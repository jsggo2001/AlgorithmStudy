package ssafyClass.permutationCombination;

import java.util.Scanner;

public class Permutation {
    public static boolean [] visited;
    public static int [] output;
    public static int n, r;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          String[] input = sc.nextLine().split(" ");
             n = Integer.parseInt(input[0]);
             r = Integer.parseInt(input[1]);
             output = new int[r];
             visited = new boolean[n+1];
          perm(0);

        System.out.print(sb);
    }
    public static void perm(int cnt) {
        if (cnt == r) {
            for (int i = 0;i < r; i++)
                sb.append(output[i] + " ");
            sb.append("\n");
            return;
        }
        for (int i = 1; i < n + 1; i++) {
            if (visited[i]) continue;
            output[cnt] = i;
            visited[i] = true;
            perm(cnt + 1);
            visited[i] = false;
        }
    }
}
