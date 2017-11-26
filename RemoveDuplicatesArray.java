import java.util.HashSet;
import java.util.Iterator;

public class RemoveDuplicatesArray {
    private static int[] array = {3, 1, 1, 0, 1, 2, 1, 6, 0, 0, 0, 1};
    public static void main(String[] args){

        remove();
    }

    private static void remove() {
        HashSet<Integer> map = new HashSet<>();
        for (Integer n:array) {
            if(map.contains(n)){
            }
            else map.add(n);
        }

        for (Integer aMap : map) {
            System.out.print(aMap);
        }
    }
}
