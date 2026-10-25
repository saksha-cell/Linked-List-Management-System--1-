public class DoublyLinkedList {
    private static class Node {
        int data;
        Node prev, next;
        Node(int data) { this.data = data; }
    }

    private Node head, tail;

    public boolean isEmpty() { return head == null; }

    public void insertAtBeginning(int value) {
        Node node = new Node(value);
        if (head == null) { head = tail = node; return; }
        node.next = head;
        head.prev = node;
        head = node;
    }

    public void insertAtEnd(int value) {
        Node node = new Node(value);
        if (tail == null) { head = tail = node; return; }
        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    // Positions are 1-based. Position size + 1 inserts at the end.
    public boolean insertAtPosition(int value, int position) {
        if (position < 1) return false;
        if (position == 1) { insertAtBeginning(value); return true; }
        Node current = head;
        for (int i = 1; current != null && i < position; i++) current = current.next;
        if (current == null) {
            if (position == countNodes() + 1) { insertAtEnd(value); return true; }
            return false;
        }
        Node node = new Node(value);
        node.prev = current.prev;
        node.next = current;
        current.prev.next = node;
        current.prev = node;
        return true;
    }

    public boolean insertAfterValue(int target, int value) {
        Node current = head;
        while (current != null && current.data != target) current = current.next;
        if (current == null) return false;
        if (current == tail) { insertAtEnd(value); return true; }
        Node node = new Node(value);
        node.prev = current;
        node.next = current.next;
        current.next.prev = node;
        current.next = node;
        return true;
    }

    public boolean insertBeforeValue(int target, int value) {
        Node current = head;
        while (current != null && current.data != target) current = current.next;
        if (current == null) return false;
        if (current == head) { insertAtBeginning(value); return true; }
        Node node = new Node(value);
        node.next = current;
        node.prev = current.prev;
        current.prev.next = node;
        current.prev = node;
        return true;
    }

    public boolean deleteFromBeginning() {
        if (head == null) return false;
        if (head == tail) { head = tail = null; return true; }
        head = head.next;
        head.prev = null;
        return true;
    }

    public boolean deleteFromEnd() {
        if (tail == null) return false;
        if (head == tail) { head = tail = null; return true; }
        tail = tail.prev;
        tail.next = null;
        return true;
    }

    public boolean deleteAtPosition(int position) {
        if (position < 1 || head == null) return false;
        Node current = head;
        for (int i = 1; current != null && i < position; i++) current = current.next;
        if (current == null) return false;
        unlink(current);
        return true;
    }

    public boolean deleteByValue(int value) {
        Node current = head;
        while (current != null && current.data != value) current = current.next;
        if (current == null) return false;
        unlink(current);
        return true;
    }

    private void unlink(Node node) {
        if (node.prev == null) head = node.next;
        else node.prev.next = node.next;
        if (node.next == null) tail = node.prev;
        else node.next.prev = node.prev;
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

    public void displayForward() {
        if (head == null) { System.out.println("List is empty."); return; }
        Node current = head;
        while (current != null) { System.out.print(current.data + " <-> "); current = current.next; }
        System.out.println("null");
    }

    public void displayBackward() {
        if (tail == null) { System.out.println("List is empty."); return; }
        Node current = tail;
        while (current != null) { System.out.print(current.data + " <-> "); current = current.prev; }
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
        Node current = head;
        while (current != null) {
            Node temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        Node temp = head;
        head = tail;
        tail = temp;
    }

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
        Node current = head;
        while (current != null) {
            Node runner = current.next;
            while (runner != null) {
                Node next = runner.next;
                if (runner.data == current.data) unlink(runner);
                runner = next;
            }
            current = current.next;
        }
    }
}
