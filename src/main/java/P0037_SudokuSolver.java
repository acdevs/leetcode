import java.util.Arrays;

public class P0037_SudokuSolver {
    public static void main(String[] args) {
        char[][] board1 =
                        {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        char[][]board2 =
                        {{'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                        {'7', '.', '.', '6', '.', '2', '.', '.', '.'},
                        {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                        {'.', '.', '7', '9', '8', '6', '2', '4', '1'},
                        {'2', '6', '4', '3', '1', '7', '5', '9', '8'},
                        {'1', '9', '8', '5', '2', '4', '3', '6', '7'},
                        {'.', '.', '.', '8', '6', '3', '.', '2', '.'},
                        {'.', '.', '.', '4', '9', '1', '.', '.', '6'},
                        {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};

        char[][] board =
                        {{'.', '.', '.', '.', '4', '8', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                        {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                        {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                        {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                        {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                        {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};


        solveSudoku(board);
//        solve(board2);
        for (char[] row : board2) {
            System.out.println(Arrays.toString(row));
        }
    }

    static void solveSudoku(char[][] board) {
        if(solve(board) == 1){
            valuerandomise(board);
        }
    }

    static int solve(char[][] board){
        int emps = 1, prev = 1;
        while (emps != 0) {
            emps = 0;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        emps += 1;
                        int[] bits = findbits(board, i, j);
                        //checking nums...
                        int count0 = 0;
                        int bit = 0;
                        for (int k = 0; k < 9; k++) {
                            if (bits[k] != k + 1) {
                                count0 += 1;
                                bit = k + 1;
                            }
                        }
                        if (count0 == 1) board[i][j] = (char) (bit + 48);
                    }
                }
            }
            if (emps == prev) {
                return 1;
            }
            prev = emps;
        }
        return 0;
    }
    static void valuerandomise(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    int[] nums = findbits(board, i, j);
                    int isfull = 1;
                    for (int k = 0; k < 9; k++) {
                        if (nums[k] != (k + 1)) {
                            isfull = 0;
                            char bit = (char) (k + 49);
                            //creating temp board...
                            char[][] temp = new char[9][9];
                            for (int l = 0; l < 9; l++) {
                                temp[l] = board[l].clone();
                            }
                            temp[i][j] = bit;
                            if (solve(temp) == 1) {
                                continue;
                            }
                            for (int l = 0; l < 9; l++) {
                                board[l] = temp[l].clone();
                            }
                            return;
                        }
                    }
                    if(isfull == 1){
                        return;
                    }
                }
            }
        }
    }

    static int[] findbits(char[][] board, int i, int j) {
        int[] nums = new int[9];
        //checking rows...
        for (int row = 0; row < 9; row++) {
            char bit = board[i][row];
            if (board[i][row] != '.') nums[bit - 49] = bit - 48;
        }
        //checking cols...
        for (int col = 0; col < 9; col++) {
            char bit = board[col][j];
            if (board[col][j] != '.') nums[bit - 49] = bit - 48;
        }
        //checking block...
        int row = (i / 3) * 3, col = (j / 3) * 3;
        for (int m = row; m < row + 3; m++) {
            for (int n = col; n < col + 3; n++) {
                if (board[m][n] != '.') nums[board[m][n] - 49] = board[m][n] - 48;
            }
        }
        return nums;
    }
}
