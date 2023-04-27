import java.awt.geom.Point2D;
import java.util.*;

class Anagram {
    public static void main(String[] args) {
        System.out.println(Anagram.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>>  ans  = new ArrayList<>();
        Map<String,List<String>> hashmap = new HashMap<>();
        for(String s: strs){
            char[] str = s.toCharArray();
            Arrays.sort(str);
            String sortedStr = new String(str);
            hashmap.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(s);
        }

        for(Map.Entry<String,List<String>> entry : hashmap.entrySet()){
            System.out.println(entry.getKey() + " " +entry.getValue());
        }

        System.out.println(hashmap.values());
        for (List<String> list: hashmap.values()
             ) {
            ans.add(list);
        }
        return ans;
    }
}