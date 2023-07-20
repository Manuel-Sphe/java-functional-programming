package org.sphedev;

public class DataLoader {
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
