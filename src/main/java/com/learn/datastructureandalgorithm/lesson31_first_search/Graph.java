package com.learn.datastructureandalgorithm.lesson31_first_search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by XJH on 2019/2/15.
 *
 * @Description:
 */
public class Graph {
    private int v;
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];

        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    //无向图一条边存两次
    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * bfs(Breadth-First-Search)
     * 地毯式”层层推进的搜索策略，即先查找离起始顶点最近的，然后是次近的，依次往外搜索
     * 我们搜索一条从 s 到 t 的路径。实际上，这样求得的路径就是从 s 到 t 的最短路径。
     *
     * @param s 起始顶点
     * @param t 结束顶点
     */
    public void bfs(int s, int t) {
        if (s == t) return;
        //初始化已访问顶点布尔数组
        //visited是用来记录已经被访问的顶点，用来避免顶点被重复访问。如果顶点 q 被访问，那相应的 visited[q] 会被设置为 true。
        boolean[] visited = new boolean[v];
        visited[0] = true;

        //queue是一个队列，用来存储已经被访问、但相连的顶点还没有被访问的顶点。
        //因为广度优先搜索是逐层访问的，也就是说，我们只有把第 k 层的顶点都访问完成之后，才能访问第 k+1 层的顶点。
        //当我们访问到第 k 层的顶点的时候，我们需要把第 k 层的顶点记录下来，稍后才能通过第 k 层的顶点来找第 k+1 层的顶点。
        //所以，我们用这个队列来实现记录的功能。
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(s);

        //prev用来记录搜索路径。当我们从顶点 s 开始，广度优先搜索到顶点 t 后，prev 数组中存储的就是搜索的路径。
        //不过，这个路径是反向存储的。prev[w] 存储的是，顶点 w 是从哪个前驱顶点遍历过来的。
        //比如，我们通过顶点 2 的邻接表访问到顶点 3，那 prev[3] 就等于 2。
        //为了正向打印出路径，我们需要递归地来打印，你可以看下 print() 函数的实现方式。
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }

        while (!queue.isEmpty()) {
            //@return the head of this queue, or {@code null} if this queue is empty
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                //获取邻接顶点
                int q = adj[w].get(i);
                //如果邻接顶点没有被访问过
                if (!visited[q]) {
                    //设置此顶点的前置顶点
                    prev[q] = w;

                    //如果已搜索到目标顶点
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }

                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    //递归打印s->t的路径
    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.println(t + " ");
    }

    //全局变量或者类成员变量,标识是否已找到出口
    boolean found = false;

    /**
     * 深度优先搜索（Depth-First-Search），简称 DFS。最直观的例子就是“走迷宫”
     *
     * @param s 起始顶点(入口)
     * @param t 结束顶点(出口 )
     */
    public void dfs(int s, int t) {
        found = false;

        boolean[] visited = new boolean[v];

        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }

        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    //dfs搜索递归调用
    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found == true) return;
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }

        for (int i = 0; i < adj[w].size(); i++) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }
}
