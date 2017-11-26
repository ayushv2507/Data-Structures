import java.util.Stack;

public class EvaluatePostFix {
    public static void main(String[] args) {
        System.out.println(postfixEvaluate("12+"));               // 3
        System.out.println(postfixEvaluate("123*+4+"));       // 11
        System.out.println(postfixEvaluate("85*742+*+"));
    }

    private static int postfixEvaluate(String s) {
        Stack<Integer> stack = new Stack<>();
        for (char c:s.toCharArray()) {
            if(isOperand(c)){
                stack.push(c-'0');
            } else{
                int one = stack.pop();
                int two = stack.pop();
                int three = applyOperation(c,one,two);
                stack.push(three);
            }
        }
        return stack.pop();
    }

    private static boolean isOperand(char c){
        return c >= '0' && c <= '9';
    }

    private static int applyOperation(int c, int one, int two) {
        switch (c){
            case '+': return (one+two);
            case '-': return  (one-two);
            case '*': return (one*two);
            case '/': return  (one/two);
            default: return 0;
        }
    }
}
