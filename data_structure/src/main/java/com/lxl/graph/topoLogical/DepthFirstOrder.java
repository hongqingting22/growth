package com.lxl.graph.topoLogical;

import com.lxl.graph.DiGraph;

import java.util.Stack;

/**
 * 深度优先顶点排序
 * 深度优先搜索，搜索完结点，结点入栈
 * 生成栈，满足栈顶元素是有向图路径中的首元素
 */
public class DepthFirstOrder {

    private boolean[] marked;
    //使用栈存储顶点序列
    private Stack<Integer> orderPath;

    public DepthFirstOrder(DiGraph graph) {
        int v = graph.v();
        marked = new boolean[v];

        this.orderPath = new Stack<>();
        for(int w = 0; w < v;w++){
            if(!marked[w]){
                dfs(graph,w);
            }
        }
    }

    private void dfs(DiGraph graph, int v){
        marked[v] = true;
        for (Integer w : graph.adj(v)) {
            if(!marked[w]){
                dfs(graph, w);
            }
        }
        orderPath.push(v);
    }

    public Stack<Integer> reversePost(){
        return orderPath;
    }
}
