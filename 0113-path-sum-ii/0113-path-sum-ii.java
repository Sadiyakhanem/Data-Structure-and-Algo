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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> diary = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        findsum(root,targetSum,0, diary,ans);
       
        return ans;
    }
    public void findsum(TreeNode root, int targetSum,int sum, ArrayList<Integer> diary,List<List<Integer>> ans)
    {
        if(root==null)
        {
            return ;
    
        }
        diary.add(root.val);
        sum+=root.val;
        if(root.left==null && root.right ==null)
        {
            if(sum==targetSum)
            {
                ans.add(new ArrayList<> (diary));

            }
            diary.remove(diary.size()-1);
            return;

        }
        findsum(root.left,targetSum,sum,diary,ans);
        findsum(root.right,targetSum,sum,diary,ans);
         diary.remove(diary.size()-1);


    }
}