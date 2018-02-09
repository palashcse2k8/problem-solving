package topics;

import java.util.Scanner;

public class AVLtree {

	
	static class Node 
	{
		int height, value;
		
		Node left, right;
		
		Node (int data)
		{
			this.value = data;
			this.left = this.right = null;
		}
	}
	
	static public int max(int a, int b)
	{
		if(a>b)
			return a;
		return b;
	}

	static class AVL_Tree
	{
		Node root;
		
		public AVL_Tree() {
			root = null;
		}
		
		
		public int getHeight(Node root)
		{
			if(root == null)
			{
				return 0;
			}
			
			return root.height;
		}
		
		public int getBalance(Node root)
		{
			if(root == null)
			{
				return 0;
			}
			
			return getHeight(root.left) - getHeight(root.right);	
		}
		
		Node leftRotation(Node z)
		{
			Node y = z.right;
			Node T = y.left;
			
			z.right = T;
			y.left = z;
			
			z.height = max(getHeight(z.left), getHeight(z.right)) + 1;
			y.height = max(getHeight(y.left), getHeight(y.right)) + 1;
			
			return y;	
		}
		
		Node rightRotation(Node z)
		{
			Node y = z.left;
			Node T = y.right;
			
			z.left = T;
			y.right = z;
			
			z.height = max(getHeight(z.left), getHeight(z.right)) + 1;
			y.height = max(getHeight(y.left), getHeight(y.right)) + 1;
			
			return y;	
		}
		
		Node insert(Node root, int key)
		{
			if(root == null)
			{
				return new Node(key);
			}
			
			else if(key<root.value)
			{
				root.left = insert(root.left, key);
			}
			
			else if(key>root.value)
			{
				root.right = insert(root.right, key);
			}
			
			
			root.height = max(getHeight(root.left),getHeight(root.right)) + 1;
			
			int balance = getBalance(root);
			
			if(balance>1 && key<root.left.value)
			{
				return rightRotation(root);
			}
			
			if(balance< -1 && key>root.right.value)
			{
				return leftRotation(root);
			}
			
			if(balance>1 && key>root.left.value)
			{
				root.left = leftRotation(root.left);
				return rightRotation(root);
			}
			
			if(balance< -1 && key<root.right.value)
			{
				root.right = rightRotation(root.right);
				return leftRotation(root);
			}
			return root;
		}
		
		public void inOrder(Node root)
		{
			if(root != null)
			{
				inOrder(root.left);
				System.out.print(root.value + " ");
				inOrder(root.right);
			}
		}
		
		Node deleteNode(Node root, int key)
		{
			if(root == null)
			{
				return root;
			}
			
			else if(key<root.value)
			{
				root.left = deleteNode(root.left, key);
			}
			
			else if(key>root.value)
			{
				root.right = deleteNode(root.right, key);
			}
			else
			{
				
				Node temp1 = root.left;
				Node temp2 = root.right;
				
				if(temp1 == null )
				{
					root = temp2;
				}
				else if(temp2 == null)
				{
					root = temp1;
				}
				else
				{
					Node currentNode = root.right;
					
					while(currentNode != null)
					{
						if(currentNode.left == null)
							break;
						currentNode = currentNode.left;
					}
					
					root.value = currentNode.value;
					
					root.right = deleteNode(root.right, currentNode.value);
					
				}
			}
			
			if(root == null)
				return root;
			
			root.height = max(getHeight(root.left), getHeight(root.right)) + 1;
			
			int balance = getBalance(root);
			
			if(balance>1 && getBalance(root.left)>= 0)
			{
				return rightRotation(root);
			}
			
			if(balance>1 && getBalance(root.left) <0)
			{
				root.left = leftRotation(root.left);
				
				return rightRotation(root);
			}
			
			if(balance<-1 && getBalance(root.right)<= 0)
			{
				return leftRotation(root);
			}
			
			if(balance<-1 && getBalance(root.right)> 0)
			{
				root.right = rightRotation(root.right);
				
				return leftRotation(root);
			}
			
			return root;
		}
		
	}
	
	public static void main(String args [])
	{
		Scanner sc = new Scanner(System.in);
		
		AVL_Tree myTree = new AVL_Tree();
		
		int data;
		while(true)
		{
			data = sc.nextInt();
			
			if(data == 0)
				break;
			myTree.root = myTree.insert(myTree.root, data);
		}
		
		myTree.inOrder(myTree.root);
		
		while(true)
		{
			data = sc.nextInt();
			
			if(data == 0)
				break;
			myTree.root = myTree.deleteNode(myTree.root, data);
			myTree.inOrder(myTree.root);
		}
	}
}
