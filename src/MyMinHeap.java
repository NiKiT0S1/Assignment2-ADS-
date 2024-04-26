public class MyMinHeap<E extends Comparable<E>>{
    private MyArrayList<E> list = new MyArrayList<>();

    public void add(E item) {
        list.add(item);
        int i = list.size() - 1;
        while (i > 0) {
            int parent = (i - 1) / 2;
            E currentItem = list.get(i);
            E parentItem = list.get(parent);
            if (currentItem.compareTo(parentItem) < 0) {
                list.set(i, parentItem);
                list.set(parent, currentItem);
                i = parent;
            }
            else {
                break;
            }
        }
    }

    public E remove() {
        if (list.size() == 0) {
            return null;
        }

        E minItem = list.get(0);
//        E lastItem = list.removeLast();
        if (list.size() > 0) {
//            list.set(0, lastItem);
            minHeapify(0);
        }
        return minItem;
    }

    private void minHeapify(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;
        if (left < list.size() && list.get(left).compareTo(list.get(smallest)) < 0) {
            smallest = left;
        }
        if (right < list.size() && list.get(right).compareTo(list.get(smallest)) < 0) {
            smallest = right;
        }
        if (smallest != i) {
            E temp = list.get(i);
            list.set(i, list.get(smallest));
            list.set(smallest, temp);
            minHeapify(smallest);
        }
    }

    public E peek() {
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}
