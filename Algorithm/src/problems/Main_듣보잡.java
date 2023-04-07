package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> noListen = new HashMap<String, String>();
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            noListen.put(temp, temp);
        }

        for (int i = 0; i < m; i++) {
            String temp = br.readLine();
            String now = noListen.get(temp);
            if (now != null) answer.add(now);
        }
        int leng = answer.size();
        answer.sort((a,b) -> a.compareTo(b));
        System.out.println(leng);
        for (int i = 0; i < leng; i++) {
            System.out.println(answer.get(i));
        }


    }
}
