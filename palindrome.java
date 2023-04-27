import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class palindrome {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(String s) {
        String res  = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int left = 0;
        int right = res.length() - 1;

        while (left < right) {
            if (res.charAt(left) != res.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}