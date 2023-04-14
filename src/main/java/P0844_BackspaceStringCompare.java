package leetcode;

import java.util.Stack;

public class P0844_BackspaceStringCompare {
    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";
        System.out.println(backspaceCompare(s,t));
    }

    static boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

     /*Time Complexity: O(s+t) Space Complexity: O(s+t) */
    static String build(String S) {
        Stack<Character> ans = new Stack();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }
}
