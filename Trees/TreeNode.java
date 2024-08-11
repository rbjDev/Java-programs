package Trees;

public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(){

    }
    public TreeNode(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
    
}
