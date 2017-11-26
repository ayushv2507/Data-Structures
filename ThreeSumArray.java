import java.util.Arrays;
import java.util.Scanner;

public class ThreeSumArray {


    static int[] array = {6, 9, 1, 4, 0, 2, 8, 15, 76, 32, 89, 27};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
       // findThreeSum(n);
        findThreeSumClosest(n);
    }

    private static void findThreeSum(int n) {
        //Using sorting
        Arrays.sort(array);

        for(int k =0;k<array.length-1;k++) {
            int i = k+1;
            int j = array.length-1;
            while (i < j) {
                if ((array[i] + array[j] + array[k] == n)) {
                    System.out.print("Exists");
                    return;
                } else if ((array[i] + array[j] + array[k] > n)) {
                    j--;
                } else i++;

            }
        }
        System.out.print("Does not exist");
    }


    private static void findThreeSumClosest(int n) {

        //Using sorting
        Arrays.sort(array);
        int min = Integer.MAX_VALUE;
        int result = 0;

        for(int k =0;k<array.length-1;k++) {
            int i = k+1;
            int j = array.length-1;
            while (i < j) {
                int sum = array[i] + array[j] + array[k];
                int diff = Math.abs(n-sum);
                if(diff<min){
                    min = diff;
                    result = sum;
                }
                if (sum == n) {
                    System.out.print("Exists");
                    return;
                }

                 if (sum> n) {
                    j--;
                } else i++;

            }
        }
        System.out.print(result);
    }

}

