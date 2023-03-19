package ssafyClass.binaryTree;

import java.util.Stack;

public class CompleteBinaryTreeByStack<T> {
    private Object[] nodes;
    private final int SIZE;
    private int lastIndex;

    public CompleteBinaryTreeByStack(int size) {
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
        //큐에는 탐색노드의 번호 저장
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        int current = 0;
        while(!stack.isEmpty()) { // 큐에 대기하고 있는 순서대로 노드 처리

            current = stack.pop(); // 현재 탐색 해야 하는 노드
            System.out.println(nodes[current]);

            // 현재 노드의 자식노드들을 큐에 넣어 순서를 기다리게 하기
            // 완전 이진 트리 : 자식이 최대 2인상황
            if (current * 2 + 1 <= lastIndex)
                stack.push(current * 2 + 1);
            if (current * 2 <= lastIndex)
                stack.push(current * 2);
        }
    }
}
