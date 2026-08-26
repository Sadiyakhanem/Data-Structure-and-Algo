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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if(root ==null)
        {
            return ans;
        }
        queue.offer(root);
     
        while(!queue.isEmpty())
        
        {
            ArrayList<Integer> list = new ArrayList<>();
               int levelsize=queue.size();
            while(levelsize!=0)
            {
           TreeNode temp= queue.poll();
           list.add(temp.val);
           if(temp.left!=null)
           {
            queue.offer(temp.left);
           }
           if(temp.right!=null)
           {
            queue.offer(temp.right);
           }
           
           levelsize--;
            }

            ans.add(list);




        }
        return ans;
        
    }
}