public class isNumber {

    static String s = "-96.34";

    public static void main(String[] args) {

        System.out.print(check(s));
    }

    public static boolean check(String s) {

        s = s.trim();
        int i = 0;
        boolean dec = false; //is decimal?
        for (char c : s.toCharArray()) {
            if (c == '-' || c == '+') {
                if (i != 0) return false;
            } else if (c == '.') {
                if (dec)
                    return false; //we can have only one decimal point in a number
                else
                    dec = true;
            } else if (c < '0' || c > '9') return false;
            i++;
        }
        return true;
    }
}
