package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import java.util.StringTokenizer;

public class Solution_1228_암호문1_정승구 {
    static List<Integer> target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());

            target = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            target.add(0);

            for (int i = 0; i < n; i++) {
                target.add(Integer.parseInt(st.nextToken()));
            }

            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "I");
            for (int i = 0; i < m; i++) {
                StringTokenizer innerSt = new StringTokenizer(st.nextToken(), " ");
                int innerN = Integer.parseInt(innerSt.nextToken());
                int innerM = Integer.parseInt(innerSt.nextToken());
                List<Integer> temp = new ArrayList<>();
                temp.add(0);
                for (int j = 1; j <= innerN; j++) {
                    temp.add(target.get(1));
                    target.remove(1);
                }
                for (int j = 0; j < innerM; j++) {
                    temp.add(Integer.parseInt(innerSt.nextToken()));
                }
                for (int j = 1; j < target.size(); j++) {
                    temp.add(target.get(j));
                }
                target = temp;
            }
            System.out.print("#" + test_case + " ");
            for (int i = 1; i < 11; i++) {
                System.out.print(target.get(i) + " ");
            }
            System.out.println();
        }
    }
}
