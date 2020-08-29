package com.lyh.personal.demo.algorithm.leeteCode.learning.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先求岛屿数量
 * 时间复杂度：O(MN)
 * 空间复杂度：O(min(M,N))
 */
public class BFS4Island {

    public static void main(String[] args) {
//        char[][] grid = {{'1','1','1','1','1','1'},
//                         {'1','1','1','1','1','1'},
//                         {'1','1','1','1','1','1'}};
//        numIslands(grid);

        char[][] grid2 = {{'1','1','1','1','1'},
                          {'1','1','1','1','1'},
                          {'1','1','1','1','1'},
                          {'1','1','1','1','1'},
                          {'1','1','1','1','1'},
                          {'1','1','1','1','1'},
                          {'1','1','1','1','1'},
                          {'1','1','1','1','1'}};
        numIslands(grid2);
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length==0){
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int isIandNum = 0;
        for (int r = 0; r < nr; r++){
            for (int c = 0; c < nc; c++){
                if (grid[r][c] == '1'){
                    ++isIandNum;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);

                    // 优先计算判断上、下、左、右
                    while (!neighbors.isEmpty()){
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            neighbors.add((row-1) * nc + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row+1][col] == '1') {
                            neighbors.add((row+1) * nc + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            neighbors.add(row * nc + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col+1] == '1') {
                            neighbors.add(row * nc + col+1);
                            grid[row][col+1] = '0';
                        }

                        if (neighbors.size() >= nr || neighbors.size() >= nc){
                            System.out.println(neighbors.size());
                        }
                    }
                }
            }
        }

        return isIandNum;
    }

}
