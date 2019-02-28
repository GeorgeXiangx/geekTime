package com.learn.datastructureandalgorithm.lesson43_topological_sorting;

import java.util.LinkedList;

/**
 * Created by XJH on 2019/2/14.
 *
 * @Description: 拓扑排序本身就是基于有向无环图的一个算法
 */
public class Graph {
    //顶点个数
    private int v;
    //邻接表
    //s先于t执行, s -> t, s指向t的边
    private LinkedList<Integer> adj[];

    //构造方法
    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    /**
     * 增加边
     *
     * @param s 起始顶点
     * @param t 结束顶点
     */
    public void addEdge(int s, int t) {
        //s 先于 t，边 s->t(s先删除后t才能删除，t依赖于s)
        adj[s].add(t);
    }

    /**
     * Kahn算法实现拓扑排序
     * Kahn 算法实际上用的是贪心算法思想，思路非常简单、好懂。
     * 定义数据结构的时候，如果 s 需要先于 t 执行，那就添加一条 s 指向 t 的边。
     * 所以，如果某个顶点入度为 0， 也就表示，没有任何顶点必须先于这个顶点执行，那么这个顶点就可以执行了。
     * <p>
     * 我们先从图中，找出一个入度为 0 的顶点，将其输出到拓扑排序的结果序列中（对应代码中就是把它打印出来），
     * 并且把这个顶点从图中删除（也就是把这个顶点可达的顶点的入度都减 1）。我们循环执行上面的过程，直到所有的顶点都被输出。
     * 最后输出的序列，就是满足局部依赖关系的拓扑排序。
     */
    public void topoSortByKahn() {
        //1.统计每个顶点的入度
        //初始化入度数组容器
        int[] inDegree = new int[v];
        //遍历填入
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                int w = adj[i].get(j);
                inDegree[w]++;
            }
        }

        //初始化待删除的顶点的队列
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < v; i++) {
            //如果相应的入度数组中的入度数为0,那么直接加入待删除的队列
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        //进行"删除"操作
        while (!queue.isEmpty()) {
            //删除队列中的入度为0的顶点
            int i = queue.remove();
            System.out.println(" -> " + i);

            //遍历被删除的顶点的邻接表
            for (int j = 0; j < adj[i].size(); j++) {
                //获取相应的被依赖顶点序号
                int k = adj[i].get(j);
                //将被依赖顶点的入度数减一
                inDegree[k]--;
                //判断是否入度为0，如果为0加入待删除的队列
                if (inDegree[k] == 0) queue.add(k);
            }
        }
    }

    /**
     * DFS算法
     * 深度优先遍历，遍历图中的所有顶点，而非只是搜索一个顶点到另一个顶点的路径。
     * 这个算法包含两个关键部分。
     * 1.第一部分是通过邻接表构造逆邻接表。
     * 邻接表中，边 s->t 表示 s 先于 t 执行，也就是 t 要依赖 s。在逆邻接表中，边 s->t 表示 s 依赖于 t，s 后于 t 执行。
     * 为什么这么转化呢？这个跟我们这个算法的实现思想有关。
     * 2.第二部分是这个算法的核心，也就是递归处理每个顶点。
     * 对于顶点 vertex 来说，我们先输出它可达的所有顶点，也就是说，先把它依赖的所有的顶点输出了，然后再输出自己。
     */
    public void topoSortByDFS() {
        //构建逆邻接表,边 s->t  表示s依赖于t，t先于s
        LinkedList<Integer> inverseAdj[] = new LinkedList[v];
        //申请空间
        for (int i = 0; i < v; i++) {
            inverseAdj[i] = new LinkedList<Integer>();
        }
        //通过邻接表生成逆邻接表
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                int w = adj[i].get(j);//i -> w
                inverseAdj[w].add(i);//w -> i
            }
        }

        boolean[] visited = new boolean[v];
        //深度优先遍历图
        for (int i = 0; i < v; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                dfs(i, inverseAdj, visited);
            }
        }
    }

    /**
     * 深度优先遍历
     *
     * @param vertex     顶点
     * @param inverseAdj 逆邻接表
     * @param visited    是否访问布尔数组
     */
    private void dfs(int vertex, LinkedList<Integer>[] inverseAdj, boolean[] visited) {
        for (int i = 0; i < inverseAdj[vertex].size(); i++) {
            int w = inverseAdj[vertex].get(i);
            if (visited[w] == true) continue;
            visited[w] = true;
            dfs(w, inverseAdj, visited);
        }// 先把 vertex 这个顶点可达的所有顶点都打印出来之后，再打印它自己

        System.out.println(" -> " + vertex);
    }
}
