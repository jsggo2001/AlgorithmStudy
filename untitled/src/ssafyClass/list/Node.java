package ssafyClass.list;

public class Node<T> {
    T data;
    Node link;

    public Node(T data) {
        super();
        this.data = data;
    }

    public Node(T e, Node<T> top) {
        super();
        this.data = e;
        this.link = top;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", link=" + link +
                '}';
    }
}
