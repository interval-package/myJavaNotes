package test.test05;

import test.test05.IllegalAgeException;
import java.util.Scanner;

public class Person {
    static public void main(String[] args){
        Person pp= new Person("ads",450,true);
        pp.dispInfo();
    }
    private String Name;
    private int age;
    private boolean sex;
    public Person(String Name, int age, boolean sex) {
            this.Name = Name;
            this.sex = sex;
            setAge(age);
    }
    public void setAge(int age) {
        try{
            if (IllegalAgeException.isSafe(age)) {
                this.age = age;
            } else {
                throw new IllegalAgeException();
            }
        } catch (IllegalAgeException e) {
            e.dispErr();
            System.out.println("please manually input the age:");
            setAge(new Scanner(System.in).nextInt());
        }
    }
    public void dispInfo(){
        System.out.format("""
                Name: %s
                Age: %d
                Sex:　%s
                """,Name,age,getStringSex());
    }
    public String getName() {
        return Name;
    }
    public int getAge() {
        return age;
    }
    public String getStringSex(){
        return sex?"male":"female";
    }
    public boolean getBooleanSex() {
        return sex;
    }
}
