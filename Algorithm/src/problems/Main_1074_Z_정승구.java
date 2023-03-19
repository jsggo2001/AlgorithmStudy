package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1074_Z_정승구 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        int add = (int) Math.pow(2,n) * (int) Math.pow(2,n);
        int half = (int) Math.pow(2,n);

        for (int i = 0; i < n; i++) {
            add = add / 4;
            half = half / 2;

            if (r < half && c < half) {
                list.add(add * 0);
            } else if (r < half && c >= half) {
                list.add(add * 1);
                c = c - half;
            } else if (r >= half && c < half) {
                list.add(add * 2);
                r = r - half;
            } else {
                list.add(add * 3);
                r = r - half;
                c = c - half;
            }
        }
        int result = 0;
        for (int a : list) {
            result += a;
        }
        System.out.println(result);
    }
}
