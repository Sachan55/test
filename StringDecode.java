import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringDecode {
    public String encode(List<String> strs) {
        // write your code here
        StringBuilder encoded = new StringBuilder();
        for(String s: strs){
            encoded.append(s.length()).append("#").append(s);
        }
        return encoded.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here
        List<String> answer = new ArrayList<>();
        int i = 0;
        while( i < str.length()){
            int j = i;
            if(str.charAt(j) != '#'){
                j++;
            }
            int length = Integer.valueOf(str.substring(i,j));
            System.out.println(i + " " + j + " " + length + " " + str.substring(i,j));
            i = j + 1 + length;
            answer.add(str.substring(j+1,i));
        }

        return answer;
    }

    public static void main(String[] args) {
         StringDecode st = new StringDecode();
         System.out.println(st.encode(Arrays.asList("lint","code","4#","you")));
         System.out.println(st.decode("4#lint4#code2#4#3#you"));
    }
}
