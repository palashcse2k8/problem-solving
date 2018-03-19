package HackerRankProblems;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Simple_Text_Editor {
	
	static class Editor
	{
		char [] editor;
		int index;
		
		
		
		public Editor() {
			editor = new char[10];
			index = 0;
		}
		
		public void insert(String str)
		{
			for (int i = index; i < str.length(); i++) 
			{
				editor[i] = str.charAt(i);
			}
			
			index += str.length();
		}
		
		public void delete(int number)
		{
			index -= number;
		}
		
		public void printEditor(int number)
		{
			for (int i = 0; i < index; i++) {
				System.out.print(editor[i]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream(new File("src/input.txt")));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int type;
		
		Editor myEditor = new Editor();
		for (int i = 0; i < N; i++) {
			type = sc.nextInt();
			
			if(type == 1)
			{
				myEditor.insert(sc.next());
			}
			else if (type == 2) 
			{
				myEditor.delete(sc.nextInt());
			}
			else if (type == 3) 
			{
				myEditor.printEditor(sc.nextInt());
			}
			else {
				
			}
		}

	}

}
