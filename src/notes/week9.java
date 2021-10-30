package notes;

/*
* 这节课最重要的就是内部类的处理了
*
*
*
* */

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class week9 {
    public static void main(String[] args) {
        week9 w = new week9();

//        week9.InnerClass asdf= new w.getIn(); //  直接的效果是javaIde在写的时候就无法访问到


        try{
            System.out.println("try");

            week9.StaticInnerClass asd =new week9.StaticInnerClass();
            // 这里会打印输出，而且还访问得到，所以这个private几乎毫无意义了
        } catch(Exception e){
            System.err.println("err");
        };

    }

    week9(){
        InnerClass i=getIn();
    }


    // class in the class
    private class InnerClass{
        // 这样子的话外部 就访问不到了
        InnerClass(){
            System.out.println("build a InnerClass");
        }
    }


    private static class StaticInnerClass{
        StaticInnerClass(){
            System.out.println("build a static inner class");
        }
    }


    @Contract(" -> new")
    private @NotNull InnerClass getIn(){
        return new InnerClass();
    }
}

class Circle {
    private double radius = 0;
    public static int count =1;
    public Circle(double radius) {
        this.radius = radius;
        getDrawInstance().drawSahpe();
        // 外部类中如果要访问成员内部类的成员，必须先创建一个成员内部类的对象，再通过指向这个对象的引用来访问
    }

    @Contract(value = " -> new", pure = true)
    private @NotNull Draw getDrawInstance() {
        return new Draw();
    }

    class Draw {     //内部类
        public void drawSahpe() {
            // 内部类可以调用
            System.out.println(radius);  //外部类的private成员
            System.out.println(count);   //外部类的静态成员
        }
    }
}
