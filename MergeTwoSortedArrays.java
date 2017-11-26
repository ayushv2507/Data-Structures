
//Program to merge two sorted arrays.
//Also to find if pair of elements exists such that swapping them will make sum of the two arrays same

import java.util.Arrays;

public class MergeTwoSortedArrays {
    static int[] array1 = {4, 1, 2, 5, 1, 2};
    static int[] array2 = {3, 6, 3, 3};
    public static void main(String[] args) {
    //    merge();
        find();
    }

    private static void merge() {

        int l1,l2, i =0, j =0, k =0;
        l1 = array1.length;
        l2 = array2.length;
        int[] result = new int[l1+l2];
        while(i<l1 && j<l2){
            if(array1[i]>array2[j]){
                result[k]= array2[j];
                j++;
            }
            else{
                result[k]= array1[i];
                i++;
            }
            k++;
        }

        while (i<l1){
            result[k] = array1[i];
            i++;
            k++;
        }
        while (j<l2) {
            result[k] = array2[j];
            j++;
            k++;
        }
        for (int a:result) {
            System.out.print(a+" ,");

        }
    }

    private static void find() {
        int a=0, b=0, target;
        int sum1 =0, sum2= 0;

        for ( int i:array1) {
            sum1 += i;
        }
        for ( int j:array2) {
            sum2 += j;
        }

        Arrays.sort(array1);
        Arrays.sort(array2);

        target = (sum1-sum2)/2;

        while (a<array1.length &&b<array2.length){
            int diff = array1[a]-array2[b];
            if(diff == target) {
                System.out.print("Found");
                return;
            }
            // Look for a greater value in array1
            if(diff<target) a++;

            // Look for a greater value in array2
            else b++;
        }
    }

}
