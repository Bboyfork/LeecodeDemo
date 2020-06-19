package com.demo.test23;

/*
LeeCode 1028. 从先序遍历还原二叉树
我们从二叉树的根节点 root 开始进行深度优先搜索。
在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。
（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
如果节点只有一个子节点，那么保证该子节点为左子节点。
给出遍历输出 S，还原树并返回其根节点 root。
示例 1：
    输入："1-2--3--4-5--6--7"
    输出：[1,2,5,3,4,6,7]
示例 2：
    输入："1-2--3---4-5--6---7"
    输出：[1,2,5,3,null,6,null,4,null,7]
*/

import java.util.Stack;

/**
 * @author Bboy_fork
 * @date 2020年6月18日16:28:30
 * */
public class Solution {
    public TreeNode recoverFromPreorder(String S) {
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < S.length();) {
            int level = 0;
            //是符号时
            while (S.charAt(i) == '-'){
                level++;
                i++;
            }

            int val = 0;
            //是数字时
            while (S.charAt(i) != '-'){
                val = val*10 + S.charAt(i)-'0';
                i++;
            }

            System.out.println(stack.size());

        }
        return null;
    }

    public static void main (String[] args){
        Solution solution = new Solution();
        TreeNode treeNode = solution.recoverFromPreorder("15-2--3---4-5--6---7");

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */