import java.util.HashSet;
import java.util.Scanner;

public class Find1stRepeatedArray {
    private static int[] array =  {5,3,3,3,3,3,3,3,4,4,4,5,3}
    ;
    public static void main(String[] args){

        Find1stRepeated();
    }

    private static void Find1stRepeated() {
        int minIndex=array.length-1;
        HashSet<Integer> set = new HashSet<>();
        for(int i = array.length-1; i>=0;i--){
            if(!set.contains(array[i])){
                set.add(array[i]);
            }
            else minIndex = i;
        }
        System.out.print(array[minIndex]);
    }
}
