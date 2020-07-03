package com.julyDemo.test3;

/*
LeeCode 108. 将有序数组转换为二叉搜索树
将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
示例:
    给定有序数组: [-10,-3,0,5,9],
    一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

          0
         / \
       -3   9
       /   /
     -10  5

*/
/**
 * @author Bboy_fork
 * @date 2020年7月3日09:56:46
 * */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return getTree(nums,0,nums.length);
    }

    public TreeNode getTree(int[] nums,int left,int right){
        int mid = (right - left >> 1)+1;
        TreeNode father = new TreeNode(nums[mid]);

        if(right-left == 1){
            System.out.println("1xxxx");
            System.out.println("left=>"+left+"--" +nums[left]+"<||>"+ "right=>" +right+"--"+nums[right]);
        }else if(right-left == 2){
            System.out.println("2xxxx");
            System.out.println("left=>"+left+"--" +nums[left]+"<||>"+ "right=>" +right+"--"+nums[right]);
        }else{
            System.out.println("3+xxxx");
            System.out.println("left=>"+left+"--" +nums[left]+"<||>"+ "right=>" +right+"--"+nums[right]);
        }
        int len = nums.length;
        System.out.println("len===>"+len+"<==>"+mid+"<===mid");

        father.left = getTree(nums, left, mid);
        father.right = getTree(nums, mid, right);
        return father;
    }

    public static void main (String[] args){
        int[] nums = new int[]{-10,-3,0,5,9};
        Solution solution = new Solution();
        TreeNode treeNode = solution.sortedArrayToBST(nums);

    }

}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
