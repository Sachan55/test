import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.*;

import java.lang.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import static java.util.stream.Stream.generate;

import static java.util.stream.Stream.generate;

public class ArrayListUses {
        public static void main(String[] args) {

            ArrayList<Integer> a  = new ArrayList<>();
            a.add(1);
            a.add(2);
            a.add(3);

            System.out.println("=======Arraylist===========");
            for (int number : a
            ) {
                System.out.println(number);
            }

            a.remove(a.size()-1);

            System.out.println("-------");

            for(int i = 0 ; i < a.size() ; i++){
                System.out.println(a.get(i));
            }


            System.out.println("=======Arraylist<Arraylist>===========");
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            adj.add(a);
            adj.add(a);

            for(int i = 0 ; i < adj.get(0).size() ; i++){
                for(int j = 0 ; j < adj.size() ; j++){
                    System.out.print(adj.get(i).get(j) + " ");
                }
                System.out.println();
            }


            System.out.println("=======Array of <Arraylist>===========");
            ArrayList<Integer> adl [] = new ArrayList[2];

            adl[0] = a;
            adl[1] = a;

            System.out.println(adl.length);

            for(int i = 0; i < adl.length ; i++){
                for(int j = 0; j < adl[i].size(); j++){
                    System.out.print(adl[i].get(j) + " ");
                }
                System.out.println();
            }

//          System.out.println(a);


            System.out.println("=======queue===========");
            Queue<Integer> q = new LinkedList<>();
            q.add(1);
            q.add(2);
            q.add(3);

            while(!q.isEmpty()){
                System.out.println(q.peek());
                q.poll();
            }

            System.out.println("=======stack===========");

            Stack<Integer> st = new Stack<>();
            st.add(1);
            st.add(2);
            st.add(3);

            while (!st.empty()){
                System.out.println(st.peek());
                st.pop();
            }


            System.out.println("=======2d array===========");

            int [][] arr = new int [5][5];

            print2dArray printing = new print2dArray();
            printing.print(arr);


            System.out.println("=======dequeue===========");

            Deque<pair> d = new ArrayDeque<>();

            d.offerFirst(new pair(1,2,3));
            d.offerFirst(new pair(2,3,4));
            System.out.println(d.pollFirst().color);


            System.out.println("=======array sorting===========");

            int[] b  = new int[]{1, 4, 2};
            ArrayList<Integer> c = new ArrayList<>();
            c.add(1);
            c.add(6);
            c.add(3);

            Collections.sort(c);

            System.out.println(c);

            Arrays.sort(b);

            for(int i = 0; i < b.length ; i++){
                System.out.print(b[i] + " ");
            }

            System.out.println();

            System.out.println("====== sorting using custom comprator ===========");

            ArrayList<pair> e = new ArrayList<>();

            e.add(new pair(1,2,3));
            e.add(new pair(4,5,6));
            e.add(new pair(5,6,7));

            // Collections.sort(e , new pairComp());

            e.sort(( o1,  o2)-> {
                if(o1.color > 0){
                    System.out.println(o1.color);
                }
                return o2.color-o1.color;
            });

            for(int i = 0; i < e.size();i++ ){
                System.out.println(e.get(i).color);
            }


            System.out.println("====== best way to generate a string ===========");


            String firstChar = "B";
            AtomicBoolean even = new AtomicBoolean(true);
            String Zeros = generate(() -> {
                if(even.get()){
                    even.set(false);
                    return "1";
                }
                even.set(true);
                return "0";
            }).limit(7).collect(Collectors.joining());
            System.out.println(firstChar + Zeros + Integer.toString(5));


        }

}
