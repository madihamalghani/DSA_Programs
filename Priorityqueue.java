import java.util.Scanner;
public class Priorityqueue {
    static final int SIZE = 5; // Maximum size of the priority queue (5 in this case).
    int[] queue = new int[SIZE]; // Array to store the elements of the priority queue.
    int[] priorities = new int[SIZE]; // Array to store the priorities of the elements.
    boolean[] occupied = new boolean[SIZE]; // Array to track occupied position
    int rear = -1; // Rear points to the last inserted element.

    // Insert an element with a priority (without sorting)
    public void insert(int x, int priority) {
        if (priority < 1 || priority > 5) {
            System.out.println("Invalid priority! Please enter a priority between 1 and 5.");
            return;
        }

        if (rear == SIZE - 1) {
            System.out.println("Priority Queue is full (Overflow)");
            return;
        }

        // Insert element at the rear without sorting
        rear++;
        queue[rear] = x;//q[rear-ka-index]=item so item inserted
        priorities[rear] = priority; //priority insert
        occupied[rear] = true;//that position occupied
    }

    // Delete the element with the lowest priority
    public void deleteLowestPriority() {
        if (rear == -1) {
            System.out.println("Priority Queue is empty");
            return;
        }

        // Find the index of the element with the lowest priority
        int lowestPriorityIndex = 0; //initialize
        for (int i = 1; i <= rear; i++) { 
            //i<=rear r is on the last element so till last element
            if (priorities[i] > priorities[lowestPriorityIndex]) {
                //check each element and store the highest priority in lowestPriorityIndex
                lowestPriorityIndex = i;
            }
        }

        // Remove the element with the highest priority
        System.out.println("Deleting element: " + queue[lowestPriorityIndex] + " with priority " + priorities[lowestPriorityIndex]);
        occupied[lowestPriorityIndex] = false; //yani deleted

        // Shift the elements after the lowest priority element to fill the gap
        for (int i = lowestPriorityIndex; i < rear; i++) {
            queue[i] = queue[i + 1];//queue[i + 1] is stored in i
            priorities[i] = priorities[i + 1];
            occupied[i] = occupied[i + 1];
        }

        // Mark the last position as unoccupied 
        occupied[rear] = false;
        rear--;//move rear to back
    }

    // Delete the element with the lowest priority
    public void deleteHighestPriority() {
        if (rear == -1) {
            System.out.println("Priority Queue is empty");
            return;
        }

        // Find the index of the element with the highest priority
        int highestPriorityIndex = 0;
        for (int i = 1; i <= rear; i++) {
            if (priorities[i] < priorities[highestPriorityIndex]) {
                highestPriorityIndex = i;
            }
        }

        // Remove the element with the lowest priority
        System.out.println("Deleting element: " + queue[highestPriorityIndex] + " with priority " + priorities[highestPriorityIndex]);
        occupied[highestPriorityIndex] = false;

        // Shift the elements after the lowest priority element to fill the gap
        for (int i = highestPriorityIndex; i < rear; i++) {
            queue[i] = queue[i + 1];
            priorities[i] = priorities[i + 1];
            occupied[i] = occupied[i + 1];
        }

        // Mark the last position as unoccupied
        occupied[rear] = false;
        rear--;
    }

    // Display the priority queue with priorities
    public void display() {
        if (rear == -1) {
            System.out.println("Priority Queue is empty");
            return;
        }

        System.out.print("Elements with priorities: ");
        for (int i = 0; i <= rear; i++) {
            if (occupied[i]) {
                System.out.print(queue[i] + "(P=" + priorities[i] + ") ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Priorityqueue pq = new Priorityqueue();
        Scanner sc = new Scanner(System.in); // Scanner for input
        int choice, x, priority;

        

        while (true) {
            System.out.println("\n********** Priority Queue **********");
            System.out.println();
            System.out.println("1. Insert with priority");
            System.out.println("3. Delete element with lowest priority");
            System.out.println("2. Delete element with highest priority");
            System.out.println("4. Display priority queue");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to insert: ");
                    x = sc.nextInt();//x=item
                    System.out.print("Enter the priority (1-5): ");
                    priority = sc.nextInt();
                    pq.insert(x, priority);
                    break;
                case 2:
                pq.deleteHighestPriority();
                
                    break;
                case 3:
                
                pq.deleteLowestPriority();
                    break;
                case 4:
                    pq.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.out.println("\n********** Happy Coding!!! Bye **********");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
