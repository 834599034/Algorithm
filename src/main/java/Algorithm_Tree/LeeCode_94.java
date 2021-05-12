package Algorithm_Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: Algorithm
 * @descrption: 树的遍历（递归与迭代）
 * @autor:hx
 * @date: 2021-05-12 16:50
 */
public class LeeCode_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        inorder(root,res);
        return res;
    }

    /**
    * @Description:  递归中序遍历
     * 递归三要素：①确定参数、返回值
     *             ②终止条件
     *             ③单层递归操作
    * @Author: hx
    * @Date: 2021/5/12
    */
    public void inorder(TreeNode root,List<Integer> res){
        if(root==null){
            return;
        }//递归终止条件
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }
    /**
    * @Description: 迭代中序遍历
     * 采用迭代法遍历时，本质是引入辅助栈，手动模拟递归过程。
     * 树的遍历本质上是一个特殊的图，因此其总结可以归为：
     *      ①dfs：树的前、中、后序遍历本质上都是dfs，其遍历过程都是：根->左子树->右子树
     *         其不同是在于在不同的时候去处理根节点。
     *      ②bfs：树的层序遍历
     *
    * @Author: hx
    * @Date: 2021/5/12
    */
    public List<Integer> for_inorderTraversal(TreeNode root){
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=root;
        while (p!=null||!stack.isEmpty()){
            while (p!=null){
                stack.push(p);
                p=p.left;//一路向左
            }//遍历完左子树
            p=stack.pop();
            res.add(p.val);//处理根节点
            p=p.right;//遍历右子树
        }
        return  res;
    }

   /**
   * @Description: 迭代前序遍历
   * @Author: hx
   * @Date: 2021/5/12
   */
    public List<Integer> for_preorderTraversal(TreeNode root){
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=root;
        while (p!=null||!stack.isEmpty()){
            if(p!=null){
                res.add(p.val);//在左子树入栈之前，处理根节点
                stack.push(p);
                p=p.left;
            }else {
                p=stack.pop();
                p=p.right;
            }
        }
        return  res;
    }

    /** 
    * @Description: 后序迭代遍历
     * 设置一个pre指向每一个pop的节点
    * @Author: hx
    * @Date: 2021/5/12 
    */ 
    public List<Integer> for_postOrderTraversal(TreeNode root){
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=root;
        TreeNode pre=null;
        while (p!=null||!stack.isEmpty()){
            if(p!=null){
                stack.push(p);
                p=p.left;
            }else {
                p=stack.peek();
                if(p.right==null||pre==p.right){//判断当前节点是不是由右子树返回而来
                    res.add(p.val);
                    pre=stack.pop();
                    p=null;

                }else {
                    p=p.right;
                    pre=null;
                }
            }
        }
        return  res;
    }



}
class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode(){}
    TreeNode(int val){
        this.val=val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
    }
}
