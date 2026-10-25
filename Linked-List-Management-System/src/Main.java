import java.util.Scanner;

public class Main {
    private static final Scanner SC = new Scanner(System.in);
    private static final SinglyLinkedList SINGLY = new SinglyLinkedList();
    private static final DoublyLinkedList DOUBLY = new DoublyLinkedList();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== LINKED LIST MANAGEMENT SYSTEM ===");
            System.out.println("1. Singly Linked List");
            System.out.println("2. Doubly Linked List");
            System.out.println("3. Compare Singly vs Doubly Linked List");
            System.out.println("4. Exit");
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> singlyMenu();
                case 2 -> doublyMenu();
                case 3 -> compareLists();
                case 4 -> { System.out.println("Thank you for using the system."); SC.close(); return; }
                default -> System.out.println("Invalid choice. Please choose 1-4.");
            }
        }
    }

    private static void singlyMenu() {
        while (true) {
            System.out.println("\n--- SINGLY LINKED LIST ---");
            System.out.println("1. Insert at Beginning\n2. Insert at End\n3. Insert at Position\n4. Insert After a Value\n5. Insert Before a Value");
            System.out.println("6. Delete from Beginning\n7. Delete from End\n8. Delete from Position\n9. Delete by Value\n10. Search\n11. Update a Value");
            System.out.println("12. Display\n13. Count Nodes\n14. Find Maximum\n15. Find Minimum\n16. Find Middle\n17. Reverse\n18. Sort\n19. Remove Duplicates\n20. Back to Main Menu");
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> { SINGLY.insertAtBeginning(readInt("Enter value: ")); success("Node inserted at beginning."); }
                case 2 -> { SINGLY.insertAtEnd(readInt("Enter value: ")); success("Node inserted at end."); }
                case 3 -> { int v = readInt("Enter value: "); int p = readInt("Enter position (1-based): "); result(SINGLY.insertAtPosition(v, p), "Node inserted.", "Invalid position."); }
                case 4 -> { int target = readInt("Insert after which value? "); int v = readInt("New value: "); result(SINGLY.insertAfterValue(target, v), "Node inserted.", "Target value not found."); }
                case 5 -> { int target = readInt("Insert before which value? "); int v = readInt("New value: "); result(SINGLY.insertBeforeValue(target, v), "Node inserted.", "Target value not found."); }
                case 6 -> result(SINGLY.deleteFromBeginning(), "First node deleted.", "List is empty.");
                case 7 -> result(SINGLY.deleteFromEnd(), "Last node deleted.", "List is empty.");
                case 8 -> result(SINGLY.deleteAtPosition(readInt("Enter position: ")), "Node deleted.", "Invalid position or empty list.");
                case 9 -> result(SINGLY.deleteByValue(readInt("Enter value to delete: ")), "First matching value deleted.", "Value not found.");
                case 10 -> { int p = SINGLY.search(readInt("Enter value to search: ")); System.out.println(p == -1 ? "Value not found." : "Value found at position " + p + "."); }
                case 11 -> { int oldV = readInt("Value to update: "); int newV = readInt("New value: "); result(SINGLY.updateFirst(oldV, newV), "First matching value updated.", "Value not found."); }
                case 12 -> SINGLY.display();
                case 13 -> System.out.println("Total nodes: " + SINGLY.countNodes());
                case 14 -> printNullable("Maximum", SINGLY.findMaximum());
                case 15 -> printNullable("Minimum", SINGLY.findMinimum());
                case 16 -> printNullable("Middle value", SINGLY.findMiddle());
                case 17 -> { SINGLY.reverse(); success("List reversed."); }
                case 18 -> { SINGLY.sort(); success("List sorted in ascending order."); }
                case 19 -> { SINGLY.removeDuplicates(); success("Duplicate values removed."); }
                case 20 -> { return; }
                default -> System.out.println("Invalid choice. Please choose 1-20.");
            }
        }
    }

    private static void doublyMenu() {
        while (true) {
            System.out.println("\n--- DOUBLY LINKED LIST ---");
            System.out.println("1. Insert at Beginning\n2. Insert at End\n3. Insert at Position\n4. Insert After a Value\n5. Insert Before a Value");
            System.out.println("6. Delete from Beginning\n7. Delete from End\n8. Delete from Position\n9. Delete by Value\n10. Search\n11. Update a Value");
            System.out.println("12. Display Forward\n13. Display Backward\n14. Count Nodes\n15. Find Maximum\n16. Find Minimum\n17. Find Middle\n18. Reverse\n19. Sort\n20. Remove Duplicates\n21. Back to Main Menu");
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> { DOUBLY.insertAtBeginning(readInt("Enter value: ")); success("Node inserted at beginning."); }
                case 2 -> { DOUBLY.insertAtEnd(readInt("Enter value: ")); success("Node inserted at end."); }
                case 3 -> { int v = readInt("Enter value: "); int p = readInt("Enter position (1-based): "); result(DOUBLY.insertAtPosition(v, p), "Node inserted.", "Invalid position."); }
                case 4 -> { int target = readInt("Insert after which value? "); int v = readInt("New value: "); result(DOUBLY.insertAfterValue(target, v), "Node inserted.", "Target value not found."); }
                case 5 -> { int target = readInt("Insert before which value? "); int v = readInt("New value: "); result(DOUBLY.insertBeforeValue(target, v), "Node inserted.", "Target value not found."); }
                case 6 -> result(DOUBLY.deleteFromBeginning(), "First node deleted.", "List is empty.");
                case 7 -> result(DOUBLY.deleteFromEnd(), "Last node deleted.", "List is empty.");
                case 8 -> result(DOUBLY.deleteAtPosition(readInt("Enter position: ")), "Node deleted.", "Invalid position or empty list.");
                case 9 -> result(DOUBLY.deleteByValue(readInt("Enter value to delete: ")), "First matching value deleted.", "Value not found.");
                case 10 -> { int p = DOUBLY.search(readInt("Enter value to search: ")); System.out.println(p == -1 ? "Value not found." : "Value found at position " + p + "."); }
                case 11 -> { int oldV = readInt("Value to update: "); int newV = readInt("New value: "); result(DOUBLY.updateFirst(oldV, newV), "First matching value updated.", "Value not found."); }
                case 12 -> DOUBLY.displayForward();
                case 13 -> DOUBLY.displayBackward();
                case 14 -> System.out.println("Total nodes: " + DOUBLY.countNodes());
                case 15 -> printNullable("Maximum", DOUBLY.findMaximum());
                case 16 -> printNullable("Minimum", DOUBLY.findMinimum());
                case 17 -> printNullable("Middle value", DOUBLY.findMiddle());
                case 18 -> { DOUBLY.reverse(); success("List reversed."); }
                case 19 -> { DOUBLY.sort(); success("List sorted in ascending order."); }
                case 20 -> { DOUBLY.removeDuplicates(); success("Duplicate values removed."); }
                case 21 -> { return; }
                default -> System.out.println("Invalid choice. Please choose 1-21.");
            }
        }
    }

    private static void compareLists() {
        System.out.println("\n--- SINGLY VS DOUBLY LINKED LIST ---");
        System.out.println("Feature                 Singly Linked List       Doubly Linked List");
        System.out.println("Links per node          next                     prev and next");
        System.out.println("Traversal               Forward only             Forward and backward");
        System.out.println("Memory per node         Lower                    Higher (extra prev reference)");
        System.out.println("Delete known node       Needs previous node      Can unlink directly with node reference");
        System.out.println("Implementation          Simpler                  More pointer updates");
        System.out.println("Both support insertion, deletion, searching, sorting, reversing and duplicate removal.");
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (SC.hasNextInt()) return SC.nextInt();
            System.out.println("Please enter a valid integer.");
            SC.next();
        }
    }

    private static void result(boolean ok, String yes, String no) { System.out.println(ok ? yes : no); }
    private static void success(String message) { System.out.println(message); }
    private static void printNullable(String label, Integer value) {
        System.out.println(value == null ? "List is empty." : label + ": " + value);
    }
}
