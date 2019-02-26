package others_swc;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;


public class myCompiler {
	
	static Map<String, Integer> myVariables = new HashMap<String, Integer>();
	
	Stack<String> myOperations = new Stack<>();
	Stack<String> Variables = new Stack<>();
	Deque<String> myValues = new ArrayDeque<>();

	static String [] Operations = {"ADD", "SUB", "MULT", "DIV", "POW", "ASSIGN", "PRINT"};
	static Set<String> operationSet = new HashSet<String>(Arrays.asList(Operations)); 
	
	static int flag = 0;
	
	public boolean isValidInput(String str)
	{
		return ((!str.equals("")) && (str != null) && (str.matches("^[a-zA-Z]*$")) || (str.matches("^[0-9]*$")));
	}
	
	public void doOperation(String operation)
	{
		String argument1 = null, argument2;
		
		if(operation.equals("ASSIGN") == true)
		{
			argument1 = myValues.remove();
			argument2 = myValues.remove();
			
			if(isStringOnlyAlphabet(argument2))
			{
				if(!myVariables.containsKey(argument2))
				{
					System.out.println("UNEXPECTED COMMAND");
					flag = 1;
					return;
				}
				argument2 = myVariables.get(argument2).toString();
			}
			
			myVariables.put(argument1, Integer.parseInt(argument2));
			myValues.addFirst(argument1);
			System.out.println("SUCCESS");
		}
		else if(operation.equals("PRINT") == true)
		{
			argument1 = myValues.getFirst();
			if(isStringOnlyAlphabet(argument1))
			{
				if(myVariables.containsKey(argument1))
				{
					System.out.println("PRINTING " + argument1 + " " + myVariables.get(argument1));
				}
				else
				{
					System.out.println("UNEXPECTED COMMAND");
					flag = 1;
					return;
				}
			}
			else
			{
				System.out.println("PRINTING " + argument1);
			}

			
		}
		else if(operation.equals("ADD") == true)
		{
			
			argument1 = myValues.remove();
			argument2 = myValues.remove();
			
			if(isStringOnlyAlphabet(argument2))
			{
				if(!myVariables.containsKey(argument2))
				{
					System.out.println("UNEXPECTED COMMAND");
					flag = 1;
					return;
				}
				argument2 = myVariables.get(argument2).toString();
			}
			
			if(isStringOnlyAlphabet(argument1))
			{
				if(myVariables.containsKey(argument1))
				{
					myVariables.put(argument1, myVariables.get(argument1) + Integer.parseInt(argument2));
					myValues.addFirst(argument1);
					System.out.println("SUCCESS");
				}
				else
				{
					System.out.println("NO VALUE ASSIGN TO " + argument1);
					return;
				}
			}
			else
			{
				System.out.println(argument2 + argument1);
				System.out.println("SUCCEESS");
			}

		}
		else if(operation.equals("POW") == true)
		{
			
			argument1 = myValues.remove();
			argument2 = myValues.remove();
			
			if(isStringOnlyAlphabet(argument2))
			{
				if(!myVariables.containsKey(argument2))
				{
					System.out.println("UNEXPECTED COMMAND");
					flag = 1;
					return;
				}
				argument2 = myVariables.get(argument2).toString();
			}
			
			if(isStringOnlyAlphabet(argument1))
			{
				if(myVariables.containsKey(argument1))
				{
					myVariables.put(argument1, (int) Math.pow(myVariables.get(argument1),  Integer.parseInt(argument2)));
					myValues.addFirst(argument1);
					System.out.println("SUCCESS");
				}
				else
				{
					System.out.println("NO VALUE ASSGIN TO " + argument1);
				}
			}
			else
			{
				System.out.println(argument2 + argument1);
				System.out.println("SUCCEESS");
			}

		}
		else if(operation.equals("SUB") == true)
		{
			
			argument1 = myValues.remove();
			argument2 = myValues.remove();
			
			if(isStringOnlyAlphabet(argument2) )
			{
				if(!myVariables.containsKey(argument2))
				{
					System.out.println("UNEXPECTED COMMAND");
					flag = 1;
					return;
				}
				argument2 = myVariables.get(argument2).toString();
			}
			
			if(isStringOnlyAlphabet(argument1))
			{
				if(myVariables.containsKey(argument1))
				{
					myVariables.put(argument1, myVariables.get(argument1) - Integer.parseInt(argument2));
					myValues.addFirst(argument1);
					System.out.println("SUCCESS");
				}
				else
				{
					System.out.println("UNEXPECTED COMMAND");
					flag = 1;
					return;
				}
			}
			else
			{
				System.out.println(argument2 + argument1);
				System.out.println("SUCCEESS");
			}

		}
		else if(operation.equals("MULT") == true)
		{
			
			argument1 = myValues.remove();
			argument2 = myValues.remove();
			
			if(isStringOnlyAlphabet(argument2))
			{
				
				if(!myVariables.containsKey(argument2))
				{
					System.out.println("UNEXPECTED COMMAND");
					flag = 1;
					return;
				}
				
				argument2 = myVariables.get(argument2).toString();
			}
			
			if(isStringOnlyAlphabet(argument1))
			{
				if(myVariables.containsKey(argument1))
				{
					myVariables.put(argument1, myVariables.get(argument1) * Integer.parseInt(argument2));
					myValues.addFirst(argument1);
					System.out.println("SUCCESS");
				}
				else
				{
					System.out.println("NO VALUE ASSGIN TO " + argument1);
				}
			}
			else
			{
				System.out.println(argument2 + argument1);
				System.out.println("SUCCEESS");
			}

		}
		else if(operation.equals("DIV") == true)
		{
			
			argument1 = myValues.remove();
			argument2 = myValues.remove();
			
			if(isStringOnlyAlphabet(argument2))
			{
				if(!myVariables.containsKey(argument2))
				{
					System.out.println("UNEXPECTED COMMAND");
					flag = 1;
					return;
				}
				argument2 = myVariables.get(argument2).toString();
			}
			
			if(isStringOnlyAlphabet(argument1))
			{
				if(myVariables.containsKey(argument1))
				{
					myVariables.put(argument1, myVariables.get(argument1) / Integer.parseInt(argument2));
					myValues.addFirst(argument1);
					System.out.println("SUCCESS");
				}
				else
				{
					System.out.println("NO VALUE ASSGIN TO " + argument1);
				}
			}
			else
			{
				System.out.println(argument2 + argument1);
				System.out.println("SUCCEESS");
			}

		}
		else
		{
			//System.out.println(myValues.pop() - myValues.pop());
			System.out.println("NOTHING MATCHED");
		}
		

	}
	
	public static boolean isStringOnlyAlphabet(String str) 
	{ 
	    return ((!str.equals("")) && (str != null) && (str.matches("^[a-zA-Z]*$")));
	}
	
	public static boolean isStringOnlyDigits(String str) 
	{ 
	    return ((!str.equals("")) && (str != null) && (str.matches("^[0-9]*$")));
	} 
	
	
	public void parseToken()
	{
		while(!myOperations.isEmpty())
		{
			String operation = myOperations.pop();
			doOperation(operation);
			if(flag == 1)
			{
				return;
			}
		}
	}
	
	
	public void makeToken(String str)
	{
		
		String [] tokens = str.split(" |,");
		//System.out.println(tokens.length);
		
		for (int i = 0; i < tokens.length; i++) {
			
			
			if(i==0 && operationSet.contains(tokens[i]) == false)
			{
				System.out.println("UNEXPECTED COMMAND");
				flag = 1;
				return;
			}
			
			if(operationSet.contains(tokens[i]) == true)
			{

				myOperations.push(tokens[i]);
			}
			else{
				
				if(tokens[i] != null && !tokens[i].equals(""))
				{
					if(isValidInput(tokens[i]))
					{
						myValues.add(tokens[i]);
					}
					else
					{
						System.out.println("UNEXPECTED COMMAND");
						flag = 1;
						return;
					}
					
				}
			
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		
		Scanner myScanner = new Scanner(System.in);
		
		String inputLine ;
		myCompiler compiler = new myCompiler();
		
		while (true)
		{	
			
			inputLine = myScanner.nextLine();
			flag = 0;
			compiler.myOperations = new Stack<>();
			compiler.Variables = new Stack<>();
			compiler.myValues = new ArrayDeque<>();

			compiler.makeToken(inputLine);
			
			if(flag == 0)
			{
				compiler.parseToken();
			}
		}
	}

}
