package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17135_캐슬디펜스_정승구 {
    static int n, m, d;
    static String[][] map;
    static int[] p;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new String[n][];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split(" ");
        }

        p = new int[m];
        for (int i = m - 1; i > m - 4; i--) {
            p[i] = 1;
        }
        int maxResult = 0;
        do {
            System.out.println(Arrays.toString(p));
            result = 0;
            String[][] temp = copy(map);
            for (int i = 0; i < n + 1; i++) {
                kill();
                moveEnemy();
            }
            map = temp;
            maxResult = Math.max(maxResult, result);
        } while (np(p));
        System.out.println(maxResult);
    }


    private static void moveEnemy() {
        for(int i = n - 1; i > 0; i--) {
            map[i] = map[i - 1];
        }
        String[] first = new String[m];
        for (int j = 0; j < m; j++) {
            first[j] = "0";
        }
        map[0] = first;
    }
    private static boolean np(int[] p) {
        int i = p.length - 1;
        while (i > 0 && p[i - 1] >= p[i]) --i;
        if (i == 0) return false;
        int j = p.length - 1;
        while (p[i - 1] >= p[j]) --j;
        swap(i - 1, j, p);
        int k = p.length - 1;
        while (i < k) swap(i++, k--, p);
        return true;
    }
    private static void swap(int i, int j, int[] input) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    private static void kill() {
        List<List<Integer>> list = new ArrayList<>();
        for (int j = p.length - 1; j >= 0; j--) {
            if (p[j] == 1) {
                List<Integer> enemy = findTarget(j);
                if (enemy != null) list.add(enemy);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (map[list.get(i).get(0)][list.get(i).get(1)].equals("1")) {
                result++;
                map[list.get(i).get(0)][list.get(i).get(1)] = "0";
            }
        }
    }

    private static List<Integer> findTarget(int j) {
        int bowX = n;
        int bowY = j;
        int minDistance = (int)1e9;
        int nowTargetX = 20;
        int nowTargetY = 20;
        int length = n - 1 - d;
        if (length < 0) {
            length = -1;
        }
        for (int i = n - 1; i > length; i--) {
            for (int k = 0; k < m; k++) {
                if (map[i][k].equals("1")) {
                    int nowDistance = Math.abs(bowX - i) +
                            Math.abs(bowY - k);
                    if (nowDistance > d) continue;
                    if (nowDistance < minDistance) {
                        minDistance = nowDistance;
                        nowTargetX = i;
                        nowTargetY = k;
                    } else if (nowDistance == minDistance && k <= nowTargetY) {
                        nowTargetX = i;
                        nowTargetY = k;
                    }
                }
            }
        }
        if (nowTargetX == 20) return null;
        return Arrays.asList(nowTargetX,nowTargetY);
    }

    public static String[][] copy(String[][] src) {
        if (src == null) {
            return null;
        }

        String[][] copy = new String[src.length][];

        for (int i = 0; i < src.length; i++) {
            copy[i] = new String[src[i].length];
            copy[i] = Arrays.copyOf(src[i], src[i].length);
        }

        return copy;
    }
}
