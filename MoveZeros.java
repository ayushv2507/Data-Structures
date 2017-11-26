//Moves zeros to the end of the array

public class MoveZeros {

    static int[] array = new int[]{2,1,3,76,0,1,5,9,0,4,0,0,0,1,3,8};

    public static void main(String[] args){
        moveZeros(array);
    }

    static void moveZeros(int[] a){
        int i=0, temp=0;
        int j = a.length-1;
        while(i<=j){

            while(a[i] != 0)
                i++;
            while(a[j] == 0)
                j--;
            if(i<j){
                temp = a[i];
                a[i]= a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        for (int x:a) {
            System.out.println(x);
        }
    }

}
