# Functional Programming with Java
![image](https://images.idgesg.net/images/article/2019/11/jw_lambda_expressions_lambda_symbol_circuits_puzzle_pieces_by_greyfebruary_gettyimages-511803821_2400x1600-100817056-large.jpg?auto=webp&quality=85,70)
Functional programming is a programming paradigm that is gaining popularity due to its emphasis on write code that is declarative, concise a and easy to reason about. In functional programming functions are treated as first-class citizens, meaning that they can be pass around as arguments, return as results and stored as variables.

Java incorporated many features of functional programming since the release of Java 8 , such `lambda expression` , `method references` , `streams` and `functional interfaces` 

## Key Concepts and Features of Functional Programming:

1. `Lambda Expressions` : Lambda expressions are a concise way of to define anonymous function, that can be used as parameters or return types in other methods 
    1. Java doesn’t have First-Class functions in a strict sense. 
    2. Lambda expressions can be used as a replacement of first-class functions in many cases.
    3. A first-class function is a function that can be treated like any other data type, such as string or number. This means that you can pass a function to another function and store a function in a variable. In Java This is not possible because functions are not objects you can not pass them around like other data types
    4. Lambda expressions provide a way to define anonymous functions that can be used as parameters or return types in a method. They allow you to write code that is more concise and readable, specially when it comes to collections and streams .
    5. Lambda functions are not straight first-class functions in a sense but they provide much of the same functionality.
    6. Example of lambda expression in Java
        1. In this example the lambda expression `n -> n%2 == 0` to filter even numbers from a list 
    
    ```java
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    
    // using a lambda expression to filter even numbers
    List<Integer> evenNumbers = numbers.stream()
                                       .filter(n -> n % 2 == 0)
                                       .collect(Collectors.toList());
    ```
    
2. `Functional Interfaces` : Is an interface that contains only one abstract method. Functional interfaces are used extensively in Java’s functional programming features such as Lambda expressions and method references. 
3. `Method References` Are a shorthand to refer to a method such as lambda expressions. They allow you to reuse existing methods as functions, which can simplify your code and make more readable.
    1. final int x = 5;
4. `Streams` Are a way to process collections of data in a functional way. Streams are created from collections or arrays and can be transmitted using terminal operations such as `forEach` or `reduce`
5. `Immutable Objects` Are objects that can not be modified after they are created. These can help simplify your code and make it more predictable as you don’t have worry about unexpected changes to the state of your program.
6. `Pure Functions` a function that returns the same output for given input and has no side effects. Pure functions are easy to reason about and can be parallelised, making them a powerful tool for concurrent programming.
    1.int func(int a){ return a+1 }
    2. Functions are not Pure whenever they refer to internal or external state change. e.g getters and setters in a class.
    3. Let’s demo Non-pure toString()
    
    ```java
    public class Person{
    		private String name;
    		private int age;
    		
    		public void setName(String name){this.name = name}
    
    		public String toString(){
    				return "name: "+this.name+" age "+age;
    		}
    }
    ```
    
    Pure toString()
    
    ```java
    public class Person{
    		private final String name;
    		private final int age;
    		
    		
    
    		public String toString(){
    				return "name: "+this.name+" age "+age;
    		}
    }
    ```
    

In conclusion, functional programming is a powerful paradigm that can simplify your code and make it more predictable. Java’s support for features such as lambda expressions, method references and streams make it easier than ever to write functional code in Java. By incorporating these concepts into your code, you can write code that is more concise, maintainable and scalable .
