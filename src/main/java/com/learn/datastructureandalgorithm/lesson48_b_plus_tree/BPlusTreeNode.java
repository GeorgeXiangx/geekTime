package com.learn.datastructureandalgorithm.lesson48_b_plus_tree;

/**
 * Created by XJH on 2019/2/25.
 *
 * @Description:
 */


/**
 * 这是 B+ 树非叶子节点的定义。
 * 假设 keywords=[3, 5, 8, 10]
 * 4 个键值将数据分为 5 个区间：(-INF,3), [3,5), [5,8), [8,10), [10,INF)
 * 5 个区间分别对应：children[0]...children[4]
 * <p>
 * m 值是事先计算得到的，计算的依据是让所有信息的大小正好等于页的大小：
 * PAGE_SIZE = (m-1)*4[keyWords大小]+m*8[children大小]
 */
public class BPlusTreeNode {
    /**
     * 不管是内存中的数据，还是磁盘中的数据，操作系统都是按页
     * （一页大小通常是 4KB，这个值可以通过 getconfig PAGE_SIZE 命令查看）来读取的，一次会读一页的数据。
     * 如果要读取的数据量超过一页的大小，就会触发多次 IO 操作。所以，我们在选择 m 大小的时候，要尽量让每个节点的大小等于一个页的大小。
     * 读取一个节点，只需要一次磁盘 IO 操作。
     */

    //5叉树
    public static int m = 5;
    //键值,用来划分数据区间
    public int[] keyWords = new int[m - 1];
    //保存子节点指针
    public BPlusTreeNode[] children = new BPlusTreeNode[m];

    public static void main(String[] args) {
        BPlusTreeNode bPlusTreeNode = new BPlusTreeNode();
        bPlusTreeNode.keyWords[0] = 99;
        bPlusTreeNode.keyWords[1] = 203;

        BPlusTreeNode children1 = new BPlusTreeNode();
        children1.keyWords[0] = 30;
        children1.keyWords[1] = 65;

        bPlusTreeNode.children[0] = children1;

        BPlusTreeLeafNode leafNode1 = new BPlusTreeLeafNode();
        leafNode1.keyWords[0] = 5;
        leafNode1.dataAddress[0] = 10000;
        leafNode1.keyWords[1] = 20;
        leafNode1.dataAddress[1] = 10001;

    }
}


