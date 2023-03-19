package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Stack {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		java.util.Stack<String> fStack = new java.util.Stack<>();
		java.util.Stack<String> bStack = new java.util.Stack<>();
		String now = "http://www.acm.org/";

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			if (order.equals("VISIT")) {
				bStack.push(now);
				now =st.nextToken();
				fStack = new java.util.Stack<>();
			} else if (order.equals("BACK")) {
				if(bStack.isEmpty()) {
					System.out.println("Ignored");
					continue;
				}
				fStack.push(now);
				now = bStack.pop();
			}else if (order.equals("FORWARD")) {
				if(fStack.isEmpty()) {
					System.out.println("Ignored");
					continue;
				}
				bStack.push(now);
				now = fStack.pop();
			}else break;
			System.out.println(now);
		}
	}

}
