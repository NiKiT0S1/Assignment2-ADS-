import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Create an instance of MyArrayList
        MyArrayList<String> myList = new MyArrayList<>();

        // Add elements to the list
        myList.add("Apple");
        myList.add("Banana");
        myList.add("Cherry");
        myList.add("Date");

        // Print all elements using iterator
        System.out.println("List contents:");
        for (String fruit : myList) {
            System.out.println(fruit);
        }

        // Get and print an element from the list
        System.out.println("\nElement at index 2: " + myList.get(2));

        // Remove an element from the list
        myList.remove(1); // Removes "Banana"
        System.out.println("\nAfter removing element at index 1:");

        // Print all elements using iterator
        for (String fruit : myList) {
            System.out.println(fruit);
        }

        // Add an element at the first position
        myList.addFirst("Apricot");
        System.out.println("\nAfter adding 'Apricot' at the first position:");

        // Print all elements using iterator
        for (String fruit : myList) {
            System.out.println(fruit);
        }

        // Remove the last element
        myList.removeLast();
        System.out.println("\nAfter removing the last element:");

        // Print all elements using iterator
        for (String fruit : myList) {
            System.out.println(fruit);
        }

        // Clear the list
        myList.clear();
        System.out.println("\nAfter clearing the list, size: " + myList.size());
    }
}
