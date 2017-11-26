
/*
 Program that segregates 0's, 1's and 2's in an array

*/

import java.util.Scanner;

public class DutchFlag {
    private static int[] array = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
    public static void main(String[] args){

        arrange();
    }

    private static void arrange() {
        int lo = 0;
        int hi = array.length - 1;
        int mid = 0,temp=0;
        while (mid <= hi)
        {
            switch (array[mid])
            {
                case 0:
                {
                    temp   =  array[lo];
                    array[lo]  = array[mid];
                    array[mid] = temp;
                    lo++;
                    mid++;
                    break;
                }
                case 1:
                    mid++;
                    break;
                case 2:
                {
                    temp = array[mid];
                    array[mid] = array[hi];
                    array[hi] = temp;
                    hi--;
                    break;
                }
            }
        }
        for (int i:array) {
            System.out.print(i);
        }

        }
}
