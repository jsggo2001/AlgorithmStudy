import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, total;
    static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        total = Integer.parseInt(br.readLine());

        int start = 0;
        int end = total;
        int mid = 0;
        while (start < end) {
            mid = (start + end) / 2;
            if (checkMid(mid) > total) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(start);
    }

    private static int checkMid(int mid) {
        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp += Math.min(mid , list[i]);
            if (mid < list[i])
                return -1;
        }
        System.out.println(temp);
        return temp;
    }
}
