import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class StringMatching {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> mp = new HashMap<>();
        for(int i = 0; i < s1.length() ; i++){
            mp.compute(s1.charAt(i) , (k,v) -> v == null ? 1 : v+1);
        }
        int ans = 0;
        int left = 0;
        for(int i = 0 ; i < s2.length() ; i++) {
            if (mp.containsKey(s2.charAt(i))) {
                if (mp.get(s2.charAt(i)) > 0) {
                    mp.compute(s2.charAt(i), (k, v) -> v - 1);
                }
            }
            while(isEmpty(mp) && left <= i){
                left++;
                if(mp.containsKey(s2.charAt(left))) {
                    mp.compute(s2.charAt(left), (k, v) -> v + 1);
                }
            }

            ans = Math.min(ans,(i-left));
        }
        return true;
    }

    private boolean isEmpty(Map<Character, Integer> mp) {
        for(Map.Entry<Character,Integer> entry : mp.entrySet()){
            if(entry.getValue() != 0){
                return false;
            }
        }
        return true;
    }

}
