import java.util.Scanner;

//Rotate an array to the right by k steps
public class RotateArray {

    static int[] array = {6, 9, 1, 4, 0, 2, 8, 15, 76, 32, 89, 27};
    static int[] rotatedArray = {76, 32, 89, 27, 6, 9, 1, 4, 0, 2, 8, 15};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        //  rotate(k);
        System.out.print(search(k));
    }

    private static void rotate(int k) {
        if (array == null || array.length == 0 || k < 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }

        int diff = array.length - k;
        swap(array, diff, array.length - 1);
        swap(array, 0, diff - 1);
        swap(array, 0, array.length - 1);
        for (int i : array) {
            System.out.print(i + " ,");
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = 0;
        if (a == null || a.length == 1)
            return;

        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }

    private static int search(int k) {
        int left = 0;
        int right = rotatedArray.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (rotatedArray[mid] == k) return mid;
            if (rotatedArray[left] < rotatedArray[mid]) {
                if (rotatedArray[left] <= k && k < rotatedArray[mid]){
                    right = mid - 1;}
                else left = mid + 1;
            }
            else {
                if (rotatedArray[mid] < k && k <= rotatedArray[right]) {
                    left = mid + 1;
                } else right = mid - 1;
            }
        }
        return -1;
    }
}