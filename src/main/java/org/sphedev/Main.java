package org.sphedev;
import java.util.function.Function;
import java.util.function.BiFunction;
public class Main {
    protected  static class MyMath{
        public static Integer triple(Integer x){
            return 3*x;
        }
    }
    public static void main(String[] args){
        // Method Reference MyMath::triple
        Function<Integer,Integer> Triple = MyMath::triple;
        Integer result  = Triple.apply(3); // apply to call triple
        System.out.println(result);

        // This can be replaced by using the String's length method using a method reference.
        Function<String,Integer> strLen = (string) -> string.length();

        //
        Function<String,Integer> strLength = String::length;

        //We can also have lambda expressions with multiple lines just add {}
        Function<Integer,Integer> myFunc = (Integer x) ->{
            Integer res = x * 2;
            return res;
        };

        Function<Integer,Integer> absoluteValue = (Integer x) -> (Integer) Math.abs(x);

        System.out.println(absoluteValue.apply(-233));
        System.out.println(myFunc.apply(4));

        System.out.println("The length of \"Hello\" is " +strLen.apply("Hello"));

        // Passing a function interface to a function as an argument
        System.out.println(func(MyMath::triple,6));

        // So far we have work with functions that take 1 argument can we do better?
        BiFunction<Integer,Integer,Integer> add = (x,y)-> x+y;

        System.out.println(add.apply(30,10));
        // You also use Integer::sum
        BiFunction<Integer,Integer,Integer> sum = Integer::sum;
        System.out.println(sum.apply(22,23));

        System.out.println(func((Integer x) -> x*x,5));
        // here we have a function that returns a function
        NoArgsFunction<NoArgsFunction<String>> crateGreater = () -> () -> "Hello Functional";
        NoArgsFunction<String> greet = crateGreater.apply();// This returns a func with we need to call apply again
        System.out.println(greet.apply());

        // Can define the func here again
        // add(x,y) = x+y
        // sub(x,y) = x-y
        // mul(x,y) = x*y
        // choice(func,'+')

        Function<Character,BiFunction<Integer,Integer,Integer>> choice = (ch) -> (x,y) -> {
            int res = 0;
            if (ch == '+')
                res = x+y;
            else if(ch=='-')
                res =  x-y;
            else if(ch == '*')
                res = x*y;
            return  res;
        };
        BiFunction<Integer,Integer,Integer> addition = choice.apply('+'); // Perform addition
        System.out.println("Results : "+addition.apply(3,5));

        BiFunction<Integer,Integer,Integer>  sub = choice.apply('-'); // Perform addition
        System.out.println("Results : "+sub.apply(3,5));

        BiFunction<Integer,Integer,Integer> mul = choice.apply('*'); // Perform addition
        System.out.println("Results : "+mul.apply(3,5));


        // Let's look at Higher order functions, you want to have a different function to test this functions params

        BiFunction<Float,Float,Float> divide = (x,y) -> x/y;
        // will use this function to test if y==0 .
        Function<BiFunction<Float,Float,Float>, BiFunction<Float,Float,Float> >
                dvideTest = (someFunction) -> (x,y) -> y==0 ? 0f : someFunction.apply(x,y);
        BiFunction<Float,Float,Float> divideSafe  = dvideTest.apply(divide); // pass the func to test
        Float value = divideSafe.apply(10f,3f); // Cast the args to floats
        Float val = divideSafe.apply(8f,0f);

        System.out.println(value);
        System.out.println(val); //
    }
    public static Integer func(Function<Integer,Integer> res,Integer x){
        return res.apply(x);
    }
}