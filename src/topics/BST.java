package topics;
/*
 * Learning source
 * http://www.geeksforgeeks.org/binary-search-tree-data-structure/
 */
 
class TreeNode {
	
	public int value;
	
	TreeNode left, right;
 
	public TreeNode(int value) {
 
		this.value = value;
		this.left = null;
		this.right = null;
	}
 
	public TreeNode() {
 
	}
 
	public TreeNode(int value, TreeNode left, TreeNode right) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
	public int getValue() {
		return value;
	}
 
	public void setValue(int value) {
		this.value = value;
	}	
}
 
class BinarySearchTree{
	
	TreeNode root;
 
	public BinarySearchTree() {
		root = null;
	}
	
	public void insert(int value) {
		root = insertNode(root, value);
	}
	
	public TreeNode insertNode(TreeNode root, int value) {
		if(root == null) {
			root = new TreeNode(value);
			return root;
		}
		if(value<root.value) root.left = insertNode(root.left, value);
		else root.right = insertNode(root.right, value);
		
		return root;
	}
	
	
	public TreeNode searchNode(TreeNode root, int value) {
		
		if(root == null || root.value == value)
		{
			if(root == null) System.out.println(value + " node not found..");
			else {
				System.out.println(value + " node found..");
			}
			return root;
		}
			
		if(value < root.value){
			return searchNode(root.left, value);
		}
		else return searchNode(root.left, value);
	}
	public TreeNode deleteNode(TreeNode root, int value) {
		
		//System.out.println(root.value + "-> ");
		if(root == null) {
			System.out.println("Node not found;");
			return root;
		}
		
		if(value< root.value) {
//			if(root.left != null)
			root.left = deleteNode(root.left, value);
//			else System.out.println("Node not found");
		}
		else if (value > root.value) {
//			if(root.right != null)
			root.right = deleteNode(root.right, value);
//			else System.out.println("Node not found");
		}
		else {
			
			if( root.left == null ) {
				return root.right;
			}
			else if (root.right == null) {
				return root.left;
			}
			
			root.value = leftMost(root.right).value;
			
			root.right = deleteNode(root.right, root.value);			
		}
		
		return root;
	}
	
	public TreeNode leftMost (TreeNode root) {
		
		while(root.left != null) {
			root = root.left;
		}
		
		return root;		
	}
	
	public void inOrder(TreeNode root){
		if( root != null) {
			inOrder(root.left);
			System.out.print(root.value + " ");
			inOrder(root.right);
		}
	}
	
	public void preOrder(TreeNode root) {
		if( root != null) {
			System.out.println(root.value);
			preOrder(root.left);			
			preOrder(root.right);
		}
	}
	
	public void postOrder(TreeNode root) {
		if( root != null) {
			postOrder(root.left);			
			postOrder(root.right);
			System.out.println(root.value);
		}
	}
}
 
public class BST {
 
	public static void main(String[] args) {
		
		
		BinarySearchTree myTree = new BinarySearchTree();
//		TreeNode root = new TreeNode();
		TreeNode tempNode = new TreeNode();
 
//		root = myTree.root;
		int[] arr = new int [] {50, 30 , 20, 40, 70, 60, 80};
		
		for (int i = 0; i < arr.length; i++) {
			myTree.insert(arr[i]);
		}
		
		System.out.println("In oder representation");
		myTree.inOrder(myTree.root);
		
		System.out.println("Inorder traversal of the given tree");
        myTree.inOrder(myTree.root);
 
        System.out.println("\nDelete 20");
        myTree.deleteNode(myTree.root, 20);
        System.out.println("Inorder traversal of the modified myTree");
        myTree.inOrder(myTree.root);
 
        System.out.println("\nDelete 30");
        myTree.deleteNode(myTree.root, 30);
        System.out.println("Inorder traversal of the modified tree");
        myTree.inOrder(myTree.root);
 
        System.out.println("\nDelete 50");
        myTree.deleteNode(myTree.root, 50);
        System.out.println("Inorder traversal of the modified tree");
        myTree.inOrder(myTree.root);
        
        System.out.println("\nDelete 100");
        myTree.deleteNode(myTree.root, 100);
        System.out.println("Inorder traversal of the modified tree");
        myTree.inOrder(myTree.root);
	}
}
 
 
