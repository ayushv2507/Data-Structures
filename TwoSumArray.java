import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class TwoSumArray {

    private static int[] array = {6,9,1,4,0,2,8,15,76,32,89,27};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        findTwoSum(k);
    }

    private static void findTwoSum(int k) {
        //Using sorting

        //Returns closest sum to the target
        Arrays.sort(array);
        int i = 0;
        int j = array.length-1;
        int result =0;
        int min = Integer.MAX_VALUE;
        while(i<j){
            int sum =array[i]+array[j];
            int diff = Math.abs(k-sum);
            if(diff ==0){
                System.out.print("Exists "+k);
                return;
            }
            if(diff<min){
                min = diff;
                result = sum;
            }

            if(sum>k){
                j--;
            }
            else {
                i++;
            }
        }
        System.out.print(result);

        //Using hashmap

       /* HashSet<Integer> map = new HashSet<>();
        for (Integer n:array) {
            if(map.contains(k-n)){
                System.out.print("Exists");
                return;
            }
            else map.add(n);
        }
        System.out.print("Does not exist");*/
    }

}
