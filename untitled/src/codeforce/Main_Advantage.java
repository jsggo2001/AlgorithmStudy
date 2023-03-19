package codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Advantage {
    static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int testC = 0; testC < T; testC++) {
            int n = Integer.parseInt(br.readLine());
            list = new int[n];
            int max = 0;
            int sec = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n;i++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp > max) {
                    sec = max;
                    max = temp;
                } else if (temp > sec) {
                    sec = temp;
                }
                list[i] = temp;
            }
            for (int i = 0; i < n; i++) {
                if (list[i] != max) {
                    System.out.print((list[i] - max) + " ");
                } else {
                    System.out.print((max - sec) + " ");
                }
            }
            System.out.println();
        }
    }
}
