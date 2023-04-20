import java.util.Arrays;

public class P0048_RotateImage {
    public static void main(String[] args) {
        int[][] image = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(image);
        for (int[] x : image) {
            System.out.println(Arrays.toString(x));
        }
    }

    /* Rotate Groups of Four Cells */
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i ++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    /* Reverse on Diagonal and then Reverse */
}
