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

/*
输入的字符串，就是深度优先遍历的结果。根左右。
用一个stack辅助存储，
从前往后，每拿到一个节点，即为当前子节点，stack 顶中存储的应是其父节点，     //应查看其父的子索引判断左右     判断肯定是要的 但是还有可能是其父的兄弟节点？！

//错了 辅助存储 弹出就弹出，他们本身就是树啊 连着呢 既然跳回某根节点了 证明根本就不需要再回到原分支了。左子树已经遍历完了。一个叶节点是 多个亦然


*/


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
            while (i< S.length() &&  S.charAt(i) != '-'){
                val = val*10 + S.charAt(i)-'0';
                i++;
            }

            while (stack.size()>level){
                stack.pop();
            }
            TreeNode treeNode = new TreeNode(val);

            if(!stack.isEmpty()){
                if(stack.peek().left == null){
                    stack.peek().left = treeNode;
                }else {
                    stack.peek().right = treeNode;
                }
            }
            stack.add(treeNode);
        }

        //返回根节点
        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.pop();
    }

    public static void main (String[] args){
        Solution solution = new Solution();
        //15-2--3---4-5--6---7
        //TreeNode treeNode = solution.recoverFromPreorder("15-2--3---4-5--6---7");
        //1-2--3--4-5--6--7
        TreeNode treeNode = solution.recoverFromPreorder("1-2--3--4-5--6--7");

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