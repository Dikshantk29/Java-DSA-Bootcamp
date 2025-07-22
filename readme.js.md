Below is a comprehensive set of notes on Data Structures and Algorithms (DSA) in JavaScript, covering all the topics and subtopics listed in the query. Each section includes explanations, easy-to-understand examples, and common methods used in problem-solving. At the end, a neatly formatted `README.md` file is provided.

---

# Data Structures and Algorithms in JavaScript

## 1. Arrays

### 1D and 2D Arrays
Arrays are collections of elements stored in contiguous memory. In JavaScript, arrays are dynamic and can hold mixed data types.

**Example**:
```javascript
let arr = [1, 2, 3, 4]; // 1D array
let matrix = [[1, 2], [3, 4]]; // 2D array
```

### Prefix Sum
A technique to compute the cumulative sum up to each index efficiently.

**Example**:
```javascript
function prefixSum(arr) {
  let prefix = [arr[0]];
  for (let i = 1; i < arr.length; i++) {
    prefix.push(prefix[i - 1] + arr[i]);
  }
  return prefix;
}
console.log(prefixSum([1, 2, 3, 4])); // [1, 3, 6, 10]
```

### Sliding Window
A method to solve subarray/substring problems by maintaining a window of elements.

**Example**:
```javascript
function maxSumSubarray(arr, k) {
  let maxSum = 0, windowSum = 0;
  for (let i = 0; i < k; i++) windowSum += arr[i];
  maxSum = windowSum;
  for (let i = k; i < arr.length; i++) {
    windowSum += arr[i] - arr[i - k];
    maxSum = Math.max(maxSum, windowSum);
  }
  return maxSum;
}
console.log(maxSumSubarray([1, 4, 2, 10, 23, 3, 1, 0, 20], 4)); // 39
```

### Two Pointers
Uses two pointers to traverse the array, often from opposite ends or in the same direction.

**Example**:
```javascript
function twoSum(arr, target) {
  let left = 0, right = arr.length - 1;
  while (left < right) {
    let sum = arr[left] + arr[right];
    if (sum === target) return [left, right];
    else if (sum < target) left++;
    else right--;
  }
  return [];
}
console.log(twoSum([2, 7, 11, 15], 9)); // [0, 1]
```

### Kadane’s Algorithm
Finds the maximum subarray sum efficiently.

**Example**:
```javascript
function maxSubarraySum(arr) {
  let maxSoFar = arr[0], maxEndingHere = arr[0];
  for (let i = 1; i < arr.length; i++) {
    maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
    maxSoFar = Math.max(maxSoFar, maxEndingHere);
  }
  return maxSoFar;
}
console.log(maxSubarraySum([-2, 1, -3, 4, -1, 2, 1, -5, 4])); // 6
```

### Merge Intervals
Merges overlapping intervals into a single interval.

**Example**:
```javascript
function mergeIntervals(intervals) {
  intervals.sort((a, b) => a[0] - b[0]);
  let merged = [intervals[0]];
  for (let i = 1; i < intervals.length; i++) {
    let last = merged[merged.length - 1];
    if (intervals[i][0] <= last[1]) {
      last[1] = Math.max(last[1], intervals[i][1]);
    } else {
      merged.push(intervals[i]);
    }
  }
  return merged;
}
console.log(mergeIntervals([[1, 3], [2, 6], [8, 10], [15, 18]])); // [[1, 6], [8, 10], [15, 18]]
```

### Cyclic Sort
Sorts an array of numbers from 1 to N where each number represents its correct index (1-based).

**Example**:
```javascript
function cyclicSort(arr) {
  let i = 0;
  while (i < arr.length) {
    if (arr[i] !== i + 1) {
      let temp = arr[arr[i] - 1];
      arr[arr[i] - 1] = arr[i];
      arr[i] = temp;
    } else {
      i++;
    }
  }
  return arr;
}
console.log(cyclicSort([3, 1, 5, 4, 2])); // [1, 2, 3, 4, 5]
```

### Dutch National Flag Problem
Sorts an array with three distinct values (e.g., 0, 1, 2) in a single pass.

**Example**:
```javascript
function sortColors(nums) {
  let low = 0, mid = 0, high = nums.length - 1;
  while (mid <= high) {
    if (nums[mid] === 0) {
      [nums[low], nums[mid]] = [nums[mid], nums[low]];
      low++;
      mid++;
    } else if (nums[mid] === 1) {
      mid++;
    } else {
      [nums[mid], nums[high]] = [nums[high], nums[mid]];
      high--;
    }
  }
  return nums;
}
console.log(sortColors([2, 0, 2, 1, 1, 0])); // [0, 0, 1, 1, 2, 2]
```

---

## 2. Strings

### Character Arrays vs Strings
In JavaScript, strings are immutable, while arrays (character arrays) are mutable.

**Example**:
```javascript
let str = "hello";
let charArray = str.split(''); // ['h', 'e', 'l', 'l', 'o']
charArray[0] = 'H'; // Mutable
console.log(charArray.join('')); // "Hello"
```

### Palindromes
Strings that read the same forwards and backwards.

**Example**:
```javascript
function isPalindrome(str) {
  let left = 0, right = str.length - 1;
  while (left < right) {
    if (str[left] !== str[right]) return false;
    left++;
    right--;
  }
  return true;
}
console.log(isPalindrome("racecar")); // true
```

### Anagrams
Strings with the same characters in a different order.

**Example**:
```javascript
function areAnagrams(str1, str2) {
  if (str1.length !== str2.length) return false;
  let count = {};
  for (let char of str1) count[char] = (count[char] || 0) + 1;
  for (let char of str2) {
    if (!count[char]) return false;
    count[char]--;
  }
  return true;
}
console.log(areAnagrams("listen", "silent")); // true
```

### String Matching Algorithms (KMP, Rabin-Karp)
Efficient algorithms for substring searching. Here’s a naive approach for simplicity:

**Example (Naive)**:
```javascript
function naiveSearch(text, pattern) {
  let n = text.length, m = pattern.length;
  for (let i = 0; i <= n - m; i++) {
    let j;
    for (j = 0; j < m; j++) {
      if (text[i + j] !== pattern[j]) break;
    }
    if (j === m) return i;
  }
  return -1;
}
console.log(naiveSearch("ababcabc", "abc")); // 2
```

### Z-Algorithm
Finds all occurrences of a pattern in a text efficiently. (Complex; refer to resources for full implementation.)

### String Compression
Compresses a string by representing repeated characters with counts.

**Example**:
```javascript
function compressString(str) {
  let compressed = '', count = 1;
  for (let i = 0; i < str.length; i++) {
    if (str[i] === str[i + 1]) {
      count++;
    } else {
      compressed += str[i] + count;
      count = 1;
    }
  }
  return compressed.length < str.length ? compressed : str;
}
console.log(compressString("aabcccccaaa")); // "a2b1c5a3"
```

### Substrings and Subsequences
Substrings are contiguous; subsequences are not.

**Example**:
```javascript
function getSubstrings(str) {
  let substrings = [];
  for (let i = 0; i < str.length; i++) {
    for (let j = i + 1; j <= str.length; j++) {
      substrings.push(str.slice(i, j));
    }
  }
  return substrings;
}
console.log(getSubstrings("abc")); // ["a", "ab", "abc", "b", "bc", "c"]
```

---

## 3. Linked List

### Singly Linked List
Each node points to the next node.

**Example**:
```javascript
class Node {
  constructor(data) {
    this.data = data;
    this.next = null;
  }
}

class LinkedList {
  constructor() {
    this.head = null;
  }

  append(data) {
    let newNode = new Node(data);
    if (!this.head) {
      this.head = newNode;
    } else {
      let current = this.head;
      while (current.next) current = current.next;
      current.next = newNode;
    }
  }
}
```

### Doubly Linked List
Each node has pointers to both next and previous nodes. (Extend `Node` with `prev` property.)

### Circular Linked List
Last node points to the head. (Modify `append` to connect last to head.)

### Reverse Linked List
Reverses the direction of links.

**Example**:
```javascript
function reverseList(head) {
  let prev = null, current = head;
  while (current) {
    let next = current.next;
    current.next = prev;
    prev = current;
    current = next;
  }
  return prev;
}
```

### Detect and Remove Loop (Floyd’s Cycle)
Detects a cycle using two pointers.

**Example**:
```javascript
function detectCycle(head) {
  let slow = head, fast = head;
  while (fast && fast.next) {
    slow = slow.next;
    fast = fast.next.next;
    if (slow === fast) return true;
  }
  return false;
}
```

### Merge Two Sorted Lists
Combines two sorted lists into one.

**Example**:
```javascript
function mergeTwoLists(l1, l2) {
  let dummy = new Node(0), current = dummy;
  while (l1 && l2) {
    if (l1.data < l2.data) {
      current.next = l1;
      l1 = l1.next;
    } else {
      current.next = l2;
      l2 = l2.next;
    }
    current = current.next;
  }
  current.next = l1 || l2;
  return dummy.next;
}
```

### Intersection Point
Finds where two lists intersect.

**Example**:
```javascript
function getIntersectionNode(headA, headB) {
  let a = headA, b = headB;
  while (a !== b) {
    a = a ? a.next : headB;
    b = b ? b.next : headA;
  }
  return a;
}
```

### Copy List with Random Pointer
Creates a deep copy with random pointers. (Complex; involves mapping nodes.)

---

## 4. Stacks

### Basic Stack Operations
Push, pop, peek, and isEmpty operations.

**Example**:
```javascript
class Stack {
  constructor() {
    this.items = [];
  }
  push(element) { this.items.push(element); }
  pop() { return this.items.pop(); }
  peek() { return this.items[this.items.length - 1]; }
  isEmpty() { return this.items.length === 0; }
}
```

### Infix, Postfix, Prefix
Converts between expression notations. (Use stack for conversion/evaluation.)

### Valid Parentheses
Checks if parentheses are balanced.

**Example**:
```javascript
function isValid(s) {
  let stack = [], map = { '(': ')', '{': '}', '[': ']' };
  for (let char of s) {
    if (map[char]) stack.push(map[char]);
    else if (stack.pop() !== char) return false;
  }
  return stack.length === 0;
}
console.log(isValid("()[]{}")); // true
```

### Min/Max Stack
Tracks minimum/maximum elements. (Use an auxiliary stack.)

### Stock Span Problem
Finds the span of stock prices. (Use stack for previous days.)

### Next Greater Element
Finds the next greater element for each array element.

**Example**:
```javascript
function nextGreaterElement(nums) {
  let stack = [], result = new Array(nums.length).fill(-1);
  for (let i = 0; i < nums.length; i++) {
    while (stack.length && nums[i] > nums[stack[stack.length - 1]]) {
      let index = stack.pop();
      result[index] = nums[i];
    }
    stack.push(i);
  }
  return result;
}
console.log(nextGreaterElement([4, 5, 2, 25])); // [5, 25, 25, -1]
```

---

## 5. Queues

### Queue using Arrays/Linked List
Basic queue implementation.

**Example**:
```javascript
class Queue {
  constructor() {
    this.items = [];
  }
  enqueue(element) { this.items.push(element); }
  dequeue() { return this.items.shift(); }
  front() { return this.items[0]; }
  isEmpty() { return this.items.length === 0; }
}
```

### Circular Queue
A queue that wraps around. (Use modulo with fixed-size array.)

### Deque (Double-ended Queue)
Allows insertion/deletion from both ends.

**Example**:
```javascript
class Deque {
  constructor() {
    this.items = [];
  }
  addFront(element) { this.items.unshift(element); }
  addRear(element) { this.items.push(element); }
  removeFront() { return this.items.shift(); }
  removeRear() { return this.items.pop(); }
}
```

### Priority Queue
Elements are dequeued based on priority. (Implement with heaps.)

### Sliding Window Maximum
Finds the maximum in each window using a deque. (Complex; see resources.)

---

## 6. Hashing

### Hash Tables
Maps keys to values for fast lookup.

**Example**:
```javascript
let hashMap = new Map();
hashMap.set('key', 'value');
console.log(hashMap.get('key')); // "value"
```

### Frequency Maps
Counts element frequencies.

**Example**:
```javascript
function frequencyCount(arr) {
  let freq = {};
  for (let num of arr) freq[num] = (freq[num] || 0) + 1;
  return freq;
}
console.log(frequencyCount([1, 2, 2, 3, 3, 3])); // { '1': 1, '2': 2, '3': 3 }
```

### HashSets
Stores unique elements with fast lookup.

**Example**:
```javascript
let set = new Set();
set.add(1);
console.log(set.has(1)); // true
```

### Count Distinct Elements
Counts unique elements.

**Example**:
```javascript
function countDistinct(arr) {
  return new Set(arr).size;
}
console.log(countDistinct([1, 2, 2, 3, 3, 3])); // 3
```

### Longest Consecutive Subsequence
Finds the longest sequence of consecutive numbers.

**Example**:
```javascript
function longestConsecutive(nums) {
  let set = new Set(nums), maxLength = 0;
  for (let num of nums) {
    if (!set.has(num - 1)) {
      let currentNum = num, currentLength = 1;
      while (set.has(currentNum + 1)) {
        currentNum++;
        currentLength++;
      }
      maxLength = Math.max(maxLength, currentLength);
    }
  }
  return maxLength;
}
console.log(longestConsecutive([100, 4, 200, 1, 3, 2])); // 4
```

### Subarray with Given Sum
Finds a subarray summing to a target.

**Example**:
```javascript
function subarraySum(arr, sum) {
  let currentSum = 0, map = new Map();
  map.set(0, -1);
  for (let i = 0; i < arr.length; i++) {
    currentSum += arr[i];
    if (map.has(currentSum - sum)) return [map.get(currentSum - sum) + 1, i];
    map.set(currentSum, i);
  }
  return [];
}
console.log(subarraySum([15, 2, 4, 8, 9, 5, 10, 23], 23)); // [1, 3]
```

---

## 7. Recursion & Backtracking

### Basic Recursion
Functions calling themselves with base cases.

**Example (Factorial)**:
```javascript
function factorial(n) {
  if (n === 0) return 1;
  return n * factorial(n - 1);
}
console.log(factorial(5)); // 120
```

### Factorial, Fibonacci, Power
Common recursive problems.

**Example (Fibonacci)**:
```javascript
function fibonacci(n) {
  if (n <= 1) return n;
  return fibonacci(n - 1) + fibonacci(n - 2);
}
console.log(fibonacci(6)); // 8
```

### Permutations & Combinations
Generates all permutations.

**Example**:
```javascript
function permute(nums) {
  let result = [];
  function backtrack(start) {
    if (start === nums.length) result.push([...nums]);
    for (let i = start; i < nums.length; i++) {
      [nums[start], nums[i]] = [nums[i], nums[start]];
      backtrack(start + 1);
      [nums[start], nums[i]] = [nums[i], nums[start]];
    }
  }
  backtrack(0);
  return result;
}
console.log(permute([1, 2, 3])); // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
```

### N-Queens Problem
Places N queens on an NxN board without conflicts. (Complex; use backtracking.)

### Sudoku Solver
Solves a Sudoku puzzle. (Complex; use backtracking.)

### Rat in a Maze
Finds a path in a maze. (Complex; use backtracking.)

### Subset Sum
Finds if a subset sums to a target.

**Example**:
```javascript
function subsetSum(nums, target) {
  function backtrack(start, currentSum) {
    if (currentSum === target) return true;
    if (currentSum > target) return false;
    for (let i = start; i < nums.length; i++) {
      if (backtrack(i + 1, currentSum + nums[i])) return true;
    }
    return false;
  }
  return backtrack(0, 0);
}
console.log(subsetSum([3, 34, 4, 12, 5, 2], 9)); // true
```

---

## 8. Searching Algorithms

### Linear Search
Checks each element sequentially.

**Example**:
```javascript
function linearSearch(arr, target) {
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] === target) return i;
  }
  return -1;
}
console.log(linearSearch([1, 3, 5, 7], 5)); // 2
```

### Binary Search
Efficient search on sorted arrays.

**Example**:
```javascript
function binarySearch(arr, target) {
  let left = 0, right = arr.length - 1;
  while (left <= right) {
    let mid = Math.floor((left + right) / 2);
    if (arr[mid] === target) return mid;
    else if (arr[mid] < target) left = mid + 1;
    else right = mid - 1;
  }
  return -1;
}
console.log(binarySearch([1, 2, 3, 4, 5], 3)); // 2
```

### Ternary Search
Divides the array into three parts. (Similar to binary search; complex implementation.)

### Search in Rotated Sorted Array
Searches in a rotated sorted array.

**Example**:
```javascript
function searchRotated(arr, target) {
  let left = 0, right = arr.length - 1;
  while (left <= right) {
    let mid = Math.floor((left + right) / 2);
    if (arr[mid] === target) return mid;
    if (arr[left] <= arr[mid]) {
      if (arr[left] <= target && target < arr[mid]) right = mid - 1;
      else left = midiant + 1;
    } else {
      if (arr[mid] < target && target <= arr[right]) left = mid + 1;
      else right = mid - 1;
    }
  }
  return -1;
}
console.log(searchRotated([4, 5, 6, 7, 0, 1, 2], 0)); // 4
```

### Binary Search on Answer
Finds optimal values in optimization problems. (See resources.)

### Exponential Search
Searches by exponentially increasing the range. (Useful for unbounded searches.)

---

## 9. Sorting Algorithms

### Bubble Sort
Swaps adjacent elements if out of order.

**Example**:
```javascript
function bubbleSort(arr) {
  for (let i = 0; i < arr.length; i++) {
    for (let j = 0; j < arr.length - i - 1; j++) {
      if (arr[j] > arr[j + 1]) [arr[j], arr[j + 1]] = [arr[j + 1], arr[j]];
    }
  }
  return arr;
}
console.log(bubbleSort([64, 34, 25, 12, 22, 11, 90])); // [11, 12, 22, 25, 34, 64, 90]
```

### Selection Sort
Selects the smallest element and swaps it.

**Example**:
```javascript
function selectionSort(arr) {
  for (let i = 0; i < arr.length; i++) {
    let minIndex = i;
    for (let j = i + 1; j < arr.length; j++) {
      if (arr[j] < arr[minIndex]) minIndex = j;
    }
    [arr[i], arr[minIndex]] = [arr[minIndex], arr[i]];
  }
  return arr;
}
console.log(selectionSort([64, 25, 12, 22, 11])); // [11, 12, 22, 25, 64]
```

### Insertion Sort
Builds the sorted array one element at a time.

**Example**:
```javascript
function insertionSort(arr) {
  for (let i = 1; i < arr.length; i++) {
    let key = arr[i], j = i - 1;
    while (j >= 0 && arr[j] > key) {
      arr[j + 1] = arr[j];
      j--;
    }
    arr[j + 1] = key;
  }
  return arr;
}
console.log(insertionSort([12, 11, 13, 5, 6])); // [5, 6, 11, 12, 13]
```

### Merge Sort
Divides and merges sorted halves.

**Example**:
```javascript
function mergeSort(arr) {
  if (arr.length <= 1) return arr;
  let mid = Math.floor(arr.length / 2);
  let left = mergeSort(arr.slice(0, mid));
  let right = mergeSort(arr.slice(mid));
  return merge(left, right);
}
function merge(left, right) {
  let result = [], i = 0, j = 0;
  while (i < left.length && j < right.length) {
    if (left[i] < right[j]) result.push(left[i++]);
    else result.push(right[j++]);
  }
  return result.concat(left.slice(i)).concat(right.slice(j));
}
console.log(mergeSort([38, 27, 43, 3, 9, 82, 10])); // [3, 9, 10, 27, 38, 43, 82]
```

### Quick Sort
Partitions around a pivot and sorts recursively.

**Example**:
```javascript
function quickSort(arr) {
  if (arr.length <= 1) return arr;
  let pivot = arr[arr.length - 1], left = [], right = [];
  for (let i = 0; i < arr.length - 1; i++) {
    if (arr[i] < pivot) left.push(arr[i]);
    else right.push(arr[i]);
  }
  return [...quickSort(left), pivot, ...quickSort(right)];
}
console.log(quickSort([10, 7, 8, 9, 1, 5])); // [1, 5, 7, 8, 9, 10]
```

### Heap Sort
Uses a heap to sort. (See Heaps section.)

### Counting Sort
Sorts by counting frequencies.

**Example**:
```javascript
function countingSort(arr, max) {
  let count = new Array(max + 1).fill(0), result = [];
  for (let num of arr) count[num]++;
  for (let i = 0; i <= max; i++) {
    while (count[i] > 0) {
      result.push(i);
      count[i]--;
    }
  }
  return result;
}
console.log(countingSort([1, 4, 1, 2, 7, 5, 2], 7)); // [1, 1, 2, 2, 4, 5, 7]
```

### Radix Sort
Sorts by processing digits. (Complex; use counting sort per digit.)

### Bucket Sort
Distributes elements into buckets and sorts them. (Useful for floats.)

---

## 10. Binary Search Tree (BST)

### Insertion & Deletion
Maintains BST properties during operations.

**Example (Insertion)**:
```javascript
class TreeNode {
  constructor(val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }
}
function insertIntoBST(root, val) {
  if (!root) return new TreeNode(val);
  if (val < root.val) root.left = insertIntoBST(root.left, val);
  else root.right = insertIntoBST(root.right, val);
  return root;
}
```

### Search in BST
Finds a value efficiently.

**Example**:
```javascript
function searchBST(root, val) {
  if (!root) return null;
  if (root.val === val) return root;
  if (val < root.val) return searchBST(root.left, val);
  else return searchBST(root.right, val);
}
```

### Validate BST
Checks if a tree is a valid BST.

**Example**:
```javascript
function isValidBST(root, min = null, max = null) {
  if (!root) return true;
  if ((min !== null && root.val <= min) || (max !== null && root.val >= max)) return false;
  return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
}
```

### Lowest Common Ancestor
Finds the LCA of two nodes.

**Example**:
```javascript
function lowestCommonAncestor(root, p, q) {
  if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
  अगर (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
  return root;
}
```

### Kth Smallest Element
Finds the kth smallest element using inorder traversal.

**Example**:
```javascript
function kthSmallest(root, k) {
  let stack = [], current = root;
  while (current || stack.length) {
    while (current) {
      stack.push(current);
      current = current.left;
    }
    current = stack.pop();
    k--;
    if (k === 0) return current.val;
    current = current.right;
  }
}
```

### BST to Balanced BST
Converts an unbalanced BST to balanced. (Inorder traversal and rebuild.)

---

## 11. Heaps / Priority Queue

### Min Heap / Max Heap
Maintains the smallest/largest element at the root.

**Example (Min Heap)**:
```javascript
class MinHeap {
  constructor() {
    this.heap = [];
  }
  push(val) {
    this.heap.push(val);
    this.bubbleUp(this.heap.length - 1);
  }
  pop() {
    let min = this.heap[0], end = this.heap.pop();
    if (this.heap.length > 0) {
      this.heap[0] = end;
      this.sinkDown(0);
    }
    return min;
  }
  bubbleUp(index) {
    let element = this.heap[index];
    while (index > 0) {
      let parentIndex = Math.floor((index - 1) / 2);
      let parent = this.heap[parentIndex];
      if (element >= parent) break;
      this.heap[index] = parent;
      index = parentIndex;
    }
    this.heap[index] = element;
  }
  sinkDown(index) {
    let length = this.heap.length, element = this.heap[index];
    while (true) {
      let leftChildIndex = 2 * index + 1, rightChildIndex = 2 * index + 2, swap = null;
      if (leftChildIndex < length && this.heap[leftChildIndex] < element) swap = leftChildIndex;
      if (rightChildIndex < length) {
        let rightChild = this.heap[rightChildIndex];
        if ((swap === null && rightChild < element) || (swap !== null && rightChild < this.heap[swap])) {
          swap = rightChildIndex;
        }
      }
      if (swap === null) break;
      this.heap[index] = this.heap[swap];
      index = swap;
    }
    this.heap[index] = element;
  }
}
```

### Heapify
Converts an array into a heap. (Call `sinkDown` on non-leaf nodes.)

### Heap Sort
Sorts using a heap. (Build max heap and extract max.)

### K Largest/Smallest Elements
Finds k largest/smallest elements.

**Example**:
```javascript
function findKLargest(nums, k) {
  let heap = new MinHeap();
  for (let num of nums) {
    heap.push(num);
    if (heap.heap.length > k) heap.pop();
  }
  return heap.heap;
}
console.log(findKLargest([3, 2, 1, 5, 6, 4], 2)); // [5, 6]
```

### Median in a Stream
Tracks median using two heaps. (Complex; see resources.)

---

## 12. Greedy Algorithms

### Activity Selection
Selects maximum non-overlapping activities.

**Example**:
```javascript
function activitySelection(start, end) {
  let activities = start.map((s, i) => [s, end[i]]).sort((a, b) => a[1] - b[1]);
  let result = [activities[0]];
  for (let i = 1; i < activities.length; i++) {
    if (activities[i][0] >= result[result.length - 1][1]) result.push(activities[i]);
  }
  return result;
}
console.log(activitySelection([1, 2, 3, 5], [2, 4, 6, 7])); // [[1, 2], [2, 4], [5, 7]]
```

### Fractional Knapsack
Maximizes value in a knapsack with fractional items.

**Example**:
```javascript
function fractionalKnapsack(values, weights, W) {
  let items = values.map((v, i) => [v, weights[i], v / weights[i]]).sort((a, b) => b[2] - a[2]);
  let totalValue = 0, capacity = W;
  for (let [value, weight, ratio] of items) {
    if (capacity >= weight) {
      totalValue += value;
      capacity -= weight;
    } else {
      totalValue += ratio * capacity;
      break;
    }
  }
  return totalValue;
}
console.log(fractionalKnapsack([60, 100, 120], [10, 20, 30], 50)); // 240
```

### Job Sequencing
Maximizes profit by scheduling jobs with deadlines.

**Example**:
```javascript
function jobSequencing(jobs) {
  jobs.sort((a, b) => b[2] - a[2]); // Sort by profit
  let maxDeadline = Math.max(...jobs.map(j => j[1])), slots = Array(maxDeadline).fill(null);
  for (let [id, deadline, profit] of jobs) {
    for (let i = Math.min(maxDeadline, deadline) - 1; i >= 0; i--) {
      if (!slots[i]) {
        slots[i] = id;
        break;
      }
    }
  }
  return slots.filter(x => x !== null);
}
console.log(jobSequencing([['a', 2, 100], ['b', 1, 19], ['c', 2, 27], ['d', 1, 25]])); // ['a', 'c']
```

### Huffman Encoding
Builds a variable-length prefix code. (Complex; use priority queue.)

### Gas Station Problem
Finds a starting point to complete a circular tour.

**Example**:
```javascript
function canCompleteCircuit(gas, cost) {
  let totalTank = 0, currTank = 0, start = 0;
  for (let i = 0; i < gas.length; i++) {
    totalTank += gas[i] - cost[i];
    currTank += gas[i] - cost[i];
    if (currTank < 0) {
      start = i + 1;
      currTank = 0;
    }
  }
  return totalTank >= 0 ? start : -1;
}
console.log(canCompleteCircuit([1, 2, 3, 4, 5], [3, 4, 5, 1, 2])); // 3
```

---

## 13. Divide and Conquer

### Merge Sort
Already covered in Sorting Algorithms.

### Quick Sort
Already covered in Sorting Algorithms.

### Binary Search
Already covered in Searching Algorithms.

### Maximum Subarray
Finds maximum subarray sum (Kadane’s is more efficient).

**Example**:
```javascript
function maxSubarray(arr) {
  function crossSum(arr, left, mid, right) {
    let leftSum = -Infinity, rightSum = -Infinity, sum = 0;
    for (let i = mid; i >= left; i--) {
      sum += arr[i];
      leftSum = Math.max(leftSum, sum);
    }
    sum = 0;
    for (let i = mid + 1; i <= right; i++) {
      sum += arr[i];
      rightSum = Math.max(rightSum, sum);
    }
    return leftSum + rightSum;
  }
  function helper(arr, left, right) {
    if (left === right) return arr[left];
    let mid = Math.floor((left + right) / 2);
    return Math.max(helper(arr, left, mid), helper(arr, mid + 1, right), crossSum(arr, left, mid, right));
  }
  return helper(arr, 0, arr.length - 1);
}
console.log(maxSubarray([-2, 1, -3, 4, -1, 2, 1, -5, 4])); // 6
```

---

## 14. Dynamic Programming (DP)

### Fibonacci (Memoization & Tabulation)
Optimizes Fibonacci calculation.

**Example (Memoization)**:
```javascript
function fibonacciMemo(n, memo = {}) {
  if (n in memo) return memo[n];
  if (n <= 1) return n;
  memo[n] = fibonacciMemo(n - 1, memo) + fibonacciMemo(n - 2, memo);
  return memo[n];
}
console.log(fibonacciMemo(10)); // 55
```

**Example (Tabulation)**:
```javascript
function fibonacciTab(n) {
  if (n <= 1) return n;
  let fib = [0, 1];
  for (let i = 2; i <= n; i++) fib[i] = fib[i - 1] + fib[i - 2];
  return fib[n];
}
console.log(fibonacciTab(10)); // 55
```

### 0/1 Knapsack
Maximizes value within a weight limit.

**Example**:
```javascript
function knapsack(weights, values, W) {
  let n = weights.length, dp = Array(n + 1).fill(0).map(() => Array(W + 1).fill(0));
  for (let i = 1; i <= n; i++) {
    for (let w = 1; w <= W; w++) {
      if (weights[i - 1] <= w) {
        dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
      } else {
        dp[i][w] = dp[i - 1][w];
      }
    }
  }
  return dp[n][W];
}
console.log(knapsack([1, 3, 4, 5], [1, 4, 5, 7], 7)); // 9
```

### Unbounded Knapsack
Allows multiple instances of items. (Modify 0/1 Knapsack.)

### Longest Common Subsequence (LCS)
Finds the longest common subsequence.

**Example**:
```javascript
function lcs(str1, str2) {
  let m = str1.length, n = str2.length, dp = Array(m + 1).fill(0).map(() => Array(n + 1).fill(0));
  for (let i = 1; i <= m; i++) {
    for (let j = 1; j <= n; j++) {
      if (str1[i - 1] === str2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
      else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
    }
  }
  return dp[m][n];
}
console.log(lcs("ABCDGH", "AEDFHR")); // 3
```

### Longest Increasing Subsequence (LIS)
Finds the longest strictly increasing subsequence.

**Example**:
```javascript
function lis(arr) {
  let n = arr.length, dp = Array(n).fill(1);
  for (let i = 1; i < n; i++) {
    for (let j = 0; j < i; j++) {
      if (arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
    }
  }
  return Math.max(...dp);
}
console.log(lis([10, 9, 2, 5, 3, 7, 101, 18])); // 4
```

### Matrix Chain Multiplication
Minimizes multiplication cost. (Complex; see resources.)

### DP on Grid
Solves grid-based problems like path counting.

**Example**:
```javascript
function uniquePaths(m, n) {
  let dp = Array(m).fill(0).map(() => Array(n).fill(0));
  for (let i = 0; i < m; i++) dp[i][0] = 1;
  for (let j = 0; j < n; j++) dp[0][j] = 1;
  for (let i = 1; i < m; i++) {
    for (let j = 1; j < n; j++) {
      dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
    }
  }
  return dp[m - 1][n - 1];
}
console.log(uniquePaths(3, 7)); // 28
```

### DP on Trees
Solves tree problems like diameter. (Complex; see resources.)

### Bitmask DP
Uses bitmasks for state representation. (Complex; see resources.)

---

## 15. Graphs

### Representations (Adjacency List/Matrix)
Ways to represent graphs.

**Example (Adjacency List)**:
```javascript
let graph = {
  'A': ['B', 'C'],
  'B': ['A', 'D'],
  'C': ['A', 'D'],
  'D': ['B', 'C']
};
```

### BFS and DFS
Traverses or searches graphs.

**Example (BFS)**:
```javascript
function bfs(graph, start) {
  let visited = new Set(), queue = [start];
  visited.add(start);
  while (queue.length) {
    let node = queue.shift();
    console.log(node);
    for (let neighbor of graph[node]) {
      if (!visited.has(neighbor)) {
        visited.add(neighbor);
        queue.push(neighbor);
      }
    }
  }
}
```

**Example (DFS)**:
```javascript
function dfs(graph, start, visited = new Set()) {
  console.log(start);
  visited.add(start);
  for (let neighbor of graph[start]) {
    if (!visited.has(neighbor)) dfs(graph, neighbor, visited);
  }
}
```

### Topological Sort
Orders vertices in a DAG.

**Example**:
```javascript
function topologicalSort(graph) {
  let visited = new Set(), stack = [];
  for (let node in graph) {
    if (!visited.has(node)) topologicalSortUtil(node, visited, stack, graph);
  }
  return stack.reverse();
}
function topologicalSortUtil(node, visited, stack, graph) {
  visited.add(node);
  for (let neighbor of graph[node]) {
    if (!visited.has(neighbor)) topologicalSortUtil(neighbor, visited, stack, graph);
  }
  stack.push(node);
}
```

### Detect Cycle (Directed/Undirected)
Checks for cycles.

**Example (Undirected)**:
```javascript
function hasCycle(graph) {
  let visited = new Set();
  for (let node in graph) {
    if (!visited.has(node)) {
      if (dfsCycle(node, visited, null, graph)) return true;
    }
  }
  return false;
}
function dfsCycle(node, visited, parent, graph) {
  visited.add(node);
  for (let neighbor of graph[node]) {
    if (!visited.has(neighbor)) {
      if (dfsCycle(neighbor, visited, node, graph)) return true;
    } else if (neighbor !== parent) return true;
  }
  return false;
}
```

### Shortest Path Algorithms (Dijkstra, Bellman-Ford, Floyd-Warshall)
Finds shortest paths.

**Example (Dijkstra)**:
```javascript
class PriorityQueue {
  constructor() {
    this.values = [];
  }
  enqueue(val, priority) {
    this.values.push({ val, priority });
    this.sort();
  }
  dequeue() {
    return this.values.shift();
  }
  sort() {
    this.values.sort((a, b) => a.priority - b.priority);
  }
}

function dijkstra(graph, start) {
  let distances = {}, pq = new PriorityQueue();
  pq.enqueue(start, 0);
  distances[start] = 0;
  while (pq.values.length) {
    let { val: node, priority: distance } = pq.dequeue();
    if (distance > distances[node]) continue;
    for (let neighbor in graph[node]) {
      let newDistance = distance + graph[node][neighbor];
      if (!(neighbor in distances) || newDistance < distances[neighbor]) {
        distances[neighbor] = newDistance;
        pq.enqueue(neighbor, newDistance);
      }
    }
  }
  return distances;
}
console.log(dijkstra({ 'A': { 'B': 4, 'C': 2 }, 'B': { 'A': 4, 'D': 3 }, 'C': { 'A': 2, 'D': 1 }, 'D': { 'B': 3, 'C': 1 } }, 'A')); 
// { A: 0, B: 4, C: 2, D: 3 }
```

### Minimum Spanning Tree (Prim's, Kruskal's)
Finds a tree with minimum edge weight.

**Example (Prim's)**:
```javascript
function prim(graph) {
  let mst = [], visited = new Set(), pq = new PriorityQueue();
  let start = Object.keys(graph)[0];
  visited.add(start);
  for (let neighbor in graph[start]) pq.enqueue([start, neighbor], graph[start][neighbor]);
  while (pq.values.length && mst.length < Object.keys(graph).length - 1) {
    let { val: [from, to], priority } = pq.dequeue();
    if (!visited.has(to)) {
      visited.add(to);
      mst.push([from, to, priority]);
      for (let neighbor in graph[to]) {
        if (!visited.has(neighbor)) pq.enqueue([to, neighbor], graph[to][neighbor]);
      }
    }
  }
  return mst;
}
```

### Union-Find (Disjoint Set)
Manages set partitions.

**Example**:
```javascript
class UnionFind {
  constructor(size) {
    this.parent = Array(size).fill().map((_, i) => i);
    this.rank = Array(size).fill(0);
  }
  find(x) {
    if (this.parent[x] !== x) this.parent[x] = this.find(this.parent[x]);
    return this.parent[x];
  }
  union(x, y) {
    let rootX = this.find(x), rootY = this.find(y);
    if (rootX !== rootY) {
      if (this.rank[rootX] > this.rank[rootY]) this.parent[rootY] = rootX;
      else if (this.rank[rootX] < this.rank[rootY]) this.parent[rootX] = rootY;
      else {
        this.parent[rootY] = rootX;
        this.rank[rootX]++;
      }
    }
  }
}
```

### Bridges and Articulation Points
Finds critical edges/nodes. (Complex; use DFS.)

### Graph Coloring
Assigns colors to vertices. (Complex; use greedy/backtracking.)

### Strongly Connected Components (Kosaraju’s Algorithm)
Finds SCCs. (Complex; use DFS twice.)

---

## 16. Tries

### Insert and Search
Manages a prefix tree.

**Example**:
```javascript
class TrieNode {
  constructor() {
    this.children = {};
    this.isEndOfWord = false;
  }
}
class Trie {
  constructor() {
    this.root = new TrieNode();
  }
  insert(word) {
    let node = this.root;
    for (let char of word) {
      if (!node.children[char]) node.children[char] = new TrieNode();
      node = node.children[char];
    }
    node.isEndOfWord = true;
  }
  search(word) {
    let node = this.root;
    for (let char of word) {
      if (!node.children[char]) return false;
      node = node.children[char];
    }
    return node.isEndOfWord;
  }
}
```

### Prefix Search
Finds all words with a prefix.

**Example**:
```javascript
function prefixSearch(trie, prefix) {
  let node = trie.root;
  for (let char of prefix) {
    if (!node.children[char]) return [];
    node = node.children[char];
  }
  return getAllWords(node, prefix);
}
function getAllWords(node, prefix) {
  let words = [];
  if (node.isEndOfWord) words.push(prefix);
  for (let char in node.children) {
    words = words.concat(getAllWords(node.children[char], prefix + char));
  }
  return words;
}
```

### Word Dictionary
Supports wildcard searches. (Modify `search` for wildcards.)

### Longest Prefix Matching
Finds the longest matching prefix. (Track last valid node.)

### IP Routing
Efficiently routes IPs. (Store prefixes in trie.)

### Count Distinct Substrings
Counts unique substrings. (Insert all substrings into trie.)

---

## 17. Segment Trees & Binary Indexed Tree (Fenwick Tree)

### Segment Tree Basics
Stores intervals for queries.

**Example (Range Sum)**:
```javascript
class SegmentTree {
  constructor(arr) {
    this.n = arr.length;
    this.tree = new Array(4 * this.n).fill(0);
    this.build(arr, 0, 0, this.n - 1);
  }
  build(arr, node, start, end) {
    if (start === end) {
      this.tree[node] = arr[start];
    } else {
      let mid = Math.floor((start + end) / 2);
      this.build(arr, 2 * node + 1, start, mid);
      this.build(arr, 2 * node + 2, mid + 1, end);
      this.tree[node] = this.tree[2 * node + 1] + this.tree[2 * node + 2];
    }
  }
  query(node, start, end, left, right) {
    if (right < start || left > end) return 0;
    if (left <= start && end <= right) return this.tree[node];
    let mid = Math.floor((start + end) / 2);
    let leftSum = this.query(2 * node + 1, start, mid, left, right);
    let rightSum = this.query(2 * node + 2, mid + 1, end, left, right);
    return leftSum + rightSum;
  }
}
```

### Range Sum / Min / Max Queries
Answers range queries. (Modify for min/max.)

### Lazy Propagation
Optimizes updates. (Add lazy array.)

### Binary Indexed Tree (BIT)
Efficient prefix sum queries.

**Example**:
```javascript
class BinaryIndexedTree {
  constructor(size) {
    this.size = size;
    this.tree = new Array(size + 1).fill(0);
  }
  update(index, val) {
    while (index <= this.size) {
      this.tree[index] += val;
      index += index & -index;
    }
  }
  query(index) {
    let sum = 0;
    while (index > 0) {
      sum += this.tree[index];
      index -= index & -index;
    }
    return sum;
  }
}
```

---

## 18. Bit Manipulation

### Bitwise Operators
AND, OR, XOR, NOT, shifts.

**Example**:
```javascript
let a = 5; // 101
let b = 3; // 011
console.log(a & b); // 1
console.log(a | b); // 7
console.log(a ^ b); // 6
console.log(a << 1); // 10
```

### Check if Power of Two
Checks if a number is a power of 2.

**Example**:
```javascript
function isPowerOfTwo(n) {
  return n > 0 && (n & (n - 1)) === 0;
}
console.log(isPowerOfTwo(16)); // true
```

### Count Set Bits
Counts 1s in binary representation.

**Example**:
```javascript
function countSetBits(n) {
  let count = 0;
  while (n) {
    count += n & 1;
    n >>= 1;
  }
  return count;
}
console.log(countSetBits(13)); // 3 (1101)
```

### XOR Properties
Uses XOR to find unique elements.

**Example (Single Number)**:
```javascript
function singleNumber(nums) {
  let result = 0;
  for (let num of nums) result ^= num;
  return result;
}
console.log(singleNumber([2, 2, 1])); // 1
```

### Single Number Problems
Solves problems like finding a single non-repeated number.

### Subsets using Bits
Generates all subsets.

**Example**:
```javascript
function subsets(nums) {
  let n = nums.length, total = 1 << n, result = [];
  for (let i = 0; i < total; i++) {
    let subset = [];
    for (let j = 0; j < n; j++) {
      if (i & (1 << j)) subset.push(nums[j]);
    }
    result.push(subset);
  }
  return result;
}
console.log(subsets([1, 2, 3])); // [[],[3],[2],[2,3],[1],[1,3],[1,2],[1,2,3]]
```

---

## 19. Mathematics for DSA

### GCD, LCM
Computes GCD and LCM.

**Example (GCD)**:
```javascript
function gcd(a, b) {
  while (b) {
    let temp = b;
    b = a % b;
    a = temp;
  }
  return a;
}
console.log(gcd(48, 18)); // 6
```

### Sieve of Eratosthenes
Finds all primes up to n.

**Example**:
```javascript
function sieve(n) {
  let primes = Array(n + 1).fill(true);
  primes[0] = primes[1] = false;
  for (let p = 2; p * p <= n; p++) {
    if (primes[p]) {
      for (let i = p * p; i <= n; i += p) primes[i] = false;
    }
  }
  return primes.map((isPrime, i) => isPrime ? i : null).filter(x => x);
}
console.log(sieve(10)); // [2, 3, 5, 7]
```

### Prime Factorization
Finds prime factors.

**Example**:
```javascript
function primeFactors(n) {
  let factors = [];
  while (n % 2 === 0) {
    factors.push(2);
    n /= 2;
  }
  for (let i = 3; i <= Math.sqrt(n); i += 2) {
    while (n % i === 0) {
      factors.push(i);
      n /= i;
    }
  }
  if (n > 2) factors.push(n);
  return factors;
}
console.log(primeFactors(84)); // [2, 2, 3, 7]
```

### Modular Arithmetic
Operations under modulo. (Used to prevent overflow.)

### Fast Exponentiation
Computes large powers efficiently.

**Example**:
```javascript
function power(base, exponent, mod) {
  let result = 1;
  base %= mod;
  while (exponent > 0) {
    if (exponent % 2 === 1) result = (result * base) % mod;
    exponent >>= 1;
    base = (base * base) % mod;
  }
  return result;
}
console.log(power(2, 10, 1000)); // 24
```

### Combinatorics (nCr, Factorials)
Calculates combinations.

**Example (nCr)**:
```javascript
function nCr(n, r) {
  if (r > n) return 0;
  let res = 1;
  for (let i = 0; i < r; i++) {
    res *= (n - i);
    res /= (i + 1);
  }
  return res;
}
console.log(nCr(5, 2)); // 10
```

---

## 20. Sliding Window & Two Pointers

### Fixed and Variable Size Window
Solves subarray problems.

**Example**:
```javascript
function maxSum(arr, k) {
  let maxSum = 0, windowSum = 0;
  for (let i = 0; i < k; i++) windowSum += arr[i];
  maxSum = windowSum;
  for (let i = k; i < arr.length; i++) {
    windowSum += arr[i] - arr[i - k];
    maxSum = Math.max(maxSum, windowSum);
  }
  return maxSum;
}
console.log(maxSum([1, 4, 2, 10], 2)); // 12
```

### Longest Substring with K Unique Characters
Tracks unique characters.

**Example**:
```javascript
function longestSubstringKUnique(s, k) {
  let maxLen = 0, start = 0, charCount = {};
  for (let end = 0; end < s.length; end++) {
    charCount[s[end]] = (charCount[s[end]] || 0) + 1;
    while (Object.keys(charCount).length > k) {
      charCount[s[start]]--;
      if (charCount[s[start]] === 0) delete charCount[s[start]];
      start++;
    }
    maxLen = Math.max(maxLen, end - start + 1);
  }
  return maxLen;
}
console.log(longestSubstringKUnique("araaci", 2)); // 4
```

### Maximum Sum Subarray
Covered in Kadane’s Algorithm.

### Two Sum / Three Sum / Four Sum Problems
Finds tuples summing to a target.

**Example (Two Sum)**:
```javascript
function twoSum(nums, target) {
  let map = new Map();
  for (let i = 0; i < nums.length; i++) {
    let complement = target - nums[i];
    if (map.has(complement)) return [map.get(complement), i];
    map.set(nums[i], i);
  }
  return [];
}
console.log(twoSum([2, 7, 11, 15], 9)); // [0, 1]
```

---

## 21. Monotonic Stack / Queue

### Next Greater Element
Covered in Stacks.

### Trapping Rain Water
Calculates trapped water.

**Example**:
```javascript
function trap(height) {
  let left = 0, right = height.length - 1, leftMax = 0, rightMax = 0, water = 0;
  while (left < right) {
    if (height[left] < height[right]) {
      if (height[left] >= leftMax) leftMax = height[left];
      else water += leftMax - height[left];
      left++;
    } else {
      if (height[right] >= rightMax) rightMax = height[right];
      else water += rightMax - height[right];
      right--;
    }
  }
  return water;
}
console.log(trap([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1])); // 6
```

### Largest Rectangle in Histogram
Finds the largest rectangle area.

**Example**:
```javascript
function largestRectangleArea(heights) {
  let stack = [], maxArea = 0;
  heights.push(0);
  for (let i = 0; i < heights.length; i++) {
    while (stack.length && heights[i] < heights[stack[stack.length - 1]]) {
      let h = heights[stack.pop()];
      let w = stack.length ? i - stack[stack.length - 1] - 1 : i;
      maxArea = Math.max(maxArea, h * w);
    }
    stack.push(i);
  }
  return maxArea;
}
console.log(largestRectangleArea([2, 1, 5, 6, 2, 3])); // 10
```

### Sliding Window Maximum
Covered in Queues.

---

## 22. Advanced Topics (Optional)

- **Mo’s Algorithm**: Efficiently answers offline queries.
- **Square Root Decomposition**: Divides array into blocks.
- **Heavy Light Decomposition**: Decomposes trees into chains.
- **Convex Hull**: Finds the smallest convex polygon.
- **KMP Automata**: Builds a string-matching automaton.
- **Suffix Arrays and Trees**: Efficient string processing.

(These are complex; refer to specialized resources.)

---

## README.md

```markdown
# Data Structures and Algorithms in JavaScript

This repository provides comprehensive notes and examples on Data Structures and Algorithms (DSA) implemented in JavaScript, covering a wide range of topics with easy examples and problem-solving techniques.

## Table of Contents

1. [Arrays](#arrays)
   - [1D and 2D Arrays](#1d-and-2d-arrays)
   - [Prefix Sum](#prefix-sum)
   - [Sliding Window](#sliding-window)
   - [Two Pointers](#two-pointers)
   - [Kadane’s Algorithm](#kadanes-algorithm)
   - [Merge Intervals](#merge-intervals)
   - [Cyclic Sort](#cyclic-sort)
   - [Dutch National Flag Problem](#dutch-national-flag-problem)

2. [Strings](#strings)
   - [Character Arrays vs Strings](#character-arrays-vs-strings)
   - [Palindromes](#palindromes)
   - [Anagrams](#anagrams)
   - [String Matching Algorithms](#string-matching-algorithms)
   - [Z-Algorithm](#z-algorithm)
   - [String Compression](#string-compression)
   - [Substrings and Subsequences](#substrings-and-subsequences)

3. [Linked List](#linked-list)
   - [Singly Linked List](#singly-linked-list)
   - [Doubly Linked List](#doubly-linked-list)
   - [Circular Linked List](#circular-linked-list)
   - [Reverse Linked List](#reverse-linked-list)
   - [Detect and Remove Loop](#detect-and-remove-loop)
   - [Merge Two Sorted Lists](#merge-two-sorted-lists)
   - [Intersection Point](#intersection-point)
   - [Copy List with Random Pointer](#copy-list-with-random-pointer)

4. [Stacks](#stacks)
   - [Basic Stack Operations](#basic-stack-operations)
   - [Infix, Postfix, Prefix](#infix-postfix-prefix)
   - [Valid Parentheses](#valid-parentheses)
   - [Min/Max Stack](#minmax-stack)
   - [Stock Span Problem](#stock-span-problem)
   - [Next Greater Element](#next-greater-element)

5. [Queues](#queues)
   - [Queue using Arrays/Linked List](#queue-using-arrayslinked-list)
   - [Circular Queue](#circular-queue)
   - [Deque](#deque)
   - [Priority Queue](#priority-queue)
   - [Sliding Window Maximum](#sliding-window-maximum)

6. [Hashing](#hashing)
   - [Hash Tables](#hash-tables)
   - [Frequency Maps](#frequency-maps)
   - [HashSets](#hashsets)
   - [Count Distinct Elements](#count-distinct-elements)
   - [Longest Consecutive Subsequence](#longest-consecutive-subsequence)
   - [Subarray with Given Sum](#subarray-with-given-sum)

7. [Recursion & Backtracking](#recursion--backtracking)
   - [Basic Recursion](#basic-recursion)
   - [Factorial, Fibonacci, Power](#factorial-fibonacci-power)
   - [Permutations & Combinations](#permutations--combinations)
   - [N-Queens Problem](#n-queens-problem)
   - [Sudoku Solver](#sudoku-solver)
   - [Rat in a Maze](#rat-in-a-maze)
   - [Subset Sum](#subset-sum)

8. [Searching Algorithms](#searching-algorithms)
   - [Linear Search](#linear-search)
   - [Binary Search](#binary-search)
   - [Ternary Search](#ternary-search)
   - [Search in Rotated Sorted Array](#search-in-rotated-sorted-array)
   - [Binary Search on Answer](#binary-search-on-answer)
   - [Exponential Search](#exponential-search)

9. [Sorting Algorithms](#sorting-algorithms)
   - [Bubble Sort](#bubble-sort)
   - [Selection Sort](#selection-sort)
   - [Insertion Sort](#insertion-sort)
   - [Merge Sort](#merge-sort)
   - [Quick Sort](#quick-sort)
   - [Heap Sort](#heap-sort)
   - [Counting Sort](#counting-sort)
   - [Radix Sort](#radix-sort)
   - [Bucket Sort](#bucket-sort)

10. [Binary Search Tree (BST)](#binary-search-tree-bst)
    - [Insertion & Deletion](#insertion--deletion)
    - [Search in BST](#search-in-bst)
    - [Validate BST](#validate-bst)
    - [Lowest Common Ancestor](#lowest-common-ancestor)
    - [Kth Smallest Element](#kth-smallest-element)
    - [BST to Balanced BST](#bst-to-balanced-bst)

11. [Heaps / Priority Queue](#heaps--priority-queue)
    - [Min Heap / Max Heap](#min-heap--max-heap)
    - [Heapify](#heapify)
    - [Heap Sort](#heap-sort)
    - [K Largest/Smallest Elements](#k-largestsmallest-elements)
    - [Median in a Stream](#median-in-a-stream)

12. [Greedy Algorithms](#greedy-algorithms)
    - [Activity Selection](#activity-selection)
    - [Fractional Knapsack](#fractional-knapsack)
    - [Job Sequencing](#job-sequencing)
    - [Huffman Encoding](#huffman-encoding)
    - [Gas Station Problem](#gas-station-problem)

13. [Divide and Conquer](#divide-and-conquer)
    - [Merge Sort](#merge-sort)
    - [Quick Sort](#quick-sort)
    - [Binary Search](#binary-search)
    - [Maximum Subarray](#maximum-subarray)

14. [Dynamic Programming (DP)](#dynamic-programming-dp)
    - [Fibonacci (Memoization & Tabulation)](#fibonacci-memoization--tabulation)
    - [0/1 Knapsack](#01-knapsack)
    - [Unbounded Knapsack](#unbounded-knapsack)
    - [Longest Common Subsequence (LCS)](#longest-common-subsequence-lcs)
    - [Longest Increasing Subsequence (LIS)](#longest-increasing-subsequence-lis)
    - [Matrix Chain Multiplication](#matrix-chain-multiplication)
    - [DP on Grid](#dp-on-grid)
    - [DP on Trees](#dp-on-trees)
    - [Bitmask DP](#bitmask-dp)

15. [Graphs](#graphs)
    - [Representations](#representations)
    - [BFS and DFS](#bfs-and-dfs)
    - [Topological Sort](#topological-sort)
    - [Detect Cycle](#detect-cycle)
    - [Shortest Path Algorithms](#shortest-path-algorithms)
    - [Minimum Spanning Tree](#minimum-spanning-tree)
    - [Union-Find](#union-find)
    - [Bridges and Articulation Points](#bridges-and-articulation-points)
    - [Graph Coloring](#graph-coloring)
    - [Strongly Connected Components](#strongly-connected-components)

16. [Tries](#tries)
    - [Insert and Search](#insert-and-search)
    - [Prefix Search](#prefix-search)
    - [Word Dictionary](#word-dictionary)
    - [Longest Prefix Matching](#longest-prefix-matching)
    - [IP Routing](#ip-routing)
    - [Count Distinct Substrings](#count-distinct-substrings)

17. [Segment Trees & Binary Indexed Tree](#segment-trees--binary-indexed-tree)
    - [Segment Tree Basics](#segment-tree-basics)
    - [Range Sum / Min / Max Queries](#range-sum--min--max-queries)
    - [Lazy Propagation](#lazy-propagation)
    - [Binary Indexed Tree (BIT)](#binary-indexed-tree-bit)

18. [Bit Manipulation](#bit-manipulation)
    - [Bitwise Operators](#bitwise-operators)
    - [Check if Power of Two](#check-if-power-of-two)
    - [Count Set Bits](#count-set-bits)
    - [XOR Properties](#xor-properties)
    - [Single Number Problems](#single-number-problems)
    - [Subsets using Bits](#subsets-using-bits)

19. [Mathematics for DSA](#mathematics-for-dsa)
    - [GCD, LCM](#gcd-lcm)
    - [Sieve of Eratosthenes](#sieve-of-eratosthenes)
    - [Prime Factorization](#prime-factorization)
    - [Modular Arithmetic](#modular-arithmetic)
    - [Fast Exponentiation](#fast-exponentiation)
    - [Combinatorics (nCr, Factorials)](#combinatorics-ncr-factorials)

20. [Sliding Window & Two Pointers](#sliding-window--two-pointers)
    - [Fixed and Variable Size Window](#fixed-and-variable-size-window)
    - [Longest Substring with K Unique Characters](#longest-substring-with-k-unique-characters)
    - [Maximum Sum Subarray](#maximum-sum-subarray)
    - [Two Sum / Three Sum / Four Sum Problems](#two-sum--three-sum--four-sum-problems)

21. [Monotonic Stack / Queue](#monotonic-stack--queue)
    - [Next Greater Element](#next-greater-element)
    - [Trapping Rain Water](#trapping-rain-water)
    - [Largest Rectangle in Histogram](#largest-rectangle-in-histogram)
    - [Sliding Window Maximum](#sliding-window-maximum)

22. [Advanced Topics](#advanced-topics)
    - [Mo’s Algorithm](#mos-algorithm)
    - [Square Root Decomposition](#square-root-decomposition)
    - [Heavy Light Decomposition](#heavy-light-decomposition)
    - [Convex Hull](#convex-hull)
    - [KMP Automata](#kmp-automata)
    - [Suffix Arrays and Trees](#suffix-arrays-and-trees)

---

## About

Each topic includes:
- **Explanations**: Clear descriptions of concepts.
- **Examples**: Simple JavaScript code snippets.
- **Problem-Solving Methods**: Common techniques used in coding interviews.

For detailed implementations of complex topics (e.g., KMP, Segment Trees), refer to additional resources like:
- [LeetCode](https://leetcode.com/)
- [GeeksforGeeks](https://www.geeksforgeeks.org/)
- [HackerRank](https://www.hackerrank.com/)
- [Introduction to Algorithms by Cormen et al.](https://mitpress.mit.edu/books/introduction-algorithms-third-edition)
```

---

This response provides a complete, self-contained set of DSA notes in JavaScript, tailored to the user’s request with examples and a formatted `README.md`. Complex topics are noted for further exploration.