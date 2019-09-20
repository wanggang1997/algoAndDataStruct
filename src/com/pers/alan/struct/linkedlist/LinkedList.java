package com.pers.alan.struct.linkedlist;


/**
 * @program: algoAndDataStruct
 * @description: 链表
 * @author: wg
 * @create: 2019-09-05 09:27
 **/
public class LinkedList<E> {
    //设置一个 虚拟头部
    private Node dummyHead;
    private int size;

    public LinkedList() {
        //虚拟节点不为null 初始化时 其成员为null
        this.dummyHead = new Node();
        this.size = 0;
    }

    //内部类 节点
    private class Node {
        private E e;
        private Node next;

        Node(E e, Node node) {
            this.e = e;
            this.next = node;
        }

        Node(E e) {
            this(e, null);
        }

        Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /*/**
     * @title
     * @description 根据索引给链表添加元素 不常用
     * @author wg
     * @param: index
     * @param: e
     * @updateTime 2019/9/5 10:33
     * @throws
     */
    public void add(int index, E e) {
        //size：末尾添加
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed.Illegal index.");

        Node prev = dummyHead;
        //注意prev的取值范围
        for (int i = 0; i < index; i++)
            prev = prev.next;

/*            Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;*/

        prev.next = new Node(e, prev.next);
        size++;
    }

    //在链表头部添加元素
    public void addFirst(E e) {
        add(0, e);
    }

    //在链表尾部添加元素
    public void addLast(E e) {
        add(size, e);
    }

    /*/**
     * @title
     * @description 获得索引为index的元素e
     * @author wg
     * @param: index
     * @updateTime 2019/9/5 15:00
     * @return: E
     * @throws
     */
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed.Illegal index.");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    //得到链表头部的元素 非虚拟头
    public E getFirst() {
        return get(0);
    }

    //得到链表最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    /*/**
     * @title
     * @description 向链表索引为index的位置修改值为e
     *查找和修改不符合链表的优势特性 使用较少
     *
     * @author wg
     * @param: index
     * @param: e
     * @updateTime 2019/9/5 15:02
     * @throws
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed.Illegal index.");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    //判断链表中是否包含元素e
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }


    /*/**
     * @title
     * @description 从链表中删除索引为index的元素 并返回该元素
     * @author wg
     * @param: index
     * @updateTime 2019/9/5 15:36
     * @throws
     */
    public E remove(int index) {
        if (isEmpty())
            throw new IllegalArgumentException("Remove failed.Linklist is empty.");
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed.Illegal index.");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node res = prev.next;
        prev.next = res.next;
        res.next = null;
        size--;
        return res.e;
    }

    //删除首部
    public E removeFirst() {
        return remove(0);
    }

    //
    public E removeLast() {
        return remove(size - 1);
    }


    // 从链表中删除元素e
    public void removeElement(E e){
        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.e.equals(e))
                break;
            prev = prev.next;
        }
        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
        }
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LinkedList: size: %d \n", size));
        res.append("dummyHead [ ");
        Node cur = dummyHead.next;
        for (int i = 0; i < size; i++) {
            res.append(cur.toString()).append(" -> ");
            cur = cur.next;
        }
        res.append("NULL ]");
        return res.toString();
    }

}
