package leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class P2390_RemovingStarsFromaString {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(removeStars(s));
    }

    static String removeStars(String s) {
        ArrayList<Character> stack = new ArrayList<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c != '*'){
                stack.add(c);
            }else{
                if(stack.size() == 0) continue;
                stack.remove(stack.size() - 1);
            }
        }
        for (char value : stack) {
            res.append(value);
        }
        return res.toString();
    }

    static String removeStars2(String s){
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }

        StringBuilder answer = new StringBuilder();
        while (!st.isEmpty()) {
            answer.append(st.pop());
        }

        return answer.reverse().toString();
    }
}
