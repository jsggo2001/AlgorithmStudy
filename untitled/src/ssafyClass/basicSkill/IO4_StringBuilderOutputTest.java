package com.ssafy.live01.dist;

import java.io.*;
import java.util.Random;

/**
 * 
 * @author THKim
 *
 */
public class IO4_StringBuilderOutputTest {

	static String path = "./input.txt";
	public static void main(String[] args) throws IOException {
		File current = new File("./input.txt");

		System.out.println("현재 위치 " + current.getCanonicalPath());
		int TC = 10;
		
		FileWriter out = new FileWriter(path);
		StringBuilder sb = new StringBuilder();
		long start = System.nanoTime();
		sb.append(TC+"\n");
		
		Random r = new Random();
		for (int tc = 0; tc < TC; tc++) {
			int N = 1000;
			sb.append(N+"\n");

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(r.nextInt(10)+" ");
				}
				sb.append("\n");
			}
		}
		out.write(sb.toString());
		out.flush();
		long end = System.nanoTime();
		System.out.println((end-start)/1_000_000_000.0+"s!");
		out.close();
	}
 
}
