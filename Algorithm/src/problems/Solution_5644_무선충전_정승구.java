package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_5644_무선충전_정승구 {
    static int[][] direction = {{0,0},{-1,0},{0,1},{1,0},{0,-1}};
    static int[] nowA;
    static int[] nowB;
    static int[][] aps;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case < T + 1; test_case++) {
            String[] MA = new String[2];
            MA = br.readLine().split(" ");

            int m = Integer.parseInt(MA[0]);
            int a = Integer.parseInt(MA[1]);

            String[] moveA = br.readLine().split(" ");
            String[] moveB = br.readLine().split(" ");

            aps = new int[a][4];

            for (int i = 0; i < a; i ++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                aps[i][0] = Integer.parseInt(st.nextToken());
                aps[i][1] = Integer.parseInt(st.nextToken());
                aps[i][2] = Integer.parseInt(st.nextToken());
                aps[i][3] = Integer.parseInt(st.nextToken());
            }
            nowA = new int[]{0,0};
            nowB = new int[]{9,9};
            result = 0;

            charge();
            for (int i = 0; i < m; i++) {
                move(nowA,Integer.parseInt(moveA[i]));
                move(nowB,Integer.parseInt(moveB[i]));
                charge();
            }
            System.out.println("#" + test_case + " " + result);
        }
    }
    private static void move(int[] now, int order) {
        now[0] = now[0] + direction[order][0];
        now[1] = now[1] + direction[order][1];
    }
    private static void charge() {
        List<Integer> aCan = checkCharge(nowA);
        List<Integer> bCan = checkCharge(nowB);

        int aSize = aCan.size();
        int bSize = bCan.size();

        if (aSize == 0 && bSize == 0) return ;

        if (aSize >= 1 && bSize == 0) {
            result += aps[aCan.get(0)][3];
            return;
        }
        if (aSize == 0 && bSize >= 1) {
            result += aps[bCan.get(0)][3];
            return;
        }
        if (aSize == 1 && bSize == 1) {
            if (aCan.get(0) == bCan.get(0)) {
                result += aps[aCan.get(0)][3];
            } else {
                result += aps[aCan.get(0)][3];
                result += aps[bCan.get(0)][3];
            }
            return;
        }
        if (aCan.get(0) == bCan.get(0)) {
            if (aSize == 1 && bSize >= 2) {
                result += aps[aCan.get(0)][3];
                result += aps[bCan.get(1)][3];
                return ;
            }
            if (aSize >= 2 && bSize == 1) {
                result += aps[bCan.get(0)][3];
                result += aps[aCan.get(1)][3];
                return ;
            }
            result += aps[aCan.get(0)][3];
            result += Math.max(aps[aCan.get(1)][3], aps[bCan.get(1)][3]);
            return ;
        } else {
            result += aps[aCan.get(0)][3];
            result += aps[bCan.get(0)][3];
        }
    }

    private static List checkCharge(int[] now) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < aps.length; i++) {
            int distance = Math.abs(now[0] - (aps[i][1] - 1)) + Math.abs(now[1] - (aps[i][0] - 1));
            if (distance <= aps[i][2]) {
                list.add(i);
            }
        }
        list.sort((a,b) -> aps[b][3] - aps[a][3]);
        return list;
    }
}
