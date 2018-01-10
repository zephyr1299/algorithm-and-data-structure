public class singlyLinkedList {
    static class node<E> {
        E key;
        node<E> nextNode;

        public node(E key) {
            this.key = key;
        }

        public void travel(node<E> root) {
            if (root == null) return;
            else System.out.println(root.key);

            travel(root.nextNode);
        }
    }

    public static void main(String... args) {
        node<Integer> root = new node<>(0);
        node<Integer> node1 = new node<>(1);
        node<Integer> node2 = new node<>(2);

        root.nextNode = node1;
        root.nextNode.nextNode = node2;

        root.travel(root);
    }
}
