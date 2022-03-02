package test.test03;
import test.test02.circle;
import java.util.Scanner;

//cylinder 类的实现
public class Cylinder extends circle{
    private double height;
    public Cylinder(double radius, double height){
        super(radius);
        this.height =height;
    }
    public Cylinder(){
        this(0,0);
    }
    public double getVol(){
        return height*super.getSize();
    }
    public void dispVol(){
        System.out.println("Vol is: "+getVol());
    }
    public double getHeight(){
        return height;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        circle cricle_1 = new circle(20);
        cricle_1.disp();
        System.out.println("input height and radius:");
        Cylinder cly = new Cylinder(scan.nextDouble(), scan.nextDouble());
        cly.dispVol();
    }
}
