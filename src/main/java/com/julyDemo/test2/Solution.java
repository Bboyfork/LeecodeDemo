package com.julyDemo.test2;

/*
LeeCode 378. 有序矩阵中第K小的元素

给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。

示例：
    matrix = [
       [ 1,  5,  9],
       [10, 11, 13],
       [12, 13, 15]
    ],
    k = 8,
    返回 13。

*/
        /*
        思路：二分查找
        因其有序数组，取其头尾值进行差值除2+1操作 拟定一中数，
        按此值进行查找 看有多少个值小于此，即他在此二维数组中有多大，
        */
/**
 * @author Bboy_fork
 * @date 2020年7月2日09:27:41
 * */
/*
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        int mid = 1+ ((matrix[len-1][len-1] -matrix[0][0]) >> 1);
        int left = 0;
        int right = 0;
        int smallerWithMid = getSmallerWithMid(matrix, mid);
        //此方法检查mid在matrix中的位置 是否大于k 大于就证明在左上半 继续缩小范围，小于则扩大范围，
        while (true){
            if(){
                mid = 1+(mid>>1);
            }
        }
    }

    int getSmallerWithMid(int[][] matrix,int mid){
        int len = matrix.length;
        int col = len - 1;
        int row = 0;
        while (row<len && col >= 0){    //符合边界条件

        }
        matrix[][]
    }

    public static void main (String[] args){
        int[][] matrixTest = new int[][]{{1,5,9},{10,11,13},{12,13,15}};
        int kTest = 8;

        Solution solution = new Solution();
        System.out.println(solution.kthSmallest(matrixTest,kTest));
    }
}
*/