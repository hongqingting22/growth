package com.lxl.linear.linkList;

/**
 * 约瑟夫问题
 *      使用循环链表
 */
public class JosephLink {

    public static void main(String[] args) {
        //构建约瑟夫环
        Node<Integer> first = null;
        Node<Integer> pre = null;
        Node<Integer> node = null;
        for(int i = 1;i<=41;i++){
            //第一个节点
            if(i == 1){
                first = new Node(Integer.valueOf(i), null);
                pre = first;
            }else if(i == 41){
                //最后一个节点
                node = new Node(Integer.valueOf(i), first);
                pre.next = node;
            }else {
                //其他节点
                node = new Node(Integer.valueOf(i), null);
                pre.next = node;
                pre = node;
            }

        }

        Node<Integer> yueSefu = first;
//        while (yueSefu != null){
//            yueSefu = yueSefu.next;
//            System.out.println(yueSefu.item);
//        }

        print(yueSefu, 3);
    }

    public static void print(Node<Integer> node,int jump){
        int count = 0;
        Node<Integer> pre = null;
        Node<Integer> cur = node;
        Node<Integer> next;
        while (cur != cur.next){
            //=3时，前一节点的next指向下一节点；！=3时，前一节点向后移动到当前节点
            if(++count == jump){
                count = 0;
                //当前节点移除
                //找到下一个节点
                next = cur.next;
                //当前节点的next指向null
//                cur.next = null;
                //前一节点的next指向下一节点
                pre.next = next;
                System.out.println(cur.item);
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        System.out.println(cur.item);
    }

    static class Node<T> {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
