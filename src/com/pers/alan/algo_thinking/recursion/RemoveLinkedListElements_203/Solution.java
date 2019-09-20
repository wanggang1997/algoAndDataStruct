package com.pers.alan.algo_thinking.recursion.RemoveLinkedListElements_203;

/**
 * @program: algoAndDataStruct
 * @description:
 * @author: wg
 * @create: 2019-09-07 14:49
 **/
public class Solution {
    public static ListNode removeElements(ListNode head, int val, int depth) {
        //打印深度--
        String depthStr = generateDepthString(depth);
        System.out.print(depthStr);
        //打印题目执行条件
        System.out.println("Que: Remove " + val + " in " + head);

        if (head == null) {
            System.out.print(depthStr);
            System.out.println("Return " + head);
            return head;
        }

        ListNode res = removeElements(head.next, val, depth + 1);
        System.out.print(depthStr);
        System.out.println("Aft: Remove " + val + " : " + head);

        ListNode ret;
        if (head.val == val) {
            ret = res;
        } else {
            head.next = res;
            ret = head;
        }

        System.out.print(depthStr);
        System.out.println("Return:" + ret);
        return ret;
    }

    private static String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        removeElements(head, 5, 1);
    }
}
