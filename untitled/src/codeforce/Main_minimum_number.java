package codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_minimum_number {
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int testC = 0; testC < T; testC++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            check = new boolean[21];
            for (int i = 0; i < 3;i++) {
                int temp = Integer.parseInt(st.nextToken());
                check[temp] = true;
            }
            int num = 0;
            for (int i = 0; i < 21; i++) {
                if (check[i] == true) {
                    num++;
                    if (num == 2) {
                        System.out.println(i);
                        break;
                    }
                }
            }
        }
    }
}
