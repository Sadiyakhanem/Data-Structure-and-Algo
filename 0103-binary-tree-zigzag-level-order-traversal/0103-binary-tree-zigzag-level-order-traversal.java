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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean lefttoright = true;
    

        while (!queue.isEmpty()) {

            int levelsize = queue.size();
            List<Integer> list = new ArrayList<>();

            while (levelsize > 0) {


                TreeNode temp = queue.poll();
                if(lefttoright==true)
                {
                list.add(temp.val);
                }
                else
                {
                    list.add(0,temp.val);
                }


                 if (temp.left != null) {
                    queue.offer(temp.left);
                }

                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                
              


                levelsize--;
            }


            ans.add(list);
            lefttoright=!lefttoright;
        }

        return ans;

        
    }
}