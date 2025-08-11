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
    List<Integer>lst=new ArrayList<>();
    public void preorder(TreeNode curr){
        if(curr==null) return;
        lst.add(curr.val);
        preorder(curr.left);
        preorder(curr.right);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return lst;
    }
}