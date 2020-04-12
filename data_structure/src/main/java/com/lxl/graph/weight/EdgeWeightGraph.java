package com.lxl.graph.weight;

import com.lxl.linear.queue.QueueByLink;

/**
 * 加权无向图
 */
public class EdgeWeightGraph {

    private final int V;
    private int E;
    private QueueByLink<Edge>[] adj;//索引为顶点，记录顶点所有邻接边

    public EdgeWeightGraph(int v) {
        this.V = v;
        this.E = 0;
        this.adj = new QueueByLink[v];
        for(int i = 0;i< v;i++){
            adj[i] = new QueueByLink<>();
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    /**
     * 添加边
     * @param e
     */
    public void addEdge(Edge e){
        int v = e.getV();
        int w = e.getW();
        adj[v].enqueue(e);
        adj[w].enqueue(e);
        E++;
    }

    /**
     * 获取顶点v的边
     * @param v
     * @return
     */
    public QueueByLink<Edge> adj(int v){
        return adj[v];
    }

    public QueueByLink<Edge> edges(){
        QueueByLink<Edge> allEdges = new QueueByLink<>();
        for(int w = 0;w< V;w++){
            QueueByLink<Edge> adj = adj(w);
            for (Edge edge : adj) {
                if(edge.getV() > w){
                    allEdges.enqueue(edge);
                }
            }
        }
        return allEdges;
    }
}
