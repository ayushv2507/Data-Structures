import java.util.Scanner;

//Program to find Pow(x,y)
//Using recursion with memoization
public class Pow {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.print(POWER(a,b));
    }

    private static int POWER(int a, int b) {
        int temp;
        if(b==0|| b==1) return a;
        if (a==0 || a==1) return a;
         temp = POWER(a,(b/2));
        if(b%2 == 0) {
            return temp * temp;
        } else {
            if (b > 0)
                return a * temp * temp;
            else return (temp * temp) / a;
        }
    }
}
