package com.learn.datastructureandalgorithm.lesson28_heap;

/**
 * Created by XJH on 2019/2/19.
 *
 * @Description: 堆需要满足两个条件:
 * 1.是完全二叉树
 * 2.堆中每一个节点的值都必须大于等于（或小于等于）其子树中每个节点的值。
 * <p>
 * 在实际开发中，为什么快速排序要比堆排序性能好？
 * 第一点，堆排序数据访问的方式没有快速排序友好。
 * 第二点，对于同样的数据，在排序过程中，堆排序算法的数据交换次数要多于快速排序。
 */
public class Heap {
    //存储容器,数组,从下标1开始存储数据
    private int[] a;
    //堆可以存放的最大数据个数
    private int n;
    //堆中已经存储的数据个数
    private int count;

    public Heap(int capacity) {
        this.n = capacity;
        a = new int[capacity + 1];
        count = 0;
    }

    //建堆操作 O(n)而不是O(n*logn)
    //直接从第一个非叶子节点开始，依次堆化就行了
    private void buildHeap(int[] a, int n) {
        for (int i = n / 2; i >= 1; --i) {
            //对于完全二叉树来说，下标从 n/2 + 1 到 n 的节点都是叶子节点。
            heapify(a, n, i);
        }
    }

    //排序操作
    //这个过程有点类似上面讲的“删除堆顶元素”的操作，当堆顶元素移除之后，我们把下标为 n 的元素放到堆顶，然后再通过堆化的方法，
    //将剩下的 n−1 个元素重新构建成堆。堆化完成之后，我们再取堆顶的元素，放到下标是 n−1 的位置，
    //一直重复这个过程，直到最后堆中只剩下标为 1 的一个元素，排序工作就完成了。
    public void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            --k;
            heapify(a, k, 1);
        }
    }

    //插入元素
    public void insert(int data) {//大顶堆
        //堆满直接返回
        if (count >= n) return;

        ++count;
        a[count] = data;
        int i = count;
        //从下往上堆化,只要子节点比根节点大就进行交换
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            //交换数组下标为i和i/2的元素
            swap(a, i, i / 2);
            i = i / 2;
        }
    }

    //poll() 删除堆顶元素
    public void removeMax() {
        //如果堆中没有数据
        if (count == 0) return;
        //将最后个元素赋值给堆顶元素并向下堆化
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
    }

    //自上向下堆化
    //一个包含 nn 个节点的完全二叉树，树的高度不会超过 log2n。
    // 堆化的过程是顺着节点所在路径比较交换的，所以堆化的时间复杂度跟树的高度成正比，也就是 O(logn)
    private void heapify(int[] a, int count, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) maxPos = i * 2;
            if (i * 2 + 1 <= n && a[i] < a[i * 2 + 1]) maxPos = i * 2 + 1;
            if (maxPos == i) break;
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    //交换数组中的元素
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
