public class MyLinkedList<T>{
    private class MyNode<T> {
        T data;
        MyNode<T> next;

        public MyNode(T data) {
            this.data = data;
            next = null;
        }
    }
    private MyNode<T> head;
    private int size;

    public MyLinkedList(){
        head = null;
        size = 0;
    }

    @Override
    public void addElement(T data) {
        MyNode<T> newNode = new MyNode<>(data);
        if (head == null) {
            head = newNode;
        }
        else {
            MyNode<T> currentNode = head;
            while (currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        size++;
    }

    public T getElement(int index) {
        checkIndex(index);
        MyNode<T> currentNode = head;
        if (index == 0)
            return currentNode.data;
        else {
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        }
        return currentNode.data;
    }

    public int getSize() {
        return size;
    }

    public void remove(int index) {
        checkIndex(index);
        if(index == 0)
            head = head.next;
        else {
            MyNode<T> currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
        }
        size--;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index not correct");
    }

    public void clear() {
        head = null;
        size = 0;
    }


}
