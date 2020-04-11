package com.lxl.graph;

import com.lxl.linear.queue.QueueByLink;

/**
 * 无向图
 * 顶点+边+每个顶点能到直接到达的顶点列表
 */
public class Graph {
    private int V;//顶点数量
    private int E;//边数量
    private QueueByLink<Integer>[] adj;//邻接表  存储每个顶点可达的邻接路径

    public Graph(int v) {
        V = v;
        this.E = 0;
        this.adj = new QueueByLink[V];
        for(int i = 0;i< v;i++){
            adj[i] = new QueueByLink<>();
        }
    }

    public int v(){
        return V;
    }

    public int e(){
        return E;
    }

    /**
     * 添加一条边
     * @param v
     * @param w
     */
    public void addEdge(int v,int w){
        //无向图中，需要向两个邻接表中添加值
        adj[v].enqueue(w);
        adj[w].enqueue(v);
        E++;
    }

    /**
     * 获取和顶点v相邻的所有顶点
     * @param v
     * @return
     */
    public  QueueByLink<Integer> adj(int v){
        return adj[v];
    }
}
