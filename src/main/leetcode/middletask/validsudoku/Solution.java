package main.leetcode.middletask.validsudoku;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isValidSudoku(char[][] board) {

        int rowElementCounter = 0;
        Set<Character> rowElementDigits = new HashSet<>();

        int columnElementCounter = 0;
        Set<Character> columnElementDigits = new HashSet<>();

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {
                rowElementCounter += getDigits(board[i][j], rowElementDigits); // find a reiteration of numbers in the rows
                columnElementCounter += getDigits(board[j][i], columnElementDigits); // find a reiteration of numbers in the columns
            }

            if (rowElementCounter != rowElementDigits.size() ||
                    columnElementCounter != columnElementDigits.size()) {
                return false;
            } else {
                rowElementCounter = 0;
                columnElementCounter = 0;
                rowElementDigits.clear();
                columnElementDigits.clear();
            }
        }

        // find a reiteration of numbers in the 3x3 cells

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                if (!checkigCell(i, j, board)) {return false;}
            }
        }
        return true;
    }

    private static boolean checkigCell(int rowStep, int columnStep, char[][] matrix) {
        int cellElementCounter = 0;
        Set<Character> cellElementDigits = new HashSet<>();

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                char cellElement = matrix[3 * rowStep + i][3 * columnStep + j];
                cellElementCounter += getDigits(cellElement, cellElementDigits);
            }
        }
        return cellElementCounter == cellElementDigits.size();
    }

    private static int getDigits(char el, Set<Character> columnDigit) {
        if (Character.isDigit(el)) {
            columnDigit.add(el);
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', ',', '.', '2', '8'},
                {'.', '.', '.', ',', '4', '1', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        Solution solution = new Solution();
        System.out.println(solution.isValidSudoku(matrix));
    }
}
