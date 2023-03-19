package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_16435_스네이크버드_정승구 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        list.sort((a, b) -> a - b);

        for (int i = 0; i < list.size(); i++) {
            if (l > list.get(i) || l == list.get(i)) {
                l++;
            }
        }
        System.out.println(l);

    }
}
