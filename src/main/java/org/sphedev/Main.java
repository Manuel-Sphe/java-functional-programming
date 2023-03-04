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
    }
}