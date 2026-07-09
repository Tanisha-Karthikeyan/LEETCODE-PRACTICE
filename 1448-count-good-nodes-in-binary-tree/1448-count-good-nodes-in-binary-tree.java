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
    private int goodNodeCount = 0;
    public int goodNodes(TreeNode root) {
        depthFirstSearch(root,Integer.MIN_VALUE);
        return goodNodeCount;
    }
    private void depthFirstSearch(TreeNode node,int maxSoFar)
    {
        if(node==null)
        {
            return;
        }
        if(maxSoFar<=node.val)
        {
            goodNodeCount++;
            maxSoFar = node.val;
        }
        depthFirstSearch(node.left,maxSoFar);
        depthFirstSearch(node.right,maxSoFar);
    }
}