package com.lxl.tree.binaryTree;

import java.util.Scanner;

/**
 * 并查集
 */
public class UF {
    private int[] eleAndGroup;//索引代表元素，值代表组标
    private int count;

    public UF(int count) {
        this.count = count;
        eleAndGroup = new int[10];
        for(int i = 0; i< count;i++){
            eleAndGroup[i] = i;
        }
    }

    public int size(){
        return count;
    }

    public int find(int p){
        return eleAndGroup[p];
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public void union(int p ,int q){
        if(connected(p, q))return;
        int pGroup = find(p);
        int qGroup = find(q);
        for(int i = 0;i<eleAndGroup.length;i++){
            if(eleAndGroup[i] == pGroup){
                eleAndGroup[i] = qGroup;
            }
        }
        count--;
    }

    public static void main(String[] args) {
        UF uf = new UF(10);
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("目前分组为：" + uf.size());
            System.out.println("请输入合并的元素：");
            int i = scanner.nextInt();
            System.out.println("请输入：");
            int i1 = scanner.nextInt();

            uf.union(i, i1);
            System.out.println("合并完毕，分组为：" + uf.size());
        }
    }
}
