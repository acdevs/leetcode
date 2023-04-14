package leetcode;

import java.util.Stack;

public class P0946_ValidateStackSequences {
    public static void main(String[] args) {
        int[] pushed = {2,1,0};
        int[] popped = {1,2,0};
        System.out.println(validateStackSequences(pushed, popped));
    }

    static boolean validateStackSequences(int[] pushed, int[] popped) {
        int N = pushed.length;
        Stack<Integer> stack = new Stack();

        int j = 0;
        for (int x: pushed) {
            stack.push(x);
            while (!stack.isEmpty() && j < N && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        return j == N;
    }
}
