// Java program to print largest contiguous array sum
public class LargestContinousSum{

    static int[] array = new int[] {-2, -3, 4, -1, -2, 1, 5, -3};

    public static void main(String[] args){
        sum(array);
    }

    static void sum(int[] array)
    {
        int currentSum = 0;
        int maxSum = 0;
        for(int i=0;i<array.length;i++){
            currentSum = Math.max(currentSum + array[i], array[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        System.out.print(maxSum);
    }
}