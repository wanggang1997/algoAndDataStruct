package com.pers.alan.struct.set;


import com.pers.alan.struct.tree.BST;

/**
 * @program: algoAndDataStruct
 * @description:
 * @author: wg
 * @create: 2019-09-12
 **/
public class BSTSet<E extends Comparable<E>> implements Set<E> {
    private BST<E> bst;

    public BSTSet(){
        bst = new BST<>();
    }
    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public int getSize() {
        return bst.size();
    }
}
