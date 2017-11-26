import java.util.*;

//Program to find  if String S1 is a substring of String S2
public class MultiString {
    static String str1 = "", str2 = "";

    public static void main(String[] args){
      // isSubStringFun(str1,str2);
      // isRotation();
      // isUnique(str2);
      // isPalindrome(str2);
        // find1stRepeating(str2);
     //   find1stNonRepeating(str2);
        //anagram(str1,str2);
        System.out.print(oneEditApart(str1,str2));
    }

    private static boolean isSubStringFun(String str1, String str2) {
        boolean isSubString = false;
        int i ,j;
        char[] s1= str1.toCharArray();
        char[] s2= str2.toCharArray();
        int l1 = s1.length;
        int l2= s2.length;
        for(i = 0, j=0;i<l2 && j<l1;i++){
            if(s1[j] == s2[i])  //imp
                j++;
        }
        if(j==l1)   isSubString = true;
       // System.out.print(isSubString);
        return isSubString;
    }

    private static boolean isRotation() {
        String str1 = "lohel", str2 = "hello";
        String str3 = str2+str2;
        return isSubStringFun(str1,str3);
    }

    private static boolean isUnique(String s) {

        Set<Character> set = new HashSet<>();
        char[] array = s.toCharArray();
        for (char c:array) {
            if(!set.add(c)){
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindrome(String s) {

        char[] array = s.toCharArray();
        int i = 0;
        int j = array.length-1;
        while(i<=j){
            if(array[i]==array[j]) {
                i++;
                j--;
            }
            else return false;
        }
        return true;
    }

    private static char find1stNonRepeating(String s) {
        char[] array = s.toCharArray();
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for (Character c: array) {
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }
            else map.put(c, 1);
        }
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() == 1)
                return e.getKey();

        }

        return 0;
        }

    private static char find1stRepeating(String s) {
        char[] array = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c: array) {
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }
            else map.put(c, 1);
        }
        for (char c : array) {
            if (map.get(c) > 1)
                return c;
        }

        return 0;
    }

    private static boolean anagram(String str1, String str2) {
        if(Math.abs(str1.length() - str2.length())>1) return false;
        HashMap<Character,Integer> map = new HashMap<>();
        char[] array1 = str1.toCharArray();
        char[] array2 = str2.toCharArray();
        for (Character c:array1) {
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }
            else map.put(c, 1);
        }
        for (Character c:array2) {
            if(map.containsKey(c)){
                map.put(c, map.get(c)-1);
            }
            else return false;
        }
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() == 1)
                return false;

        }
        return true;
    }

    private static boolean oneEditApart(String str1, String str2) {
        if(Math.abs(str1.length() - str2.length())>=2) return false;
        int i=0 ,j=0,count =0;
        char[] s1= str1.toCharArray();
        char[] s2= str2.toCharArray();
        int l1 = s1.length;
        int l2= s2.length;
        while(i<l1 && j<l2){
            if(s1[i] == s2[j]){
                i++;
                j++;
            }
            else{
                count++;
                if(count>1)
                    return false;
                if(l1>l2)
                i++;
                else if(l2>l1)
                j++;
                else{
                    i++;
                    j++;
                }
            }
        }
        if(i<l1||j<l2){
            count++;
        }
        return count == 1;
    }
}
