import java.util.*;


public class Solution {

    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root != null ){
            List<TreeNode> record = new ArrayList<>();
            record.add(root);
            List<Integer> rootres = new ArrayList<>();
            rootres.add(root.val);
            res.add(rootres);
            helper(record);
            return res;
        }
        
        return res;       
    }
    
    private void helper(List<TreeNode> nodes) {
        List<TreeNode> noderecord = new ArrayList<>();
        List<Integer> resrecord = new ArrayList<>();
        for(TreeNode node:nodes) {
            if(node.left != null){
                resrecord.add(node.left.val);
                noderecord.add(node.left);
            }
            if(node.right != null){
                resrecord.add(node.right.val);
                noderecord.add(node.right);
            }         
        }
        if(!resrecord.isEmpty()) {
            res.add(resrecord);
            helper(noderecord);      
        }
    }
    
}
