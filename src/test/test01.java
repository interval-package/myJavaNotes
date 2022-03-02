package test;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class test01 {
    public static void main(String[] args){
//        isRtTriangle();
//        theNumberLength();
//        railCost();
        System.out.println(superN(15));
        System.out.println(superNW(15));
    }

//----------------------------------------------------ques--------------------------------------------------------------

    public static boolean isRtTriangle(){
        System.out.println("输入三边长");
        Scanner sc = new Scanner(System.in);
        double[] edges = new double[3];
        try{
            for(int i=0;i<3;i++){
                edges[i]=sc.nextDouble();
                if(edges[i]<0){
                    System.err.println("输入错误数据");
                    throw new Exception();
                }
            }
        }catch(Exception e){
            System.err.println("出现错误");
//            e.printStackTrace();
            return false;
        }

        Arrays.sort(edges);
//        使用arrays排序

        if(Math.abs(Math.pow(edges[0],2)+Math.pow(edges[1],2)-Math.pow(edges[2],2))<0.0001){
            System.out.println("是直角三角形");
            return true;
        }else{
            System.out.println("不是直角三角形");
            return false;
        }
    }
//----------------------------------------------------ques--------------------------------------------------------------

    public static void theNumberLength(){
        Scanner sc = new Scanner(System.in);
        System.out.println("input a integer(0-9999): ");
        int num=0;
        try{
            num = sc.nextInt();
            if (num<0||num>9999){
                System.err.println("exceeding the size");
                throw new Exception();
            }
        }catch(InputMismatchException ime){
            System.err.println("mismatch exception");
            ime.printStackTrace();
            return;
        }catch(Exception ex){
            System.err.println("wrong");
            ex.printStackTrace();
            return;
        }
        String str = Integer.toString(num);
        System.out.println("the length is "+str.length());
    }

//----------------------------------------------------ques--------------------------------------------------------------

    public static void railCost(){
        System.out.println("input railDistance and wight:");
        Scanner sc = new Scanner(System.in);
        double dis,weight;
        try{
            dis = sc.nextDouble();
            weight = sc.nextDouble();
            if (dis<0||weight<0){
                System.err.println("wrong input");
                throw new Exception();
            }
        }catch(InputMismatchException ime){
            System.err.println("mismatch exception");
            ime.printStackTrace();
            return;
        }catch(Exception ex){
            ex.printStackTrace();
            return;
        }
        double cost=0;
        int divider = (int)(dis/100);
        if(divider>10){
            cost += (dis-1000)*weight*0.6;
            dis=1000;
            divider=5;
        }
        switch (divider){
            case 5: case 6: case 7: case 8: case 9: case 10:
                cost += (dis-500)*weight*0.7;
                dis=500;
            case 3: case 4:
                cost += (dis-300)*weight*0.8;
                dis=300;
            case 1: case 2:
                cost += (dis-100)*weight*0.9;
                dis=100;
            case 0:
                cost += dis*weight*1;
        }
        System.out.println(cost);
    }
//----------------------------------------------------ques--------------------------------------------------------------

    public static int superN(int n){
        System.out.println("for method");
        if (n<0){
            System.err.println("wrong input");
            return -1;
        }
        int result=0;
        for (int i=1,iter=1;i<n+1;i++){
            iter*=i;
            result+=iter;
        }
        return result;
    }

    public static int superNW(int n){
        System.out.println("while method");
        if (n<0){
            System.err.println("wrong input");
            return -1;
        }
        int result=0;
        int i=1,iter=1;
        while(i<n+1){
            iter*=i;
            result+=iter;
            i++;
        }
        return result;
    }
}
