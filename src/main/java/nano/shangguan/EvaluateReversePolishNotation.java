package nano.shangguan;

import java.util.Stack;

/**
 * Created by Nano on 2015/10/30.
 * +, -, *, /
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String token : tokens) {
            //如果是操作符
            if (token.equals("+") || token.equals("-")
                    || token.equals("*") || token.equals("/")) {
                //弹出两个数
                int a = stack.pop();
                int b = stack.pop();
                //计算
                int result = a + b;
                if (token.equals("-")) result = b - a;
                else if (token.equals("*")) result = a * b;
                else if (token.equals("/")) result = b / a;
                //将结果push进stack
                stack.push(result);
            } else stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }
}
