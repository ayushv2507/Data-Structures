public class StringManipulation {

    private static String s = "Java Concept Of The Day";
    private static String t = "Java program of the day";
    private static String str = "wwwwwiiiikkkkkkkiiippppppeeeeeddddiia";


    public static void main(String[] args) {
        // revereWholeString();                            // output : yaD ehT fO tpecnoC avaJ
        // reverseEachWordOfString(s);                     // output : avaJ tpecnoC fO ehT yaD
        // reverseWordsInString(s);                       // output : Day The Of Concept Java
        // swapWithoutThirdVariable(s,t);
        //   runLengthEncoding(str);
    }

    private static void revereWholeString() {
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            result = result + s.charAt(i);
        }
        System.out.print(result);
    }

    private static void reverseEachWordOfString(String s) {
        String result = "";

        String[] words = s.split(" ");
        for (String word : words) {
            String reverseWord = "";
            for (int i = word.length() - 1; i >= 0; i--) {
                reverseWord = reverseWord + (word.charAt(i));
            }
            result = result + (reverseWord) + " ";
        }
        System.out.print(result);
    }

    private static void reverseWordsInString(String s) {
        String result = "";

        String[] words = s.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            result = result + words[i] + " ";
        }
        System.out.print(result);
    }

    private static void swapWithoutThirdVariable(String s, String t) {
        s = s + t;
        t = s.substring(0, s.length() - t.length());
        s = s.substring(t.length());
        System.out.println("s: " + s);
        System.out.print("t: " + t);
    }

    private static void runLengthEncoding(String str) {
        int count = 1;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < str.length() - 1; i++) {

            if (str.charAt(i) != str.charAt(i + 1)) {
                stringBuilder.append(count);
                stringBuilder.append(str.charAt(i));
                count = 1;
            } else {
                count++;
            }
        }
        System.out.print(stringBuilder.toString());


    }


}
