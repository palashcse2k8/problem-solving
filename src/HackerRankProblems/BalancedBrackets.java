package HackerRankProblems;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class BalancedBrackets {


	static char stack [], top;
	
	static void push_stack(char ch)
	{
		stack[top++] = ch;
	}
	
	static char pop_stack()
	{
		return stack[--top];
	}
	static int stack_size()
	{
		return top;
	}
	
    static String isBalanced(String s) 
    {
		String matched = "Yes";
    	for (int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
			{
				push_stack(s.charAt(i));
			}		
			else {
				if(s.charAt(i) == ')')
				{
					if(pop_stack() != '(')
					{
						return "NO";
					}
				}
				else if(s.charAt(i) == '}')
				{
					if(pop_stack() != '{')
					{
						return "NO";
					}
				}
				else if(s.charAt(i) == ']')
				{
					if(pop_stack() != '[')
					{
						return "NO";
					}
				}
			}
		}
    	
    	if(stack_size() != 0)
    	{
    		return "NO";
    	}
    	
    	return "YES";
    }

    public static void main(String[] args) throws FileNotFoundException {
    	
    	System.setOut(new PrintStream( new File("src/output.txt")));
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
        	top = 0;
        	stack = new char[1000000];
            String s = in.next();
            String result = isBalanced(s);
            System.out.println(result);
        }
        in.close();
    }
}
