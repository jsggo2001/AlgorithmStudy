package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4014_활주로건설_정승구 {
    static int[][] map;
    static int answer;
    static int n, x;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t < T + 1; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            answer = 0;
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());

            map = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                checkRight(i);
                checkDown(i);
            }
            sb.append("#" + t + " " + answer + "\n");
        }
        System.out.println(sb);
    }

    private static void checkRight(int i) {
        int flag = 0;
        int pre = map[i][0];
        int cnt = 1;
        for (int j = 1; j < n; j++) {
            if (pre == map[i][j]) {
                cnt++;
                if (flag == 1 && cnt == x) {
                    flag = 0;
                    cnt = 0;
                }
            } else {
                if (Math.abs(pre - map[i][j]) > 1) {
                    return;
                } else {
                    if (pre > map[i][j]) {
                        if (flag == 1 && cnt < x) return;
                        cnt = 1;
                        flag = 1;
                        pre = map[i][j];
                    } else if (pre < map[i][j]) {
                        if (cnt < x) {
                            return;
                        } else {
                            pre = map[i][j];
                            cnt = 1;
                        }
                    }
                }
            }
        }
        if (flag == 0) {
            answer++;
        }
        if (flag == 1 && cnt > x) {
            answer++;
        }
    }

    private static void checkDown(int i) {
        int flag = 0;
        int pre = map[0][i];
        int cnt = 1;
        for (int j = 1; j < n; j++) {
            if (pre == map[j][i]) {
                cnt++;
                if (flag == 1 && cnt == x) {
                    flag = 0;
                    cnt = 0;
                }
            } else {
                if (Math.abs(pre - map[j][i]) > 1) {
                    return;
                } else {
                    if (pre > map[j][i]) {
                        if (flag == 1 && cnt < x) return;
                        cnt = 1;
                        flag = 1;
                        pre = map[j][i];
                    } else if (pre < map[j][i]) {
                        if (cnt < x) {
                            return;
                        } else {
                            pre = map[j][i];
                            cnt = 1;
                        }
                    }
                }
            }
        }
        if (flag == 0) {
            answer++;
        }
        if (flag == 1 && cnt > x) {
            answer++;
        }
    }


}

/*
6 2
3 3 3 2 1 1
3 3 3 2 2 1
3 3 3 3 3 2
2 2 3 2 2 2
2 2 3 2 2 2
2 2 2 2 2 2
 */