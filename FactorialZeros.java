//Program to Count trailing zeros in factorial of a number

import java.util.Scanner;

public class FactorialZeros {
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(count(n));
    }

    private static int count(int n) {
        int sum = 0;
        for(int i = 5;n/i>=1; i=i*5){
            sum = sum+n/i;
        }
        return sum;
    }
}
