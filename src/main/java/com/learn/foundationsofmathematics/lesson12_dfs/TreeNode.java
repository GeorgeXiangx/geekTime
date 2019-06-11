package com.learn.foundationsofmathematics.lesson12_dfs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

/**
 * Created by XJH on 2019/1/30.
 *
 * @Description: 前缀树节点, 表示有向树的结点和边。这个类需要体现前缀树结点最重要的两个属性。
 * 1.这个结点所代表的字符，要用 label 变量表示。
 * 2.这个结点有哪些子结点，要用 sons 哈希映射表示。之所以用哈希，是为了便于查找某个子结点（或者说对应的字符）是否存在。
 */
public class TreeNode {
    //节点的名称，在前缀树里是个字母
    public char label;
    //使用哈希映射存放子结点。哈希便于确认是否已经添加过某个字母对应的结点。
    public HashMap<Character, TreeNode> sons = null;
    //从树的根到当前结点这条通路上，全部字母所组成的前缀。例如通路 b->o->y，对于字母 o 结点而言，前缀是 b；对于字母 y 结点而言，前缀是 bo
    public String prefix = null;
    //词条的解释
    public String explanation = null;

    public TreeNode(char label, String prefix, String explanation) {
        this.label = label;
        this.prefix = prefix;
        this.explanation = explanation;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode('0', null, "根节点");
        root.getOrCreateTree("abc", root);
    }

    /**
     * 获取或者创造树
     *
     * @param str    需处理的字符串
     * @param parent 父节点
     * @return 节点
     * <p>
     * 需要注意的是，我们需要动态地构建这棵树。
     * 每当接收一个新单词时，代码都需要扫描这个单词的<每个>字母，并使用当前的前缀树进行匹配。
     * 如果匹配到某个结点，发现相应的字母结点并不存在，那么就建立一个新的树结点。
     */
    public TreeNode getOrCreateTree(String str, TreeNode parent) {
        //处理当前字符串的第一个字母
        char c = str.toCharArray()[0];
        TreeNode found = null;

        //如果字母节点已经存在与当前父节点下，返回他。否则创建一个新的节点
        if (parent.sons.containsKey(c)) {
            found = parent.sons.get(c);
        } else {
            TreeNode son = new TreeNode(c, parent.prefix + parent.label, "");
            parent.sons.put(c, son);
            found = son;
        }

        return found;
    }

    /**
     * 用栈结构来实现深度优先遍历
     *
     * @param root 根节点
     */
    public void dfsByStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();

        //首先将root节点压入栈底
        stack.push(root);

        while (!stack.isEmpty()) {
            //弹出栈顶节点
            TreeNode node = stack.pop();

            //判断弹出的的节点是否为空
            if (node.sons.isEmpty()) {
                //已经达到了叶子结点，输出
                System.out.println(node.prefix + node.label);
            } else {
                //非叶子结点
                Iterator<Map.Entry<Character, TreeNode>> iterator = node.sons.entrySet().iterator();

                //创建临时栈，这样做是为了保持遍历的顺序，和递归遍历的顺序是一致的
                Stack<TreeNode> tempStack = new Stack<TreeNode>();

                while (iterator.hasNext()) {
                    tempStack.push(iterator.next().getValue());
                }

                while (!tempStack.isEmpty()) {
                    stack.push(tempStack.pop());
                }
            }
        }
    }
}
