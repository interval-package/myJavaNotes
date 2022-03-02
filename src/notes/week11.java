package notes;
//java.默认导入了lang
import java.util.InputMismatchException;
import java.util.Scanner;
//import java.swing.JOptionPane;

/*
 * how to deal with java exception
 * dangerous action and warning the users
 * throw and throws
 * */

/*
 * 三种异常：
 * 程序可控异常（不致命型的，可以预见的）
 * 不可控（致命，由JVM处理）
 * 人为异常
 * */

/*
 * 异常是一层一层向外抛出的，最底层错误向外抛出Exception
 * 如果没有做处理，则在最外层main做处理
 * Throwable为异常主类，但是不能直接用，只能用其的两个子类exception and error
 * error 我们无处处理，所以我们经常用exception
 * */

//    检查型异常（要强制检查的异常，除了runtime其他ex都是），非（不强制要求的,编程时的逻辑错误，runtime，error）
/*
 * runtimeException
 * NullPointerException
 * ClassCastException 强制转换时
 * */

public class week11 {
    public static void main(String[] args) {
    exceptionDealer.scanTry();
    }
    public static void myThrows() throws NumberFormatException{
//        可以就地解决
//        也可以抛给外部
//        函数如果出现异常，则向前抛出。throws只能用在这个地方。
//        并且这个异常必须要处理。调用者要么解决，要么就要继续向前抛出
        try {
//            手动抛出的是对象，必须是实例，而自动是类型。同时这样异常可以自己定义。而且啥时候都可以抛。
            throw new Exception();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

class exceptionDealer extends Exception{
//    异常类exception
//    两种：编译时异常，运行时异常
    public static void scanTry() throws NullPointerException{
        Scanner sc = new Scanner(System.in);


        String str="123";
        double a =Double.parseDouble(str);
        System.out.println(a);


        try {
//            可能发生异常的情况，可以没有catch，只是抛出异常，交由外部处理。注意这里throws and throw区别
            int myInt = Integer.parseInt(str);
            System.out.println("try");
            return;
        }catch(NullPointerException npe){
//            这里的类型要匹配才会进入，exception是基本都会收掉
            System.err.println(npe);
//            错误的标准输出区，out输出流会缓存，err不会。out可以重定向，err只打印

//            显示错误内容 Prints this throwable and its backtrace to the specified print stream.
            npe.printStackTrace();
//            当接受到相应类型异常时执行
        }catch(InputMismatchException ime){
            ime.printStackTrace();
        }catch(Exception ex){
//            一个个匹配下来，一般是先子类后父类
            ex.printStackTrace();
        }finally{
//            如果try里面return了，还是会执行finally。但是try exit时，就不行了。
            System.out.println("finally");
//            无论如何都会执行
        }
    }

    public static void trymySCAN(){
        Scanner sc = new Scanner(System.in);


        String str="123";
        double a =Double.parseDouble(str);
        System.out.println(a);
        sc.hasNextLine();
        sc.hasNextInt();
        sc.nextInt();
    }
}

class myDefException extends Exception{
//    自定义错误类型
}


