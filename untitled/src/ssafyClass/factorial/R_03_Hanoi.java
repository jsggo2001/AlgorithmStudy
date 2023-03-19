package ssafyClass.factorial;

import java.util.Scanner;

public class R_03_Hanoi {
    public static void hanoi(int cnt, int now, int temp, int target) {
        int tempCnt = cnt;
        if (tempCnt == 0) return;
        hanoi(cnt - 1, now, target, temp);
        System.out.println(now +  " -> " + target);
        hanoi(cnt -1 , temp, now, target);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        hanoi(n,1,2,3);
    }

}
