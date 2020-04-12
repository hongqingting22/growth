package com.lxl.linear.linkList.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现LRU算法
 * 最近最少使用
 * 使用双向链表，所有新使用的node放在队列头部
 */
public class LeastRecentlyUsedCache<K,V> {
    //可以快速查找缓存中是否含有key，并查找到结果
    private Map<K, NodeLinkedList<V>> keyNodeMap;
    //移除node信息时，可以快速将k移除
    private Map<NodeLinkedList<V>, K> nodeKeyMap;
    //结点中保存的是node信息
    private NodeLinkedList<V> head,tail;
    private int capacity;
    private int count;

    public LeastRecentlyUsedCache(int capacity) {
        this.keyNodeMap = new HashMap<>();
        this.nodeKeyMap = new HashMap<>();
        this.head = new NodeLinkedList<>(null,null,null);
        this.tail = null;
        this.capacity = capacity;
        this.count = 0;
    }

    public V get(K key){
        NodeLinkedList<V> node = keyNodeMap.get(key);
        if( node != null){
           //将该node放在队列头部
            moveToHead(node);
       }
        return null;
    }

    public void set(K key, V value){
        NodeLinkedList<V> node = keyNodeMap.get(key);
        if(node != null){
            node.value = value;
            moveToHead(node);
        }else{
            node = new NodeLinkedList<>(value, null, null);
            addNode(node);
            this.keyNodeMap.put(key, node);
            this.nodeKeyMap.put(node, key);
            if(count > capacity){
                removeNode(tail);
            }

        }
    }

    public void del(K key){
        NodeLinkedList<V> node = keyNodeMap.get(key);
        removeNode(node);
        this.keyNodeMap.remove(key);
    }

    public void addNode(NodeLinkedList node){
        if(tail == null){
            head.next = node;
            tail = node;
        }else{
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }
        this.count++;
    }

    public void removeNode(NodeLinkedList node){
        if(tail == node){
            node.pre.next = null;
            tail = node.pre;
            node.pre = null;
        }else{
            NodeLinkedList pre = node.pre;
            NodeLinkedList next = node.next;
            pre.next = next;
            next.pre = pre;

            node.next = null;
            node.pre = null;
        }
        //维护键值关系
        K k = this.nodeKeyMap.get(node);
        this.keyNodeMap.remove(k);
        this.nodeKeyMap.remove(node);
        this.count--;
    }

    public void moveToHead(NodeLinkedList node){
        NodeLinkedList pre = node.pre;
        NodeLinkedList next = node.next;

        pre.next = next;
        next.pre = pre;

        head.pre = node;
        node.next = head;
        node.pre = null;

        head = node;
    }

    class NodeLinkedList<V> {
        V value;
        NodeLinkedList pre;
        NodeLinkedList next;

        public NodeLinkedList( V value, NodeLinkedList pre, NodeLinkedList next) {
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }

}
