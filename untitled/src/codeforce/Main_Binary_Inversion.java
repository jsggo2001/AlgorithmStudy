package codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Binary_Inversion {
    static int[] list;
    static long zero;
    static long one;
    static int n;
    static long answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            answer = 0;
            zero = 0;
            one = 0;
            n = Integer.parseInt(br.readLine());
            list = new int[n];
            int temp = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                temp = Integer.parseInt(st.nextToken());
                if (temp == 0) zero++;
                else one++;
                list[i] = temp;
            }
            checkAnswer(zero, one);
//            for (int i = 0; i < n; i++) {
//                int nowOne = one;
//                int nowZero = zero;
//                if (ssafyClass.list[i] == 0) {
//                    ssafyClass.list[i] = 1;
//                    nowZero--;
//                    nowOne++;
//                    checkAnswer(nowZero, nowOne);
//                    ssafyClass.list[i] = 0;
//                } else {
//                    ssafyClass.list[i] = 0;
//                    nowZero++;
//                    nowOne--;
//                    checkAnswer(nowZero,nowOne);
//                    ssafyClass.list[i] = 1;
//                }
            int cnt = 0;
            while(cnt < n) {
                if (list[cnt] == 0) {
                    list[cnt] = 1;
                    checkAnswer(zero - 1, one + 1);
                    list[cnt] = 0;
                    break;
                }
                cnt++;
            }
            cnt = n-1;
            while(cnt >= 0) {
                if (list[cnt] == 1) {
                    list[cnt] = 0;
                    checkAnswer(zero + 1, one - 1);
                    list[cnt] = 1;
                    break;
                }
                cnt--;
            }
            sb.append(answer + "\n");
        }
        System.out.println(sb);
    }

    private static void checkAnswer(long zero, long one) {
        long result = 0;
        for (int i = 0; i < n; i++) {
            if (list[i] == 0) {
                zero--;
            } else {
                result += zero;
                one--;
                if (one == 0) break;
            }
        }
        answer = Math.max(answer, result);
    }
}
