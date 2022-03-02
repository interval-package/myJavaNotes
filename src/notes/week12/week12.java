package notes.week12;

//默认导入了lang
//不用类名调用
import java.util.Random;
import java.util.Date;


/*
* today talk about the useful API
*
* String
* StringBuffer to deal with the problem of String unchangeable
* System
* Math
*
* */

public class week12 {
//    Random obj
    public static Random myCon =new Random(new Date().getTime());
    public static String str = null;
//    String 内部Char为final 不可修改

    public static void main(String[] arg){
        bufferDemo.bufferMain();
//        str = new String(" ");
//        char[] s=str.toCharArray();
//        System.out.println(s[0]);
    }

    public static void MathTry(){
        System.out.format("""
                method: %d
                %b
                """, myCon.nextInt(100),myCon.nextBoolean());
    }// nextInt(n) [0,n)
}

/*
*
* Math private constructor
* only have static method
*
* */

/*
* StringBuffer create with a size(default 16+strLen?0)
* StringBuffer is just a container, with remain space for new items
* So have a lower efficiency
* */

class bufferDemo{
    public static void bufferMain(){
        StringBuffer b=new StringBuffer();
        b.append("you are!");
        System.out.format("""
                %d
                %d
                """,b.length(),b.capacity());
        b.append("aaaaaaaaaaaaaaaaaa");
        System.out.format("""
                %d
                %d
                """,b.length(),b.capacity());
//        容量扩增
    }

    public static void subMain(){
        System.out.format("""
                time: %d
                property: %s
                """,System.currentTimeMillis(),
                System.getProperties()
                );

        System.gc();
//        回收垃圾

        System.exit(0);
//        status int
    }
}

class mySystem{

}


