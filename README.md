ASSIGNMENT 2 -- DOCUMENTATION

## MyList

MyList - is an interface that defines basic operations such as adding, deleting, and retrieving elements.

### Methods:
- `add(E item)`: Adds an element to the end of the list.
- `set(int index, E item)`: Sets the element at the specified index.
- `add(int index, E item)`: Adds an element at the specified index.
- `addFirst(E item)`: Adds an element to the beginning of the list.
- `addLast(E item)`: Adds an element to the end of the list.
- `get(int index)`: Returns the element at the specified index.
- `getFirst()`: Returns the first element of the list.
- `getLast()`: Returns the last element of the list.
- `remove(int index)`: Removes the element at the specified index.
- `removeFirst()`: Removes the first element of the list.
- `removeLast()`: Removes the last element of the list.
- `sort()`: Sorts the list.
- `indexOf(Object object)`: Returns the index of the first occurrence of the specified element.
- `lastIndexOf(Object object)`: Returns the index of the last occurrence of the specified element.
- `exists(Object object)`: Checks whether an element exists in the list.
- `toArray()`: Returns an array of all elements of the list.
- `clear()`: Clears the list.
- `size()`: Returns the number of elements in the list.


## MyArrayList

MyArrayList - is an implementation of the `MyList` interface that uses an array to store elements.

### Using example:
MyArrayList<String> list = new MyArrayList<>();
list.add("Apple");
list.add("Banana");
String fruit = list.get(0); // Returns "Apple"
list.remove(1); // Removes "Banana"


## MyLinkedList

MyLinkedList - is an implementation of the MyList interface that uses a doubly linked list to store elements.

### Using example:
MyLinkedList<String> list = new MyLinkedList<>();
list.add("Apple");
list.addFirst("Banana");
String fruit = list.getFirst(); // Returns "Banana"
list.removeLast(); // Removes "Apple"


## MyStack

MyStack - is a class that implements a stack data structure, using MyLinkedList to store elements.

### Using example(this example didn't use in Main class. If you want to use, just copy it):
MyStack<String> stack = new MyStack<>();
stack.push("Apple");
String fruit = stack.peek(); // Returns "Apple" without removing it
fruit = stack.pop(); // Returns "Apple", removing it


## MyQueue

MyQueue - is a class that implements a queue data structure, using MyLinkedList to store elements.

### Using example(this example didn't use in Main class. If you want to use, just copy it):
MyQueue<String> queue = new MyQueue<>();
queue.enqueue("Apple");
String fruit = queue.peek(); // Returns "Apple" without removing it
fruit = queue.dequeue(); // Returns "Apple", removing it


## MyMinHeap

MyMinHeap - is a class that implements a min-heap data structure, using MyArrayList to store elements.

### Using example(this example didn't use in Main class. If you want to use, just copy it):
MyMinHeap<Integer> minHeap = new MyMinHeap<>();
minHeap.add(10);
minHeap.add(5);
int min = minHeap.peek(); // Returns 5 without removing it
min = minHeap.remove(); // Returns 5, removing it


## Main

Main - is a class containing a main method that can be used to test implementations of the above collections.

### Using example(You can check 'Main.java' to use methods):
MyArrayList<String> list = new MyArrayList<>();
list.add("Apple");
// And other operations with list...
