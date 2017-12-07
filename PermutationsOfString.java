
//Program to print all permutations of a string using recursion

public class PermutationsOfString {
    static String str1 = "Two";

    public static void main(String[] args) {

        printPermutations("", str1);
    }

    private static void printPermutations(String prefix, String str1) {
        int n = str1.length();
        if (n == 0)
            System.out.println(prefix);

        else {
            for (int i = 0; i < str1.length(); i++) {
                //increase prefix one by one
                printPermutations(prefix + str1.charAt(i), str1.substring(0, i) + str1.substring(i + 1, n));
            }
        }
    }
}
