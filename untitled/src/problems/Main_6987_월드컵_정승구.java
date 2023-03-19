package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6987_월드컵_정승구 {

    static int[][] scores;
    static int[] game1 = {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
    static int[] game2 = {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
    static boolean result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            scores = new int[6][3];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 18; j++) {
                scores[j / 3][j % 3] = Integer.parseInt(st.nextToken());
            }
            result = false;
            if (fiveCheck()) {
                solution(0);
            }
            if (result == true) System.out.print("1 ");
            else System.out.print("0 ");
        }
    }

    private static void solution(int cnt) {
        if (cnt == 15) {
            result = true;
            return ;
        }

        int now = game1[cnt];
        int target = game2[cnt];

        if (scores[now][0] > 0 && scores[target][2] > 0) {
            scores[now][0]--;
            scores[target][2]--;
            solution(cnt + 1);
            scores[now][0]++;
            scores[target][2]++;

        }
        if (scores[now][2] > 0 && scores[target][0] > 0) {
            scores[now][2]--;
            scores[target][0]--;
            solution(cnt + 1);
            scores[now][2]++;
            scores[target][0]++;

        }
        if (scores[now][1] > 0 && scores[target][1] > 0) {
            scores[now][1]--;
            scores[target][1]--;
            solution(cnt + 1);
            scores[now][1]++;
            scores[target][1]++;
        }
    }

    private static boolean fiveCheck() {
        for (int i = 0; i < 6; i++) {
            if (scores[i][0] + scores[i][1] + scores[i][2] != 5)
                return false;
        }
        return true;
    }
}


/*
5 0 0 3 0 2 2 0 3 0 0 5 4 0 1 1 0 4
4 1 0 3 0 2 4 1 0 1 1 3 0 0 5 1 1 3
5 0 0 4 0 1 2 2 1 2 0 3 1 0 4 0 0 5
5 0 0 3 1 1 2 1 2 2 0 3 0 0 5 1 0 4
 */

/*
3 1 1 1 0 4 1 1 3 3 0 2 3 0 2 3 0 2
3 1 1 1 0 4 1 1 3 3 0 2 3 0 2 3 0 2
3 1 1 1 0 4 1 1 3 3 0 2 3 0 2 3 0 2
3 1 1 1 0 4 1 1 3 3 0 2 3 0 2 3 0 2
 */