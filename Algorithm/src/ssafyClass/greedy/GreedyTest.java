package ssafyClass.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GreedyTest {

    private static class Meeting implements Comparable<Meeting> {
        int start,end;

        public Meeting(int start,int end) {
            super();
            this.start = start;
            this.end = end;
        }

        // 양수 교환 0은 그대로 음수는 그대로
        @Override
        public int compareTo(Meeting o) {
            return this.end != o.end ?
                    Integer.compare(this.end , o.end) :
                    Integer.compare(this.start, o.start);
        }

        @Override
        public String toString() {
            return "Meeting{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        Meeting[] m = new Meeting[count];

        for (int i =0; i < count; i++) {
            m[i] = new Meeting(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(m);

        List<Meeting> result = new ArrayList<Meeting>();
        result.add(m[0]);

        for (int i = 1; i < count; i++) {
            // 마지막 회의의 종료시간보다 현재회의의 시작시간이 같거나 크다면 양립가능
            if (result.get(result.size() - 1).end <= m[i].start)
                result.add(m[i]);
        }

        System.out.println(result.size());
        for (Meeting meeting : result) {
            System.out.println(meeting);
        }

    }
}
/*
10
1 4  1 6  6 10  5 7  3 8  5 9  3 5 8 11  2 13  12 14
 */

