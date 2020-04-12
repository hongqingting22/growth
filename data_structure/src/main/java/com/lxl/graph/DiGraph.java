package com.lxl.graph;

import com.lxl.linear.queue.QueueByLink;

/**
 * 有向图
 */
public class DiGraph {
    private int V;
    private int E;
    private QueueByLink<Integer>[] adj;

    public DiGraph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = new QueueByLink[V];
        for(int i = 0;i< adj.length;i++){
            adj[i] = new QueueByLink();
        }
    }

    public int v(){
        return V;
    }

    public int E(){
        return E;
    }

    /**
     * 添加由v指向w的边
     * @param v
     * @param w
     */
    public void addEdge(int v, int w){
        adj[v].enqueue(w);
        E++;
    }

    /**
     * 获取顶点v指出的边
     * @param v
     * @return
     */
    public QueueByLink<Integer> adj(int v){
        return adj[v];
    }

    /**
     * 生成有向图的反向图
     * @return
     */
    private DiGraph reverse(){
        DiGraph diGraph = new DiGraph(V);
        for(int v = 0;v < V;v++){
            for (Integer o : adj(v)) {//原图中v指出的边
                addEdge(o , v);//添加从v指出的顶点指向v的边
            }
        }
        return diGraph;
    }


}
