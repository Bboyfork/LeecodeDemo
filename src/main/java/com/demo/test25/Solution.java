package com.demo.test25;

/*
LeeCode 124. 二叉树中的最大路径和
本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
示例 1:
    输入: [1,2,3]

           1
          / \
         2   3

    输出: 6
示例 2:
    输入: [-10,9,20,null,null,15,7]

       -10
       / \
      9  20
        /  \
       15   7

    输出: 42

思路1：


*/

/**
 * @author Bboy_fork
 * @date 2020年6月21日13:04:06
 * */
class Solution {
    private int resultMax = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMax(root);
        return resultMax;
    }

    public int getMax(TreeNode node){
        if (node == null){
            return 0;
        }

        int leftMax = Math.max(getMax(node.left) , 0);
        int rightMax = Math.max(getMax(node.right) , 0);

        //更新其最大结果
        resultMax = Math.max(resultMax,node.val + leftMax + rightMax);

        return node.val + Math.max(leftMax , rightMax);
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
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
