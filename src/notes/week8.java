package notes;

/*
在这一周我们学习了代码块的使用，关于代码块的使用顺序
包的载入，与对象的构造


*/


public class week8 {
    static {
//        静态代码块
        System.out.println("enter the static code block");
        myInt = 10;
    }

//    常成员必须先初始化
    static final int myPi = 314;
    static int myInt;
    int x;

    {
        System.out.println("only you construct a main class obj can you get here!");
    }

    week8(){
        System.out.println("myJava main class constructor without parameter!");
    }

    public static void main(String[] args){
        System.out.println("it is my thing and i get into the main");
        staticCode aSc= new staticCode(100);
        myTry my = new myTry();
    }

    void testFinalVar(final int x){
        System.out.println(x);
    }

}

class myTry{
    static{
        System.out.println("my try get Static");
    }

    {
//        构造代码块
        System.out.println("i get the my try construct block!");
    }

    myTry(){
        System.out.println("do it my try");
    }
}

class staticCode{
    static{
        System.out.println("staticCode get Static");
    }

    staticCode(int a){
        System.out.println("get a code");
    }
}
