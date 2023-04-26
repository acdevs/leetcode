public class P0258_AddDigits {
    public static void main(String[] args) {
        int n = 123;
        System.out.println(addDigits(n));
    }
    static int addDigits(int num) {
        return num == 0 ? 0 : 1 + (num - 1) % 9;
    }
}
