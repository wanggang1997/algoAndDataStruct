package com.pers.alan.algo_thinking.recursion.RemoveLinkedListElements_203;

/**
 * @program: algoAndDataStruct
 * @description:
 * @author: wg
 * @create: 2019-09-07 14:48
 **/
public class ListNode {
    public int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("The array is empty.");

        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while (cur!=null){
            res.append(cur.val).append(" -> ");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
