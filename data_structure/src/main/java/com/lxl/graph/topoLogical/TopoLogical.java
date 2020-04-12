package com.lxl.graph.topoLogical;

import com.lxl.graph.DiGraph;

import java.util.Stack;

/**
 * 拓扑排序
 * 有环则无法进行排序，无环时生成排序队列
 */
public class TopoLogical {
    private Stack<Integer> order;

    public TopoLogical(DiGraph graph) {
        DiectedCycle cycle = new DiectedCycle(graph);
        if(!cycle.hasCycle()){
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(graph);
            order = depthFirstOrder.reversePost();
        }
    }

    public boolean isCycle(){
        return order == null;
    }

    public Stack<Integer> order(){
        return order;
    }

    public static void main(String[] args) {
        DiGraph diGraph = new DiGraph(6);
        diGraph.addEdge(0,2);
        diGraph.addEdge(0,3);
        diGraph.addEdge(2,4);
        diGraph.addEdge(3,4);
        diGraph.addEdge(4,5);
        diGraph.addEdge(1,3);

        TopoLogical topoLogical = new TopoLogical(diGraph);
        boolean cycle = topoLogical.isCycle();
        System.out.println(cycle);
        Stack<Integer> order = topoLogical.order();
        StringBuilder str = new StringBuilder();
        for (Integer w : order) {
            str.append(w + "<-");
        }
        String s = str.toString();
        int index = s.lastIndexOf("<-");
        s = s.substring(0, index);
        System.out.println(s);

    }
}
