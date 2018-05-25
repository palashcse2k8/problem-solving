package topics;

import java.util.Scanner;

public class Tree {

	class TreeNode{
		TreeNode parent;
		int nodeValue;
		TreeNode [] childs;
		
		public TreeNode(int data) {
			this.nodeValue = data;
			this.parent = null;
			childs = new TreeNode[2];
		}
	}
	
	int nodeNumber;
	TreeNode [] nodes;
	TreeNode head;
	
	public Tree(int n) {
		this.nodeNumber = n;
		nodes = new TreeNode[n+1];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new TreeNode(i);
		}
	}
	
	void addNode(int parent, int child)
	{
		int childNumber = -1;
		for (int i = 0; i < 2; i++) {
			if(nodes[parent].childs[i] ==null)
			{
				childNumber = i;
				break;
			}
		}
		
		nodes[parent].childs[childNumber] = nodes[child];
		nodes[child].parent = nodes[parent];	
	}
	
	TreeNode getRoot()
	{
		for (int i = 1; i < nodes.length; i++) {
			if(this.nodes[i].parent == null)
			{
				return nodes[i];
			}
		}
		return null;
	}
	
	
	void printNode(TreeNode root)
	{
		System.out.print(root.nodeValue + " ");
		for (int i = 0; i < root.childs.length; i++) {
			if(root.childs[i] != null)
			{
				printNode(root.childs[i]);
			}
		}
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		int N, Edges;
		
		Tree myTree;
		
		for (int i = 0; i < T; i++) {
			N = sc.nextInt();
			myTree = new Tree(N);
			Edges = sc.nextInt();
			for (int j = 0; j < Edges; j++) {
				myTree.addNode(sc.nextInt(), sc.nextInt());
			}
			System.out.println((i+1)  + "#");
			myTree.printNode(myTree.getRoot());
			System.out.println();
		}
	}
}
