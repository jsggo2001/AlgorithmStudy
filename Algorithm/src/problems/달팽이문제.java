package problems;

import java.util.Arrays;
import java.util.Scanner;
public class 달팽이문제
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=Integer.parseInt(sc.nextLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(sc.nextLine());

            int[][] ans = new int[N + 2][N + 2];
            for (int i = 0; i < N + 2; i++) {
                ans[0][i] = 200;
                ans[i][0] = 200;
                ans[N + 1][i] = 200;
                ans[i][N + 1] = 200;
            }
            for (int[] line: ans) {
                System.out.println(Arrays.toString(line));
            }

            int[] directionx = {0,-1,0,1};
            int[] directiony = {1,0,-1,0};

            int nowx = 0;
            int nowy = 0;
            int direction = 0;
            int prex = 1;
            int prey = 0;
            for (int i = 1; i <= N*N; i++) {
                nowx = prex + directionx[direction];
                nowy = prey + directiony[direction];
                if (ans[nowx][nowy] == 0) {
                    ans[nowx][nowy] = i;
                } else {
                    direction = (direction + 1) % 4;
                    i--;
                    continue;
                }
                prex = nowx;
                prey = nowy;
            }
            System.out.println("#" + test_case);
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}