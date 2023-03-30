import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            boolean result = false;
            if (a + b == c) result = true;
            if (Math.abs(a - b) == c) result = true;
            if (result) {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }

    }
}


/*
7
1 4 3
2 5 8
9 11 20
0 0 0
20 20 20
4 12 3
15 7 8

 */