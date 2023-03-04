package org.sphedev;
import java.util.Optional;
import java.util.function.Consumer;
public class FunctionInterfaces {

    protected static class Person{
        private  String name;
        private  Integer age;

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
        Consumer<String> cout = System.out::println;
        // 3 args
        TriFunction<Integer,Integer,Integer,Integer> add = (x,y,z) -> x + y + z;
        cout.accept("The sum of 3 numbers is "+add.apply(3,2,6));

        // No args
        NoArgsFunction<String> print = () -> "Hello no args";
        // print
        cout.accept(print.apply());

        final Boolean IS_DEV = true;

        DataLoader dataLoader = new DataLoader(IS_DEV);
        cout.accept(dataLoader.select.apply().toString());
    }
}
