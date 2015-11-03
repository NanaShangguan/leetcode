package nano.shangguan;

import java.util.Stack;

/**
 * Created by Nano on 2015/10/30.
 */
public class BasicCalculator {
    public int calculate(String s) {
        //去掉empty space
        s = s.replace(" ", "");
        Stack<Integer> operand = new Stack<Integer>();
        Stack<Character> operator = new Stack<Character>();
        String numTracker = "";
        for (int i = 0; i < s.length(); i++) {
            char token = s.charAt(i);
            if (Character.isDigit(token)) numTracker += token;
            else {
                if (!numTracker.equals("") && !numTracker.equals("-")) {
                    //push数字
                    operand.push(Integer.parseInt(numTracker));
                    //清空tracker
                    numTracker = "";
                }
                if (token == (')')) {
                    char op = operator.pop();
                    while (op != ('(') && operand.size() > 1) {
                        int a = operand.pop();
                        int b = operand.pop();
                        if (op == '+') operand.push(a + b);
                        else operand.push(b - a);
                        op = operator.pop();
                    }
                } else if (token == '-') {
                    operator.push('+');
                    numTracker += "-";
                } else operator.push(token);
            }
        }
        if (!numTracker.equals("")) operand.push(Integer.parseInt(numTracker));
        while (!operator.isEmpty() && operand.size() > 1) {
            char op = operator.pop();
            int a = operand.pop();
            int b = operand.pop();
            operand.push(op == '+' ? a + b : b - a);
        }
        return operand.pop();
    }

    public static void main(String[] args) {
        System.out.println(new BasicCalculator().calculate("2-(5-6)"));
    }
}
