package notes.week12;

//import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/*
* java:集合
* 可以变化长度，提升于数组
* 可以放不同类型的数据（不同于Array
* 但是只能够放对象（基本类型使用包装类）！javaScript了
* 使用引用来进行元素
* */

/*
 * Collection and Map
 *
 * List Map Queue
 *
 * LinkedList ArrayList Vector
 *
 * HashMap TreeMap
 * */

/*
 * Arrays是工具类
 * */
/*
 * Iterator:next hasNext...
 * */

/*
 * List is serial(有顺序的)
 * LinkedList ArrayList Vector
 * */

public class week12a {

}


class tryArrayList{
    void myTry(){

//        RandomAccess()
//        可以被序列化（在输出输入时，可以字节化，反字节化，就是可以进行对象的转换?json）
        ArrayList<String> strs = new ArrayList<String>(6);// def the initialCapacity
//        泛型，针对于类型进行初始化
//        collection<extends E>,指定存放的类型（可以是子类）,在创建时约定类型
//        扩容，到达栈顶，增加0.5倍

        ArrayList objs = new ArrayList();

        strs.add(new String(""));
//        boolean 类型
        strs.add(0,new String(" "));
        strs.remove(0);
        strs.clear();
        if(strs.isEmpty()){
            strs.toArray();
        }
        strs.add("");
        for(String str:strs){
            str.chars();
        }
//        增强循环
        for(Iterator<String> it =strs.iterator();it.hasNext();){
//            迭代器循环，需要import
        }

//        contains->indexOf->obj.equals
//        如果要修改的话，那就重写obj的equals方法
    }
}

class trySet{
//    无序集合，无下标，无重复元素
    void myDo(){
        HashSet<String> mp = new HashSet<String>();
//        加载因子0.75

    }

}