package test.test08;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
//int[] intArr = Prime.stream().mapToInt(Integer::intValue).toArray();



public class javaSavePrime {
    public static void main(String[] args){
        javaSavePrime me = new javaSavePrime("PRIME.DAT");
        me.getPrimers(200);
        me.startSave(false);
        me.readPrimeAsString();
    }

    private ArrayList<Integer> Prime = new ArrayList<Integer>();
    private File src;
    private OutputStream os = null;
    private InputStream is = null;
    private String PrimeInfo = "";

    public javaSavePrime(String filename){
        src = new File(filename);
    }

    public void startSave(boolean isAppend){
        if(Prime.size()==0){
            System.out.println("yet not found!");
            return;
        }

        System.out.println("===写出文件====");
        try {
//            isAppend 控制是否以追加模式进行
            os = new FileOutputStream(src, isAppend);  //创建输出流对象

            byte[] data = Arrays.toString(Prime.toArray()).getBytes();//字符串转换为字节数组

//            使用字符的方式进行输出，减去两位除去方括号的输出
            os.write(data,1,data.length-2);
            os.flush();//强制刷新，输出文件

        } catch(FileNotFoundException e){
            System.out.println("文件未找到");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("文件写出失败");
            e.printStackTrace();
        } finally{
            if(null !=os){
                try {
                    os.close();//close关闭
                } catch (IOException e) {
                    System.out.println("关闭文件输出流失败");
                    e.printStackTrace();
                }
            }
        }
    }

    public void readPrimeAsString(){
        System.out.println("===读取文件====");
        try {
            is = new FileInputStream(src);
//            这里应该用Reader的，字符流就多了一步强制转换的操作
//            FileReader fr = new FileReader(src);

//            或者在这个地方使用装换流，很可惜这个地方没有用上处理流的形式

            byte[] car = new byte[16];//缓冲数组，用于存放暂时的数据
            int len = 0;//接收实际读取大小
            try {
                while(-1 !=(len = is.read(car)))
                {
                    PrimeInfo = new String(car,0,len);
                    System.out.println(PrimeInfo);
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("文件不存在");
            }
        } catch (FileNotFoundException e) {
            System.out.println("读取文件失败");
            e.printStackTrace();
        }finally{
            if(null !=is){
                try { is.close();//close关闭
                } catch (IOException e) {
                    System.out.println("关闭文件输入流失败");
                    e.printStackTrace();
                }
            }
        }

    }

//    获取素数的模块
    public void getPrimers(int counts){
        for(int i = 1;i<=counts;i++) {
            if(isPrime(i)){
                Prime.add(i);
                System.out.println("prime: "+i);
            }
        }
    }
    public static boolean isPrime(int n) {
        // 1 不是素数
        if (n <= 1) {
            return false;
        }
        // 由于在找 n 的因数时，只需要除到 n 开根号，所以只需 i*i<n 即可
        for (int i = 2; i * i < n; i++) {
            // 只要能被 i 整除，则返回 0
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}


