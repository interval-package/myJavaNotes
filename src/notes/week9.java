package notes;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/*
*
*
* 这节课最重要的就是内部类的处理了
* 内部类可以拥有private、protected、public及包访问权限。
* 外部类只能被public和包访问两种权限修饰
* 外部类被内部类遮蔽（这个要体现一下，是怎么覆盖的）
* 外部类.this.成员变量
*
*
* */

public class week9 {
    public static void main(String[] args) {
        week9 w = new week9();

//        week9.InnerClass asdf= new w.getIn(); //  直接的效果是javaIDE在写的时候就无法访问到，会标红


        try{
            // 没有想到吧，是可以直接上去的，都是要有一个构造好的对象在这里
            week9.InnerClassPub pucl= w.new InnerClassPub();

            // 同时这个语法实际上也是挺奇怪的

            System.out.println("try");

            week9.StaticInnerClass stIncl =new week9.StaticInnerClass();
            // 这里会打印输出，而且还访问得到，所以这个private几乎毫无意义了

            w.coverFun();
            pucl.coverFun();


            /*
            * 外部类只能被public和包访问两种权限修饰
            * 外部类被内部类遮蔽（这个要体现一下，是怎么覆盖的）
            *
            * 外部类.this.成员变量
            * 没有体现出来，不懂
            *
            * site：懂了，这里指的是在内部类里面调用外部的函数。所以一定会有隐藏效果
            *
            * */

        } catch(Exception e){
            System.err.println("err");
        };

    }

    week9(){
        InnerClass i=getIn();
    }

    public void coverFun(){
        System.out.println("outer cover");
    }

    // class in the class
    private class InnerClass{
        // 这样子的话外部 就访问不到了
        InnerClass(){
            System.out.println("build a InnerClass");
        }
    }

    public class InnerClassPub{
        // 这样子的话外部 就访问不到了
        InnerClassPub(){
            System.out.println("build a InnerClass");
        }
        public void coverFun(){
            System.out.println("inner public cover");
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

// 匿名类，用于抽象实例化输出

abstract class Person {
    public abstract void eat();
}

class Demo {
    public static void main(String[] args) {
        Person p = new Person() {
            public void eat() {
                System.out.println("eat something");
            }
        };
        p.eat();
    }
}

