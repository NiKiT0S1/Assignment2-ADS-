import java.util.Iterator;

public class MyLinkedList<E> implements MyList<E>{
    private class MyNode<E>{
        E element;
        MyNode<E> next;
        MyNode<E> prev;

        MyNode(E element, MyNode<E> next, MyNode<E> prev){
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private MyNode<E> head;
    private MyNode<E> tail;
    private int size;

    public MyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public void add (E item) {
        if (head == null) {
            head = new MyNode(item, null, null);
            tail = head;
        }
        else {
            MyNode<E> newNode = new MyNode<> (item, tail, null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void set(int index, E item) {
        MyNode<E> current = getNode(index);
        if (current != null) {
            current.element = item;
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void add(int index, E item) {
        if (index == size) {
            addLast(item);
        }
        else {
            MyNode<E> current = getNode(index);
            if (current != null) {
                MyNode<E> newNode = new MyNode<> (item, current.prev, current);
                if (current.prev != null) {
                    current.prev.next = newNode;
                }
                else {
                    head = newNode;
                }
                current.prev = newNode;
                size++;
            }
            else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    public void addFirst(E item) {
        MyNode<E> newNode = new MyNode<>(item, null, head);
        if (head != null) {
            head.prev = newNode;
        }
        else {
            tail = newNode;
        }
        head = newNode;
        size++;
    }

    public void addLast(E item) {
        if (tail == null) {
            addFirst(item);
        }
        else {
            MyNode<E> newNode = new MyNode<>(item, tail, null);
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    public E get(int index) {
        MyNode<E> current = getNode(index);
        return (current != null) ? current.element : null;
    }

    public E getFirst() {
        return (head != null) ? head.element : null;
    }

    public E getLast() {
        return (tail != null) ? tail.element : null;
    }

    public void remove(int index) {
        MyNode<E> current = getNode(index);
        if (current != null) {
            if (current.prev != null) {
                current.prev.next = current.next;
            }
            else {
                head = current.next;
            }
            if (current.next != null) {
                current.next.prev = current.prev;
            }
            else {
                tail = current.prev;
            }
            size--;
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            else {
                tail = null;
            }
            size--;
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void removeLast() {
        if (tail != null) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
            else {
                head = null;
            }
            size--;
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void sort() {
        if (size > 1) {
            head = mergeSort(head);
            tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
        }
    }

    private MyNode<E> mergeSort(MyNode<E> head) {
        if (head == null || head.next == null) {
            return head;
        }

        MyNode<E> middle = getMiddle(head);
        MyNode<E> nextOfMiddle = middle.next;
        middle.next = null;

        MyNode<E> left = mergeSort(head);
        MyNode<E> right = mergeSort(nextOfMiddle);

        return merge(left, right);
    }

    private MyNode<E> merge(MyNode<E> left, MyNode<E> right) {
        MyNode<E> result = null;

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

//        if (left.element.compareTo(right.element) <= 0) {
//            result = left;
//            result.next = merge(left.next, right);
//        }
//        else {
//            result = right;
//            result.next = merge(left, right.next);
//        }
        return result;
    }

    private MyNode<E> getMiddle(MyNode<E> head) {
        if (head == null) {
            return head;
        }

        MyNode<E> slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public int indexOf(Object object) {
        MyNode<E> current = head;
        int index = 0;
        while (current != null) {
            if (current.element.equals(object)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        MyNode<E> current = tail;
        int index = size - 1;
        while (current != null) {
            if (current.element.equals(object)) {
                return index;
            }
            current = current.prev;
            index--;
        }
        return -1;
    }

    public boolean exists(Object object) {
        return indexOf(object) >= 0;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        MyNode<E> current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.element;
            current = current.next;
        }
        return array;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    private MyNode<E> getNode(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        MyNode<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private MyNode<E> current = head;

            public boolean hasNext() {
                return current != null;
            }

            public E next() {
                if (!hasNext()) {
                    return null;
                }
                E item = current.element;
                current = current.next;
                return item;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
