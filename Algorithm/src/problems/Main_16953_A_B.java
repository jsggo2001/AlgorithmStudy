package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16953_A_B {

    static int a, b;
    static int result = -1;
    static Queue<long[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        q = new LinkedList<>();

        q.offer(new long[]{a,1});

        while(!q.isEmpty()) {
            long[] temp = q.poll();
            long now = temp[0];
            int cnt = (int)temp[1];

            if (now > b) continue;
//            q.stream().forEach(a -> System.out.print(Arrays.toString(a) + "//"));
//            System.out.println();
            if (now == b) {
                result = cnt;
                break;
            }

            q.offer(new long[]{now * 2, cnt + 1});
            q.offer(new long[]{now * 10 + 1, cnt + 1});
        }
        System.out.println(result);
    }
}
