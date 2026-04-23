# 1.OOPs

### **1. Encapsulation**

```java
class BankAccount {
    private double balance;

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}
```

👉 *Data hiding using private variables and public methods.*

---

### **2. Inheritance**

```java
class Animal {
    void eat() {
        System.out.println("Eating");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking");
    }
}
```

👉 *Child class inherits properties of parent class.*

---

### **3. Polymorphism**

**Method Overloading (Compile-time)**

```java
class MathOps {
    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

**Method Overriding (Runtime)**

```java
class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
```

👉 *Same method name, different behavior.*

---

### **4. Abstraction**

```java
abstract class Vehicle {
    abstract void start();

    void stop() {
        System.out.println("Vehicle stopped");
    }
}

class Car extends Vehicle {
    void start() {
        System.out.println("Car starts with key");
    }
}
```

👉 *Hiding implementation details using abstract classes.*
