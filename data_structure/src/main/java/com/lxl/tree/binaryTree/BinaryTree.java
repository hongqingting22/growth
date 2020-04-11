package com.lxl.tree.binaryTree;


import com.lxl.linear.queue.QueueByLink;

/**
 * 使用链表实现二叉树
 * @param <K>
 * @param <V>
 */
public class BinaryTree<K extends Comparable<K>,V>{

    private Node root;
    private int N;

   class Node{
        Node left;
        Node right;
        K key;
        V value;

        public Node( K key, V value,Node left, Node right) {
            this.left = left;
            this.right = right;
            this.key = key;
            this.value = value;
        }
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void put(K key, V value){
        root = put(root, key, value);

    }

    public Node put(Node node, K key, V value){
        if(node == null){
            N++;
            return new Node(key, value,null, null);
        }
        int compare = key.compareTo(node.key);
        if(compare == 0){
            node.value = value;
        }else if(compare > 0){
            node.right = put(node.right, key, value);
        }else{
            node.left = put(node.left, key, value);
        }
        return node;
    }

    public V get(K key){
        return get(root, key);
    }

    public V get(Node node, K key){
        if(node == null)
            return null;
        int compare = key.compareTo(node.key);
        if(compare == 0){
            return node.value;
        }else if(compare > 0){
            return get(node.right, key);
        }else{
            return get(node.left, key);
        }
    }

    /**
     * 删除元素
     * 1.
     * @param key
     */
    public void delete(K key){
        delete(root, key);
    }

    /**
     * 删除结点内的key
     * 1.结点为空则无法删除
     * 2.如果key比当前节点key大，则从当前结点右子树中删除，当前结点的右子树等于删除后的右子树；
     *   如果key比当前结点key小，则从当前结点左子树中删除，当前结点的左子树等于删除后的左子树；
     *   如果key与当前结点key相等，则表示当前结点需要被删除
     *          如果当前结点只有左子树，则返回左子树；
     *          如果当前结点只有右子树，则返回右子树；
     *          如果当前结点有两个子树
     *              从右子树中找到最小元素作为当前结点左右子树的父结点
     *                  （需要保证左边结点都比该结点小，右侧结点都比该结点大
     *                          也可以找左子树的最大结点）
     *               步骤：1.找到右子树的最左结点
     *                      2.删除该结点
     *                      3.该结点左子树变为当前结点的左子树
     *                      4.该结点右子树变为当前结点右子树
     *                      5.当前结点变为该结点
     *                      6.返回当前结点（返回当前结点是已经维持树特性的新树）
     *
     * @param node
     * @param key
     * @return
     */
    public Node delete(Node node, K key){
        if(node == null)return null;
        N--;
        int compareTo = key.compareTo(node.key);
        if(compareTo > 0){
            node.right = delete(node.right, key);
        }else if(compareTo < 0){
            node.left = delete(node.left, key);
        }else{
            if(node.left == null){
                return node.right;
            }
            if(node.right == null){
                return node.left;
            }
            //找到右子树中最小元素
            Node rightMin = node.right;
            while (rightMin.left != null){
                rightMin = rightMin.left;
            }
            //删除右子树中最小元素
            Node n = node.right;
            while (n.left != null){
                if(n.left.left == null){
                    n.left = null;
                }else{
                    n = n.left;
                }
            }
            rightMin.left = node.left;
            rightMin.right = node.right;
            node = rightMin;

        }
        return node;
    }

    /**
     * 查找最小的键
     * @return
     */
    public K min(){
        Node min = min(root);
        if(min == null)return null;
        return min.key;
    }

    /**
     * 查找指定树中最小的键
     * @param node
     * @return
     */
    public Node min(Node node){
        if(node == null)return null;
        while (node.left != null){
            node = node.left;
        }
        return node;
    }

    /**
     * 查找树中找到最大的键
     * @return
     */
    public K max(){
        Node max = max(root);
        if(max == null)return null;
        return max.key;
    }

    /**
     * 在指定树中找到最大的键
     * @param node
     * @return
     */
    public Node max(Node node){
        if(node == null)return null;
        while (node.right != null){
            node = node.right;
        }
        return node;
    }

    /**
     * 前序遍历key,放入指定队列
     * @return
     */
    public QueueByLink<K> preErgodic(){
        QueueByLink<K> queues = new QueueByLink<>();
        preErgodic(root, queues);
        return queues;
    }

    public void preErgodic(Node node, QueueByLink<K> keys){
        if(node== null)return;
        keys.enqueue(node.key);
        preErgodic(node.left, keys);
        preErgodic(node.right, keys);
    }

    public QueueByLink<K> midErgodic(){
        QueueByLink<K> queues = new QueueByLink<>();
        midErgodic(root, queues);
        return queues;
    }

    public void midErgodic(Node node, QueueByLink<K> keys){
        if(node== null)return;
        midErgodic(node.left, keys);
        keys.enqueue(node.key);
        midErgodic(node.right, keys);
    }

    public QueueByLink<K> afterErgodic(){
        QueueByLink<K> queues = new QueueByLink<>();
        afterErgodic(root, queues);
        return queues;
    }

    public void afterErgodic(Node node, QueueByLink<K> keys){
        if(node== null)return;
        afterErgodic(node.left, keys);
        afterErgodic(node.right, keys);
        keys.enqueue(node.key);
    }

    /**
     * 层序遍历（广度优先）
     * 头结点放入辅助队列
     * 如果辅助队列不为空，出队列，出队列的元素放入结果集
     *  出队列的元素如果有左右子树，将左子树，右子树压入队列
     * @return
     */
    public QueueByLink<K> layerErgodic(){
        //中间队列
        QueueByLink<Node> queue = new QueueByLink<>();
        QueueByLink<K> result = new QueueByLink<>();
        queue.enqueue(root);
        while (queue.size() != 0){
            Node dequeue = queue.dequeue();
            result.enqueue(dequeue.key);
            if(dequeue.left != null)queue.enqueue(dequeue.left);
            if(dequeue.right != null)queue.enqueue(dequeue.right);
        }
        return result;
    }

    /**
     * 获取树的深度
     * @return
     */
    public int maxDepth(){
        return maxDepth(root);
    }

    /**
     * 结点的最大深度
     * 左节点和右节点的最大深度 + 1
     * @param node
     * @return
     */
    public int maxDepth(Node node){
        if(node == null)return 0;
        int leftMaxDepth = maxDepth(node.left);
        int rightMaxDepth = maxDepth(node.right);
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }


    public static void main(String[] args) {
        BinaryTree<String,String> tree = new BinaryTree<>();
        tree.put("E","5");
        tree.put("B","2");
        tree.put("G","7");
        tree.put("A","1");
        tree.put("D","4");
        tree.put("F","6");
        tree.put("H","8");
        tree.put("C","3");
        System.out.println(tree.size());
        System.out.println(tree.get("G"));
        System.out.println(tree.max());
        System.out.println(tree.min());
        tree.delete("H");
        System.out.println(tree.get("H"));
        System.out.println(tree.size());
        System.out.println("------------------------------");
        QueueByLink<String> preErgodic = tree.preErgodic();
        for(String key : preErgodic){
            System.out.println(key + ":" + tree.get(key));
        }
        System.out.println("------------------------------");
        QueueByLink<String> midErgodic = tree.midErgodic();
        for(String key : midErgodic){
            System.out.println(key + ":" + tree.get(key));
        }

        System.out.println("------------------------------");
        QueueByLink<String> afterErgodic = tree.afterErgodic();
        for(String key : afterErgodic){
            System.out.println(key + ":" + tree.get(key));
        }

        System.out.println("--------------------------------");
        QueueByLink<String> queue = tree.layerErgodic();
        for(String key : queue){
            System.out.println(key);
        }

        System.out.println("--------------------------------");
        System.out.println(tree.maxDepth());
    }
}
