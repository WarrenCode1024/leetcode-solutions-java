package com.leetcode.top100liked.lc_0226_invert_binary_tree;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 1. 交换当前节点的左右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 2. 递归翻转左子树（原来的右子树）
        invertTree(root.left);

        // 3. 递归翻转右子树（原来的左子树）
        invertTree(root.right);

        return root;

    }
}
