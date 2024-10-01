import java.util.Scanner;

public class Deque {
    static final int SIZE = 5;  // Maximum size of the deque
    int[] deque = new int[SIZE];  // Array to store elements
    int front = -1, rear = -1;  // Pointers for front and rear, initialized to -1 (empty state)

    // Insert element at the front of the deque
    public void insertFront(int value) {
        // Check if deque is full
        if ((front == 0 && rear == SIZE - 1) || (front == rear + 1)) {
            System.out.println("Deque is full! Cannot insert at front.");
        }
        // If deque is empty, initialize front and rear to 0
        else if (front == -1) {
            front = rear = 0;
            deque[front] = value;
        }
        // If front is at the first position, move front to the last position (circular behavior)
        else if (front == 0) {
            front = SIZE - 1;
            deque[front] = value;
        }
        // Otherwise, decrement front and insert the value
        else {
            front--;
            deque[front] = value;
        }
    }

    // Insert element at the rear of the deque
    public void insertRear(int value) {
        // Check if deque is full
        if ((front == 0 && rear == SIZE - 1) || (front == rear + 1)) {
            System.out.println("Deque is full! Cannot insert at rear.");
        }
        // If deque is empty, initialize front and rear to 0
        else if (front == -1) {
            front = rear = 0;
            deque[rear] = value;
        }
        // If rear is at the last position, move rear to the first position (circular behavior)
        else if (rear == SIZE - 1) {
            rear = 0;
            deque[rear] = value;
        }
        // Otherwise, increment rear and insert the value
        else {
            rear++;
            deque[rear] = value;
        }
    }

    // Delete element from the front of the deque
    public void deleteFront() {
        // Check if deque is empty
        if (front == -1) {
            System.out.println("Deque is empty! Cannot delete from front.");
        }
        // If there is only one element, reset front and rear to -1 (deque becomes empty)
        else if (front == rear) {
            System.out.println("Deleted element from front: " + deque[front]);
            front = rear = -1;
        }
        // If front is at the last position, move it to 0 (circular behavior)
        else if (front == SIZE - 1) {
            System.out.println("Deleted element from front: " + deque[front]);
            front = 0;
        }
        // Otherwise, increment front to delete the element
        else {
            System.out.println("Deleted element from front: " + deque[front]);
            front++;
        }
    }

    // Delete element from the rear of the deque
    public void deleteRear() {
        // Check if deque is empty
        if (front == -1) {
            System.out.println("Deque is empty! Cannot delete from rear.");
        }
        // If there is only one element, reset front and rear to -1 (deque becomes empty)
        else if (front == rear) {
            System.out.println("Deleted element from rear: " + deque[rear]);
            front = rear = -1;
        }
        // If rear is at the first position, move it to the last position (circular behavior)
        else if (rear == 0) {
            System.out.println("Deleted element from rear: " + deque[rear]);
            rear = SIZE - 1;
        }
        // Otherwise, decrement rear to delete the element
        else {
            System.out.println("Deleted element from rear: " + deque[rear]);
            rear--;
        }
    }

    // Display the deque elements
    public void display() {
        // Check if deque is empty
        if (front == -1) {
            System.out.println("Deque is empty!");
            return;
        }

        System.out.print("Elements in the deque are: ");
        int i = front;
        // Traverse the deque in circular fashion until we reach rear
        while (i != rear) {
            System.out.print(deque[i] + " ");
            i = (i + 1) % SIZE;  // Circular increment
        }
        // Print the element at rear separately as the loop doesn't include it
        System.out.println(deque[rear]);
    }

    // Get the element at the front of the deque
    public void getFront() {
        if (front == -1) {
            System.out.println("Deque is empty!");
        } else {
            System.out.println("Element at front: " + deque[front]);
            System.out.println("front= " + front);
        }
    }

    // Get the element at the rear of the deque
    public void getRear() {
        if (rear == -1) {
            System.out.println("Deque is empty!");
        } else {
            System.out.println("Element at rear: " + deque[rear]);
            System.out.println(" rear= " + rear);
        }
    }

    // Main method to run the deque operations
    public static void main(String[] args) {
        Deque deque = new Deque();  // Create a Deque object
        Scanner sc = new Scanner(System.in);  // Scanner for user input
        int choice, value;  // Variables to store user input for choices and values

        System.out.println("********** DEQUE OPERATIONS **********");
        while (true) {
            // Display menu options for deque operations
            System.out.println("\n1. Insert at front");
            System.out.println("2. Insert at rear");
            System.out.println("3. Delete from front");
            System.out.println("4. Delete from rear");
            System.out.println("5. Display deque");
            System.out.println("6. Get front element");
            System.out.println("7. Get rear element");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();  // Get user choice

            switch (choice) {
                case 1:
                    // Insert element at the front
                    System.out.print("Enter value to insert at front: ");
                    value = sc.nextInt();
                    deque.insertFront(value);
                    break;
                case 2:
                    // Insert element at the rear
                    System.out.print("Enter value to insert at rear: ");
                    value = sc.nextInt();
                    deque.insertRear(value);
                    break;
                case 3:
                    // Delete element from the front
                    deque.deleteFront();
                    break;
                case 4:
                    // Delete element from the rear
                    deque.deleteRear();
                    break;
                case 5:
                    // Display the deque elements
                    deque.display();
                    break;
                case 6:
                    // Get the element at the front
                    deque.getFront();
                    break;
                case 7:
                    // Get the element at the rear
                    deque.getRear();
                    break;
                case 8:
                    // Exit the program
                    System.out.println("Exiting...");
                    sc.close();  // Close the scanner
                    System.exit(0);  // Exit the program
                default:
                    // Handle invalid choices
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}