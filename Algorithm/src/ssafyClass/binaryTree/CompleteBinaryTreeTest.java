package ssafyClass.binaryTree;

public class CompleteBinaryTreeTest {

    public static void main(String[] args) {
        byQueue();
//        byStack();
    }

    public static void byQueue() {
        int size = 9;
        CompleteBinaryTree<Character> tree = new CompleteBinaryTree<>(size);

        for (int i = 0; i < size; i++) {
            tree.add((char)(65+i));
        }
        tree.bfs();
        tree.dfsByPreOrder();
        tree.dfsByInOrder();
        tree.dfsByPostOrder();
    }

    public static void byStack() {
        int size = 9;
        CompleteBinaryTreeByStack<Character> tree = new CompleteBinaryTreeByStack<>(size);

        for (int i = 0; i < size; i++) {
            tree.add((char)(65+i));
        }
        tree.bfs();
    }

}
