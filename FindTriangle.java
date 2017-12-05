/*
Find at least one triplet from given integers that form a triangle.
 */

import java.util.Arrays;
import java.util.Scanner;

public class FindTriangle {
    static int[] array = {6, 9, 1, 4, 0, 2, 8, 15, 76, 32, 89, 27};

    public static void main(String[] args) {

        System.out.print(triangleTripletExists(array));
    }

    public static boolean triangleTripletExists(int[] arr) {
        Arrays.sort(arr);

        int i, j, k;

        i = 0;
        j = 1;
        k = 2;

        for (k = 2; k < arr.length; k++) {

            if (isTriplet(arr[i++], arr[j++], arr[k])) {

                return true;
            }
        }

        return false;

    }

    public static boolean isTriplet(int a, int b, int c) {

        boolean first, second, third;

        first = ((a + b) > c);
        second = ((a + c) > b);
        third = ((c + b) > a);

        return (first && second && third);
    }

}
