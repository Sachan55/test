import java.security.cert.CertPathValidatorException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class printer implements Runnable{
    static int count  = 1;
    int reminder;

    static Object  lock = new Object();

    printer(int value){
        this.reminder = value;
    }
    void Printer(){
        System.out.println(Thread.currentThread().getName() + " " + count++);
    }

    @Override
    public void run() {
        for(int i = 1; i <= 10 ; i++) {
            synchronized (lock) {
                while (count % 2 != reminder) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                Printer();
                lock.notify();
            }
        }
    }
}
public class main {
    Queue<Integer> q1 = new LinkedList<>();
    public static void main(String[] args) {
//        Queue<Integer> q = new LinkedList<>();
//        Thread t1 = new Thread(() -> {
//                while (true) {
//                    System.out.println("produced: " + q.size());
//                    q.add(1);
//                }
//        });
//        Thread t2 = new Thread(()->{
//            while(true) {
//                System.out.println("consumed: " + q.size());
//                q.poll();
//            }
//        });

//        System.out.println(Integer.toString(1));
//
//        StringBuilder st = new StringBuilder("abc");
//        System.out.println(st);
//
//        int [] arr = {1,2,3};
//        List<String> l = new ArrayList<>(Arrays.asList("eaebc","def"));
//        Collections.sort(l, (s1,s2)->{
//            return s2.compareTo(s1);
//        });
//        System.out.println(l);
//        ArrayList<Integer> ar = new ArrayList<>(Arrays.asList(1,2,3));
//
//        Collections.sort(ar, (a,b)->{
//            return b-a;
//        });
//        System.out.println(ar);

//       SortedMap<Integer,List<Integer>> mp = new TreeMap<>();
//
//        mp.put(1,new ArrayList<>(Arrays.asList(5)));
//        mp.put(4,new ArrayList<>(Arrays.asList(5)));
//        mp.put(2,new ArrayList<>(Arrays.asList(5)));
//        mp.put(3,new ArrayList<>(Arrays.asList(5)));
//
//        for(int a: mp.keySet()){
//            mp.computeIfAbsent(a, k -> new ArrayList<>()).add(5);
//        }
//
////        t1.start();
////        t2.start();
//        Object key = new Object();
//        printer evn = new printer(0);
//        printer odd = new printer(1);
//        Thread even = new Thread(evn, "even");
//        Thread odds = new Thread(odd, "odd");
//
//        even.start();
//        odds.start();

//        String s = "abcd";
//        System.out.println(s.substring(0,1)+"b"+s.substring(1));
//
//        List<Integer> st = new LinkedList<>();
//        st.add(1);
//        st.add(2);
//        st.add(3);
//
//        st.remove(st.size()-1);
//        for(int x: st){
//            System.out.println(x);
//        }
//
//        Map<String,Integer> hs = new ConcurrentHashMap<>();

        boolean visited[][] = new boolean[3][3];
        for(int i = 0 ; i < visited.length ; i++)
            Arrays.fill(visited[i],true);

        for(int i = 0 ; i < visited.length ; i++){
            for(int j =0; j < visited[0].length ; j++){
                System.out.print(visited[i][j]);
            }
            System.out.println();
        }


    }
}