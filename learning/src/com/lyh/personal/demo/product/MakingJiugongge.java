package com.lyh.personal.demo.product;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MakingJiugongge {

    /**
     * 步骤：
     * 1-随机生成一个完整的3x3九宫格；
     *  1.1-先随机生成第一行；
     *  1.2-再逐次随机生成其他行：期间对每个元素进行校验：行不同，列不同，宫不同；
     * 2-按照输入因子，隐藏宫内元素，并保存因子与九宫的关系；
     */

    /**
     * 随机生成1~9
     *
     * @return
     */
    public int getElemet() {
        int v = (int) (Math.random() * 10);

        if (v == 0) {
            return getElemet();
        }
        return v;
    }


    @Test
    public void makingTest() {
//        final int size = 3;
//        int realSize = size * size;
        try {
            making();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 生成随机九宫格
     *
     * @return
     */
    public int[][] making() {
        int[][] result = new int[9][9];
        for (int x = 0; x < 9; x++) {
            List<Integer> theRowChecker = new ArrayList<>();
            for (int y = 0; y < 9; y++) {
                int value = getElemet();
                if ((x % 3) == 0) {
                    // making every first row
                    if (x != 0) {
                        theRowChecker.clear();
                        setRowAndColumChecker(result, theRowChecker, x, y);
                        if (theRowChecker.size() == 9) {
                            // 生成了不符合规则的数据，需要重新开始生成
                            y = -1;
                            theRowChecker.clear();
                            continue;
                        }
                    }
                    while (theRowChecker.contains(value)) {
                        value = getElemet();
                    }
                    theRowChecker.add(value);

                } else {
                    value = checkTheValue(result, value, x, y);
                    if (value == -1) {
                        for (int k = 0; k <= y; k++) {
                            result[x][k] = 0;
                        }
                        y = -1;
                        theRowChecker.clear();
                        continue;
                    }
                }

                result[x][y] = value;
            }
        }
        printResult(result);
        return result;

    }

    private void setRowAndColumChecker(int[][] result, List<Integer> checker, int x, int y) {
        for (int colum = 0; colum < y; colum++) {
            setChecker(result, checker, x, colum);
        }
        for (int row = 0; row < x; row++) {
            setChecker(result, checker, row, y);
        }
    }

    private int checkTheValue(int[][] result, int value, int x, int y) {
        List<Integer> checker = new ArrayList<>();
        int gongIndexX = x / 3;
        int gongIndexY = y / 3;

        for (int rx = gongIndexX * 3, countX = 0; countX < 3; rx++, countX++) {

            for (int ry = gongIndexY * 3, countY = 0; countY < 3; ry++, countY++) {
                setChecker(result, checker, rx, ry);
            }

        }
        setRowAndColumChecker(result, checker, x, y);

        if (checker.size() == 9) {
            // 生成了不符合规则的数据，需要重新开始生成
            return -1;
        }
        while (checker.contains(value)) {
            value = getElemet();
        }
        return value;
    }

    private void setChecker(int[][] result, List<Integer> checker, int rx, int ry) {
        int temp = result[rx][ry];
        if (checker.contains(temp) || temp == 0) {
            return;
        }
        checker.add(temp);
    }

    private void printResult(int[][] result) {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                System.out.print(result[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------------");
    }


}
