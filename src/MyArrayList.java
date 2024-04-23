public class MyArrayList<T> {
    private T[] arr = (T[]) new Object[5];
    private int size;

    public MyArrayList(){
        size = 0;
    }
    public void addElement(T element){
        if(size>=arr.length){
            increaseBuffer();
        }
        arr[size++] = element;
    }

    public void addElement(T element, int index){
        checkIndex(index);
        if(size>= arr.length){
            increaseBuffer();
        }
        arr[index] = element;
    }

    private void increaseBuffer() {
        T[] newArr = (T[]) new Object[arr.length*2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public T getElement(int index){
        checkIndex(index);
        return arr[index];
    }

    public int getSize(){
        return size;
    }

    public void removeElement(int index){
        checkIndex(index);
        for (int i = index+1; i <size ; i++) {
            arr[i-1] = arr[i];
        }
        size--;
    }

    private void checkIndex(int index){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException("index not correct");
        }
    }

    public void clear(){
        arr = (T[]) new Object[5];
        size = 0;
    }
}
