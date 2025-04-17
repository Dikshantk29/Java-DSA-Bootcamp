/**
 * Object-Oriented Programming (OOP) Pillars
 * 
 * There are four main pillars of Object-Oriented Programming:
 * 
 * 1. Encapsulation:
 *    - Definition: Bundling of data and the methods that operate on that data within a single unit (class)
 *    - Purpose: To hide internal details and provide an interface to access the data
 *    - Implementation: Using private variables and public methods (getters/setters)
 *    Example:
 *    class BankAccount {
 *        private double balance;  // Data hiding
 *        public void deposit(double amount) {  // Interface to modify data
 *            if (amount > 0) {
 *                balance += amount;
 *            }
 *        }
 *    }
 * 
 * 2. Inheritance:
 *    - Definition: Mechanism that allows a class to inherit properties and methods from another class
 *    - Purpose: To promote code reuse and establish relationships between classes
 *    - Types: Single, Multiple (through interfaces), Multilevel, Hierarchical
 *    Example:
 *    class Animal {
 *        void eat() { }
 *    }
 *    class Dog extends Animal {  // Dog inherits from Animal
 *        void bark() { }
 *    }
 * 
 * 3. Polymorphism:
 *    - Definition: Ability of objects to take multiple forms
 *    - Types:
 *      a) Compile-time (Method Overloading)
 *         - Same method name with different parameters
 *      b) Runtime (Method Overriding)
 *         - Subclass providing specific implementation of superclass method
 *    Example:
 *    class Calculator {
 *        int add(int a, int b) { return a + b; }  // Overloaded method
 *        int add(int a, int b, int c) { return a + b + c; }  // Overloaded method
 *    }
 * 
 * 4. Abstraction:
 *    - Definition: Process of hiding implementation details and showing only functionality
 *    - Purpose: To reduce complexity and isolate impact of changes
 *    - Implementation: Through abstract classes and interfaces
 *    Example:
 *    abstract class Shape {
 *        abstract double calculateArea();  // Abstract method
 *    }
 *    class Circle extends Shape {
 *        double radius;
 *        double calculateArea() {  // Implementation of abstract method
 *            return Math.PI * radius * radius;
 *        }
 *    }
 * 
 * Benefits of OOP:
 * - Modularity: Each object has its own independent code and data
 * - Reusability: Through inheritance and composition
 * - Data hiding and abstraction: Implementation details are hidden
 * - Maintainability: Easier to maintain and modify code
 * - Security: Encapsulation provides better control over data
 */

public class Concept {
    public static void main(String[] args) {
        // This file contains theoretical concepts of OOP pillars
        System.out.println("Study the comments above for OOP concepts!");
    }
}