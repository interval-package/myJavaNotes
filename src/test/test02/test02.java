package test.test02;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class test02 {
    public static void main(String[] args){
        Triangle tri =new Triangle();
        tri.setTri();
        tri.disp();
    }

}

//----------------------------------------------------ques2-------------------------------------------------------------
//自带compareTo属性，comparable模板类型要加上
class student implements Comparable<student>{
    public void disp(){
        System.out.format("""
                name: %s
                no: %s
                sex:　%s
                age: %d
                sjava: %d
                """,sName,sNO,sSex,sAge,sJava);
    }
    public student(){
        setAge();
        setJava();
        setSex();
    }
    public student(String nameStr,int no, boolean sex, int age, int score){
        this.sName = nameStr;
        this.sNO= Integer.toString(no);
        this.sAge=age;
        if (sex){
            this.sSex = "male";
        }else{
            this.sSex = "female";
        }
        this.sJava=score;
    }

    public student(int sJava){
        this.sJava=sJava;
    }

    private final Scanner privateScanner= new Scanner(System.in);

    private String sNO="unNamed";
    private String sName="unNamed";
    private String sSex="male";
    private int sAge=0;
    private int sJava=0;

    public String getSex() {
        return sSex;
    };
    public String getName(){
        return sName;
    };
    public String getNO(){
        return sNO;
    };
    public int getAge(){
        return sAge;
    };
    public int getJava(){
        return sJava;
    };

    public void setName() {
        this.sName = privateScanner.next();
    }

    public void setNO(String sNO) {
        this.sNO = privateScanner.next();
    }

    public int setAge(){
        int age=0;
        try{
            System.out.println("input age:");
            age=privateScanner.nextInt();
            if(age<0||age>169){
                throw new InputMismatchException();
            }
        }catch(InputMismatchException ime){
            ime.printStackTrace();
            return -1;
        }
        sAge=age;
        return sAge;
    }

    public int setJava(){
        int score=0;
        try{
            System.out.println("input java score:");
            score=privateScanner.nextInt();
            if(score<0||score>100){
                throw new InputMismatchException();
            }
        }catch(InputMismatchException ime){
            ime.printStackTrace();
            return -1;
        }
        sJava=score;
        return sJava;
    }

    public String setSex() {
        System.out.println("input your gender(1 male; 0 female): ");
        boolean temp;
        try{
            temp = privateScanner.nextBoolean();
        }catch(InputMismatchException ime){
            ime.printStackTrace();
            return "";
        }
        if(temp){
            this.sSex = "male";
        }else{
            sSex="female";
        }
        return this.sSex;
    }

    @Override
    public int compareTo(@NotNull student another) {
        return Integer.compare(sJava,another.getJava());
    }

    public static int stuMean(student stu1, student stu2){
        return (stu1.getJava()+stu2.getJava())/2;
    }

    public static void fiveCompare(){
        student[] stu = {new student(10),
                new student(30),
                new student(80),
                new student(60),
                new student(20),
        };
        Arrays.sort(stu);
        System.out.println("max: "+stu[stu.length-1].getJava()+" min : "+stu[0].getJava());
    }

}

//比较器对象
class stuCompare implements Comparator<student> {
    public int compare(student obj,student another) {
        return Integer.compare(obj.getJava(), another.getJava());
    }
}

//----------------------------------------------------ques2-------------------------------------------------------------

class point{
    private double x,y;
    public point(double x, double y){
        this.x=x;
        this.y=y;
    }
    public point(){
        this(0,0);
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }

    public static double getLength(point p1, point p2){
        return Math.sqrt(Math.pow(p1.getX()- p2.getX(), 2)+Math.pow(p1.getY()- p2.getY(),2));
    }
}

class Triangle{
    private point[] ps =new point[3];
    public void setTri(){
        Scanner sc = new Scanner(System.in);
        setTri(sc);
    }
    public void setTri(Scanner sc){
        try{
            for (int i=0;i<3;i++){
                System.out.println("input x y:");
                ps[i]=new point(sc.nextDouble(),sc.nextDouble());
            }
        }catch(InputMismatchException ime){
            ime.printStackTrace();
        }
    }
    public double getVolume(){
        double a=point.getLength(ps[0],ps[1]);
        double b=point.getLength(ps[2],ps[1]);
        double c=point.getLength(ps[2],ps[0]);
        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p-a)* (p-b) * (p-c));
    }

    public void disp(){
        System.out.format("""
                面积：%f
                周长：%f
                """,getVolume(),getGirth());
    }

    public double getGirth(){
        return point.getLength(ps[0],ps[1])+point.getLength(ps[2],ps[1]);
    }
}