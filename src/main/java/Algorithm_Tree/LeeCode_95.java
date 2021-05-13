package Algorithm_Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Algorithm
 * @descrption: 不同的二叉搜索树
 * @autor:hx
 * @date: 2021-05-13 15:07
 */
public class LeeCode_95 {
    public List<TreeNode> generateTrees(int n) {
        return  generateTree(1,n);

    }
    public List<TreeNode> generateTree(int left,int right){
        List<TreeNode> res=new ArrayList<>();
        if(left>right){
           res.add(null);
           return res;
        }// 此时区间内没有数
        TreeNode treeNode=new TreeNode();
        if(left==right){
            treeNode.val=left;
            res.add(treeNode);
            return  res;
        }// 此时区间内就只有唯一的一个数
        for(int i=left;i<=right;i++){
            List<TreeNode> leftNode=generateTree(left,i-1);
            List<TreeNode> rightNode=generateTree(i+1,right);
            for (TreeNode l:leftNode) {
                for (TreeNode r:rightNode) {//将左右两个区间内的所有节点随机组合生成树
                    TreeNode root=new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    res.add(root);
                }
            }
        }
        return  res;
    }

}
