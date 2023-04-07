import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2042_구간합구하기_정승구 {
    static int n, m, k;
    static long[] list;
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        list = new long[n + 1];
        tree = new long[n + 1];

        for (int i = 1; i < n + 1; i++) {
            long val = Long.parseLong(br.readLine());
            change(i,val);
            list[i] = val;
        }

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                change(b, c);
            } else if (a == 2) {
                getSum(b - 1, c);
            }
        }
    }

    private static void getSum(long longstart, long longend) {
        int start = (int) longstart;
        int end = (int) longend;
        long result = 0;
        int i = end;
        while (i >= 1) {
            result += tree[i];
            i = i - (i & - i);
        }
        i = start;
        while (i >= 1) {
            result -= tree[i];
            i = i - (i & - i);
        }
        System.out.println(result);
    }

    private static void change(long longtarget, long toNum) {
        int target = (int)longtarget;
        long differ = toNum - list[target];
        list[target] = toNum;
        int i = target;
        while (i <= n) {
            tree[i] += differ;
            i = i + (i & -i);
        }
    }
}
