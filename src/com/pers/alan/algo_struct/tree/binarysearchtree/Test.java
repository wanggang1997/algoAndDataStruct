package com.pers.alan.algo_struct.tree.binarysearchtree;

/**
 * @program: algoAndDataStruct
 * @description: 二叉树测试
 * @author: wg
 * @create: 2019-08-29 17:11
 **/
public class Test {

    public static void main(String[] args) {
        BSTreeOfRec<Integer,String> bs1=new BSTreeOfRec<>();
        bs1.insert(41,"t");
        bs1.insert(22,"t");
        bs1.insert(58,"t");
        bs1.insert(15,"t");
        bs1.insert(33,"t");
        bs1.insert(50,"t");
        bs1.insert(60,"t");
        bs1.insert(13,"t");
        bs1.insert(37,"t");
        bs1.insert(42,"t");
        bs1.insert(53,"t");
        bs1.insert(59,"t");
        bs1.insert(63,"t");

        bs1.remove(58);
        bs1.levelOrder();
    }

}
