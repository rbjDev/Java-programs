package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class BinarySearchTrees {
    static Node root;

    static Node insert(Node root, int key){
        if(root==null){
            root = new Node(key);
            return root;
        }
        if(key < root.value)
            root.left = insert(root.left, key);
        else
            root.right = insert(root.right, key);
        return root;
    }

    //Node left right
    static void preorder(Node root){
        if(root == null) return;
        System.out.print(root.value + " ");
        preorder(root.left);
        preorder(root.right);
    }

    //left node right
    static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.value + " ");
        inorder(root.right);
    }

    //left right node
    static void postorder(Node root){
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.value + " ");
    }

    static List<Integer> postorderTraversal(Node root, List<Integer> result){
        if(root == null) return result;
        postorderTraversal(root.left,result);
        postorderTraversal(root.right,result);
        result.add(root.value);
        return result;
    }

    static int maxDepth(Node root){
        if(root==null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public boolean isBalanced(Node root) {
        if(root==null) return true;
        return Math.abs(maxDepth(root.left)-maxDepth(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right);
    }


    public static void main(String[] args) {
        Node root = new Node(100);
        root.left = new Node(20);
        root.left.left = new Node(10);
        root.left.right = new Node(30);
        root.right = new Node(200);
        root.right.left = new Node(150);
        root.right.right = new Node(300);

        System.out.println("Inorder traversal:");
        inorder(root);
        System.out.println("\nPreorder traversal:");
        preorder(root);
        System.out.println("\nPostorder traversal:");
        postorder(root);
        System.out.println("\nPost order traversal" + postorderTraversal(root, new ArrayList<>()));
        insert(root, 125);
        System.out.println("\nInorder traversal:");
        inorder(root);
        
    }

    int preOrderIndex =0;
    Map<Integer,Integer> inorderIndexMap= new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            inorderIndexMap.put(inorder[i],i);
        }
        return build(preorder,inorder,0,inorder.length-1);

    }

    public TreeNode build(int[] preorder, int[] inorder,int inStart, int inEnd){
        if(inStart>inEnd)
            return null;
        TreeNode node = new TreeNode(preorder[preOrderIndex++]);
        int index = inorderIndexMap.get(node.value);
        node.left = build(preorder, inorder, inStart, index-1);
        node.right = build(preorder, inorder, index+1, inEnd);
        return node;      

    }

    private int find(int value) {        
        return inorderIndexMap.get(value);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        if(root.left==null && root.right==null && root.value==targetSum)
            return true;
        return hasPathSum(root.left, targetSum - root.value)
                || hasPathSum(root.right, targetSum-root.value);

    }

    int sum = 0;
    public int sumNumbers(TreeNode root) {
        void helper(root,0);
    }

    private void helper(TreeNode root, int num) {
        if(root==null) return ;
        if(root.left==null && root.right==null ){
            sum+= num*10 + root.value;
            return;
        }
        helper(root.left, num*10 + root.value);
        helper(root.right, num*10 + root.value);
            
        
    }
}
