package org.sphedev;
import java.util.function.Consumer;
import java.util.Scanner;
import java.util.function.Supplier;
public class ConsumerSupplier {
    public static void main(String[] args) {
        // Creating a function reference and use as a short cut
        Consumer<String> cout = System.out::println;
        cout.accept("This is cool!!");

        // Let's try getting user input
        Scanner in = new Scanner(System.in);
        System.out.println("Please Enter your name : ");
        Supplier<String> cin = in::nextLine;
        String input = cin.get();
        cout.accept("Your name is "+input);
        in.close();
    }
}
