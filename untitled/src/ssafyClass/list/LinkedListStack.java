package ssafyClass.list;

public class LinkedListStack<E> implements IStack<E>{
    private Node<E> top;

    @Override
    public void push(E e) {
        // top으로 삽입
        top = new Node<E>(e, top);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            System.out.println("스택이 비어 있습니다.");
            return null;
        }
        Node<E> popNode = top;
        top = popNode.link;
        popNode.link = null;

        return popNode.data;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            System.out.println("스택이 비어 있습니다.");
            return null;
        }
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int size() {
        int cnt = 0;
        Node<E> now = top;
        while (now != null) {
            now = now.link;
            cnt++;
        }
        return cnt;
    }
}
