import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2470_두용액_투포인터 {
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int small = 0;
        int big = 0;
        int i = 0;
        int j = n - 1;
        int val = Math.abs(list[i] + list[j]);
        int sum;
        while (i < j) {
            sum = list[i] + list[j];
            int temp = Math.abs(list[i] + list[j]);
            if (temp < val) {
                small = i;
                big = j;
            }
            if (sum > 0) {
                i++;
            } else {
                j--;
            }

        }
        System.out.println(list[small] + " " + list[big]);
    }
}
