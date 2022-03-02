package test.test03;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class test03 {
    public static void main(String[] argv){
//        test undergraduate
        Undergraduate[] ungStu= {new Undergraduate("allen",465789, new int[]{96, 98, 93}), new Undergraduate("amy",464689, new int[]{96, 76, 86})};
        for(Undergraduate stu: ungStu)stu.dispProperty();
        System.out.println("---into the graduate---");
//        test graduate
        Graduate[] gStu= {new Graduate("allen",465789, new int[]{96, 98, 93}), new Graduate("amy",464689, new int[]{66, 76, 86})};
        for(Graduate stu: gStu)stu.dispProperty();
    }
}

abstract class student{
    protected Scanner selfScanner =new Scanner(System.in);

    public student(String name,int no, int[] scores){
        this.sName=name;
        this.sNO=no;
        this.scores=scores.clone();
    }

    private int[] scores= new int[3];

    private int sNO=0;
    private String sName="unNamed";

    public void setName(){
        try{
            System.out.println("input your name:");
            sName=selfScanner.next();
        }catch(InputMismatchException ime){
            ime.printStackTrace();
        }
    }

    public int getNO() {
        return sNO;
    }

    public String getName() {
        return sName;
    }

    public void setNO(){
        try{
            System.out.println("input your NO:");
            int temp = selfScanner.nextInt();
            if(Integer.toString(temp).length()==8){
                System.out.println("input successfully");
                sNO=temp;
            }else{
                System.err.println("err NO length");
                throw new Exception();
            }
        }catch(InputMismatchException ime){
            System.err.println("err input format");
            ime.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public int[] getScores() {
        return scores.clone();
    }

    public void dispScores(){
        System.out.println("three scores are "+Arrays.toString(getScores()));
    }

    public void dispProperty() {
        System.out.format("""
                name: %s
                NO: %d
                isDegreed: %b
                the scores: %s
                mean score: %s
                """,getName(),getNO(),isGetDegree(),Arrays.toString(getScores()),getMeanScores());
    }

    public double getMeanScores(){
        double count=0;
        for (int score : scores) {
            count += score;
        }
        return count/scores.length;
    }

    abstract public boolean isGetDegree();
}

class Undergraduate extends student{
    public Undergraduate(String name,int no, int[] scores){super(name,no,scores);}
    @Override
    public boolean isGetDegree() {
        return getMeanScores() >= 60;
    }


}

class Graduate extends student{
    public Graduate(String name,int no, int[] scores){super(name,no,scores);}
    @Override
    public boolean isGetDegree() {
        int[] a= getScores();
        Arrays.sort(a);
        return getMeanScores() >= 80 && a[0]>= 60;
    }
}