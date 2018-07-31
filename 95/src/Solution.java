
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0)
            return new ArrayList<TreeNode>();
        
        return genTree(1,n);
    }
    
    public List<TreeNode> genTree(int start,int end) {
        
        List<TreeNode> res = new ArrayList<>();
        if(start > end){
            res.add(null);
            return res;
        }
        if(start == end) {
            res.add(new TreeNode(start));
            return res;
        }
        for(int i = start;i<=end;i++) {
            List<TreeNode> left = genTree(start,i-1);
            List<TreeNode> right = genTree(i+1,end);
            
            for(TreeNode l:left) {
                for(TreeNode r:right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
