package ssafyClass.permutationProcessed;

import java.util.Scanner;

public class ByBitMasking {
    public static boolean [] visited;
    public static int [] numbers;
    public static int n, r;
    public static int[] inputs;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        n = Integer.parseInt(input[0]);
        r = Integer.parseInt(input[1]);


        numbers = new int[r];
        inputs = new int[n];

        for (int i =0; i < n; i++) {
            inputs[i] = sc.nextInt();
        }

        perm(0, 0);

        System.out.print(sb);
    }
    public static void perm(int cnt, int flag) {
        if (cnt == r) {
            for (int i = 0;i < r; i++)
                sb.append(numbers[i] + " ");
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if ((flag & (1<<i)) != 0) continue;
            numbers[cnt] = inputs[i];
            perm(cnt + 1, flag | (1<<i));
        }
    }
}


