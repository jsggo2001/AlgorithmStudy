package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_3040_백설공주와일곱난쟁이_정승구 {

    static List<Integer> list;
    static int sum;
    static List<Integer> result;
    static List<Integer> temp;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        list = new ArrayList<>();
        for (int i = 0; i < 9; i++) list.add(sc.nextInt());

        visited = new boolean[9];
        result = new ArrayList<>();
        temp = new ArrayList<>();
        perm(0);

        for (int i = 6; i >= 0; i--) {
            System.out.println(result.get(i));
        }
    }

    public static void perm(int cnt) {
        if (cnt == 7) {
            int value = 0;
            for (int val : temp) {
                value += val;
            }
            if (value == 100) result = new ArrayList<>(temp);
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (visited[i]) continue;
            temp.add(list.get(i));
            visited[i] = true;
            perm(cnt + 1);
            visited[i] = false;
            temp.remove(temp.size()-1);
        }
    }
}
