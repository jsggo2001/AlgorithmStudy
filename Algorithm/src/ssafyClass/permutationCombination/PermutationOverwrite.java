package ssafyClass.permutationCombination;

import java.util.Arrays;

public class PermutationOverwrite {
    public static int [] output;
    public static int n, r;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        n = 4;
        r = 4;
        output = new int[r];
        perm(0);
        System.out.println(sb);
    }
    public static void permTail(int cnt) {
        if (cnt == r) {
            sb.append(Arrays.toString(output) + "\n");
            return;
        }
        for (int i = 1; i < n + 1; i++) {
            output[cnt] = i;
            perm(cnt + 1);
        }
    }

    public static void perm(int cnt) {
        if (cnt == r) {
            sb.append(Arrays.toString(output) + "\n");
            return;
        }
        for (int i = 1; i < n + 1; i++) {
            output[cnt] = i;
            perm(cnt + 1);
        }
    }

}
