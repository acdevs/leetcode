package leetcode;

public class P2133_ContainsAllNumbers {
    public static void main(String[] args) {
        int[][] arr = {{2,4,2},{3,1,2},{2,3,1}};
        System.out.println(checkValid(arr));
    }

    static boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        int[] ints;
        //checking rows...
        for (int row = 0; row < n; row++) {
            ints = new int[n];
            for (int i = 0; i < n; i++) {
                int bit = matrix[row][i];
                //also check range?
                if(bit < 1 || bit > n) return false;
                if(ints[bit - 1] != 0 && ints[bit - 1] == bit) return false;
                else ints[bit - 1] = bit;
            }
        }
        //checking cols...
        for (int i = 0; i < n; i++) {
            ints = new int[n];
            for (int col = 0; col < n; col++) {
                int bit = matrix[col][i];
                if(ints[bit - 1] != 0 && ints[bit - 1] == bit) return false;
                else ints[bit - 1] = bit;
            }
        }
        return true;
    }
}
