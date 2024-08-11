package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class LevelOrderTraversal {
    public static void main(String[] args) {
        
    }

    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> outerList = new ArrayList<>();
        if(root==null) return outerList;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> innerList = new ArrayList<>();
            for(int i=0 ; i<levelNum ; i++){
                Node node = queue.poll();
                innerList.add(node.value);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            outerList.add(innerList);            
        }
        return outerList;
    }
}
