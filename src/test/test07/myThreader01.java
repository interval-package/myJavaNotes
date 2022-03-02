package test.test07;

import java.util.Random;
import java.util.ArrayList;

public class myThreader01 extends Thread{
    private final ArrayList<Integer> Prime;
    {Prime = new ArrayList<Integer>();}

    private final Random random = new Random(System.currentTimeMillis());

    public void run() {
        System.out.println("Creating a Thread_01!");
        getPrimers(100);
        try{
            Thread.sleep(getRandom(100,500));
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public void getPrimers(int counts){
        for(int i = 1;i<=counts;i++) {
            if(isPrime(i)){
                Prime.add(i);
                System.out.println("prime: "+i);
            }
        }
    }

    private int getRandom(int min, int max){
        return random.nextInt(max-min)+min;
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

    public void showPrimers(){
        System.out.println("primes are"+this.Prime.toString());
    }
}
