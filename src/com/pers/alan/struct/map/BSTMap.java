package com.pers.alan.struct.map;

/**
 * @program: algoAndDataStruct
 * @description:
 * @author: wg
 * @create: 2019-09-18
 **/
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        K key;
        V value;
        Node left, right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return key.toString()+":"+value.toString();
        }
    }

    //二分搜索树的根节点
    private Node root;
    //二分搜索树的当前大小
    private int size;

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    //添加实现
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0)
            node.left = add(node.left, key, value);
        else if (key.compareTo(node.key) > 0)
            node.right = add(node.right, key, value);
        else //key.equals(node.key)
            node.value = value;
        return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    //二叉搜索树remove的实现，通过key来移除该Node，并返回该Node
    private Node remove(Node node, K key) {
        if (node == null)
            return null;

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            //key.compareTo(node.key) == 0
            if (node.left == null) {
                Node right = node.right;
                node.right = null;
                size--;
                return right;
            }
            if (node.right == null) {
                Node left = node.left;
                node.left = null;
                size--;
                return left;
            }

            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    //寻找以node为根节点的二叉搜索树的最小节点 此处指key最小
    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    //删除以node为根节点的二叉搜索树的最小节点
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node right = node.right;
            node.right = null;
            size--;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public boolean contains(K key) {
        Node node = getNode(root, key);
        if (node != null)
            return true;
        return false;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V valueN) {
        Node node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException("Node doesn't exist.Set failed.");
        node.value = valueN;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /*/*
     * @title
     * @description 辅助函数 通过key来寻找相应的Node
     * @author wg
     * @updateTime 2019/9/18
     * @return: com.pers.alan.struct.map.BSTMap<K,V>.Node
     * @throws
     */
    private Node getNode(Node node, K key) {
        if (node == null)
            return null;

        if (node.key.compareTo(node.key)==0)
            return node;
        else if (key.compareTo(node.key) < 0)
            node.left = getNode(node.left, key);
        else //key.compareTo(node.key)>0
            node.right = getNode(node.right, key);

        return node;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res = postOrder(root,res);
        return res.toString();
    }

    private StringBuilder postOrder(Node node,StringBuilder res) {
        if (node == null)
            return res;
        postOrder(node.left,res);
        postOrder(node.right,res);
        res.append(node.toString()+"--");
        return res;
    }

}
