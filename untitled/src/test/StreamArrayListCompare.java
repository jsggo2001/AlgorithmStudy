package test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class StreamArrayListCompare {
    public static void main(String[] args) {
        int maxlen = 10000000;


        long time = System.nanoTime();
        IntStream stream = IntStream.rangeClosed(1, maxlen);
        int max1 = stream.max().getAsInt();
        System.out.println("Stream : " + (System.nanoTime() - time) + " max : " + max1);

        long time2 = System.nanoTime();
        Integer[] arr = new Integer[maxlen];
        for (int i = 0; i < maxlen; i++) {
            arr[i] = i + 1;
        }
        int max = 0;
        for (int i = 0;i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("array  : " + (System.nanoTime() - time2) + " max : " + max);

        long time3 = System.nanoTime();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= maxlen; i ++) {
            list.add(i);
        }
        int max4 = 0;
        for (int i = 0;i < list.size(); i++) {
            if (list.get(i) > max4) {
                max4 = list.get(i);
            }
        }
        System.out.println("ssafyClass.list   : " + (System.nanoTime() - time3) + "  max : " + max4);
        System.out.println(list.getClass().getName());
    }
}