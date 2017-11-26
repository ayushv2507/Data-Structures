//Program to Find the kth largest element in an unsorted array

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthLargestInArray {

    static int[] array = {6,9,1,4,0,2,8,15,76,32,89,27};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(findKth(n));
    }

    private static int findKth(int n) {
        //Method 1
        /*Arrays.sort(array);
        if(n<array.length)
        return array[array.length-n];
        else
        return 0;
        */
        //Method 2
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i: array) {
                pq.offer(i);
                if(pq.size()>n)
                    pq.poll();

        }
        return pq.peek();
    }
}
