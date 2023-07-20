package org.sphedev;


public final class Student  extends Person{

    private String email ;


    public Student(String name , Integer age , String email){
        super(name, age);
        this.email = email;
    }

    public String getNameAndEmail(){
        return super.getName() +", " + this.email;
    }

    public String personToString(){
        return super.toString();
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                ", email='" + email + '\'' +
                '}';
    }
}
