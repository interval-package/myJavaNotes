package test.test07;

import java.util.ArrayList;
import java.util.Random;

public class myThreader02 implements Runnable{
    private final ArrayList<Integer> Prime;
    {Prime = new ArrayList<Integer>();}

    private final Random random = new Random(System.currentTimeMillis());

    private int getRandom(int min, int max){
        return random.nextInt(max-min)+min;
    }

    @Override
    public void run() {
        System.out.println("Runnable Thread!");
        for(int i=1;i<=100;i++){
            if(i%3==0){
                System.out.println("it % 3==0! : "+i);
            }
        }
        try{
            Thread.sleep(getRandom(100,500));
        }catch(InterruptedException e){
            e.printStackTrace();
        }
//        进行sleep操作时必须要进行异常的处理
    }
}
