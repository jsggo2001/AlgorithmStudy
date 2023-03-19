package ssafyClass.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class AdjListTest2 {
	//직접 링크드리스트 구현하지말고 어레이리스트 써보자
	
	static ArrayList<Integer>[] adjList;
	//어레이리스트를 묶은 배열을 만들겠다.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
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
	}
	
	static void print() {
		for (ArrayList<Integer> list : adjList) {
			System.out.println(list);
		}
	}

}
