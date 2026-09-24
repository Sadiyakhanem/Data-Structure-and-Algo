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
    public boolean findTarget(TreeNode root, int k) {
        if(root==null)
        return false;
        Stack<TreeNode> asc = new Stack<>();
        Stack<TreeNode> des = new Stack<>();
        pushleft(asc,root);
        pushright(des,root);
        TreeNode i = getsmall(asc);
        TreeNode j =getBig(des);
       
      
        while(i.val<j.val)
        {
            int sum =i.val+j.val;
            if(sum==k)
            {
                return true;
            }
            else if(sum>k)
            {
              j=getBig(des);
            }
            else
            {
                i=getsmall(asc);
             
            }
        }
        return false;

        
    }

    public void pushleft(Stack<TreeNode> asc, TreeNode root)
    {
        while(root!=null)
        {
            asc.push(root);
            root =root.left;
        }
    }
    public void pushright(Stack<TreeNode> des, TreeNode root)
    {
        while(root!=null)
        {
            des.push(root);
            root=root.right;
        }
    }
    public TreeNode getsmall(Stack<TreeNode>asc)
    {
        if(asc.isEmpty())
        {
            return null;
        }
        TreeNode node = asc.pop();
        if(node.right!=null)
        {
            pushleft(asc,node.right);
        }
        return node;
    }
    public TreeNode getBig(Stack<TreeNode>des)
    {
        if(des.isEmpty())
        return null;
        TreeNode node =des.pop();
        if(node.left!=null)
        {
            pushright(des,node.left);
        }
        return node;
    }


}