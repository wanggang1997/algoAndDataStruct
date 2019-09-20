package com.pers.alan.struct.tree;

import com.pers.alan.struct.queue.LinkedListQueue;
import com.pers.alan.struct.queue.Queue;
import com.pers.alan.struct.stack.LinkedListStack;
import com.pers.alan.struct.stack.Stack;

/**
 * @program: algoAndDataStruct
 * @description:
 * @author: wg
 * @create: 2019-09-10
 **/
public class BST<E extends Comparable<E>> {

    private class Node {
        private E e;
        private Node leftNode, rightNode;

        public Node() {
        }

        public Node(E e) {
            this.e = e;
            this.leftNode = this.rightNode = null;
        }

    }

    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    /*/**
     * @title
     * @description
     * @author wg
     * @param: node
     * @param: e
     * @updateTime 2019/9/10
     * @return: com.pers.wgdemo.struct.tree.BST<E>.Node
     * @throws
     */
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.leftNode = add(node.leftNode, e);
        }
        if (e.compareTo(node.e) > 0) {
            node.rightNode = add(node.rightNode, e);
        }
        return node;
    }


    /*/**
     * @title
     * @description
     * @author wg
     * @param: e
     * @updateTime 2019/9/11
     * @return: boolean
     * @throws
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {

        if (node == null)
            return false;

        if (e.equals(node.e))
            return true;
        else if (e.compareTo(node.e) < 0)
            return contains(node.leftNode, e);
        else //(e.compareTo(node.e)>0)
            return contains(node.rightNode, e);
    }


    /*/**
     * @title
     * @description
     * @author wg
     * @updateTime 2019/9/11
     * @throws
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null)
            return;
        System.out.print(node.e + " ");
        preOrder(node.leftNode);
        preOrder(node.rightNode);
    }

    /*/**
     * @title
     * @description
     * @author wg
     * @updateTime 2019/9/11
     * @throws
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.leftNode);
        System.out.print(node.e + " ");
        inOrder(node.rightNode);
    }

    /*/**
     * @title
     * @description
     * @author wg
     * @updateTime 2019/9/11
     * @throws
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.leftNode);
        postOrder(node.rightNode);
        System.out.print(node.e + " ");
    }


    /*/**
     * @title
     * @description 前序遍历非递归实现
     * @author wg
     * @updateTime 2019/9/11
     * @throws
     */
    public void preOrderNoRec() {
        Stack<Node> stack = new LinkedListStack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.print(cur.e + " ");
            if (cur.rightNode != null)
                stack.push(cur.rightNode);
            if (cur.leftNode != null)
                stack.push(cur.leftNode);
        }
    }

    public void levelOrder() {
        Queue<Node> queue = new LinkedListQueue<>();
        queue.enQueue(root);

        while (!queue.isEmpty()) {
            Node cur = queue.deQueue();
            System.out.print(cur.e + " ");
            if (cur.leftNode != null)
                queue.enQueue(cur.leftNode);
            if (cur.rightNode != null)
                queue.enQueue(cur.rightNode);
        }
    }

    /*
     * @title
     * @description 寻找最小元素
     * @author wg
     * @updateTime 2019/9/11
     * @return: E
     * @throws
     */
    public E minimum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty.");
        return minimum(root).e;
    }


    private Node minimum(Node node) {
        if (node.leftNode == null)
            return node;
        return minimum(node.leftNode);
    }

    /*
     * @title
     * @description
     * @author wg
     * @updateTime 2019/9/11
     * @return: E
     * @throws
     */
    public E maximum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty.");
        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if (node.rightNode == null)
            return node;
        return maximum(node.rightNode);
    }


    /*/*
     * @title
     * @description
     * @author wg
     * @updateTime 2019/9/11
     * @throws
     */
    public E removeMin() {
        E res = minimum();
        removeMin(root);
        return res;
    }

    /*/*
     * @title
     * @description 删掉以node为根的bst的最小节点
     *              返回删除节点后的bst的根节点
     *
     * @author wg
     * @param: node
     * @updateTime 2019/9/11
     * @return: com.pers.wgdemo.struct.tree.BST<E>.Node
     * @throws
     */
    private Node removeMin(Node node) {
        //用于最小节点存在右子树的场景
        //将mini节点的右子树的根节点返回给mini节点的父节点
        //注意递归结束条件
        if (node.leftNode == null) {
            Node rightNode = node.rightNode;
            node.rightNode = null;
            size--;
            return rightNode;
        }
        node.leftNode = removeMin(node.leftNode);
        return node;
    }


    /*/*
     * @title
     * @description
     * @author wg
     * @updateTime 2019/9/11
     * @return: E
     * @throws
     */
    public E removeMax() {
        E res = maximum();
        removeMax(root);
        return res;
    }

    /*/*
     * @title
     * @description
     * @author wg
     * @param: node
     * @updateTime 2019/9/11
     * @return: com.pers.wgdemo.struct.tree.BST<E>.Node
     * @throws
     */
    private Node removeMax(Node node) {

        if (node.rightNode == null) {
            Node leftNode = node.leftNode;
            node.leftNode = null;
            size--;
            return leftNode;
        }

        node.rightNode = removeMax(node.rightNode);
        return node;
    }

    //删除二叉搜索树中的节点
    public void remove(E e) {
        root = remove(root, e);
    }

    /*/*
     * @title
     * @description
     * @author wg
     * @param: node
     * @param: e
     * @updateTime 2019/9/12
     * @return: com.pers.wgdemo.struct.tree.BST<E>.Node
     * @throws
     */
    private Node remove(Node node, E e) {

        if (node == null)
            return null;

        if (e.compareTo(node.e) < 0) {
            node.leftNode = remove(node.leftNode, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.rightNode = remove(node.rightNode, e);
            return node;
        } else /*if (e.equals(node.e))*/ {

            if (node.leftNode == null) {
                Node rightNode = node.rightNode;
                node.rightNode = null;
                size--;
                return rightNode;
            }
            if (node.rightNode == null) {
                Node leftNode = node.leftNode;
                node.leftNode = null;
                size--;
                return leftNode;
            }

            Node precursor = maximum(node.leftNode);
            precursor.leftNode = removeMax(node.leftNode);
            //size++；
            precursor.rightNode = node.rightNode;
            node.leftNode = node.rightNode = null;
            //size--；
            return precursor;
        }
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("BST[ ");

        Queue<Node> queue = new LinkedListQueue<>();
        queue.enQueue(root);
        while (!queue.isEmpty()) {
            Node cur = queue.deQueue();
            res.append(cur.e).append(" ");
            if (cur.leftNode != null)
                queue.enQueue(cur.leftNode);
            if (cur.rightNode != null)
                queue.enQueue(cur.rightNode);
        }
        res.append("]");
        return res.toString();
    }
}
