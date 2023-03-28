import java.util.Optional;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        String a = null;
        System.out.println(Optional.ofNullable(a)
                .orElse("??"));
    }

    private static String test(String a) {
        return null;
    }
}
