package com.demo.test34;

/*
LeeCode 02.01. 移除重复节点
编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
示例1:
    输入：[1, 2, 3, 3, 2, 1]
    输出：[1, 2, 3]
示例2:
    输入：[1, 1, 1, 1, 2]
    输出：[1, 2]
*/
/**
 * @author Bboy_fork
 * @date 2020年6月26日13:54:28
 * */
public class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        int[] bits = new int[20000 / 32 + 1];
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            System.out.println(bits[cur.val / 32]);
            System.out.println(1 << (cur.val % 32));
            bits[cur.val / 32] |= 1 << (cur.val % 32);
            if ((bits[cur.next.val / 32] & (1 << (cur.next.val % 32))) != 0){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String args[]){
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);


        Solution solution = new Solution();
        ListNode listNode1 = solution.removeDuplicateNodes(listNode);
        System.out.println(listNode1);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}