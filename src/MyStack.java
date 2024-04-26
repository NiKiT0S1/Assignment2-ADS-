import java.util.LinkedList;

public class MyStack<E> {
    private MyLinkedList<E> list = new MyLinkedList<>();

    public void push(E item) {
        list.addFirst(item);
    }

    public E pop() {
        if (list.size() == 0) {
            return null;
        }
        E item = list.getFirst();
        list.removeFirst();
        return item;
    }

    public E peek() {
        if (list.size() == 0) {
            return null;
        }
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}
