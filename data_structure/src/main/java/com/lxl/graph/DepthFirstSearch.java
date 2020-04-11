package com.lxl.graph;

/**
 * 深度优先搜索
 */
public class DepthFirstSearch {
    //索引代表顶点，值表示该顶点是否已经被搜索
    private boolean[] marked;
    //记录有多少个顶点与s顶点想通
    private int count;

    //获取图graph中s顶点所有的相邻顶点
    public DepthFirstSearch(Graph graph, int s) {
        this.marked = new boolean[graph.v()];
        this.count = 0;
        dfs(graph, s);

    }
    //深度优先搜索顶点v所有相通的顶点
    private void dfs(Graph graph, int v){
        marked[v] = true;
        for (Integer w : graph.adj(v)){
            if(!marked[w]){
                dfs(graph, w);
            }
        }
        count++;//每搜索一个
    }

    /**
     * 判断w与顶点s是否相通
     * @param w
     * @return
     */
    public boolean marked(int w){
        return marked[w];
    }

    /**
     * 查找顶点s相通的顶点个数
     * @return
     */
    public int count(){
        return count;
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
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph, 0);

        System.out.println(depthFirstSearch.count);

        System.out.println(depthFirstSearch.marked(10));

        System.out.println(depthFirstSearch.marked(6));
    }
}
