package topics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class CompoundsSearching {
	
	
	static int maxSize = 10;
	
	static class hashTable{
		
		class NodeList{
			int value;
			NodeList nexNode;
			NodeList lastNode;
			
			public NodeList(int data) {
				value = data;
				nexNode = null;
				lastNode = null;
			}
			
			void addNode1(NodeList newNode)
			{
				NodeList temp = this;
				while(temp.nexNode != null){
					temp = temp.nexNode;
				}
				
				temp.nexNode = newNode;
			}
			
			void addNode(NodeList newNode)
			{
				if(lastNode == null)
				{
					lastNode = newNode;
				}
				
				lastNode.nexNode = newNode;
				lastNode = lastNode.nexNode;
			}
			
			void printNodeList()
			{
				NodeList temp = this;
				
				while(temp != null)
				{
					System.out.print(temp.value + " ");
					temp = temp.nexNode;
				}
			}
		}
		
		class Node{
			int key;
			char [] value;
			NodeList listNode;
			
			public Node(int key, char [] value, int listIndex) {
				
				this.key = key;
				this.value = value;
				listNode = new NodeList(listIndex);
			}
		}
		
		Node [] table;
		
		public hashTable() 
		{
			table = new Node[maxSize];
		}
		
		void addData(char [] st, int number)
		{
			int index = makeHash(st);
			
			while(table[index] != null)
			{
				if(compareString(table[index].value,st)==1)
				{
					table[index].listNode.addNode(new NodeList(number));
					return;
				}
				index = (index + 1)%maxSize;
				
			}
			
			table[index] = new Node(index, st,number);	
		}
		
		
		int makeHash(char [] st)
		{
			int hash = 5381;
			
			for (int i = 0; i < st.length; i++) {
				hash =((hash<<5) + hash)+ st[i];
			}
			
			if(hash<0) hash *= -1;
			return hash%maxSize;
		}
		
		int compareString(char [] st1, char [] st2)
		{
			if(st1.length != st2.length)
			{
				return 0;
			}
			
			for (int i = 0; i < st1.length; i++) {
				if(st1[i]!=st2[i])
				{
					return 0;
				}
			}
			return 1;
		}
	}
	
	public static void main(String args[]) throws FileNotFoundException
	{
		System.setIn(new FileInputStream(new File("src/input.txt")));
		System.setOut(new PrintStream( new File("src/output.txt")));
		Scanner sc = new Scanner(System.in);
		
		hashTable tb = new hashTable();
		
		int N = sc.nextInt();
		
		for (int i = 0; i < 6; i++) {
//			System.out.println(tb.makeHash(sc.next().toCharArray()));
			tb.addData(sc.next().toCharArray(), i);
			
		}
		tb.table[0].listNode.printNodeList();
	}
}

	