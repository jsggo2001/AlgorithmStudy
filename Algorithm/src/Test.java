public class Test {
    public static void main(String[] args) {
        int[] list = {1,2,3,4,5,6,7,8,9,10};

        int start = 0;
        int end = list.length - 1;
        int mid = 0;

        int x = 5;

        while(start < end) {
            mid = (start + end) / 2;
            if (list[mid] > x) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(list[end]);
    }
}
