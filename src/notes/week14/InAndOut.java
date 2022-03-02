package notes.week14;
import java.io.*;
import java.util.Arrays;

/*
*
* File class
*
*   default path user.dir
*
*
* */

// System.in/out 是字节流

public class InAndOut {
    public static void main(String[] args) throws FileNotFoundException {
        OutputStream os = new FileOutputStream("  ");
        PrintWriter pw = new PrintWriter(os);
//        打印流，格式化输出
    }
//    不能只依赖file类进行输出输入，还要用输出输入流
}

// caution "\\" means the \ used in dir!


/**********************************************************************************************************************/

// java使用了一个常量 separator，作为分隔符
class opener{
    public static void getCreate() throws IOException {
//        这里  throws IOException 是必须的，对于f.createNewFile();

        File f =new File("notes");

//        创建文件
        f.createNewFile();

//        创建文件夹
        f.mkdir();
//        只创建一个文件夹，如果父路径不满足则返回false
        f.mkdirs();
//        如果不存在，则把完全的路径给全部创建

        System.out.println(f.isFile());

        File f1 =new File(f,"child name");

        System.out.println(f.getAbsolutePath());
        System.out.println(Arrays.toString(f.list()));
//        implicit call to toString

        f1.length();
//        获取文件大小（字节数），只能对文件，文件夹不可以

        f.delete();
        f1.delete();
//        目录、文件都可以删除
//        无法删除非空文件夹（目录）
    }


}

//  建立流，数据处理

class ReaderSelf{
    public static void myTry(){

//        在finally一定要关闭

// 给输出流，加上-追加-属性
// FileOutputStream(file,true-实现尾部追加)

    }
}

// 缓冲流（是处理流，要先构建节点流，用节点流做参数，节点流用文件对象做参数），都是对缓冲去进行操作，满了就输出
// 可以使用flush强制输出、入

// 转换流，就是将字节流转化为字符流，再把字符流转化为字节流，用于解码转换

// 外部流关闭，会带着内部关闭


//对象流
//不需要序列化的字段前加 transient