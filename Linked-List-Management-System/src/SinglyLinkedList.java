public class SinglyLinkedList {
    private static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node head;

    public boolean isEmpty() { return head == null; }

    public void insertAtBeginning(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
    }

    public void insertAtEnd(int value) {
        Node node = new Node(value);
        if (head == null) { head = node; return; }
        Node current = head;
        while (current.next != null) current = current.next;
        current.next = node;
    }

    // Positions are 1-based. Position size + 1 inserts at the end.
    public boolean insertAtPosition(int value, int position) {
        if (position < 1) return false;
        if (position == 1) { insertAtBeginning(value); return true; }
        Node current = head;
        for (int i = 1; current != null && i < position - 1; i++) current = current.next;
        if (current == null) return false;
        Node node = new Node(value);
        node.next = current.next;
        current.next = node;
        return true;
    }

    // Inserts after the first node containing target.
    public boolean insertAfterValue(int target, int value) {
        Node current = head;
        while (current != null && current.data != target) current = current.next;
        if (current == null) return false;
        Node node = new Node(value);
        node.next = current.next;
        current.next = node;
        return true;
    }

    // Inserts before the first node containing target.
    public boolean insertBeforeValue(int target, int value) {
        if (head == null) return false;
        if (head.data == target) { insertAtBeginning(value); return true; }
        Node current = head;
        while (current.next != null && current.next.data != target) current = current.next;
        if (current.next == null) return false;
        Node node = new Node(value);
        node.next = current.next;
        current.next = node;
        return true;
    }

    public boolean deleteFromBeginning() {
        if (head == null) return false;
        head = head.next;
        return true;
    }

    public boolean deleteFromEnd() {
        if (head == null) return false;
        if (head.next == null) { head = null; return true; }
        Node current = head;
        while (current.next.next != null) current = current.next;
        current.next = null;
        return true;
    }

    public boolean deleteAtPosition(int position) {
        if (position < 1 || head == null) return false;
        if (position == 1) return deleteFromBeginning();
        Node current = head;
        for (int i = 1; current.next != null && i < position - 1; i++) current = current.next;
        if (current.next == null) return false;
        current.next = current.next.next;
        return true;
    }

    // Deletes only the first matching value.
    public boolean deleteByValue(int value) {
        if (head == null) return false;
        if (head.data == value) return deleteFromBeginning();
        Node current = head;
        while (current.next != null && current.next.data != value) current = current.next;
        if (current.next == null) return false;
        current.next = current.next.next;
        return true;
    }

    public int search(int value) {
        Node current = head;
        int position = 1;
        while (current != null) {
            if (current.data == value) return position;
            current = current.next;
            position++;
        }
        return -1;
    }

    public boolean updateFirst(int oldValue, int newValue) {
        Node current = head;
        while (current != null) {
            if (current.data == oldValue) { current.data = newValue; return true; }
            current = current.next;
        }
        return false;
    }

    public void display() {
        if (head == null) { System.out.println("List is empty."); return; }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int countNodes() {
        int count = 0;
        for (Node current = head; current != null; current = current.next) count++;
        return count;
    }

    public Integer findMaximum() {
        if (head == null) return null;
        int max = head.data;
        for (Node current = head.next; current != null; current = current.next) if (current.data > max) max = current.data;
        return max;
    }

    public Integer findMinimum() {
        if (head == null) return null;
        int min = head.data;
        for (Node current = head.next; current != null; current = current.next) if (current.data < min) min = current.data;
        return min;
    }

    // For even-sized lists, returns the second middle node.
    public Integer findMiddle() {
        if (head == null) return null;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) { slow = slow.next; fast = fast.next.next; }
        return slow.data;
    }

    public void reverse() {
        Node previous = null, current = head;
        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    // Bubble sort by swapping node data; O(n^2).
    public void sort() {
        if (head == null) return;
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                if (current.data > current.next.data) {
                    int temp = current.data; current.data = current.next.data; current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public void removeDuplicates() {
        for (Node current = head; current != null; current = current.next) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) runner.next = runner.next.next;
                else runner = runner.next;
            }
        }
    }
}
