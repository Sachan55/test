import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<String> rowSet [] = new HashSet [9];
        Set<String> colSet [] = new HashSet [9];
        Set<String> boxSet [][] = new HashSet [3][3];

        for (int i = 0; i < 9; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boxSet[i][j] = new HashSet<>();
            }
        }

        for(int i = 0 ; i < board.length; i++){
            for(int j = 0 ; j < board[0].length ; j++) {
                if (board[i][j] != '.') {
                    if (!rowSet[i].add(Integer.toString(i) + " " + board[i][j]))
                        return false;
                    if (!colSet[j].add(Integer.toString(j) + " " + board[i][j]))
                        return false;
                    if (!boxSet[i / 3][j / 3].add(Integer.toString(i) + " " + Integer.toString(j) + " " + board[i][j]))
                        return false;
                }
            }
        }
        return true;
    }
}
