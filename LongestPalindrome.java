//Program to find length of the Longest Palindrome from a given string

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    private static String s = "abccccdd";

    public static void main(String[] args) {

        System.out.print(length(s));

    }

    private static int length(String s) {
        int result = 0;
        boolean singlechar = false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {

            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else map.put(s.charAt(i), 1);
        }
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() % 2 == 0) {
                result = result + e.getValue();
            } else if (e.getValue() == 1 && !singlechar) {
                result++;
                singlechar = true;
            } else result = result + e.getValue() - 1;
        }
        return result;
    }
}
