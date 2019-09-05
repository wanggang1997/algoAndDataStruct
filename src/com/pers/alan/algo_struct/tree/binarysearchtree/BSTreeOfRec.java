package com.pers.alan.algo_struct.tree.binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: algoAndDataStruct
 * @description: 二叉搜索树递归实现
 * @author: wgg
 * @create: 2019-08-23 16:46
 **/
@SuppressWarnings("unchecked")
public class BSTreeOfRec<Key extends Comparable, Value> {
    private Node root;
    private int count;

    //内部类 节点
    private class Node {
        private Key key;
        private Value value;
        private Node leftNode, rightNode;

        Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.leftNode = null;
            this.rightNode = null;
        }

        @Override
        public String toString() {
            return "[node{" + key + ":" + value + "}]";
        }
    }

    //包含该key?
    boolean contain(Key key) {
        return contain(root, key);
    }

    //寻找该key对应的calue
    Value search(Key key) {
        return search(root, key);
    }


    //获得整棵树的节点数
    public int size() {
        return count;
    }

    //
    public boolean isEmpty() {
        return count == 0;
    }

    //递归版insert
    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    //前序遍历
    public void preOrder() {
        preOrder(root);
    }

    //中序遍历
    public void inOrder() {
        inOrder(root);
    }

    //后序遍历
    public void postOrder() {
        postOrder(root);
    }

    //寻找最小值节点
    public Node minimum() {
        return minimum(root);
    }

    //寻找最大值节点
    public Node maximum() {
        return maximum(root);
    }

    //删除最小节点(key)
    public void removeMin() {
        if (root != null)
            root = removeMin(root);
    }

    public void removeMax() {
        if (root != null)
            root = removeMax(root);
    }

    public void remove(Key key) {
        remove(root, key);
    }


    /*/**
     * @title
     * @description 层序遍历 此处的队列使用链表
     * @author wg
     * @updateTime 2019/8/29 20:39
     * @throws
     */
    public void levelOrder() {
        Queue<Node> nodeQueue = new LinkedList<Node>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            Node node = nodeQueue.remove();
            System.out.println(node);

            if (node.leftNode != null)
                nodeQueue.offer(node.leftNode);
            if (node.rightNode != null)
                nodeQueue.offer(node.rightNode);
        }
    }


    /*/**
     * @title
     * @description 二叉搜索树递归实现 注意引用传递 防止空指针
     * @author wg
     * @param: current
     * @param: key
     * @param: data
     * @updateTime 2019/8/29 17:58
     * @return: com.pers.algo.nographic.tree.binarysearchtree.BSTreeOfRec<Key,Value>.Node
     * @throws
     */
    private Node insert(Node node, Key key, Value value) {
        if (node == null) {
            Node c = new Node(key, value);
            count++;
            return c;
        }
        if (key.compareTo(node.key) < 0) {
            node.leftNode = insert(node.leftNode, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.rightNode = insert(node.rightNode, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    //
    private boolean contain(Node node, Key key) {
        if (node == null)
            return false;

        if (key == node.key)
            return true;
        else if (key.compareTo(node.key) < 0)
            return contain(node.leftNode, key);
        else
            return contain(node.rightNode, key);
    }

    //
    private Value search(Node node, Key key) {

        if (node == null)
            return null;

        if (key == node.key)
            return node.value;
        else if (key.compareTo(node.key) < 0)
            return search(node.leftNode, key);
        else
            return search(node.rightNode, key);
    }

    //
    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(node);
            preOrder(node.leftNode);
            preOrder(node.rightNode);
        }
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.leftNode);
            System.out.println(node);
            inOrder(node.rightNode);
        }
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.leftNode);
            postOrder(node.rightNode);
            System.out.println(node);
        }
    }

    /*/**
     * @title
     * @description
     * @author wg
     * @param: root
     * @updateTime 2019/8/31 10:06
     * @return: Key
     * @throws
     */
    private Node minimum(Node node) {

        if (node.leftNode == null)
            return node;
        else
            return minimum(node.leftNode);
    }

    /*/**
     * @title
     * @description
     * @author wg
     * @param: root
     * @updateTime 2019/8/31 10:08
     * @return: Key
     * @throws
     */
    private Node maximum(Node node) {
        if (node.rightNode == null)
            return node;
        else
            return maximum(node.rightNode);
    }

    /*/**
     * @title
     * @description 删除以node为根的树的最小节点 返回新的树的根节点
     * @author wg
     * @param: root
     * @updateTime 2019/8/31 10:10
     * @return: com.pers.algo.nographic.tree.binarysearchtree.BSTreeOfRec<Key,Value>.Node
     * @throws
     */
    private Node removeMin(Node node) {
        if (node.leftNode == null) {
            Node rightNode = node.rightNode;
            node = null;
            count--;
            return rightNode;
        }
        node.leftNode = removeMin(node.leftNode);
        return node;
    }

    /*/**
     * @title
     * @description 删除以node为根的树的最大节点 返回新的树的根节点
     * @author wg
     * @param: root
     * @updateTime 2019/8/31 10:12
     * @return: com.pers.algo.nographic.tree.binarysearchtree.BSTreeOfRec<Key,Value>.Node
     * @throws
     */
    private Node removeMax(Node node) {
        if (node.rightNode == null) {
            Node leftNode = node.leftNode;
            node = null;
            count--;
            return leftNode;
        }
        node.rightNode = removeMax(node.rightNode);
        return node;
    }

    /*/**
     * @title
     * @description 删除任意节点 分多种情况讨论
     *              核心：将要删除的节点 用前驱或者后驱代替
     *              注意维护count的值
     * @author wg
     * @param: root
     * @param: key
     * @updateTime 2019/8/31 11:26
     * @throws
     */
    private Node remove(Node node, Key key) {
        if (node == null)
            return null;
        else if (key.compareTo(node.key) < 0) {
            node.leftNode = remove(node.leftNode, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.rightNode = remove(node.rightNode, key);
            return node;
        } else {
            if (node.leftNode == null) {
                Node rightNode = node.rightNode;
                node = null;
                count--;
                return rightNode;
            }
            if (node.rightNode == null) {
                Node leftNode = node.leftNode;
                node = null;
                count--;
                return leftNode;
            }
                Node successor = minimum(node.rightNode);
                count++;
                successor.rightNode = removeMin(node.rightNode);
                successor.leftNode = node.leftNode;
                node=null;
                count--;
                return successor;
        }
    }




}
