package com.haresh.leetcode.problems;

/*
    79. [Medium] Word Search
    https://leetcode.com/problems/word-search/

    Given an m x n grid of characters board and a string word, return true if word exists in the grid.

    The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
    The same letter cell may not be used more than once.

    Example 1:
    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
    Output: true

    Example 2:
    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
    Output: true

    Example 3:
    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
    Output: false

    Constraints:
        m == board.length
        n = board[i].length
        1 <= m, n <= 6
        1 <= word.length <= 15
        board and word consists of only lowercase and uppercase English letters.

    Follow up: Could you use search pruning to make your solution faster with a larger board?
 */

/**
 * @author Haresh Shaha
 * @since 17-MAY-2022
 */
public class Program189 {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        boolean doesExist = exist(board, word);
        System.out.println(doesExist);
    }

    private static boolean[][] states;

    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;
        states = new boolean[rows][columns];

        /*Find word's first letter.  Then call method to check it's surroundings */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == word.charAt(0) && wordSearch(i, j, 0, board, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean wordSearch(int i, int j, int index, char[][] board, String word) {
        /* once we get past word.length, we are done. */
        if (index == word.length()) {
            return true;
        }

        /* if off bounds, letter is seen, letter is unequal to word.charAt(start) return false */
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || board[i][j] != word.charAt(index) || states[i][j]) {
            return false;
        }

        /* set this board position to seen. (Because we can use this postion) */
        states[i][j] = true;

        /* recursion on all 4 sides for next letter, if works: return true */
        boolean result = wordSearch(i + 1, j, index + 1, board, word)
                || wordSearch(i - 1, j, index + 1, board, word)
                || wordSearch(i, j + 1, index + 1, board, word)
                || wordSearch(i, j - 1, index + 1, board, word);

        //Set back to unseen
        states[i][j] = false;

        return result;
    }
}
