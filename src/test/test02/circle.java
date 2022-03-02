package test.test02;

//circle类的实现
public class circle{
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
    public double getSize(){
        return Math.PI*Math.pow(radius,2);
    }
    public void disp(){
        System.out.format("半径：%f\n周长：%f\n面积：%f\n", radius,getPerimeter(), getSize());
    }
}

