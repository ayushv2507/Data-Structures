//Program to find LCM and GCD of two numbers

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Scanner;

public class LCM {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int gcd = GCD(a,b);
        int lcm = lcm(a,b);
        System.out.print("GCD : "+ gcd+ " LCM: "+lcm);


    }

    private static int lcm(int a, int b) {
        return (a*b/GCD(a,b));
    }

    private static int GCD(int a, int b) {
        if(b==0) return a;
        return GCD(b,a%b);
    }


}
