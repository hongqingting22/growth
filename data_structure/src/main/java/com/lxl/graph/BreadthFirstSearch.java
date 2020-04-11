package com.lxl.graph;

import com.lxl.linear.queue.QueueByLink;

import java.util.Arrays;

/**
 * 广度优先搜索
 */
public class BreadthFirstSearch {

    private boolean[] marked;

    private int count;
    //存储待搜索的顶点
    private QueueByLink<Integer> waitSearch;

    public BreadthFirstSearch(Graph graph, int s) {
        this.marked = new boolean[graph.v()];
        this.count = 0;
        this.waitSearch = new QueueByLink<>();
        bfs(graph, s);
    }

    public void bfs(Graph graph, int v){
        marked[v] = true;
        for (Integer w : graph.adj(v)) {
            if(!marked[w]){
                waitSearch.enqueue(w);
            }
        }
        while (!waitSearch.isEmpty()){
            Integer dequeue = waitSearch.dequeue();
            bfs(graph, dequeue);
        }
        count++;
    }

    public boolean marked(int w){
        return marked[w];
    }

    public int count(){
        return count;
    }

    @Override
    public String toString() {
        return "BreadthFirstSearch{" +
                "marked=" + Arrays.toString(marked) +
                ", count=" + count +
                ", waitSearch=" + waitSearch +
                '}';
    }

    public static void main(String[] args) {
        //构造图
        Graph graph = new Graph(13);
        graph.addEdge(0,5);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,6);
        graph.addEdge(4,5);
        graph.addEdge(5,3);
        graph.addEdge(4,3);
        graph.addEdge(4,6);

        graph.addEdge(7,8);
        graph.addEdge(9,10);
        graph.addEdge(9,11);
        graph.addEdge(9,12);
        graph.addEdge(11,12);
        //构造搜索对象
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph, 0);

        System.out.println(breadthFirstSearch);
        System.out.println(breadthFirstSearch.count());

        System.out.println(breadthFirstSearch.marked(10));

        System.out.println(breadthFirstSearch.marked(6));
    }
}
