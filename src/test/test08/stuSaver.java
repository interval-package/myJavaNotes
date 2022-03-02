package test.test08;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class stuSaver{
    public ArrayList<saveableStudent> result= null;
    public static void main(String[] args){
        saveableStudent[] stus = {
                new saveableStudent("sad","15613", new int[]{12, 122, 12}),
                new saveableStudent("saaxd","1561143", new int[]{112, 12003, 12}),
                new saveableStudent("saxasd","113", new int[]{122, 12, 112}),
                new saveableStudent("saaxd","1561143", new int[]{112, 12003, 12}),
                new saveableStudent("saxasd","113", new int[]{122, 12, 12}),
        };
        ArrayList<saveableStudent> students = new ArrayList<saveableStudent>(List.of(stus));
        stuSaver sav= new stuSaver("students.DAT");
        sav.saveStu(students);
        sav.disp();
    }

    private final File src;
    public stuSaver(String pathName){
        src = new File(pathName);
    }

    public void disp(){
        if(result==null){
            result=readStu();
        }
        for (saveableStudent stu:result
        ) {
            stu.disp();
        }
    }

    public void saveStu(ArrayList<saveableStudent> students){
        ObjectInputStream iis =null;
        try{
            OutputStream os = new FileOutputStream(src,false);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(students);
            System.out.println("---保存ing---");
        } catch (FileNotFoundException e) {
            System.out.println("无法文件");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<saveableStudent> readStu(){
        ObjectInputStream iis =null;
        ArrayList<saveableStudent> result= new ArrayList<saveableStudent>();
        try{
            InputStream is = new FileInputStream(src);
            iis = new ObjectInputStream(is);
            result= (ArrayList<saveableStudent>) iis.readObject();
            System.out.println("---输出ing---");
        } catch (FileNotFoundException e) {
            System.out.println("file not found!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("unknow error");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("未找到类");
            e.printStackTrace();
        } finally{
            if(null !=iis){
                try { iis.close();//close关闭
                } catch (IOException e) {
                    System.out.println("关闭文件输入流失败");
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

}
