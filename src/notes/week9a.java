package notes;

/*
in today's lesson we learn about the interface and extends uitls
and the key super, differences between rewrite and reload is important
what a base mean and the differences to the c++
 */

/*
* 多层继承
* java查询机制，自己里面找，找不到再向上找一层
* 与interface不同，implements interface与extends是同层的
*
*
*
*
* */


public class week9a {
    private final int a;

    week9a(){
        this(0);
    };
    week9a(int a1)
    {
        a=a1;
        System.out.println("this.a="+a);
    }

    public static void main(String args){

    }
}

class base extends week9{
    base(){
        // 父类构造函数必须在第一行调用！
        super();

    }
}