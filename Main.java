import java.util.Scanner;

class SimpleQueue {
    private final Integer[] queue;  // Array to store the elements in the queue
    private final int max;
    private int rear;              // Pointer to the rear (end) of the queue
    private int front;             // Pointer to the front (beginning) of the queue
    private int itemCount;         // Count of elements in the queue

    public SimpleQueue() {
        this.queue = new Integer[5]; // Initialize the queue with size 5
        this.max = 5;              // Set the maximum size of the queue
        this.rear = -1;
        this.front = 0; 
        this.itemCount = 0;        // Keep track of the actual number of elements in the queue
    }

    // Insertion method
    public void qinsert(int item) {
        if (rear == max - 1) {
            System.out.println("\nSimple Queue is Full or overflow\n");
        } else if (itemCount == max) {
            System.out.println("\nSimple Queue has reached its limit. Cannot insert more items.\n");
        } else {
            rear++;
            queue[rear] = item;
            itemCount++;  // Increment the item count
            System.out.println("Item Inserted in Simple Queue");
        }
    }

    // Deletion method
    public void qdelete() {
        if (itemCount == 0) {
            System.out.println("Simple Queue Is Empty or underflow\n");
        } else {
            int item = queue[front];
            System.out.println("\nThe deleted Item: " + item);
            queue[front] = null;
            front++;
            itemCount--;  // Decrement the item count
        }
    }

    public void display() {
        if (itemCount > 0) {
            String[] frontIndicator = new String[max];
            String[] rearIndicator = new String[max];
            for (int i = 0; i < max; i++) {
                frontIndicator[i] = "  ";   // Initialize front indicator array with spaces
                rearIndicator[i] = "  ";    // Initialize rear indicator array with spaces
            }

            if (front <= rear) {
                frontIndicator[front] = "F";
                rearIndicator[rear] = "R";
            }

            // Display Rear indicators
            System.out.print("\nRear  : ");
            for (String s : rearIndicator) {
                System.out.print(s + "   ");
            }
            System.out.println();

            // Display separator line, even if the queue is empty
            System.out.println("       " + "_____".repeat(max));
            System.out.println();
            // Display Queue items
            System.out.print("Queue : ");
            for (int i = 0; i < max; i++) {
                if (queue[i] == null) {
                    System.out.print("     ");
                } else {
                    System.out.print(queue[i] + "   ");
                }
            }
            System.out.println();

            // Display another separator line
            System.out.println("       " + "_____".repeat(max));

            // Display Front indicators
            System.out.print("Front : ");
            for (String s : frontIndicator) {
                System.out.print(s + "   ");
            }
            System.out.println();
        } else {
            System.out.println("\nNO Value in Simple Queue\n");

            // Even when the queue is empty, display prominent separators
            System.out.println("       " + "_____".repeat(max));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SimpleQueue queue = new SimpleQueue();
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        System.out.println("\n*********** Enter your choice *********** ");
        while (!choice.equals("4")) {
        
            System.out.println("\n1 : Insert In Queue (Insert)");
            System.out.println("2 : Delete From Queue (Front)");
            System.out.println("3 : Display");
            System.out.println("4 : Exit\n");
            System.out.print("Enter Choice... ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("\nEnter value into Queue... ");
                    int item = scanner.nextInt();
                    queue.qinsert(item);
                    scanner.nextLine();
                    break;
                case "2":
                    queue.qdelete();
                    break;
                case "3":
                    queue.display();
                    break;
                case "4":
                    System.out.println("Exiting...");
                    System.out.println("\n\t\t********** Happy Coding! Bye **********");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }
}