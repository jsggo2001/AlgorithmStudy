import java.util.Scanner;

public class Main {
    static int a,b;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();

        if (a < b) System.out.println("<");
        else if (a > b) System.out.println(">");
        else if (a == b) System.out.println("==");
    }
}