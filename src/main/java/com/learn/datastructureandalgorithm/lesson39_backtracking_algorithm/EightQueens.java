package com.learn.datastructureandalgorithm.lesson39_backtracking_algorithm;

/**
 * Created by XJH on 2019/1/24.
 *
 * @Description: 回溯算法解决八皇后问题
 * 回溯算法本质上就是枚举，优点在于其类似于摸着石头过河的查找策略，且可以通过剪枝少走冤枉路。
 * 它可能适合应用于缺乏规律，或我们还不了解其规律的搜索场景中。
 * <p>
 * 通过逐行每列的放置尝试，去验证当前放置的棋子是否符合规范
 */
public class EightQueens {
    //全局变量存放八皇后,数组下标代表行数，值代表列数
    public int[] results = new int[8];
    public int count = 0;

    /**
     * 调用八皇后问题，从第一行开始调用
     *
     * @param row 行数
     */
    private void cal8Queens(int row) {
        //放满，打印退出
        if (row == 8) {
            printQueens(results);
            count++;
            return;
        }

        //每行有8种放法(8列)
        for (int column = 0; column < 8; column++) {
            if (isOK(row, column)) {
                //结果符合预期，放置结果
                results[row] = column;
                //递归进行下一行的放置
                cal8Queens(row + 1);
            }
        }
    }

    /**
     * 判断row行column列放置棋子是否合适
     *
     * @param row    行数
     * @param column 列数
     * @return 是否可以放置
     */
    private boolean isOK(int row, int column) {
        int leftUp = column - 1, rightUp = column + 1;
        //相同的行和列上不能出现两个棋子
        //从当前行的上一行开始判断
        for (int i = row - 1; i >= 0; --i) {
            //在相同列上，直接返回false
            if (results[i] == column) return false;

            //检查当前棋子的左斜线上是否有其他的皇后
            if (leftUp >= 0) {
                if (results[i] == leftUp) return false;
            }

            //检查当前棋子的右斜线上是否有其他的皇后
            if (rightUp < 8) {
                if (results[i] == rightUp) return false;
            }

            //验证更远斜线上是否有皇后，变量自增
            leftUp--;
            rightUp++;
        }
        return true;
    }

    /**
     * 打印符合规则的八皇后排列
     *
     * @param results 符合规则的数组
     */
    private void printQueens(int[] results) {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (results[row] == column) System.out.print("Q  ");
                else System.out.print("*  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();
        eightQueens.cal8Queens(0);
        System.out.println("八皇后问题共 : " + eightQueens.count + " 种解法");
    }
}
