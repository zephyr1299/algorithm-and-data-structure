public class Stack<E> {
    private Node<E> head;

    private class Node<E> {
        public E value;
        public Node<E> next;

        public Node(E value){
            this.value = value;
        }
    }

    public Stack(){
        head = null;
    }

    public void push(E value){
        Node<E> node = new Node<>(value);
        node.next = head;
        head = node;
    }

    public E pop(){
        Node<E> oldHead = head;
        head = head.next;
        return oldHead.value;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public static void main2(String... args){
        Stack<String> stack = new Stack<>();
        stack.push("0");
        stack.push("1");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push("3");
        stack.push("4");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
