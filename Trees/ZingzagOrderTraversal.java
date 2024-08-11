package Trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZingzagOrderTraversal {
    public static void main(String[] args) {
        
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {        
        List<List<Integer>> outerList = new ArrayList<>();
        if(root==null) return outerList;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> innerList = new ArrayList<>();
            for(int i=0 ; i<levelNum ; i++){
                if(!reverse){
                    TreeNode node = queue.pollFirst();
                    innerList.add(node.value);
                    if(node.left!=null) queue.addLast(node.left);
                    if(node.right!=null) queue.addLast(node.right);
                }
                else{
                    TreeNode node = queue.pollLast();
                    innerList.add(node.value);
                    if(node.right!=null) queue.addFirst(node.right);
                    if(node.left!=null) queue.addFirst(node.left);                    
                }                              
            }
            reverse = !reverse;  
            outerList.add(innerList);            
        }
        return outerList;
    }
}
