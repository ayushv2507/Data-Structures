//If we were only permitted to complete at most one transaction

//TODO figure out how to return indexes as well

public class MaxProfit {

    // stock prices on consecutive days
    static int price[] = {7, 1, 5, 3, 6, 4};
    public static void main(String args[])
    {
        maxProfit(price);
    }

    static void maxProfit(int[] array){
        int minPrice = array[0];
        int maxprofit = 0;
        for(int i=0;i<array.length;i++){
            maxprofit = Math.max(maxprofit, array[i]-minPrice);
            minPrice = Math.min(minPrice, array[i]);
        }

        System.out.print(maxprofit);
    }
}
