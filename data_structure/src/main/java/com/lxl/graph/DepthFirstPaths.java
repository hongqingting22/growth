package com.lxl.graph;

import java.util.Stack;

/**
 * 深度优先搜索，查找路径
 */
public class DepthFirstPaths {
    //索引值表示顶点，标记顶点是否被搜索过
    private boolean[] marked;
    //起点
    private int s;
    //索引代表顶点，值代表从起点s到当前顶点路径上的最后一个顶点
    private int[] edgeTo;

    public DepthFirstPaths(Graph graph, int s) {
        this.marked = new boolean[graph.v()];
        this.s = s;
        this.edgeTo = new int[graph.v()];
        dfs(graph, s);
    }

    /**
     * 深度优先搜索填充属性值
     * @param graph
     * @param s
     */
    private void dfs(Graph graph, int s){
        marked[s] = true;
        for (Integer w : graph.adj(s)) {
            if(!marked[w]){
                edgeTo[w] = s;
                dfs(graph, w);
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Stack<Integer> pathTo(int v){
        if(!hasPathTo(v))return null;
        Stack<Integer> stack = new Stack<>();

        for(int x = v;x != s;x = edgeTo[x]){
            stack.push(x);
        }
        stack.push(s);
        return stack;
    }

    public static void main(String[] args) {
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

        DepthFirstPaths depthFirstPaths = new DepthFirstPaths(graph, 0);

        System.out.println( depthFirstPaths.hasPathTo(6));
        System.out.println(depthFirstPaths.pathTo(6));
    }
}
