package com.simon.learn.nqueens;

import java.util.ArrayList;
import java.util.List;

/**
 * @author simon.wei
 */
public class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if(n <= 0) {
            return result;
        }
        search(result, new ArrayList<Integer>(), n);
        return result;
    }

    public void search(List<List<String>> result, List<Integer> cols, int n) {
        if(cols.size() == n) {
            result.add(drawChessBoard(cols));
            return;
        }
        for(int colIndex = 0; colIndex < n; colIndex++) {
            if(!isValid(cols, colIndex)) {
                continue;
            }
            cols.add(colIndex);
            search(result, cols, n);
            cols.remove(cols.size() - 1);
        }
    }

    public boolean isValid(List<Integer> cols, int column) {
        int rows = cols.size();
        for(int rowIndex = 0; rowIndex < rows; rowIndex++) {
            if(cols.get(rowIndex) == column) {
                return false;
            }
            if(rowIndex - cols.get(rowIndex) == rows - column) {
                return false;
            }
            if(rowIndex + cols.get(rowIndex) == rows + column) {
                return false;
            }
        }
        return true;
    }

    public List<String> drawChessBoard(List<Integer> cols) {
        List<String> chessBoard = new ArrayList<>();
        for(int i = 0; i < cols.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < cols.size(); j++) {
                sb.append(j == cols.get(i) ? "Q" : ".");
            }
            chessBoard.add(sb.toString());
        }
        return chessBoard;
    }

}
