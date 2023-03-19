package ssafyClass.factorial;

import java.util.Collections;
import java.util.Scanner;
import java.util.stream.IntStream;

public class R_01_FactorialTest {
    private static int factorial(int n){
        int res = 1;

        for(int i = n; i > 0; --i) {
            res *= i;
        }
        return res;
    }

    private static int result = 1;
    private static void factorial2(int n) {

        if (n <= 0) return ;
        result *= n;
        factorial2(n-1); // 후행 재귀 반복문으로 바꿀 수 있다.
    }

    private static int factorial3(int n) {
        if (n <= 1) return 1;
        return n * factorial3(n - 1); // 선행 재귀 리턴값 활용 반복문 활용 어려움
    }

    public static int factorialByStream(int n) {
        return IntStream.rangeClosed(1, n)
                .boxed()
                .sorted(Collections.reverseOrder())
                .reduce((a,b) -> a * b)
                .get();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(factorialByStream(n));
        factorial2(n);
        System.out.println(result);
        System.out.println(factorial3(n));
    }
}
