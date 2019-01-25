package com.learn.datastructureandalgorithm.lesson39_backtracking_algorithm;

/**
 * Created by XJH on 2019/1/25.
 *
 * @Description: 0-1背包问题
 * 我们有一个背包，背包总的承载重量是 Wkg。现在我们有 n 个物品，每个物品的重量不等，并且不可分割。
 * 我们现在期望选择几件物品，装载到背包中。在不超过背包所能装载重量的前提下，如何让背包中物品的总重量最大？
 * <p>
 * 实际上，背包问题我们在贪心算法那一节，已经讲过一个了，不过那里讲的物品是可以分割的，我可以装某个物品的一部分到背包里面。
 * 今天讲的这个背包问题，物品是不可分割的，要么装要么不装，所以叫 0-1 背包问题。
 * 显然，这个问题已经无法通过贪心算法来解决了。
 * 我们现在来看看，用回溯算法如何来解决。
 * <p>
 * 我们可以把物品依次排列，整个问题就分解为了 n 个阶段，每个阶段对应一个物品怎么选择。
 * 先对第一个物品进行处理，选择装进去或者不装进去，然后再递归地处理剩下的物品。
 */
public class PackageProblem {
    //存储背包中物品总重量的最大值(用于存储最终的结果)
    private int maxWeight = Integer.MIN_VALUE;

    /**
     * 背包函数
     *
     * @param index         考察到哪个物品了
     * @param putWeight     已放入物品的重量总和
     * @param items         每个物品重量的数组
     * @param totalNumb     表示总共有多少个物品可以选择
     * @param packageWeight 背包可承受重量
     *                      <p>
     *                      假设背包可承受重量 100，物品个数 10，物品重量存储在数组 items 中，那可以这样调用函数：func(0, 0, a, 10, 100)
     */
    public void func(int index, int putWeight, int[] items, int totalNumb, int packageWeight) {
        //如果 putWeight == packageWeight表示背包已经装满, index == count表示物品已经被选完
        //函数入口处的 if 分支表明递归结束条件，并保证 maxWeight 跟踪所有选择中的最大值
        if (putWeight == packageWeight || index == totalNumb) {
            if (putWeight > maxWeight) {
                System.out.println("* 递归终止条件满足, 分支条件: putWeight > maxWeight , putWeight = " + putWeight + " maxWeight = " + maxWeight);
                maxWeight = putWeight;
            }
            System.out.println("** 递归终止条件满足, putWeight = " + putWeight + " maxWeight = " + maxWeight + "\n");
            return;
        }

        System.out.println("不选择当前物品,index = " + index + ", putWeight = " + putWeight + " maxWeight = " + maxWeight);
        //表示不选择当前物品，直接考虑下一个（第index + 1个），故putWeight不更新
        func(index + 1, putWeight, items, totalNumb, packageWeight);

        //选择当前物品
        if (putWeight + items[index] <= packageWeight) {
            System.out.println("选择当前物品,index = " + index + ", putWeight = " + putWeight + " maxWeight = " + maxWeight);
            func(index + 1, putWeight + items[index], items, totalNumb, packageWeight);
        }
    }

    public static void main(String[] args) {
        int[] items = {10, 20, 30};
        PackageProblem packageProblem = new PackageProblem();
        packageProblem.func(0, 0, items, 3, 100);
        System.out.println(packageProblem.maxWeight);
    }
}
