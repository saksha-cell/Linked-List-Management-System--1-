# Linked List Management System (Java)

A menu-driven console project demonstrating **Singly Linked Lists** and **Doubly Linked Lists** in Java. It includes the operations listed in the project brief and a comparison menu.

## Requirements
- JDK 17 or newer (the menu uses modern Java `switch` arrow syntax).
- VS Code, IntelliJ IDEA, or any Java IDE; alternatively, use a terminal.

## Project structure
```text
Linked-List-Management-System/
├── src/
│   ├── Main.java
│   ├── SinglyLinkedList.java
│   └── DoublyLinkedList.java
├── sample-output/
│   └── output.txt
├── docs/
│   └── PROJECT-REPORT.md
├── README.md
└── .gitignore
```

## Compile and run
Open a terminal in the project root folder and run:

```bash
javac -d out src/*.java
java -cp out Main
```

On Windows PowerShell, these commands work in a normal JDK terminal too. In VS Code, make sure the terminal's current directory is the project root.

## Main menu
1. Singly Linked List
2. Doubly Linked List
3. Compare Singly vs Doubly Linked List
4. Exit

### Singly linked list operations
- Insert at beginning / end / position
- Insert before / after the first matching value
- Delete from beginning / end / position / by value
- Search and update the first matching value
- Display, count, maximum, minimum, middle
- Reverse, sort ascending, remove duplicates

### Doubly linked list operations
- The same insertion, deletion, search, update, count, max/min/middle, reverse, sort and duplicate-removal operations
- Display forward and backward

## Behaviour and assumptions
- Positions are **1-based**.
- Insertion at position `size + 1` appends to the end; positions outside the valid range are rejected.
- Delete-by-value, search, update, insert-before and insert-after use the **first matching value**.
- For an even number of nodes, `findMiddle()` returns the second middle node.
- Sorting uses bubble sort by swapping node data. This is easy to understand for a beginner project but has `O(n²)` time complexity.
- Removing duplicates keeps the first occurrence of each value and uses a simple `O(n²)` approach.
- Java manages memory automatically, so there is no explicit `free` or `delete` operation for node memory.

## Complexity overview
| Operation | Singly list | Doubly list |
|---|---:|---:|
| Insert at beginning | O(1) | O(1) |
| Insert at end | O(n) | O(1) (tail reference maintained) |
| Search / display / count | O(n) | O(n) |
| Delete at beginning | O(1) | O(1) |
| Delete at end | O(n) | O(1) (tail reference maintained) |
| Reverse | O(n) | O(n) |
| Bubble sort | O(n²) | O(n²) |
| Remove duplicates | O(n²) | O(n²) |

## Suggested test cases
1. Display an empty list.
2. Insert one value and delete it from beginning/end.
3. Insert at position 1 and at `size + 1`.
4. Try position 0 and a position beyond the end.
5. Search for an existing and a missing value.
6. Delete a missing value.
7. Insert duplicates, remove duplicates, and verify the first occurrence remains.
8. Reverse and sort empty, one-node, and multi-node lists.
9. For a doubly linked list, display forward and backward before and after reversing.

## GitHub submission
1. Create a repository on GitHub named `Linked-List-Management-System`.
2. Upload these folders and files, or push the project using Git.
3. Confirm the README appears on the repository home page.
4. Copy the repository URL and submit it as directed by your teacher.

This repository contains source code and a sample-output file. Review the code, run the test cases, and make sure you can explain each operation before submitting it.
