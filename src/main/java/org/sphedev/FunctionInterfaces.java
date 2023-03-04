package org.sphedev;
import java.util.function.Consumer;
public class FunctionInterfaces {
    public static void main(String[] args) {
        Consumer<String> cout = System.out::println;
        // 3 args
        TriFunction<Integer,Integer,Integer,Integer> add = (x,y,z) -> x + y + z;
        cout.accept("The sum of 3 numbers is "+add.apply(3,2,6));

        // No args
        NoArgsFunction<String> print = () -> "Hello no args";
        // print
        cout.accept(print.apply());
    }
}
