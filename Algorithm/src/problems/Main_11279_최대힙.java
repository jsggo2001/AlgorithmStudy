package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_11279_최대힙 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b - a);
        int n = Integer.parseInt(br.readLine());
        int target;
        for (int i = 0; i < n; i++) {
            target = Integer.parseInt(br.readLine());
            if (target == 0) {
                if (q.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(q.poll() + "\n");
                }
            } else {
                q.offer(target);
            }
        }
        System.out.println(sb);
    }
}
