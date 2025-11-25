# JavaScript DSA Beginner Notes

## 1. JavaScript Fundamentals for DSA

### Variables and Data Types
```javascript
// Primitive types
let num = 42;           // Number
let str = "hello";      // String
let bool = true;        // Boolean
let nothing = null;     // Null
let undef = undefined;  // Undefined

// Reference types
let arr = [1, 2, 3];    // Array
let obj = {key: "value"}; // Object
```

### Functions
```javascript
// Function declaration
function add(a, b) {
    return a + b;
}

// Arrow function
const multiply = (a, b) => a * b;

// Higher-order functions
const numbers = [1, 2, 3, 4, 5];
const doubled = numbers.map(x => x * 2);
const filtered = numbers.filter(x => x > 2);
```

### Common Array Methods
```javascript
let arr = [1, 2, 3, 4, 5];

// Add/Remove elements
arr.push(6);        // Add to end
arr.pop();          // Remove from end
arr.unshift(0);     // Add to beginning
arr.shift();        // Remove from beginning

// Access elements
arr[0];             // First element
arr[arr.length - 1]; // Last element

// Useful methods
arr.indexOf(3);     // Find index of element
arr.includes(4);    // Check if element exists
arr.slice(1, 3);    // Extract portion [1, 3)
arr.concat([6, 7]); // Merge arrays
```

## 2. Time and Space Complexity

### Big O Notation
- **O(1)** - Constant time
- **O(log n)** - Logarithmic time
- **O(n)** - Linear time
- **O(n log n)** - Linearithmic time
- **O(n²)** - Quadratic time

### Examples
```javascript
// O(1) - Constant
function getFirst(arr) {
    return arr[0];
}

// O(n) - Linear
function findMax(arr) {
    let max = arr[0];
    for (let i = 1; i < arr.length; i++) {
        if (arr[i] > max) max = arr[i];
    }
    return max;
}

// O(n²) - Quadratic
function bubbleSort(arr) {
    for (let i = 0; i < arr.length; i++) {
        for (let j = 0; j < arr.length - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                [arr[j], arr[j + 1]] = [arr[j + 1], arr[j]];
            }
        }
    }
}
```

## 3. Basic Data Structures

### Arrays
```javascript
// Static operations
let arr = [1, 2, 3, 4, 5];

// Dynamic operations
arr.push(6);           // O(1)
arr.pop();             // O(1)
arr.unshift(0);        // O(n)
arr.shift();           // O(n)

// Search
arr.indexOf(3);        // O(n)
arr.find(x => x > 3);  // O(n)
```

### Objects (Hash Maps)
```javascript
let obj = {};

// Insert/Update - O(1)
obj.key1 = "value1";
obj["key2"] = "value2";

// Access - O(1)
console.log(obj.key1);

// Delete - O(1)
delete obj.key1;

// Check existence
"key1" in obj;              // or
obj.hasOwnProperty("key1");

// Get all keys/values
Object.keys(obj);    // ["key2"]
Object.values(obj);  // ["value2"]
```

### Strings
```javascript
let str = "hello world";

// Common operations
str.length;              // 11
str.charAt(0);           // "h"
str.substring(0, 5);     // "hello"
str.indexOf("world");    // 6
str.split(" ");          // ["hello", "world"]
str.replace("world", "JS"); // "hello JS"

// Converting
str.toUpperCase();       // "HELLO WORLD"
str.toLowerCase();       // "hello world"
```

## 4. Basic Algorithms

### Linear Search
```javascript
function linearSearch(arr, target) {
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] === target) {
            return i;
        }
    }
    return -1;
}
// Time: O(n), Space: O(1)
```

### Binary Search (on sorted array)
```javascript
function binarySearch(arr, target) {
    let left = 0;
    let right = arr.length - 1;
    
    while (left <= right) {
        let mid = Math.floor((left + right) / 2);
        
        if (arr[mid] === target) {
            return mid;
        } else if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1;
}
// Time: O(log n), Space: O(1)
```

### Bubble Sort
```javascript
function bubbleSort(arr) {
    let n = arr.length;
    for (let i = 0; i < n - 1; i++) {
        for (let j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // Swap elements
                [arr[j], arr[j + 1]] = [arr[j + 1], arr[j]];
            }
        }
    }
    return arr;
}
// Time: O(n²), Space: O(1)
```

### Selection Sort
```javascript
function selectionSort(arr) {
    let n = arr.length;
    
    for (let i = 0; i < n - 1; i++) {
        let minIdx = i;
        
        // Find minimum element
        for (let j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIdx]) {
                minIdx = j;
            }
        }
        
        // Swap if needed
        if (minIdx !== i) {
            [arr[i], arr[minIdx]] = [arr[minIdx], arr[i]];
        }
    }
    return arr;
}
// Time: O(n²), Space: O(1)
```

## 5. Problem-Solving Patterns

### Two Pointers
```javascript
// Find pair that sums to target
function twoSum(arr, target) {
    let left = 0;
    let right = arr.length - 1;
    
    while (left < right) {
        let sum = arr[left] + arr[right];
        if (sum === target) {
            return [left, right];
        } else if (sum < target) {
            left++;
        } else {
            right--;
        }
    }
    return [-1, -1];
}
```

### Sliding Window
```javascript
// Find maximum sum of k consecutive elements
function maxSumSubarray(arr, k) {
    let maxSum = 0;
    let windowSum = 0;
    
    // Calculate first window
    for (let i = 0; i < k; i++) {
        windowSum += arr[i];
    }
    maxSum = windowSum;
    
    // Slide the window
    for (let i = k; i < arr.length; i++) {
        windowSum += arr[i] - arr[i - k];
        maxSum = Math.max(maxSum, windowSum);
    }
    
    return maxSum;
}
```

### Frequency Counter
```javascript
// Check if two strings are anagrams
function areAnagrams(str1, str2) {
    if (str1.length !== str2.length) return false;
    
    let freq = {};
    
    // Count characters in first string
    for (let char of str1) {
        freq[char] = (freq[char] || 0) + 1;
    }
    
    // Subtract characters from second string
    for (let char of str2) {
        if (!freq[char]) return false;
        freq[char]--;
    }
    
    return true;
}
```

## 6. Useful JavaScript Tricks for DSA

### Array Initialization
```javascript
// Create array of size n with default value
let arr = new Array(n).fill(0);

// Create 2D array
let matrix = Array(rows).fill().map(() => Array(cols).fill(0));

// Range array
let range = Array.from({length: n}, (_, i) => i); // [0,1,2,...,n-1]
```

### Math Operations
```javascript
Math.max(...array);          // Maximum element
Math.min(...array);          // Minimum element
Math.floor(num);             // Round down
Math.ceil(num);              // Round up
Math.abs(num);               // Absolute value
Math.pow(base, exp);         // Power
```

### String/Array Conversions
```javascript
// String to array
let arr = str.split('');

// Array to string
let str = arr.join('');

// Reverse string
let reversed = str.split('').reverse().join('');
```

### Destructuring and Swapping
```javascript
// Swap variables
[a, b] = [b, a];

// Destructuring arrays
let [first, second, ...rest] = [1, 2, 3, 4, 5];
```

## 7. Practice Problems to Start With

1. **Two Sum** - Find two numbers that add up to target
2. **Reverse String** - Reverse a string in-place
3. **Palindrome Check** - Check if string reads same forwards/backwards
4. **Maximum Subarray** - Find contiguous subarray with largest sum
5. **Valid Parentheses** - Check if brackets are properly matched
6. **Merge Sorted Arrays** - Combine two sorted arrays
7. **Remove Duplicates** - Remove duplicates from sorted array
8. **Search Insert Position** - Find position to insert target in sorted array

## 8. Next Steps

After mastering these basics:
- Learn about Stacks and Queues
- Study Linked Lists
- Explore Trees and Graphs
- Practice recursion
- Learn advanced sorting algorithms (Merge Sort, Quick Sort)
- Study dynamic programming basics

## Resources
- LeetCode (start with Easy problems)
- HackerRank
- Codewars
- MDN Web Docs for JavaScript reference