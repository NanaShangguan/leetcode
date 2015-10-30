package nano.shangguan;

import java.util.Stack;

/**
 * Created by Lenovo on 2015/10/30.
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (String each : arr) {
            if (!each.equals("")) {
                if (each.equals("..")) {
                    if (!stack.isEmpty())
                        stack.pop();
                } else if (!each.equals("."))
                    stack.push(each);
            }
        }
        String simplifiedPath = "";
        while (!stack.isEmpty()) {
            simplifiedPath = stack.pop() + "/" + simplifiedPath;
        }
        if (!simplifiedPath.equals("")) {
            simplifiedPath = simplifiedPath.substring(0, simplifiedPath.length() - 1);
        }
        return "/" + simplifiedPath;
    }

    public static void main(String[] args) {
        System.out.println(new SimplifyPath().simplifyPath("/../"));
    }
}
