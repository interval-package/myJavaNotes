package notes.week15;

//import java.io.IOException;
import java.net.*;
//无法pub构造，可以获取IP地址对象

//import java.io.OutputStream;
//import java.io.InputStream;
import java.io.*;

/*
*
* java是网络的编程语言
*
* IP地址：硬件地址，hostname
* DNS服务器将域名转化为IP地址
*
* */

public class javaNetProgram {
    public static void main(String[] args) throws IOException {
        InetAddress myNet=InetAddress.getLocalHost();
//        InetAddress baidu=InetAddress.getByName("ip String");
//        throws UnknownHostException

//        System.out.println(baidu.isReachable(3000));
//        update UnknownHostException to IOException
        System.out.println(myNet.getHostName());


    }
}


class ser{
    public static void main() throws IOException {
        ServerSocket server=new ServerSocket(8888);
//        IOex

        while(true){
            System.out.println("Waiting");
            Socket sc = server.accept();
            // accept 会阻塞,while会停止,等待监听结束
            if(sc!=null){
                System.out.println("acc!");

//                进入read状态，也会阻塞，直到信息发完。要有结束标志
                break;
            }
        }
    }
}
/*
*
* socket
*
* 使用close
* socket关闭之后，只能重新新建，不可重新开启
*
* */

/*
*
* cli write 与 ser read 阻塞,没有标志传输结束，ser端出错
* cli端 标志一下结束
* 让cli outputStream 结束-socket.shutdownOutput()
* 记得在结束前刷新一下，全部推出去
*
* */



class cli{
//    对于这个，要会用缓冲流
    public static void main(){
//        SocketAddress, abstract
    }
}