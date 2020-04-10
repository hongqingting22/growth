package com.lxl.linear.linkList;

/**
 * 快慢指针
 *      可以解决的问题：
 *          1.找到中间节点
 *          2.判断链表是否有环
 *          3.找到环的入口
 */
public class LinkListUseSlowFastPointer {

    public static void main(String[] args) {
        Node first = new Node(1,null);
        Node second = new Node(2,null);
        Node third = new Node(3,null);
        Node four = new Node(4,null);
        first.next = second;
        second.next = third;
        third.next = four;

        Integer mid = getMid(first);
        System.out.println(mid);

        System.out.println(hasCircle(first));

        four.next=second;
        System.out.println(hasCircle(first));

        System.out.println(getEntrance(first));
    }

    /**
     * 查找中间节点
     * @param node
     * @return
     */
    public static Integer getMid(Node<Integer> node){
        Node<Integer> slow = node;
        Node<Integer> fast = node;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.item;
    }

    /**
     * 判断链表是否有环
     * @param node
     * @return
     */
    public static boolean hasCircle(Node<Integer> node){
        Node<Integer> slow = node;
        Node<Integer> fast = node;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow.equals(fast))return true;
        }
        return false;
    }

    /**
     * 找到环的入口
     * @param node
     * @return
     */
    public static Integer getEntrance(Node<Integer> node){
        Node<Integer> slow = node;
        Node<Integer> fast = node;
        Node<Integer> temp = null;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow.equals(fast)){
                temp = node;
                continue;
            }

            if(temp != null){
                temp = temp.next;
                if(slow.equals(temp))
                    break;
            }
        }
        return temp.item;
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
