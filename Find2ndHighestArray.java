public class Find2ndHighestArray {

    private static int[] array = {6,79,1,4,0,2,8,15,76,32,89,27};

    public static void main(String[] args){
       find();

    }

    private static void find() {
        int max1 = array[0], max2 = array[1];
        for(int i =0; i<array.length-1;i++){

            if(array[i]>max1){
                max2 = max1;
                max1 = array[i];

            }
            else if(array[i]>max2){
                max2 = array[i];
            }
        }
        System.out.print(max2);
    }
}
