package problem.list;

import java.util.Scanner;

public class Normal_Text_Editor {
	
	static int maxSize = 22;
	static class editor{
		
		char [] editor;
		int start, end;
		
		public editor(int size) {
			editor = new char[size] ;
			start = 0;
			end = size - 1;
		}
		
		public void swapCharacter(int from, int to)
		{
			char ch = editor[from];
			editor[from] = editor[to];
			editor[to] = ch;
		}
		
		public void moveCursor(int pos)
		{
			if(pos != start)
			{
				if(pos<start)
				{
					for (int i = start - 1; i >= pos; i--) {
						swapCharacter(i, end);
						end--;
					}
				}
				else
				{
					for (int i = start; i <= pos; i++) 
					{
						swapCharacter(i, end);
						end++;
					}
				}
				
				start = pos;
			}	
		}
		
		public void insert(char [] str, int length, int pos)
		{
			int index = 0;
			
			moveCursor(pos);
			
			while(index<length)
			{
				editor[start++] =  str[index++];
			}
		}
		
		public void delete(int pos, int length)
		{
			moveCursor(pos);
			end += length;
		}
		
		public char [] read (int pos, int length)
		{
			char[] data = new char [length];
			int dataIndex = 0;
			if(pos<start)
			{
				while(pos<start && dataIndex<length)
				{
					data[dataIndex++] = editor[pos++];
				}
				
				pos = end + 1;
			}
			else
			{
				int diff = pos - start;
				pos = end + diff;
			}
			
			while(dataIndex<length)
			{
				data[dataIndex++] = editor[pos++];
			}
			
			return data;
		}
		
		public void print ()
		{
			int pos = 0;
			
			if(pos<start)
			{
				while(pos<start)
				{
					System.out.print(editor[pos++]);
				}
				
				pos = end + 1;
			}
			
			while(pos<=editor.length-1)
			{
				System.out.print(editor[pos++]);
			}
			
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		
		char [] output = new char [maxSize];
		editor myTextEditor = new editor(maxSize);
		
		String input2 = "Is a good boy";
		String input = " Sami?";
		myTextEditor.insert(input.toCharArray(), input.length(), 0);
		myTextEditor.insert(input2.toCharArray(), input2.length(), 0);
		
//		myTextEditor.insert("la".toCharArray(), 2, 2);
		
		
//		myTextEditor.delete(15, 5);
		myTextEditor.print();
		output = myTextEditor.read(3, 7);
		
		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i]);
		}
		System.out.println();
	}

}
