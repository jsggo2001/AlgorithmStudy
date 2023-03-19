package ssafyClass.permutationProcessed;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    public static void main(String[] args) {
        List<BigDecimal> list = new ArrayList<>();
        BigDecimal a = new BigDecimal(10);
        list.add(a);
        List<String> strings = new ArrayList<>();
        strings.add("asd");

        System.out.println(test(list));
        System.out.println(test(strings));

        System.out.println(list);
    }

    static <T> T test(List<T> list) {
        T a = list.get(0);
        return a;
    }
}
