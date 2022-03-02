package test.test08;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.io.Serializable;

public class saveableStudent implements Serializable, Comparable<saveableStudent>{
//    必须先要实现序列化
    public static void main(String[] args){
        stuSaver sav= new stuSaver("students.DAT");
        sav.disp();
        System.out.println("---------------");
        saveableStudent.sortor(sav.result);
        sav.disp();
    }

    private String Name;
    private String ID;
    private int[] scores = new int[3];
    saveableStudent(String Name, String ID, int[] score){
        this.Name=Name;
        this.ID=ID;
        System.arraycopy(score, 0, scores, 0, 3);
    }
    public void disp(){
        System.out.format("""
                Name: %s
                ID: %s
                Scores: %s
                """,Name,ID, Arrays.toString(scores));
    }
    public String toString(){
        return String.format("Name: %s,ID: %s,Scores: %s",Name,ID,Arrays.toString(scores));
    }

    public int getAve(){
        return (scores[0]+scores[1]+scores[2])/3;
    }

    @Override
    public int compareTo(@NotNull saveableStudent o) {
        System.out.println((getAve()-o.getAve())>0?">":"<");
        return getAve()-o.getAve();
    }

    public static void sortor(ArrayList<saveableStudent> input){
        //        Collections.sort(result);
        input.sort(new Comparator<saveableStudent>(){
            public int compare(saveableStudent o1, saveableStudent o2){
                return o1.getAve()- o2.getAve();
            }
        });
    }
}

