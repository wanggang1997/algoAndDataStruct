package com.pers.alan.struct.tree.test;

import com.pers.alan.struct.tree.BST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: algoAndDataStruct
 * @description:
 * @author: wg
 * @create: 2019-09-11
 **/
public class TestBST {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();


        Integer[] nums = {5,3,6,8,4,2,9,7,1};
        List list  = new ArrayList<>(Arrays.asList(nums));


        list.forEach(e-> bst.add((Integer) e));

        //bst.preOrder();
        //System.out.println("~~~~~~~~~~~");
        //bst.inOrder();
        //System.out.println("~~~~~~~~~~~");
        //bst.postOrder();
        //System.out.println("~~~~~~~~~~~");
        //bst.preOrderNoRec();
        //bst.levelOrder();

        bst.inOrder();
        System.out.println("\nsize:"+bst.size()+"\n");


        System.out.println(bst.removeMax());
        bst.inOrder();
        System.out.println("\nsize:"+bst.size()+"\n");


        System.out.println(bst.removeMin());
        bst.inOrder();
        System.out.println("\nsize:"+bst.size()+"\n");


        bst.remove(5);
        bst.inOrder();
        System.out.println("\nsize:"+bst.size()+"\n");


        bst.remove(2);
        bst.inOrder();
        System.out.println("\nsize:"+bst.size()+"\n");
    }

}
