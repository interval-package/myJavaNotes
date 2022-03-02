package test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import org.jetbrains.annotations.NotNull;

public class test04 {
    public static void main(String[] argv){
        System.out.println("---test Exam obj---");
        Exam exam = new Exam(5);
        exam.changeLengthInput();
        System.out.format("Scores are: %s;\naverage is: %d",Arrays.toString(exam.getScores()),exam.getAverage());
        System.out.println("\n---test dive obj---");
        Diving dive = new Diving(5);
        dive.setScores();
        System.out.format("Scores are: %s;\naverage is: %d",Arrays.toString(dive.getScores()),dive.getAverage());
    }
}

abstract class Shape{
    private boolean isFilled;
    private String color;
    abstract public double getArea();
    public boolean isFilled() {
        return isFilled;
    }
    public void setFilled(boolean filled) {
        isFilled = filled;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
}
interface Colorable{
    void howToColor();
}
class Rectangle extends Shape{
    private double width;
    private double height;
    public Rectangle(double height,double width){
        this.height=height;
        this.width= width;
    }
    @Override
    public double getArea() {return width*height;}
}
class circle extends Shape{
    private double radius;
    public circle(){
        this.radius = 0;
    }
    public circle(double r){
        this.radius=r;
    }
    public double getRadius(){
        return radius;
    }
    public double getPerimeter(){
        return 2*Math.PI*radius;
    }

    @Override
    public double getArea(){
        return Math.PI*Math.pow(radius,2);
    }
}
class Triangle extends Shape{
    private int[] lines=new int[3];
    @Override
    public double getArea() {
        double a = (double)lines[0];
        double b = (double)lines[1];
        double c = (double)lines[3];
        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p-a)* (p-b) * (p-c));
    }
    public Triangle(int[] x){this.lines=x.clone();}
    public Triangle(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("input three line: ");
        for(int i=0;i<3;i++){
            lines[i]= scanner.nextInt();
        }
        System.out.println("is filled?:");
        setFilled(scanner.nextBoolean());
        System.out.println("what's the color?:");
        setColor(scanner.next());
    }
    public double getPerimeter(){
        double a =0;
        for(double l: lines) a+=l;
        return a;
    }
    public void disp(){
        System.out.format("""
                Area: %f
                Perimeter: %f
                color: %s
                isFilled: %b
                """,getArea(),getPerimeter(),getColor(),isFilled());
    }
}
class ComparableCircle extends circle implements Comparable<ComparableCircle>{
    @Override
    public int compareTo(@NotNull ComparableCircle o) {
        return Double.compare(getArea(),o.getArea());
    }
    public ComparableCircle(int r){
        super(r);
    }
}

class Square extends Shape implements Colorable{
    private double length;
    public double getLength() {
        return length;
    }

    public Square(){
        Scanner cs = new Scanner(System.in);
        System.out.println("enter the length color and isFilled:");
        length=cs.nextDouble();
        super.setColor(cs.next());
        super.setFilled(cs.nextBoolean());
    }
    public Square(int length, String color, boolean isFilled){
        super.setColor(color);
        super.setFilled(isFilled);
        this.length=length;
    }
    @Override
    public double getArea() {
        return length*length;
    }

    @Override
    public void howToColor() {
        if(isFilled()){
            System.out.println("color the four edges, color method: "+this.getColor());
        }else{
            System.out.println("uncolored");
        }
    }
}



//----------------------------------------------------ques--------------------------------------------------------------

interface StudentInterface{
    void setFee();
    int getFee();
}
interface TeacherInterface{
    void setPay();
    int getPay();
}

class Graduate implements StudentInterface,TeacherInterface{
    private String name;
    private boolean sex;
    private int fee;
    private int pay;

    public Graduate(){
        setFee();
        setPay();
    }

    public Graduate(String name,boolean sex,int fee,int pay){
        this.name = name;
        this.sex=sex;
        this.fee=fee;
        this.pay=pay;
    }

    @Override
    public int getFee() {
        return fee;
    }

    @Override
    public void setFee() {
        System.out.println("input fee:");
        this.fee = new Scanner(System.in).nextInt();
    }

    @Override
    public int getPay() {
        return pay;
    }

    @Override
    public void setPay() {
        System.out.println("input pay:");
        this.pay = new Scanner(System.in).nextInt();
    }

    public void conditionJugde(){
        if(12*(pay-fee)>2000){
            System.out.println("You income is enough！");
        }else{
            System.out.println("You need a loan!");
        }
    }
}

//----------------------------------------------------ques2-------------------------------------------------------------

interface CalculateAverage{
    int getAverage();
}

class Diving implements CalculateAverage{
    private int[] scores;

    public void changeLengthInput(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list =new ArrayList<Integer>();
        System.out.println("input scores: ");
        while(sc.hasNext()){
            list.add(sc.nextInt());
        }
        scores=list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public Diving(int length){
        scores = new int[length];
    }

    public void setScores(){
        Scanner cs=new Scanner(System.in);
        System.out.println("input the numbers: ");
        for (int i=0;i<scores.length;i++){
            scores[i]=cs.nextInt();
        }
    }

    public int[] getScores() {
        return scores.clone();
    }

    @Override
    public int getAverage() {
        int[] scl=getScores();
        Arrays.sort(scl);
        int count=0;
        for (int i=1;i<scl.length-1;i++){
            count+=scl[i];
        }
        return count/(scl.length-2);
    }
}
class Exam implements CalculateAverage{
    private int[] scores;

    public Exam(int length){
        scores = new int[length];
    }

    public Exam(int[] source){
        this.scores=source.clone();
    }

    public void setScores(){
        Scanner cs=new Scanner(System.in);
        System.out.println("input the numbers: ");
        for (int i=0;i<scores.length;i++){
            scores[i]=cs.nextInt();
        }
    }

    public int[] getScores() {
        return scores.clone();
    }

    public void changeLengthInput(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("input scores, end with char: ");
        while(sc.hasNextInt()){
            list.add(sc.nextInt());
        }
        scores=list.stream().mapToInt(Integer::valueOf).toArray();
    }

    @Override
    public int getAverage() {
        int[] scl=getScores();
        int count=0;
        for (int i:scl){
            count+=i;
        }
        return count/scl.length;
    }
}
