public class Nqueens {
    public static boolean isSafe (boolean board[][], int row, int col){
        //Vertical rows
        for (int i = 0; i < row; i++)
            if (board[i][col])
                return false;

        //left diagonal
        int left = Math.min (row, col);
        for (int i = 1; i <= left; i++)
            if (board[row-i][col-i])
                return false;

        //right diagonal
        int right = Math.min (row, board.length-col-1);
        for (int i = 1; i <= right; i++)
            if (board[row-i][col+i])
                return false;
        return true;
    }
    public static void display (boolean board [][]){
        for (boolean i[] : board) {
            for (boolean j : i)
                if (j)
                    System.out.print("Q ");
                else
                    System.out.print("_ ");
            System.out.println();
        }
        System.out.println ();
    }
    public static void setQueens (boolean board[][], int row){
        //when all the queens are placed
        if (row == board.length)
            display(board);

        //positioning the queen
        for (int col = 0; col<board.length; col++)
            if (isSafe (board, row, col)) {
                board[row][col] = true;
                setQueens(board, row);
                board[row][col] = false;
            }
    }
    public static void main (String[]args){
        boolean board[][] = new boolean[4][4];
        setQueens(board, 0);
    }
}