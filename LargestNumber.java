import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*Given a list of non negative integers, arrange them such that they form the largest number.
For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.


To construct the largest number, we want to ensure that the most significant digits are occupied by the largest digits.
First, we convert each integer to a string. Then, we sort the array of strings
for each pairwise comparison during the sort, we compare the numbers achieved by concatenating the pair in both orders.
*/
public class LargestNumber {

    private static int[] array = {6, 9, 1, 4, 0, 2, 8};

    public static void main(String[] args) {
        System.out.print(largestNumber(array));
    }

    private static class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }

    public static String largestNumber(int[] nums) {
        // Get input integers as strings.
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // Sort strings according to custom comparator.
        Arrays.sort(asStrs, new LargerNumberComparator());

        // If, after being sorted, the largest number is `0`, the entire number
        // is zero.
        if (asStrs[0].equals("0")) {
            return "0";
        }

        // Build largest number from sorted array.
        StringBuilder largestNumberStr = new StringBuilder();
        for (String numAsStr : asStrs) {
            largestNumberStr.append(numAsStr);
        }

        return largestNumberStr.toString();
    }
}
