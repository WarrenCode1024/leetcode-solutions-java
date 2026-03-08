package com.leetcode.top100liked.lc_0098_validate_binary_search_tree;


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
    public boolean isValidBST(TreeNode root) {
        return validate(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        // 空节点视为有效
        if (node == null) {
            return true;
        }

        // 检查当前节点值是否在合法范围内 (开区间)
        if(node.val <= min || node.val >= max) {
            return false;
        }

        // 递归检查左右子树
        // 左子树的上界变为当前节点值
        // 右子树的下界变为当前节点值
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);

    }
}
