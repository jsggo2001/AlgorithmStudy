package ssafyClass.factorial;

public class R_02_ArrayTest {

    static int arr[] = {1,2,3};

    private static void printArray(int n) {
        if (n >= arr.length) {
            System.out.println();
            return;
        }
        System.out.print(arr[n] + "\t");
        printArray(n + 1);
    }

    private static void printArray2(int n) {
        if (n >= arr.length) {
            System.out.println();
            return;
        }
        printArray2(n + 1);
        System.out.print(arr[n] + "\t");
    }

    private static void printArray3(int n) {
        if (n < 0) {
            System.out.println();
            return;
        }
        printArray3(n - 1);
        System.out.print(arr[n] + "\t");
    }

    public static void main(String[] args) {
        printArray(0);
        printArray2(0);
        printArray3(arr.length - 1);
    }
}
