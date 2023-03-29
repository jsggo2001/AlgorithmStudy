import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    static int n;
    static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        System.out.println(Arrays.toString(list));
        System.out.println(getLower() + " " + getUpper());
    }

    private static int getUpper() {
        int result = 0;
        int start = 0;
        int end = n;
        int mid = 0;
        while (start < end) {
            mid = (start + end) / 2;

            if (0 >= list[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        result = list[start];
        return result;
    }

    private static int getLower() {
        int result = 0;
        int start = 0;
        int end = n;
        int mid = 0;
        while (start < end) {
            mid = (start + end) / 2;

            if (0 <= list[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        result = list[start];
        return result;
    }
}

/*
5
-2 4 -99 -1 98
 */