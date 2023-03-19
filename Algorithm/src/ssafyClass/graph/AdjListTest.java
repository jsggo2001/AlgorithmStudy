package ssafyClass.graph;

import java.util.Scanner;
import java.util.StringTokenizer;

public class AdjListTest {
	
	static class Node{
		int vertex;
		//int weight -> 가중치 그래프일때.
		Node link;
		
		
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}


		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}
		//디버깅용.
	}
	
	static Node[] adjList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		adjList = new Node[V]; //head가 모두 null인 상태로 초기화
		
		StringTokenizer st = null;
		int from, to;
		for (int i = 0; i < E; ++i) {
			from = sc.nextInt(); //from 정점
			to = sc.nextInt(); //to 정점


			adjList[from] = new Node(to, adjList[from]);
			//무향 그래프를 구현하려면 to에도 거꾸로 from을 넣어준다.
			adjList[to] = new Node(from, adjList[to]);
			
			
		}
		
		print();
	}
	
	static void print() {
		for (Node node : adjList) {
			System.out.println(node);
		}
	}

}
