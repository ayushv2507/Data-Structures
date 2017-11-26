import java.util.Scanner;

public class RomanToInteger {
    static char[] array = {'M','C', 'M', 'I', 'V'};
    public static void main(String[] args){

        convert(array);
    }

    private static void convert(char[] array) {
        int result = 0;
        for(int i=0;i<array.length-1;i++){
            if(value(array[i]) > value(array[i+1])){
                result = result + value(array[i]);

            } else {
                result = result + (value(array[i + 1]) - value(array[i]));
                i++;
            }
        }
        System.out.print(result);
    }

    // Helper function that returns value of a Roman symbol
    static int value(char r)
    {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }
}
