package UVA;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Uva_11286_Conformity {

	static int maxSize = 401;

	static class Node {
		int isLeaf;
		int frequency;
		Node[] childs;

		public Node() {
			isLeaf = 0;
			frequency = 0;
			childs = new Node[maxSize];
		}
	}

	static class Trie {
		Node root;
		int maxValue;
		int c;

		public Trie() {
			root = new Node();
			maxValue = 0;
			c = 0;
		}

		void insertTrie(Node root, int[] arr) {
			Node currentNode = root;
			int index;

			for (int i = 0; i < arr.length; i++) {
				index = arr[i] - 100;

				if (currentNode.childs[index] == null) {
					currentNode.childs[index] = new Node();
				}
				currentNode = currentNode.childs[index];
				currentNode.frequency++;
			}

			currentNode.isLeaf++;
			
			if(currentNode.isLeaf == maxValue)
			{
				c++;
			}		
			else if(maxValue<currentNode.isLeaf)
			{
				maxValue = currentNode.isLeaf;
				c = 1;
			}	
		}
		
		void searchMax(Node root)
		{
			if (root.isLeaf > 0) {
				
				if(root.isLeaf == this.maxValue)
				{
					c += root.isLeaf;
				}
			}

			for (int i = 0; i < maxSize; i++) {
				if (root.childs[i] != null) {
					searchMax(root.childs[i]);
				}
			}
		}

		void printTrie(Node root, String str) {
			if (root.isLeaf > 0) {
				System.out.println(str);
			}

			int value;
			for (int i = 0; i < maxSize; i++) {

				value = i + 100;
				if (root.childs[i] != null) {
					printTrie(root.childs[i], str + value + " ");
				}
			}
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		try {
			System.setIn(new FileInputStream(new File("src/input.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int N;
		int [] dataArr = new int[5];
		
		while(true)
		{
			N = sc.nextInt();
			
			if(N == 0)
				break;
			
			Trie myTrie = new Trie();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < dataArr.length; j++) {
					dataArr[j] = sc.nextInt();
				}
				
				Arrays.sort(dataArr);
				myTrie.insertTrie(myTrie.root, dataArr);	
			}
//			myTrie.searchMax(myTrie.root);
			System.out.println(myTrie.c * myTrie.maxValue);
//			myTrie.printTrie(myTrie.root, "");			
		}

	}
}
