import java.util.Stack;

public class PatternMatching {

    private static char[] exp = {'{', '(', ')', '}', '[', ']'};

    public static void main(String[] args) {

        System.out.print(isPatternMatching());
    }

    private static boolean isPatternMatching() {
        Stack<Character> stack = new Stack<>();
        for (char c : exp) {

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            if (c == ')' || c == '}' || c == ']') {
                if (stack.empty()) {
                    return false;
                }
                char ch = stack.pop();
                return isMatching(ch, c);
            }
        }
        return false;
    }

    private static boolean isMatching(char ch, char c) {
        if (c == ')' && ch == '(') {
            return true;
        }
        if (c == '}' && ch == '{') {
            return true;
        }
        if (c == ']' && ch == '[') {
            return true;
        }
        return false;
    }
}
