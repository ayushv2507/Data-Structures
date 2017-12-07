import java.util.Random;

// Java Program to shuffle a given array in place
public class ShuffleArray {

    private static int[] array = {5, 38, 36, 43, 3, 31, 30, 32, 41, 43, 45, 50, 39};

    public static void main(String[] args) {
        shuffle();
    }

    private static void shuffle() {
        Random random = new Random();
        // Start from the last element and swap one by one
        for (int i = array.length - 1; i > 0; i--) {

            // Pick a random index from 0 to i
            int j = random.nextInt(i);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        for (int i : array) {
            System.out.print(i + ",");
        }
    }
}
