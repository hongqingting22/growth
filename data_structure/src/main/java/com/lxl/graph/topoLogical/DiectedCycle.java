package com.lxl.graph.topoLogical;

import com.lxl.graph.DiGraph;

/**
 * 检测有向图中是否有环
 * 搜索顶点时标记为正在搜索，深度优先方法搜索该顶点可达的其他顶点，
 *      如果搜索过程中出现已经被标记为"正在搜索"的顶点，则表明有环；
 * 顶点搜索结束后，需要将该顶点正在搜索标记清除
 */
public class DiectedCycle {
    //索引代表顶点，值代表该顶点是否已经被搜索
    private boolean[] marked;
    //记录图中是否有环
    private boolean hasCycle;
    //索引代表顶点，值代表该顶点是否已经处于正在搜索的有向路径上
    private boolean[] onSearch;

    public DiectedCycle(DiGraph graph) {
        int v = graph.v();
        this.marked = new boolean[v];
        this.hasCycle = false;
        this.onSearch = new boolean[v];

        //找到图中每个顶点，让每个顶点作为入口，计算该顶点路径上是否存在环
        for(int w = 0 ;w< v;w++){
            if(!marked[w]){
                dfs(graph, w);
            }
        }
    }

    private void dfs(DiGraph graph, int v){
        marked[v] = true;
        //当前结点记录正在搜索路径中
        onSearch[v] = true;

        for (Integer w : graph.adj(v)) {
            if(!marked[w]){
                dfs(graph, w);
            }
            //如果w已经存在在路径上，表示已经出现环
            if(onSearch[w]){
                hasCycle = true;
                return;
            }
        }
        //v搜索完毕之后，将v从搜索路径上移除
        onSearch[v] = false;
    }
    //判断有向图中是否有环
    public boolean hasCycle(){
        return hasCycle;
    }

}
