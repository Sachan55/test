import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TwoSum {
        public int[] twoSums(int[] nums, int target) {
            int ans[] = new int[2];
            Map<Integer, Integer> hash = new TreeMap<>();
            for(int i = 0; i < nums.length; i++){
                int num = nums[i];
                int counterPart = target - num;
                print(hash);
                if(hash.containsKey(counterPart)){
                    ans[0] = hash.get(counterPart);
                    ans[1] = i;
                    return ans;
                }
                hash.put(num,i);
            }
            return ans;
        }

        public int[] twoSum(int[] numbers, int target) {
            int ans[] = new int[2];
            int i = 0;
            int j = numbers.length-1;
            while(i < j){
                if(numbers[i] + numbers[j] == target){
                    ans[0] = i+1;
                    ans[1] = j+1;
                    return ans;
                }else if (numbers[i] + numbers[j] > target){
                    j--;
                }else{
                    i++;
                }
            }
            return ans;
        }

    private void print(Map<Integer, Integer> hash) {
           for (Map.Entry<Integer,Integer> entry: hash.entrySet()){
               System.out.println(entry.getKey() + " " + entry.getValue());
           }
           System.out.println("==========================");
    }
}
