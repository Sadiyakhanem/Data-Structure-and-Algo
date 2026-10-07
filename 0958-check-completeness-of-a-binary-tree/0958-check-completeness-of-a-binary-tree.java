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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<>();
      
        Boolean Nullseen=false;
        q.offer(root);

        while(!q.isEmpty())
        {
            TreeNode t =  q.poll();
            if(t==null)
            {
                Nullseen=true;
            }
            else
            {
                if(Nullseen==true)
                {
                    return false;
                }
                q.offer(t.left);
                q.offer(t.right);

            }
       


        }
        return true;

        
    }
}