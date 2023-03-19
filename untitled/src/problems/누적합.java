package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 누적합 {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[][] array = new int[N + 1][N + 1];
        for (int j = 1; j < N + 1; j ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; i++) {
                array[j][i] = array[j][i - 1] + array[j - 1][i] - array[j - 1][i - 1] + Integer.parseInt(st.nextToken());
            }
        }

        int row1;
        int column1;
        int row2;
        int column2;
        for(int i = 0; i < M; i++) {
            String[] startEnd = br.readLine().split(" ");
            row1 = Integer.parseInt(startEnd[0]);
            column1 = Integer.parseInt(startEnd[1]);
            row2 = Integer.parseInt(startEnd[2]);
            column2 = Integer.parseInt(startEnd[3]);
            int result = 0;
            result = array[row2][column2] + array[row1 - 1][column1 - 1] - array[row1 - 1][column2] - array[row2][column1 - 1];
            sb.append(result + "\n");
        }
        System.out.print(sb);
    }
}
/*
4 3
1 2 3 4
2 3 4 5
3 4 5 6
4 5 6 7
2 2 3 4
3 4 3 4
1 1 4 4
 */