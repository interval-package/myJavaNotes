package test.test08;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class detectConfigSys {
    public static void main(String[] args) throws IOException {
//        main1();
        main2();
    }


    public static void main1(){
        File file = new File("C:\\");
        if(file.exists()){
            System.out.println("文件存在");
        }else{
            System.out.println("文件不存在");
            return;
        }
        if(file.isDirectory()){
            System.out.println(file.getName());
            for (String fileName: Objects.requireNonNull(file.list())
            ) {
                System.out.println(fileName);
            }
        }
        if(file.isFile()){
            System.out.println(file.getName());
            try{
                InputStream is = new FileInputStream(file);
                System.out.println(is.read());
            } catch (FileNotFoundException e) {
                System.out.println("file not found");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("不是文件夹");
        }
    }

    public static void main2() throws IOException {
        File file=new File("D:\\Qt\\Tools\\mingw810_64\\opt\\share\\terminfo\\6e\\nansi.sys");
        if (file.exists()){
            FileInputStream fi=null;
            try {
                System.out.println("文件存在");
                fi=new FileInputStream(file);
                BufferedInputStream bif = new BufferedInputStream(fi);
                byte[] data=new byte[64];
                int hasRead;
                while ((hasRead=bif.read(data))>0){
                    System.out.println(new String(data,0,hasRead));
                }
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                fi.close();
            }
        }else{
            System.out.println("文件不存在");
        }
    }
}
