/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
int res=0;
       return sumfind(root,0,res);
    }
      public int sumfind(TreeNode root, int sum ,int res)
    {
        
       
        if(root==null)
        {
            return res;
        }
         
         sum= sum*10+root.val;
        if(root.left==null && root.right ==null)
        {
           res+=sum;
           
             
        }
      res=  sumfind(root.left,sum,res);
      res=  sumfind(root.right,sum,res);
        
return res;
    }
}