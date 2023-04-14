package leetcode;

import java.util.Stack;

public class P0071_SimplifyPath {
    public static void main(String[] args) {
        String path = "/home/../work/.../dir/";
        System.out.println(simplifyPath(path));
//        simplifyPath(path);
    }

    static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder PATH = new StringBuilder();
        for(String s: path.split("/")){
            /*consecutive slashes: /// -> / */
            if(s.isEmpty()) continue;
            /*consecutive dots: ... -> ... */
            if(s.equals(".")) continue;
            if(s.equals("..")){
                if(!stack.isEmpty()) stack.pop();
                continue;
            }
            stack.push(s);
        }
        PATH.append("/");
        for (int i = 0; i < stack.size(); i++) {
            PATH.append(stack.get(i));
            if(i != stack.size() - 1) PATH.append("/");
        }
        return PATH.toString();
    }
}
