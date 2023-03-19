package ssafyClass.binaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class CompleteBinaryTree<T> {
    private Object[] nodes;
    private final int SIZE;
    private int lastIndex;

    public CompleteBinaryTree(int size) {
        SIZE = size;
        nodes = new Object[SIZE + 1];
    }

    private boolean isFull() {
        return lastIndex == SIZE;
    }

    public void add(T e) {
        if (isFull()) return;
        nodes[++lastIndex] = e;
    }

    public void bfs() {
        int size = 0;
        //큐에는 탐색노드의 번호 저장
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.offer(1);
        int current = 0, level = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            System.out.print("level : " + level + " ");
            while (--size >= 0) { // 큐에 대기하고 있는 순서대로 노드 처리

                current = queue.poll(); // 현재 탐색 해야 하는 노드
                System.out.print(nodes[current] + " ");

                // 현재 노드의 자식노드들을 큐에 넣어 순서를 기다리게 하기
                // 완전 이진 트리 : 자식이 최대 2인상황
                if (current * 2 <= lastIndex)
                    queue.offer(current * 2);
                if (current * 2 + 1 <= lastIndex)
                    queue.offer(current * 2 + 1);
            }
            level++;
            System.out.println();
        }
    }

    public void dfsByPreOrder() {
        System.out.print("PreOrder : ");
        dfsByPreOrder(1);
        System.out.println();
    }

    private void dfsByPreOrder(int current) {

        System.out.print(nodes[current] + " ");

        if (current * 2 <= lastIndex) dfsByPreOrder(current * 2);
        if (current * 2 + 1 <= lastIndex) dfsByPreOrder(current * 2 + 1);
    }

    public void dfsByInOrder() {
        System.out.print("InOrder : ");
        dfsByInOrder(1);
        System.out.println();
    }

    private void dfsByInOrder(int current) {

        if (current * 2 <= lastIndex) dfsByInOrder(current * 2);
        System.out.print(nodes[current] + " ");
        if (current * 2 + 1 <= lastIndex) dfsByInOrder(current * 2 + 1);
    }

    public void dfsByPostOrder() {
        System.out.print("PostOrder : ");
        dfsByPostOrder(1);
        System.out.println();
    }

    private void dfsByPostOrder(int current) {

        if (current > lastIndex) return;
        dfsByPostOrder(current * 2);
        dfsByPostOrder(current * 2 + 1);
        System.out.print(nodes[current] + " ");
    }

}
