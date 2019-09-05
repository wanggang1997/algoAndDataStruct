package com.pers.alan.algo_struct.tree.binarysearchtree;

/**
 * @program: algoAndDataStruct
 * @description: 二叉搜索树循环实现
 * @author: wgg
 * @create: 2019-08-23 16:41
 **/
public class BSTreeOfLoop <Key extends Comparable,Value>{
    //根节点
    private Node root;
    //获得整棵树的节点数
    public int size(){
        return size(root);
    }
    private int size(Node node){
        if (root==null) return 0;
        else return node.count;
    }
    private class Node{
        private Key key;
        private Value data;
        private Node leftChild,rightChild;
        private int count;
        public Node(Key key, Value data, int count) {
            this.key = key;
            this.data = data;
            this.count = count;
        }
    }


    public void insert(Key key,Value data){
        //将要插入的节点
        if (root==null){
            root = new Node(key,data,1);
            return;
        }
        //利用parent存储上一节点 便于比较当前节点的子节点
        Node parent = null;
        Node current = root;
        while (true){
            parent = current;
            if (current.key.compareTo(key)<0){
                //从当前节点左侧寻找
                current = parent.leftChild;
                //插入子节点后 父节点的count++
                parent.count++;
                //到达应该插入的位置
                if (parent.leftChild==null){
                    parent.leftChild=new Node(key,data,0);
                    return;
                }
            }else {
                //从当前节点右侧寻找
                current = parent.rightChild;
                parent.count++;
                //到达应该插入的位置
                if (parent.rightChild==null){
                    parent.rightChild=new Node(key,data,0);
                    return;
                }
            }

        }
    }

}
