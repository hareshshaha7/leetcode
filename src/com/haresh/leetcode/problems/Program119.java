package com.haresh.leetcode.problems;

/*
    36. Valid Sudoku
    https://leetcode.com/problems/valid-sudoku/

    Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
    Note:

    A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    Only the filled cells need to be validated according to the mentioned rules.

    Example 1:
    Input: board =
        [["5","3",".",".","7",".",".",".","."]
        ,["6",".",".","1","9","5",".",".","."]
        ,[".","9","8",".",".",".",".","6","."]
        ,["8",".",".",".","6",".",".",".","3"]
        ,["4",".",".","8",".","3",".",".","1"]
        ,["7",".",".",".","2",".",".",".","6"]
        ,[".","6",".",".",".",".","2","8","."]
        ,[".",".",".","4","1","9",".",".","5"]
        ,[".",".",".",".","8",".",".","7","9"]]
    Output: true
    Example 2:

    Input: board =
        [["8","3",".",".","7",".",".",".","."]
        ,["6",".",".","1","9","5",".",".","."]
        ,[".","9","8",".",".",".",".","6","."]
        ,["8",".",".",".","6",".",".",".","3"]
        ,["4",".",".","8",".","3",".",".","1"]
        ,["7",".",".",".","2",".",".",".","6"]
        ,[".","6",".",".",".",".","2","8","."]
        ,[".",".",".","4","1","9",".",".","5"]
        ,[".",".",".",".","8",".",".","7","9"]]
    Output: false
    Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.

    Constraints:
        board.length == 9
        board[i].length == 9
        board[i][j] is a digit 1-9 or '.'.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Haresh Shaha
 * @since 11-Jan-2022
 */
public class Program119 {

    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        char[][] board =
//                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
//                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
//                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
//                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
//                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
//                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
//                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
//                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
//                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
                {{'.', '8', '7', '6', '5', '4', '3', '2', '1'},
                        {'2', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'3', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'5', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'9', '.', '.', '.', '.', '.', '.', '.', '.'}};

        boolean validSudoku = isValidSudoku(board);
        System.out.println(validSudoku);
    }

    public static boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rows = new ArrayList<>();
        List<Set<Character>> columns = new ArrayList<>();
        List<Set<Character>> boxes = new ArrayList<>();
        populateListWithSet(rows, board.length);
        populateListWithSet(columns, board.length);
        populateListWithSet(boxes, board.length);

        for (int i = 0; i < board.length; i++) {
            Set<Character> row = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                // Skips any check for empty cell
                if (board[i][j] != '.') {
//                    System.out.println("-------");
//                    System.out.println(rows);
//                    System.out.println(columns);
//                    System.out.println(boxes);

                    // Check if row has any duplicate
                    row = rows.get(i);
                    if (!row.add(board[i][j])) {
                        System.out.println("Returning from Row");
                        return false;
                    }

                    // Check if column has any duplicate
                    Set<Character> column = columns.get(j);
                    if (!column.add(board[i][j])) {
                        System.out.println("Returning from Column");
                        return false;
                    }

                    // Check if box has any duplicate
                    int index = getIndex(i, j);
                    Set<Character> box = boxes.get(index);
                    if (!box.add(board[i][j])) {
                        System.out.println("Returning from box");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static void populateListWithSet(List<Set<Character>> list, int num) {
        for (int i = 0; i < num; i++) {
            list.add(new HashSet<>());
        }
    }

    public static int getIndex(int i, int j) {
        if (i < 3 & j < 3)
            return 0;
        if (i < 3 & j < 6)
            return 1;
        if (i < 3 & j < 9)
            return 2;
        if (i < 6 & j < 3)
            return 3;
        if (i < 6 & j < 6)
            return 4;
        if (i < 6 & j < 9)
            return 5;
        if (i < 9 & j < 3)
            return 6;
        if (i < 9 & j < 6)
            return 7;
        return 8;
    }
}
