package notes.week10Pack;
/*
* 接口是抽象的集合
* 不能定义构造函数
* 不能实例化函数
* 对于所有对象都是常对象，要初值，要大写
* 父类和接口是并列关系
*
* 子接口继承父类还是用extends
* 接口间继承还是单继承
*
* 抽象类可以有构造函数，但是构造函数不能定义为抽象函数
*
* 接口只能继承其他接口，不能继承抽类
* */


public class week10a{
    public static void main(String[] args) {
        subClass a = new subClass(){
            public int show(){
                System.out.println("""
                        匿名的内部类暂时实例化抽象对象
                        Anonymous""");
//                text block java method same as the python
//                it could directly contain the \n
                return 0;
            }
        };
        a.show();
    }
}

//format
abstract class subClass extends week10a implements myUtils, subUtils{
    subClass(){
     System.out.println("""
             抽象类可以有构造函数，但是构造函数不能定义为抽象函数！
             abstract也不可用来修饰变量、代码块。
             """);
//     末端分行会被记录进去
    }
}

//same as the abstract, but able to multi inherit
interface myUtils{
//    if you want to make a public inter, it should in the name.java as the main class
    int show();
//    the fun is public abstract
    int ID = 0;
//    the var in the inter is public static final(defualtly)
}
//the methods in the inter could only be done in the subclass

interface subUtils extends myUtils{
//    a inter inherit from another
}

abstract class Imath implements compareUtils{
//    the implements ket word;
//    子类重写时，其访问修饰符的范围，不能比父类小

//    所以interface只能用public实现

}
interface compareUtils{
//    默认为public
    int myCompare();
    int getMax();
 
//    只能是常量final
    double PI = 3.14;
//    注意，我们不能在子类中修改其的访问修饰符号
}

