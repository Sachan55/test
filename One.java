import javafx.util.Pair;

import java.sql.Array;
import java.sql.PseudoColumnUsage;
import java.util.*;

public class One {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public boolean containsDuplicate(int[] nums) {
       // Map<Integer,Integer>  mp = new HashMap<>();
        HashSet<Integer> mp = new HashSet<>();
        for(int num : nums){
            if(mp.contains(num)){
                return false;
            }
            mp.add(num);
        }
        return false;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String ,List<String>> mp = new HashMap<>();
        for(String s: strs){
            char[] curr = s.toCharArray();
            Arrays.sort(curr);
            String sortedString = new String(curr);
            mp.computeIfAbsent(sortedString, k-> new ArrayList<>()).add(s);
        }
        for(Map.Entry<String, List<String>> entry: mp.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }

    public int[] topKFrequent(int[] nums, int s) {
        Map<Integer,Integer> mp = new HashMap<>();

        for(int num: nums){
            mp.compute(num , (k, v) -> v == null ? 1 : v + 1);
        }
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.getKey() - o2.getKey();
            }
        });

        for(Map.Entry<Integer,Integer> entry: mp.entrySet()){
            pq.add(new Pair<>(entry.getValue(),entry.getKey()));
        }
        int ans[] = new int[s];
        int i = 0;
        while(!pq.isEmpty() && i < s) {
            ans[i] = (pq.poll().getValue());
            i++;
        }
        return ans;
    }


    public static int lengthOfLongestSubstring(String s) {
        Deque<Character> window = new LinkedList<>();
        HashSet<Character> hash = new HashSet<Character>();
        int ans = 0;
        for(int i = 0; i < s.length() ; i++){
            if(hash.contains(s.charAt(i))){
                while(!window.isEmpty() && window.peekFirst() != s.charAt(i)){
                    hash.remove(window.peekFirst());
                    window.pollFirst();
                }
                if(!window.isEmpty())
                    window.pollFirst();
                window.offerFirst(s.charAt(i));
            }else{
                hash.add(s.charAt(i));
                window.offerLast(s.charAt(i));
            }
            ans = Math.max(window.size(),ans);
        }

        return ans;
    }

    public int longestConsecutive(int[] nums) {

        Map<Integer,Integer> mp = new HashMap<>();
        int i = 0;
        while(i < nums.length)
        {
            mp.put(nums[i],1);
            i++;
        }
        i = 0;
        int ans = 0;
        while(i < nums.length)
        {
            if(mp.get(nums[i]) != 0)
            {
                int temp = nums[i]+1;
                int count = 1;
                while(mp.containsKey(temp))
                {
                    mp.put(temp,0);
                    count++;
                    temp = temp+1;
                }
                temp = nums[i]-1;
                while(mp.containsKey(temp))
                {
                    mp.put(temp,0);
                    count++;
                    temp = temp - 1;
                }
                mp.put(nums[i],count);
                ans = Math.max(ans,count);
            }
            i++;
        }
        return ans;
    }

    public int characterReplacement(String s, int k) {
        ArrayList<Character> window = new ArrayList<>();
        int count = 0;
        int ans = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char curr = s.charAt(i);
            if(window.contains(curr)){
                window.add(curr);
            }else{
                if(count  < k){
                    window.add(curr);
                    count++;
                }else{
                    char front = window.get(0);
                    int index = window.lastIndexOf(front);
                    window.remove(index);
                    if(index > 0){
                        window.subList(0,index).clear();
                    }
                    window.add(curr);
                }
            }
            ans = Math.max(ans,window.size());
        }
        return ans;
    }


    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length;
        if(nums[start] < nums[end]){
            return nums[start];
        }
        while(start < end){
            int mid = (start + end)/2;
            if(mid!= 0 && mid != nums.length-1 && nums[mid] < nums[mid-1] && nums[mid] > nums[mid+1]){
                return nums[mid];
            }
            if(nums[mid] < nums[start]){
                end = mid;
            }else{
                start = mid;
            }
        }
        return -1;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return (o2.val - o1.val);
            }
        });

        for (ListNode nodes : lists) {
            ListNode current = nodes;
            while (current != null) {
                minHeap.add(current);
                current = current.next;
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!minHeap.isEmpty()) {
            current.next = minHeap.poll();
            current = current.next;
        }

        return dummy.next;
    }

    public  boolean dfs(char[][] board , int i , int j , String word , int index){
        if(index == word.length())
        if(i < 0 || i >= board.length || j < 0 || j > board[0].length){
            return false;
        }
        if(board[i][j] == word.charAt(index)){
            if(dfs(board,i,j+1,word,index+1) || dfs(board,i+1,j,word,index+1) || dfs(board,i,j-1,word,index+1) || dfs(board,i-1,j,word,index+1)){
                return true;
            }
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int [][] visited = new int[board.length][board[0].length];
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0; j < board[0].length ; j++){
                if(board[i][j] == word.charAt(0) && dfs(board,i,j,word,0) == true){
                    return true;
                }
            }
        }
        return false;
    }

    //public void bac
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        return ans;
    }

}
