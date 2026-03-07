package com.leetcode.topinterview150.lc_0289_game_of_life;

class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0)
            return;

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = countLiveNeighbors(board, i, j);

                if (board[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = -1; // 从活变死
                    }
                } else {
                    if (liveNeighbors == 3) {
                        board[i][j] = 2; // 从死变活
                    }
                }
            }
        }

        // 更新为最终状态
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                } else if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int countLiveNeighbors(int[][] board, int row, int col) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;

        // 方向数组：上、下、左、右、左上、右上、左下、右下
        int[] directions = { -1, 0, 1 };
        for (int i : directions) {
            for (int j : directions) {
                if (i == 0 && j == 0)
                    continue;
                int r = row + i;
                int c = col + j;
                if (r >= 0 && r < m && c >= 0 && c < n && Math.abs(board[r][c]) == 1) {
                    count++;
                }
            }
        }

        return count;
    }

}
