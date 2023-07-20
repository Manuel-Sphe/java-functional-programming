package org.sphedev;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionInterfaces {
    private static final List<String> WORDS =
            List.of("hello","functional","programming"
                    ,"is", "cool","programming","programming");

    public static void main(String[] args) {

        Consumer<Object> cout = System.out::println; // Change <String> to <Object> to take more values
        // 3 args
        TriFunction<Integer,Integer,Integer,Integer> add = (x,y,z) -> x + y + z;

        cout.accept("The sum of 3 numbers is "+add.apply(3,2,6));

        // No args
        NoArgsFunction<String> print = () -> "Hello no args";
        // print
        cout.accept(print.apply());

        final Boolean IS_DEV = true;

        DataLoader dataLoader = new DataLoader(IS_DEV);
        cout.accept(dataLoader.select.apply()); // Removed the .toString() for Employee it will Automatically get called

        // Let's Demo Maps

        List<Integer>  nums = List.of(1,2,3,4,5,6,7);

        //1. By pass a lambda expression
        List<Integer> sqr = nums.stream()
                                .map(x->x*x)
                                .toList(); // can also use .collect(Collectors.toList())

        cout.accept(sqr);

        // 2. Using Function interface
        Function<Integer,Integer> doubler = (x) -> x * 2;
        List<Integer> times2 = nums.stream()
                                    .map(doubler)
                                    .collect(Collectors.toList()); //this works

        cout.accept(times2);

        // Filter
        // Predicate<T> T is the type that we're going check for some condition on
        Predicate<Integer> isEven = (x) -> x%2 == 0 ;
        // we can also pass the lambda expression directly to filter
        List<Integer> even = sqr.stream()
                                   .filter(isEven)
                                   .toList();
        cout.accept(even);


        Function<Integer,Predicate<String>> lengthTest = (minLength) -> (string) -> string.length() > minLength;

        List<String> longWords = WORDS.stream()
                .filter(lengthTest.apply(3)) // pass any length with to check
                .toList();
        cout.accept(longWords);

        // Reduce

        BinaryOperator<Integer> getSum  = Integer::sum;
        Integer sum  = sqr.stream()
                          .reduce(0, getSum);

        cout.accept("The sum is "+sum);

        //Collectors

        // Make a set
        Set<String> set  = WORDS
                .stream()
                .filter(lengthTest.apply(4))
                .collect(Collectors.toSet());
        cout.accept(set); // no duplicates

        // Join strings
        String myStr = set
                       .stream()
                       .filter(lengthTest.apply(4))
                       .collect(Collectors.joining("--"));// join the distinct words from the set.
        cout.accept(myStr);

        //count
        Long count = set
                .stream()
                .filter(lengthTest.apply(4))
                .count(); // collect(Collectors.counting()) will work

        cout.accept(count);

        // Map - group by

        Map<Integer,List<String> > wordDict = WORDS
                                              .stream()
                                              .collect(Collectors.groupingBy(String::length));

        cout.accept(wordDict);

        // Partitions a group by true of false

        Map<Boolean, List<String > >splits  = WORDS
                                            .stream()
                                            .collect(Collectors.
                                                    partitioningBy(lengthTest.apply(5)));

        cout.accept(splits);

        // Challenge

        List<Person> people = List.of(
                new Person("Brandon", 23),
                new Person("Hank",43),
                new Person("Jenna", 23 ),
                new Person("Jack",27),
                new Person("Veronica",56)
        );

        // Get a list thaqt gets people's names
        List<String> names = people
                            .stream()
                            .map(Person::getName)
                            .toList();

        names.forEach(System.out::println);

        parallelStreams();

    }

    private static void parallelStreams(){

        System.out.println("\nParallel Streams : ");

        WORDS.parallelStream()
                .map(StringBuffer::new)
                .map(s -> s.append("!"))
                .map(StringBuffer::toString)
                .forEach(System.out::println);


    }
}
