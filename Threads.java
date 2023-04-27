public class Threads {
    //        Runnable runnable = new Runnable() {
//            String lock = "";
//            public void prepareFood(){
//                synchronized (lock) {
//                    System.out.println("Food preparation started");
//                    System.out.println(Thread.currentThread().getName());
//                    try {
//                        Thread.sleep(300);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    System.out.println("Food preparation done");
//                }
//            }
//
//
//            @Override
//            public void run() {
//                System.out.println("Order taken " + Thread.currentThread().getName());
//                prepareFood();
//            }
//        };
//
//            Thread t1= new Thread(runnable);
//            Thread t2 = new Thread(runnable);
//            t1.start();
//            t2.start();
//        Producer pd = new Producer();
//        Thread t1 = new Thread(pd);
//        t1.start();
//
//        Producer pd2 = new Producer();
//        Thread t2 = new Thread(pd2);
//        t2.start();

}
