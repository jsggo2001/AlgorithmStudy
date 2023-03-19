package ssafyClass.permutationCombination;

import java.util.Arrays;
import java.util.Scanner;

public class Ex_DiceTest {
    // 입력으로 주사위 던지기 모드를 받는다.(1,2,3,4)
    // 던지는 주사위 수도 입력 받는다.(1 <= N <= 10)

    static int N; // 던지는 주사위 수
    static int[] numbers;
    static int totalCnt;
    static boolean[] isSelected;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mode = sc.nextInt();
        N = sc.nextInt();

        numbers = new int[N];

        switch (mode) {
            case 1: // 중복 순열
                dice1(0);
                break;
            case 2: // 순열
                isSelected = new boolean[7]; // 자동초기화 : false
                dice2(0);
                break;
            case 3:
                dice3(0,1);
                break;
            case 4:
                dice4(0,1);
                break;
        }
        System.out.println("총경우의 수 : " + totalCnt);
    }

    private static void dice1(int cnt) { // cnt: 기존까지 던져진 주사위 수 --> 현재 주사위의 수를 기록하기 위한 인덱스로 사용
        if (cnt == N) {
            System.out.println(Arrays.toString(numbers));
            totalCnt++;
            return;
        }
        // 주사위릐 눈은 1-6의 경우가 있음
        for (int i = 0; i <= 6; i++) {
            numbers[cnt] = i;
            // 다음 주사위 던지러 가기
            dice1(cnt + 1);
        }
    }
    private static void dice2(int cnt) { // cnt: 기존까지 던져진 주사위 수 --> 현재 주사위의 수를 기록하기 위한 인덱스로 사용
        if (cnt == N) {
            System.out.println(Arrays.toString(numbers));
            totalCnt++;
            return;
        }
        // 주사위의 눈은 1-6의 경우가 있음
        for (int i = 0; i <= 6; i++) {
            if (isSelected[i]) continue;
            numbers[cnt] = i;
            isSelected[i] = true;
            // 다음 주사위 던지러 가기
            dice2(cnt + 1);
            isSelected[i] = false;
        }
    }

    private static void dice3(int cnt, int start) {

        if (cnt == N) {
            System.out.println(Arrays.toString(numbers));
            totalCnt++;
            return;
        }

        for (int i = start; i <= 6; i++) {
            numbers[cnt] = i;
            dice3(cnt + 1, i);
        }
    }

    private static void dice4(int cnt, int start) {

        if (cnt == 3) {
            System.out.println(Arrays.toString(numbers));
            totalCnt++;
            return;
        }

        for (int i = start; i <= 6; i++) {
            numbers[cnt] = i;
            dice4(cnt + 1, i + 1);
        }
    }
}
