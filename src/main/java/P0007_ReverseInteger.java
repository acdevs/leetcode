package leetcode;

public class P0007_ReverseInteger {
    public static void main(String[] args) {
        int x = -2147483648;
        System.out.println(reverse(x));
    }
    static int reverse(int x) {
        if (x == 0) return 0;
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            //check range before operation...
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
            x /= 10;
        }
        return rev;
    }
}
