package HackerRankProblems;

import java.util.Scanner;

public class Contacts {
	
	
	static class Node{
		int isLeaf;
		int frequency;
		Node child [];
		
		public Node() {			
			isLeaf = 0;
			frequency = 0;
			child = new Node[26];
		}
	}
	
	static class ContactsList{
		Node root;
		
		public ContactsList() {
			root = new Node();
		}
		
		public Node insertContacts(Node root, String str)
		{
			Node currentNode = root;
			int index;
			for (int i = 0; i < str.length(); i++) 
			{
				index = str.charAt(i) - 'a';
				
				if(currentNode.child[index] == null)
				{
					currentNode.child[index] = new Node();
				}
				
				currentNode = currentNode.child[index];
				currentNode.frequency++;
				
			}
			
			currentNode.isLeaf = 1;
			return root;
		}
		
		public int searchContacts(Node root, String str)
		{
			Node currentNode = root;
			int index;
			for (int i = 0; i < str.length(); i++)
			{
				index = str.charAt(i) - 'a';
				
				if(currentNode.child[index] == null)
				{
					return 0;
				}
				
				currentNode = currentNode.child[index];
				
			}

			return currentNode.frequency;
		}
		
		public void printContacts(Node root, String str)
		{
			
			if(root.isLeaf == 1)
			{
				System.out.println(str);
			}
			
			char ch;
			for (int i = 0; i < 26; i++)
			{
				ch = (char) (i + 'a');
				
				if(root.child[i] != null)
				{
					printContacts(root.child[i], str + ch);
				}
			}
			
		}
	}

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		ContactsList myContacts = new ContactsList();
		
		int queryNumber = sc.nextInt();
		
		String query, value;
		
		for (int i = 0; i < queryNumber; i++) 
		{
			query = sc.next();
			value = sc.next();
			
			if(query.equals("add"))
			{
				myContacts.insertContacts(myContacts.root, value);
			}
			else
			{
				System.out.println(myContacts.searchContacts(myContacts.root, value));
			}
			
//			myContacts.printContacts(myContacts.root, "");
		}
		
		

	}

}
