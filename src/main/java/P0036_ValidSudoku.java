public class P0036_ValidSudoku {
    public static void main(String[] args) {
        char[][] board =
                        {{'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                        {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                        {'4', '.', '3', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '7', '2', '.', '.', '.', '.'},
                        {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'}};

        System.out.println(isValidSudoku(board));
    }

    static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if(!isdigit(board[i][j])) return false;
                    //checking rows...
                    int[] nums = new int[9];
                    for (int row = 0; row < 9; row++) {
                        char bit = board[i][row];
                        if (bit != '.') {
                            if( nums[bit - 49] == 0) nums[bit - 49] = bit - 48;
                            else return false;
                        }
                    }
                    //checking cols...
                    nums = new int[9];
                    for (int col = 0; col < 9; col++) {
                        char bit = board[col][j];
                        if (bit != '.') {
                            if( nums[bit - 49] == 0) nums[bit - 49] = bit - 48;
                            else return false;
                        }
                    }
                    //checking block...
                    nums = new int[9];
                    int row = (i / 3) * 3, col = (j / 3) * 3;
                    for (int m = row; m < row + 3; m++) {
                        for (int n = col; n < col + 3; n++) {
                            char bit = board[m][n];
                            if (bit != '.') {
                                if( nums[bit - 49] == 0) nums[bit - 49] = bit - 48;
                                else return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    static boolean isdigit(char x){
        if (x > 48 && x < 58 ) return true;
        else return false;
    }
}
