package codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_Atillas_Favorite_Problem {
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int testC = 0; testC < T; testC++) {
            check = new boolean[27];
            int n = Integer.parseInt(br.readLine());
            char[] target = br.readLine().toCharArray();
            for (int i = 0; i < n;i++) {
                int temp = target[i] - 'a' + 1;
                check[temp] = true;
            }
            int num = 0;
            for (int i = 0; i < 27; i++) {
                if (check[i] == true) {
                    num = i;
                }
            }
            System.out.println(num);
        }
    }
}
