package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1541_잃어버린괄호_정승구 {

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String target = br.readLine();
        String[] temp = target.split("-");
        plus(temp[0]);
        for (int i = 1; i < temp.length; i++) {
            minus(temp[i]);
        }
        System.out.println(result);
    }

    private static void plus(String target) {
        String[] temp = target.split("\\+");
        for (int i = 0; i < temp.length; i++) {
            result += Integer.parseInt(temp[i]);
        }
    }
    private static void minus(String target) {
        String[] temp = target.split("\\+");
        for (int i = 0; i < temp.length; i++) {
            result -= Integer.parseInt(temp[i]);
        }
    }

}

