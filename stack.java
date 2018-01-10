public class stack<E> {
    private stack1<E> head;
    private E value;
    stack1<E> next;

    public stack1(){

    }
    public stack1(E value) {
        this.value = value;
    }

    public void setNext(stack1<E> nextNode) {
        next = nextNode;
    }

    public void push(stack1<E> nodeToInsert, stack1<E> head) {
        nodeToInsert.setNext(head);
        head = nodeToInsert;
    }

    public E pop() {
        head = next;
        return value;
    }

    public stack1<E> getHead(){
        return head;
    }

    public boolean isEmpty(){
        if (head == null) return true;
        else return false;
    }

    public E getValue(){
        return value;
    }

}
