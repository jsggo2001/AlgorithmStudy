package problems;

import java.util.*;

public class Main_1158_요세푸스문제_정승구 {
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();

        for (int i = 1;i < n + 1; i++) {
            q.add(i);
        }
        System.out.print("<");
        int cnt = n;
        int idx = 0;
        while (cnt > 0) {
            int temp = 0;
            temp = q.poll();
            idx += 1;
            if (idx == k){
                System.out.print(temp);
                idx = 0;
                cnt--;
                if (cnt != 0) System.out.print(", ");
            } else {
                q.add(temp);
            }
        }
        System.out.print(">");
    }

}
