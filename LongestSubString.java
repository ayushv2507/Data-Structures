////Program to find length of the Longest substring without repeating characters from a given string

import java.util.LinkedHashMap;

public class LongestSubString {
    private static String s = "Java Concept Of The Day";

    public static void main(String[] args) {

        System.out.print(length(s));

    }

    private static int length(String s) {
        s = s.trim();
        int max = 0;
        String longestSubString = "";
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            } else {
                i = map.get(s.charAt(i));
                map.clear();
            }
            if (map.size() > max) {
                max = map.size();
                longestSubString = map.keySet().toString();
            }
        }
        System.out.print(longestSubString);
        return max;
    }
}
