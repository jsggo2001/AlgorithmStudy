package problems;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main_크면서작은수 {
    static int n = 0;
    static List<Integer> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.nextLine();
        String[] target = first.split("");
        list = Arrays.stream(target).map(a -> Integer.parseInt(a)).collect(Collectors.toList());
        n = list.size();
        np();
        String answer = list.stream().map(String::valueOf).reduce("",(a, b) -> a + b);

        if (first.equals(answer)) System.out.println("0");
        else System.out.println(answer);
    }
    private static void np() {

        int i = n-1;
        while(i>0 && list.get(i)<=list.get(i-1)) --i;
        if (i == 0) return;
        int j = n - 1;
        while(list.get(i - 1)>=list.get(j)) --j;
        swap(i-1,j);
        int k = n - 1;

        while(i < k) swap(i++, k--);

    }

    private static void swap(int i, int j) {
        int temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }
}


