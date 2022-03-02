package test.test07;

public class ThreadTogether {
    public static void main(String[] args) {
        Thread th1 = new myThreader01();
        Thread th2 = new Thread(new myThreader02());
        th1.start();
        th2.start();
    }

//        Thread[] threads = new Thread[3];
//        for (Thread i: threads) {
//            i=new Thread(new ThreadDemo());
//            i.start();
//        }
//        try{
//            Thread.sleep(5000);
//            System.out.println("start question2!");
//        }catch(InterruptedException e){
//            e.printStackTrace();
//        }
//    }


    class ThreadDemo implements Runnable {
        @Override
        public void run() {
            int timeout = (int) (100 * Math.random() + 1000);
            System.out.println("createThread: " + timeout);
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end:　" + timeout);
        }
    }
}
