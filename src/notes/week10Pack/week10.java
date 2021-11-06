package notes.week10Pack;

/*
*
* today we are taling about the multiple
* java对象的强制转换叫做“造型”，(type)
* 父类到子类需要用强制转型
* instanceof 做测试
*
* */

public class week10 {
    public static void main(String args){
//        两个对象比较，比的是对象的地址。
//        类里面的静态方法直接调用
        myShow();
//        多态的转型

//        向上转型，很熟了
        sub father = new sub();
        decendent solidFather = new decendent();

//        向下转型
        sub lower = (sub)father;    //本质这玩意是“强制转换”！所以IDE会显示cast
//        对于传入的参数向上转型后的恢复，使可以调用子类的特定方法


        try {
            sub lowerDanger1 = (sub)solidFather;     //不安全的向下转型
        }catch(Exception err){
            System.err.println("err happens");
        }

//        解决方法
//        using the key instanceof, it could judge the typer
        if (solidFather instanceof sub){
//            pattern variable???
            sub lowerDanger2 = (sub)solidFather;
        }

//        抽象类实例化
        virtualFather unname = new virtualFather(){
            public void show(){
                System.out.println("unname show");
            }
        };
         
    }

    public static void myShow(){

    }
}

// 编译多态：方法的重载
// 运行时的多态：动态绑定。根据实际类型来选择方法，也就是父类指向子类（c++有点像）

// 抽象类
abstract class virtualFather{
    // the property could not be rewrited, only the method could be.
    String type ="father";

    // 也就是java默认发生了重写（虚拟调用），但是还是和c+一样，还是使用父类的属性。是因为重写才有这样的效果，调用还是父类的。

    // 父类指针，还是使用父类的属性，只是函数被重载了


    // java and c++ need a return type not like the python
    // 抽象方法要在抽象类中
    abstract void show();

    // test the override of static method, it's unable.
    public static void staticMethodFunMulti(){
        System.out.println("get decendent static fun");
    }

    // also the 'final' mean unable too!
}

class decendent extends virtualFather{
    String type="decendent get covered";
    void show(){
        System.out.println("decendent_01 show function awake.");
    }

    public static void staticMethodFunMulti(){
        System.out.println("get decendent static fun");
    }
}

class sub extends decendent{

}

// 重写+虚拟调用，同c++的virtual