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
    TreeNode prev = null;
    int galat=0;
    TreeNode g1first;
    TreeNode g1second;
    TreeNode g2first;
    TreeNode g2second;
    public void recoverTree(TreeNode root) {
        Inordertype(root);
        if(galat==2)
        {
         int temp;
            temp=g1first.val;
            g1first.val=g2second.val;
            g2second.val=temp;
            

        }
        else
        {
            int temp;
            temp=g1first.val;
            g1first.val=g1second.val;
            g1second.val=temp;
        }
       
        

    }
    public void Inordertype(TreeNode root)
    {
        if(root==null)
        return;
        Inordertype(root.left);
        if(prev==null)
        {
            prev=root;
        }
        else
        {
            if(root.val<=prev.val)
            {
                if(galat==0)
                {
                    g1first=prev;
                    g1second=root;

                   
                }
                else
                {
                    g2first=prev;
                    g2second=root;


                }
                 galat++;
            }
            prev=root;
        }
         Inordertype(root.right);

    }
    
}