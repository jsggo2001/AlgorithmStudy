package ssafyClass.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class BFSByAdjListTest2 {
	//직접 링크드리스트 구현하지말고 어레이리스트 써보자
	
	static ArrayList<Integer>[] adjList;
	//어레이리스트를 묶은 배열을 만들겠다.
	static int V;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		int E = sc.nextInt();
		
		adjList = new ArrayList[V]; //head가 모두 null인 상태로 초기화
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		int from, to;
		for (int i = 0; i < E; ++i) {
			from = sc.nextInt(); //from 정점
			to = sc.nextInt(); //to 정점

			adjList[from].add(to);
			//무향 그래프를 구현하려면 to에도 거꾸로 from을 넣어준다.
			adjList[to].add(from);
		}
		
		print();

		bfs(0);
	}

	private static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[V];

		queue.offer(start);
		visited[start] = true;

		int current = 0;
		while (!queue.isEmpty()) {
			current = queue.poll();
			System.out.println((char)(current + 65));

			for (int vertex : adjList[current]) {
				if (!visited[vertex]) {
					queue.offer(vertex);
					visited[vertex] = true;
				}
			}
		}
	}
	
	static void print() {
		for (ArrayList<Integer> list : adjList) {
			System.out.println(list);
		}
	}

}
