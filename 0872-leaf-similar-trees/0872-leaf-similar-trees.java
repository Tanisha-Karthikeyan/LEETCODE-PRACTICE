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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafValues1 = new ArrayList<>();
        List<Integer> leafValues2 = new ArrayList<>();
        collectLeaves(root1,leafValues1);
        collectLeaves(root2,leafValues2);
        return leafValues1.equals(leafValues2);
    }
    private void collectLeaves(TreeNode node,List<Integer> leafValues)
    {
        if(node.left == null && node.right == null)
        {
            leafValues.add(node.val);
            return;
        }
        if(node.left!=null)
        {
            collectLeaves(node.left,leafValues);
        }
        if(node.right!=null)
        {
            collectLeaves(node.right,leafValues);
        }
    }
}