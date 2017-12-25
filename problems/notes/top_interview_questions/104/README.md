# [104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/description/)

## Description

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.


### 思路
> Time:12/25/2017

> 初次看到这个题很怵，因为看到了二叉树就感觉不会做，思考了一下，应该是要用到递归，因此就按照递归写了，但是提交的时候提示Time Limit Exceeded了，38个测试用例，在第36个的时候挂掉了。应该是还可以优化，参考下别人的先。


```
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return getTreeDepth(root);
    }
    
    public int getTreeDepth(TreeNode tree){
        if(tree != null){
            if(tree.left != null && tree.right != null){
                return getTreeDepth(tree.left) > getTreeDepth(tree.right) ? (1 + getTreeDepth(tree.left)) : (1 + getTreeDepth(tree.right)); 
            }else if(tree.left != null){
                return 1 + getTreeDepth(tree.left);
            }else if(tree.right != null){
                return 1 + getTreeDepth(tree.right);
            }else{
                return 1;
            }
        }
        return 0;
    }
}
```
`未Accept`

### 优秀思路（参考别人）
> 自己还是没有掌握递归的精髓，根本没必要加那么多的判断，直接像下面这样写就是ok的。

```
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
```