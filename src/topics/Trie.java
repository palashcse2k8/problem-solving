package topics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Trie {
	
	static int maxSize = 126;
	
	static class Node{
		int isLeaf;
		int frequency;
		
		Node [] child;
		
		public Node() {
			this.isLeaf = 0;
			this.frequency = 0;
			child = new Node[maxSize];
		}
	}
	
	static class MainTrie{
		Node root;
		
		public MainTrie() {
			root = new Node();
		}
		
		public void createTrie(Node root, String str)
		{
			Node currentNode = root;
			int index;
			for (int i = 0; i < str.length(); i++) {
				index = str.charAt(i);
				if(currentNode.child[index] == null)
				{
					currentNode.child[index] = new Node();
					currentNode = currentNode.child[index];
				}
			}
			
			currentNode.isLeaf = 1;
		}
		
		public void searchTrie(Node root, String str)
		{
			Node currentNode = root;
			int index;
			for (int i = 0; i < str.length(); i++) {
				index = str.charAt(i);
				
				if(currentNode.child[index] != null)
				{
					currentNode = currentNode.child[index];
				}
				else {
					System.out.println("Not found");
					return;
				}
			}
			
			if(currentNode.isLeaf == 1)
			{
				System.out.println("Found");
			}
			else
			{
				System.out.println("Not found");
			}
		}
		public void printTrie(Node root, String output)
		{
			if(root.isLeaf == 1)
			{
				System.out.println(output);
			}
			
			for (int i = 0; i < maxSize; i++) {
				if(root.child[i] != null)
				{
					char ch = (char) (i);
					printTrie(root.child[i], output + ch);
				}
			}
		}
	}
	
	
	public static void main (String args[]) throws FileNotFoundException
	{
		System.setIn(new FileInputStream(new File("src/input.txt")));
		Scanner sc = new Scanner(System.in);
		
		MainTrie myTire = new MainTrie();
		
		myTire.createTrie(myTire.root, sc.next());
		myTire.createTrie(myTire.root, sc.next());
		
		
		
		myTire.printTrie(myTire.root, "");
		
		myTire.searchTrie(myTire.root, sc.next());
	}

}
