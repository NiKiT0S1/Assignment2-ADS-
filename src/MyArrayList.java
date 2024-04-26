import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<E> implements MyList<E> {
    private Object[] elements;
    private int size;

    public MyArrayList() {
        elements = new Object[10];
        size = 0;
    }

    public void add(E item) {
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[size++] = item;
    }

    public void set(int index, E item) {
        checkIndex(index);
        elements[index] = item;
    }

    public void add(int index, E item) {
        checkIndexForAdd(index);
        if (size == elements.length) {
            increaseCapacity();
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = item;
        size++;
    }

    public void addFirst(E item) {
        add(0, item);
    }

    public void addLast(E item) {
        add(item);
    }

    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void remove(int index) {
        checkIndex(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
    }

    public void removeFirst() {
        remove(0);
    }

    public void removeLast() {
        remove(size - 1);
    }

    public void sort() {
        Arrays.sort((E[]) elements, 0, size);
    }

    public int indexOf(Object object) {
        if (object == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        }
        else {
            for (int i = 0; i < size; i++) {
                if (object.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        if (object == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (elements[i] == null) {
                    return i;
                }
            }
        }
        else {
            for (int i = size - 1; i >= 0; i--) {
                if (object.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean exists(Object object) {
        return indexOf(object) >= 0;
    }

    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private  int currentIndex = 0;

            public boolean hasNext() {
                return currentIndex < size;
            }

            public E next() {
                return (E) elements[currentIndex++];
            }

            public void remove() {
                throw new UnsupportedOperationException("Remove not supported");
            }
        };
    }

    private void increaseCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index = " + index + ", Size = " + size);
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index = " + index + ", Size = " + size);
        }
    }
}