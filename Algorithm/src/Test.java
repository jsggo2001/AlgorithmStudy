import java.util.Optional;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {

        char a = 'a';
        char A = 'A';
        char f = 'f';

        System.out.println((int)a);
        System.out.println((int)A);


        int bit = 1<<1;
        bit = bit | 1<<2;
        bit = bit | 1<<3;
        bit = bit | 1<<5;
        System.out.println(1<<6);
        System.out.println(bit & 1<<5);

        System.out.println((int)f);
    }
}
