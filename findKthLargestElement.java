import java.util.Comparator;
import java.util.PriorityQueue;

public class findKthLargestElement {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });

            for(int num: nums){
                pq.add(num);
            }

            while(!pq.isEmpty() && k > 0){
                pq.poll();
            }

            return !pq.isEmpty() ? pq.peek() : -1;
        }
}
