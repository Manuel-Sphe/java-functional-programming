package org.sphedev;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionInterfaces {

    protected static class Person{
        private final String name;
        private  final Integer age;

        public Person(String name, Integer age){
            this.name = name;
            this.age = age;
        }
        public String toString(){
            return this.name +" "+this.age;
        }
    }

    protected static class DataLoader{
        public final NoArgsFunction<Person> select ;

        public DataLoader(Boolean isDevelopment){
            this.select = isDevelopment ? this::loadPersonFake : this::loadPersonReal;
        }
        private Person loadPersonReal(){
            System.out.println("Loading person....");
            return new Person("Real Person",23);
        }
        private Person loadPersonFake(){
            System.out.println("Loading person....");
            return new Person("Fake Person",47);
        }
    }
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

        List<Integer>  nums = Arrays.asList(1,2,3,4,5,6,7);

        //1. By pass a lambda expression
        List<Integer> sqr = nums.stream()
                                .map(x->x*x)
                                .toList(); // can also use .collet(Collectors.toList())
        
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

        List<String> words = Arrays.asList("hello","functional","programming","is", "cool","programming","programming");

        Function<Integer,Predicate<String>> lengthTest = (minLength) -> (string) -> string.length() > minLength;

        List<String> longWords = words.stream()
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
        Set<String> set  = words
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

        Map<Integer,List<String> > wordDict = words
                                              .stream()
                                              .collect(Collectors.groupingBy(String::length));

        cout.accept(wordDict);

        // Partitions a group by true of false

        Map<Boolean, List<String > >splits  = words
                                            .stream()
                                            .collect(Collectors.partitioningBy(lengthTest.apply(5)));

        cout.accept(splits);

        // Challenge

        List<Person> people = Arrays.asList(
                new Person("Brandon", 23),
                new Person("Hank",43),
                new Person("Jenna", 23 ),
                new Person("Jack",27),
                new Person("Veronica",56)
        );

        // Get a list that gets people's names
        List<String> names = people
                            .stream()
                            .map(x -> x.name)
                            .collect(Collectors.toList());
        cout.accept(names);
    }
}
