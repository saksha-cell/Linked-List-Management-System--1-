# Project Report: Linked List Management System

## 1. Objective
To develop a menu-driven Java console application that demonstrates the operations of singly and doubly linked lists.

## 2. Introduction
A linked list is a linear data structure made of nodes. Each node stores data and one or more references that connect it to other nodes. Unlike an array, the nodes do not need to be stored next to each other in memory.

## 3. Types implemented
### Singly linked list
Each node stores an integer and a `next` reference. Traversal is forward-only.

### Doubly linked list
Each node stores an integer plus `prev` and `next` references. The list maintains both `head` and `tail`, allowing forward and backward traversal.

## 4. Features
The application supports insertion at the beginning, end, position, before a value and after a value; deletion at the beginning, end, position and by value; search; update; display; count; maximum; minimum; middle element; reverse; ascending sort; and duplicate removal. The doubly linked list also supports backward display. A comparison option summarizes the differences between the two structures.

## 5. Design
`Main.java` handles the console menus and input. `SinglyLinkedList.java` contains singly linked-list operations. `DoublyLinkedList.java` contains doubly linked-list operations. Each list class keeps its node type private so that node links are modified only by the class's methods.

## 6. Algorithms and complexity
- Beginning insertion/deletion: O(1).
- Search, display, count, maximum, minimum and middle: O(n).
- Singly-list end insertion/deletion: O(n), because there is no tail reference.
- Doubly-list end insertion/deletion: O(1), because a tail reference is maintained.
- Reverse: O(n).
- Bubble sort and duplicate removal: O(n²) in this beginner-friendly implementation.

## 7. Edge cases considered
Empty lists, one-node lists, invalid positions, values not found, duplicate values, and operations after reversing or sorting. Positions are 1-based; deleting by value removes the first match.

## 8. Conclusion
The project provides practical experience with node references, traversal, insertion, deletion, searching, and pointer/reference updates. It also demonstrates the trade-off between the simpler singly linked list and the more flexible doubly linked list.

## 9. Possible improvements
Add automated unit tests, support generic data types, implement merge sort for O(n log n) sorting, and separate input handling from the data-structure classes.
