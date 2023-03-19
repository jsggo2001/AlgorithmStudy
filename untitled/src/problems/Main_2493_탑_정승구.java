package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493_탑_정승구 {

    static Stack<List> first;
    static Stack<List> second;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        first = new Stack<List>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        String temp;
        int count = 1;
        for (int i = 0; i < n; i++) {
            temp = st.nextToken();
            List<Integer> now = new ArrayList<>();
            now.add(Integer.parseInt(temp));
            now.add(i + 1);
            first.push(now);
        }
        second = new Stack<>();
        answer = new int[n + 1];
        second.add(first.pop());

        while (!first.isEmpty()) {
            List<Integer> check = first.pop();
            while (!second.isEmpty()) {
                List<Integer> top = second.pop();
                if (check.get(0) >= top.get(0)) {
                    answer[top.get(1)] = check.get(1);
                } else {
                    second.add(top);
                    break;
                }
            }
            second.add(check);
        }
        int i = 1;
        while (i < answer.length) {
            sb.append(answer[i] + " ");
            i++;
        }
        System.out.println(sb);
    }
}

