package com.pers.alan.struct.map;

/**
 * @program: algoAndDataStruct
 * @description: Map的LinkedList实现
 * @author: wg
 * @create: 2019-09-17
 **/
public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node {
        private K key;
        private V value;
        private Node next;

        public Node(K key, V value, Node node) {
            this.key = key;
            this.value = value;
            this.next = node;
        }

        public Node(K key, V value) {
            this(key, value, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            res.append(key +":"+value);
            return res.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        this.dummyHead = new Node();
        this.size = 0;
    }

    /*/*
     * @title
     * @description 辅助函数 通过key来寻找相应Node
     * @author wg
     * @param: key
     * @updateTime 2019/9/17
     * @return: com.pers.alan.struct.map.LinkedListMap<K,V>.Node
     * @throws
     */
    private Node getNode(K key){
        Node pre = dummyHead;
        while (pre.next!=null){
            if (pre.next.key.equals(key))
                return pre.next;
            pre = pre.next;
        }
        return null;
    }


    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size==0;
    }

    @Override
    public boolean contains(K key) {
        Node node = getNode(key);
        return node != null;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node==null){
            dummyHead.next = new Node(key,value,dummyHead.next);
            size++;
        }
        else
            node.value = value;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node==null?null:node.value;
    }

    @Override
    public void set(K key, V valueN) {
        Node node = getNode(key);
        if (node==null)
            throw new IllegalArgumentException("The key doesn't exist.Set failed.");
        else
            node.value = valueN;
    }

    @Override
    public V remove(K key) {
        if (!contains(key))
            throw new IllegalArgumentException("The key doesn't exist.Remove failed.");
        Node pre = dummyHead;
        while (pre.next!=null){
            if (pre.next.key.equals(key))
                break;
            pre = pre.next;
        }

        if (pre.next!=null){
            Node delNode = pre.next;
            pre.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("dummyHead -> ");
        Node cur = dummyHead.next;
        while (cur!=null){
            res.append(cur).append(" -> ");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
