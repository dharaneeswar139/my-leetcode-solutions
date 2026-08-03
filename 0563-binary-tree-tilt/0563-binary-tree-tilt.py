# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findTilt(self, root: Optional[TreeNode]) -> int:
        self.ans=0
        def dfs(node):
            if not node:
                return 0
            ls=dfs(node.left)
            rs=dfs(node.right)
            self.ans+=abs(ls-rs)
            return ls+rs+node.val
        dfs(root)
        return self.ans
        