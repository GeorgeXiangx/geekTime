package com.learn.datastructureandalgorithm.lesson44_shortest_path_algorithm;

import java.util.LinkedList;

/**
 * Created by XJH on 2019/2/18.
 *
 * @Description: 有向带权图  迪杰斯特拉算法(Dijkstra)
 */
public class Graph {
    //邻接表
    private LinkedList<Edge> adj[];
    //顶点个数
    private int v;

    public Graph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            this.adj[i] = new LinkedList<Edge>();
        }
    }

    //边
    private class Edge {
        //边的起始顶点编号
        public int sid;
        //边的结束顶点编号
        public int tid;
        //边的权重
        public int w;

        public Edge(int sid, int tid, int w) {
            this.sid = sid;
            this.tid = tid;
            this.w = w;
        }
    }

    //顶点 为了 dijkstra 实现用的
    private class Vertex {
        //        java.util.PriorityQueue
        //顶点编号(前趋顶点的编号)
        public int id;
        //从起始顶点到这个顶点的距离
        public int dist;

        public Vertex(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }

    // 因为 Java 提供的优先级队列，没有暴露更新数据的接口，所以我们需要重新实现一个
    private class PriorityQueue { // 根据 vertex.dist 构建小顶堆
        //优先队列中的顶点元素
        private Vertex[] nodes;
        //个数
        private int count;

        public PriorityQueue(int v) {
            this.nodes = new Vertex[v + 1];
            this.count = v;
        }


        //删除堆顶元素并返回
        public Vertex poll() { // TODO: 留给读者实现
            //1.将第一个数组数据和最后一个数据交换,并将数组最后的元素返回后删除
            //2.从上向下堆化
            return new Vertex(1, 1);
        }

        //添加元素
        public void add(Vertex vertex) { // TODO: 留给读者实现
            //添加到数组最后,然后依次从下往上堆化
        }

        // 更新结点的值，并且从下往上堆化，重新符合堆的定义。时间复杂度 O(logn)。
        public void update(Vertex vertex) { // TODO: 留给读者实现
            //如果跟新后的值比父节点还小就向上堆化
            //如果跟新后的值比父节点大就向下堆化
        }

        //判断优先队列是否为空
        public boolean isEmpty() { // TODO: 留给读者实现
            return nodes.length == 0 ? true : false;
        }
    }

    public void dijkstra(int s, int t) { // 从顶点 s 到顶点 t 的最短路径
        int[] predecessor = new int[this.v]; // 用来还原最短路径
        //我们用 vertexes 数组，记录从起始顶点到每个顶点的距离（dist）
        Vertex[] vertexes = new Vertex[this.v];
        for (int i = 0; i < this.v; ++i) {
            //我们把所有顶点的 dist 都初始化为无穷大（也就是代码中的 Integer.MAX_VALUE）
            vertexes[i] = new Vertex(i, Integer.MAX_VALUE);
        }
        PriorityQueue queue = new PriorityQueue(this.v);// 小顶堆
        boolean[] inqueue = new boolean[this.v]; // 标记是否进入过队列

        //我们把起始顶点的 dist 值初始化为 0，然后将其放到优先级队列中
        vertexes[s].dist = 0;
        queue.add(vertexes[s]);
        inqueue[s] = true;

        while (!queue.isEmpty()) {
            Vertex minVertex = queue.poll(); // 取堆顶元素并删除
            if (minVertex.id == t) break; // 最短路径产生了

            for (int i = 0; i < adj[minVertex.id].size(); ++i) {
                Edge e = adj[minVertex.id].get(i); // 取出一条 minVetex 相连的边
                Vertex nextVertex = vertexes[e.tid]; // minVertex-->nextVertex

                //如果有更短的路径
                if (minVertex.dist + e.w < nextVertex.dist) {
                    // 更新 next 的 dist
                    nextVertex.dist = minVertex.dist + e.w;
                    predecessor[nextVertex.id] = minVertex.id;

                    //如果入过队列，则更新
                    if (inqueue[nextVertex.id] == true) {
                        queue.update(nextVertex); // 更新队列中的 dist 值
                    } else {//否则则添加
                        queue.add(nextVertex);
                        inqueue[nextVertex.id] = true;
                    }
                }
            }
        }
        // 输出最短路径
        System.out.print(s);
        print(s, t, predecessor);
    }

    private void print(int s, int t, int[] predecessor) {
        if (s == t) return;
        print(s, predecessor[t], predecessor);
        System.out.print("->" + t);
    }

}
