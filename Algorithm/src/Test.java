import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.offer(5);
        int a = q.peek();
        System.out.println(a);
    }
}
