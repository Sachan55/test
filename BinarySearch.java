import javafx.util.Pair;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    public String search(List<Pair<String, Integer>> list, int timestamp) {
            int start = 0;
            int end = list.size() -1;
            while (start <= end){
                int mid = (start + end)/2;
                if(list.get(mid).getValue() == timestamp){
                    return list.get(mid).getKey();
                }
                if(list.get(mid).getValue() < timestamp){
                    start = mid;
                }else{
                    end = mid - 1;
                }
            }

            if(list.get(start).getValue() > timestamp){
                return "";
            }

            return list.get(start).getKey();
    }

    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end)/2;
            if(nums[start] > nums[end]){
                 return start;
            }
            if(nums[mid] > nums[start]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start;
    }

    public int binarySearch(int[] nums, int target, int start , int end) {
            while (start <= end){
                int mid = (start + end)/2;
                if(nums[mid] == target){
                    return mid;
                }
                if(nums[mid] > target){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
            return -1;
    }
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int pivot = -1;
        while(start <= end){
            int mid = (start + end)/2;
            if(nums[start] > nums[end]){
                pivot = start;
                break;
            }
            if(nums[mid] >= nums[start]){
                start = mid + 1;
            }else{
                end = mid;
            }
        }

        if(pivot == 0)
            return binarySearch(nums,0,nums.length-1,target);
        if(target >= nums[0] && target <= nums[pivot-1]){
            return binarySearch(nums,0,pivot-1,target);
        }else{
            return binarySearch(nums,pivot,nums.length-1,target);
        }
    }
}
