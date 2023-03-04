package org.sphedev;

import java.util.function.Function;
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


    }
    public static Integer func(Function<Integer,Integer> res,Integer x){
        return res.apply(x);
    }
}