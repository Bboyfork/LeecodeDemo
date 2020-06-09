package com.demo.test15;


/**
 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，
 并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。

 输入：["a==b","b!=a"]
 输出：false
 输出：["b==a","a==b"]
 输入：true
 输入：["a==b","b==c","a==c"]
 输出：true
 输入：["a==b","b!=c","c==a"]
 输出：false

 具体实现方面，使用一个数组 parent 存储每个变量的连通分量信息，
 其中的每个元素表示当前变量所在的连通分量的父节点信息，
 如果父节点是自身，说明该变量为所在的连通分量的根节点。
 一开始所有变量的父节点都是它们自身。
 对于合并操作，我们将第一个变量的根节点的父节点指向第二个变量的根节点；
 对于查找操作，我们沿着当前变量的父节点一路向上查找，直到找到根节点
 * */
class Solution {
    public boolean equationsPossible(String[] equations) {
        int length = equations.length;
        //创建了一个数组，[0,1,2,3,4,5,6,7,8...24,25]
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        for (String str : equations) {  //遍历条件集，
            if (str.charAt(1) == '=') { // 如果是 ==
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                union(parent, index1, index2);
            }
        }
        for (String str : equations) {
            if (str.charAt(1) == '!') { //如果是 !=
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                //对比起根节点。如果在一个树上，即 相等，这里是不等，即 返回false 表示悖论。
                if (find(parent, index1) == find(parent, index2)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 一直用 a=b b=c c=d 这样的智障型来debug 导致眼瞎没看出来，
     * 这里存储的并不是下一个节点的值， 而是尽可能的存储链的末端，或者说是根节点？！ 这样也可以避免了数据链被替换 有的数据丢失的问题
     * so 由于录入元素，录入顺序等原因 他也不是单纯的多叉树状一层结构，可能也有很长的链，
     *      但 已经足够，保证连接到树上就可。
     * */
    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    /**
     * 此方法返回的是 其链状结构的最末端 或者说是树状结构的根节点
     * */
    public int find(int[] parent, int index) {
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }

    public static void main (String[] args){
        String str1 = "d==e";
        String str2 = "e==f";
        String str3 = "a==d";
        String str4 = "d!=a";

        String[] strs = new String[]{str1,str2,str3,str4};
        Solution solution = new Solution();
        boolean b = solution.equationsPossible(strs);
        System.out.println(b);
    }

        /*
    public boolean equationsPossible(String[] equations) {

        //创建一个反映关系的数组 其本身为索引，其值代表等于的索引。因字母26个 所以长度26
        int[] arrParent = new int[26];
        for (int i = 0; i < arrParent.length; i++) {
            arrParent[i] = i;
        }

        //循环遍历方程两次，第一次录入等于的条件，
        for (String str:equations) {
            if(str.charAt(1) == '='){
                int first = str.charAt(0)-'a';
                int second = str.charAt(3)-'a';
                //关联两个字母， 即first中存储second的索引
                saveIndex(arrParent,first,second);
            }
        }
        //第二次检查其不等的条件，查看是否相悖。
        for (String str:equations) {
            if(str.charAt(1) == '!'){
                int first = str.charAt(0)-'a';
                int second = str.charAt(3)-'a';
                //检查first处的值，并根据其映射关系迭代，对比是否有找到second的索引
                return !checkIndex(arrParent,first,second);
            }
        }
        //如果没有被上面return 那么就是没有不等式，或是没有相关不等式，则返回true
        return true;
    }
*/
    /**
     * first中存储second的索引
     */
    public void saveIndex(int[] arrParent,int first,int second){
        arrParent[first] = second;
    }

    /**
     * 检查first处的值，并根据其映射关系迭代，对比是否有找到second的索引
     * @return boolean true代表在first关系中检索到second 即 first == second
     * */
    public boolean checkIndex(int[] arrParent,int first,int second){
        if(first == second){
            return true;
        }

        while (first != second){
            //循环查找 first的值替换成索引处
            first = arrParent[first];
            if(first == second){
                return true;
            }
        }
        return false;
    }

}