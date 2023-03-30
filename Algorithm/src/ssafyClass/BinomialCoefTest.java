package ssafyClass;

import java.util.Scanner;

// 이항 계수 구하기, 파스칼의 삼각형
public class BinomialCoefTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] B = new int[N+1][K+1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0,end = Math.min(i,K);j <= end; j++) {
                if(j == 0 || i == j) B[i][j] = 1;
                else B[i][j] = B[i-1][j-1] + B[i-1][j];
            }
        }
        System.out.println(B[N][K]);
    }
}

/*
4 2
answer : 6
 */