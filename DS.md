# Data Structures in Java

This document provides definitions, Java syntax examples, and **memorable** real-world applications of common data structures to help you quickly recall when and why to use each one.

---

## 1. Array

**Definition:** A fixed-size, ordered collection of elements of the same type, stored contiguously in memory.

**Java Syntax:**
```java
int[] numbers = new int[10];
String[] fruits = {"Apple", "Banana", "Cherry"};
```

**Real-World Application:**
- **Movie Theater Seating:** Seats numbered 1–100 are mapped directly to array indices, letting you jump instantly to seat 50.
- **Weekly Schedule:** Days Monday–Sunday stored in an array of size 7, enabling direct lookup by day index.

**Clarification:**
- Arrays have O(1) access by index but fixed size; to resize, create a new array and copy elements.

---

## 2. LinkedList

**Definition:** A dynamic collection of elements (nodes), where each node holds data and a reference to the next (and optionally previous) node.

**Java Syntax:**
```java
import java.util.LinkedList;
LinkedList<String> playlist = new LinkedList<>();
playlist.add("Song1");
playlist.addFirst("Intro");
```

**Real-World Application:**
- **Train Cars:** Attaching or detaching cars at either end of a train instantly, like adding elements at the head or tail.
- **Music Playlist:** Easily insert or remove songs anywhere in the playlist without shifting all tracks.

**Clarification:**
- Excellent for fast O(1) insertions/removals at ends, but O(n) for random access.

---

## 3. Stack

**Definition:** A LIFO (Last-In, First-Out) data structure supporting push and pop operations.

**Java Syntax:**
```java
import java.util.Stack;
Stack<Integer> stack = new Stack<>();
stack.push(10);
int top = stack.pop();
```

**Real-World Application:**
- **Stack of Plates:** The last plate placed is the first one you take.
- **Browser Back Button:** The last page visited is the first one you return to when hitting back.

**Clarification:**
- `peek()` lets you view the top without removing it.

---

## 4. Queue

**Definition:** A FIFO (First-In, First-Out) data structure supporting enqueue and dequeue operations.

**Java Syntax:**
```java
import java.util.Queue;
import java.util.LinkedList;
Queue<String> line = new LinkedList<>();
line.offer("Alice");
String first = line.poll();
```

**Real-World Application:**
- **Grocery Store Line:** First customer who gets in line is the first served.
- **Print Queue:** Documents print in the order submitted.

**Clarification:**
- Use `offer()`/`poll()` for safe operations (no exceptions on failure).

---

## 5. Deque (Double-Ended Queue)

**Definition:** A queue that allows insertion and removal at both ends.

**Java Syntax:**
```java
import java.util.ArrayDeque;
ArrayDeque<Integer> deck = new ArrayDeque<>();
deck.addFirst(1);
deck.addLast(2);
```

**Real-World Application:**
- **Deck of Cards:** Draw or place cards on either the top or bottom.
- **Undo/Redo Stack:** Maintain actions so you can undo (pop from one end) or redo (pop from the other).

**Clarification:**
- `ArrayDeque` is typically faster than `LinkedList` for deque operations.

---

## 6. HashMap

**Definition:** A key-value store with average constant-time (O(1)) put and get operations, using hashing.

**Java Syntax:**
```java
import java.util.HashMap;
HashMap<String, Integer> phoneBook = new HashMap<>();
phoneBook.put("Alice", 12345);
```

**Real-World Application:**
- **Phone Book:** Map a person’s name to their phone number for instant lookup.
- **Web Cache:** Map URLs to their cached HTML content.

**Clarification:**
- Collisions handled with chaining; worst-case can degrade to O(n).

---

## 7. HashSet

**Definition:** A collection of unique elements backed by a HashMap for constant-time operations.

**Java Syntax:**
```java
import java.util.HashSet;
HashSet<String> guestList = new HashSet<>();
guestList.add("Bob");
```

**Real-World Application:**
- **Guest List:** Ensure no duplicate invites for an event.
- **Unique Hashtags:** Track distinct hashtags in a stream of tweets.

**Clarification:**
- No guaranteed order; use `LinkedHashSet` for insertion-order.

---

## 8. TreeMap

**Definition:** A red-black tree implementation of `SortedMap`, maintaining keys in sorted order.

**Java Syntax:**
```java
import java.util.TreeMap;
TreeMap<Integer, String> leaderboard = new TreeMap<>();
leaderboard.put(1, "Alice");
```

**Real-World Application:**
- **Dictionary:** Words stored alphabetically for quick range queries.
- **Bank Ledger:** Transactions sorted by date.

**Clarification:**
- All operations run in O(log n) time.

---

## 9. PriorityQueue (Heap)

**Definition:** A min-heap (by default) implementation of a priority queue, retrieving the smallest (or highest priority) element first.

**Java Syntax:**
```java
import java.util.PriorityQueue;
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.offer(5);
int highest = pq.poll();
```

**Real-World Application:**
- **Hospital Triage:** Treat the most critical patient first.
- **Task Scheduler:** Execute the highest priority task first.

**Clarification:**
- Can supply a custom comparator for max-heap behavior.

---

## 10. Graph

**Definition:** A set of vertices (nodes) connected by edges, which can be directed or undirected, weighted or unweighted.

**Java Syntax (Adjacency List):**
```java
Map<Integer, List<Integer>> graph = new HashMap<>();
void addEdge(int u, int v) {
  graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
}
```

**Real-World Application:**
- **Road Map:** Cities as nodes and roads as edges for route planning.
- **Social Network:** Users connected by friend relationships.

**Clarification:**
- Use adjacency lists for sparse graphs; adjacency matrices for dense graphs.

---

## 11. Trie (Prefix Tree)

**Definition:** A tree-like data structure for efficient retrieval of strings, where each node represents a character.

**Java Syntax (Skeleton):**
```java
class TrieNode { TrieNode[] children = new TrieNode[26]; boolean isEnd; }
class Trie { void insert(String w) { /* ... */ } }
```

**Real-World Application:**
- **Autocomplete:** Suggest words as you type on your phone keyboard.
- **DNS Resolver:** Quickly match domain prefixes.

**Clarification:**
- Can be memory-heavy; consider compressed tries (radix trees) if needed.

---

## 12. Union-Find (Disjoint Set)

**Definition:** A structure to track partitions of elements into disjoint sets, supporting `find` and `union`.

**Java Syntax (Simplified):**
```java
class UF { int[] p; UF(int n){ p=new int[n]; Arrays.fill(p,-1);} int find(int x){/*...*/} void union(int a,int b){/*...*/} }
```

**Real-World Application:**
- **Party Groups:** Determine which guests are in the same friend circle.
- **Network Clusters:** Manage connected components in computer networks.

**Clarification:**
- With path compression and union by rank, nearly O(1) per operation.

---

## 13. Segment Tree

**Definition:** A binary tree for storing intervals, enabling fast range queries and updates.

**Java Syntax (High-Level):**
```java
class SegTree { int[] t; SegTree(int[] a){/*...*/} }
```

**Real-World Application:**
- **Temperature Tracker:** Quickly find max temperature between day 1 and day 7.
- **Leaderboard Ranges:** Sum or max scores in a range of players.

**Clarification:**
- O(n) memory, O(log n) per query/update.

---

## 14. Fenwick Tree (Binary Indexed Tree)

**Definition:** An array-based structure for efficient prefix-sum queries and updates.

**Java Syntax:**
```java
class BIT { int[] b; BIT(int n){b=new int[n+1];} void upd(int i,int v){/*...*/} int qry(int i){/*...*/} }
```

**Real-World Application:**
- **Rainfall Records:** Instant cumulative rainfall from day 1 to day k.
- **Likes Counter:** Prefix totals of likes on social media posts in real time.

**Clarification:**
- Simpler to implement than segment trees, with O(log n) operations.

---



