package com.lxl.linear.linkList;

/**
 * 翻转链表
 */
public class ReverseLinkList {

    /**
     * 递归旋转
     * 递归终止条件：最后一个节点
     * 例：翻转最后一个节点时，直接将该节点返回，此时栈内保留的当前节点为最后一个节点的前一个节点
     *          将栈内节点下个节点的next指向自己//反转指向
     *          将自己的next置为空
     *
     *         如：栈内节点 2    反转后的节点为3<-4
     *         则此时2指向3，需要完成的操作为  2->3   变为  2<-3
     *         两步：2.next.next = 2; --- 这里不能使用reverse，因为reverse此时为3<-4,即4
     *              2.next = null;
     *          则出栈后的结果为  2<-3<-4
     * @param node
     * @return
     */
    public static Node reverse(Node node){
        if(node == null || node.next == null)return node;
        Node next = node.next;
        Node reverse = reverse(next);
        node.next.next = node;
        node.next = null;
        return reverse;
    }

    /**
     * 使用pre，cur，next三个指针向后移动，修改指针的指向
     * @param node
     * @return
     */
    public static Node reverse2 (Node node){
        Node pre = null;
        Node cur = node;
        Node next;
        while (cur != null){
            next = cur.next;//记录下一个节点，便于cur向后移动
            cur.next = pre;//当前节点的next翻转，指向前一个节点
            //pre，cur向后移动
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node first = new Node(1,null);
        Node second = new Node(2,null);
        Node third = new Node(3,null);
        Node four = new Node(4,null);
        first.next = second;
        second.next = third;
        third.next = four;
        Node n = first;
//        while (n != null){
//            System.out.println(n.item);
//            n = n.next;
//        }
//        Node node = reverse2(n);
        Node node = reverse(n);
        while (node != null){
            System.out.println(node.item);
            node = node.next;
        }
    }

    static class Node{
        Integer item;
        Node next;

        public Node(Integer item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
