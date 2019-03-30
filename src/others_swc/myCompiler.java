package others_swc;

/*
try these input also works for lower case operation name
ADD 2 2 2
MULT 2 2 2
add 2 2 2
mult 2 2 2
ADD X, 4
SQRT 9
HELLO CLASS
ASSIGN X, 10
ADD X, 10
PRINT X
PRINT ASSIGN Y, X
ADD X, Y
PRINT ADD POW X, 2, 4
SUB Y, $
PRINT ::))
PRINT 100
ADD PRINT ASSIGN Z, 100, 4
 */
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

	Stack<String> myOperations = new Stack<>(); //to add the valid operations
	Stack<String> Variables = new Stack<>();
	Deque<String> myValues = new ArrayDeque<>(); // to add the valid values and variables, used dequeue to add/remove in both side

	static String [] Operations = {"ADD", "SUB", "MULT", "DIV", "POW", "ASSIGN", "PRINT"}; //set of valid operations
	static Set<String> operationSet = new HashSet<String>(Arrays.asList(Operations)); 

	static int flag = 0; //to terminate for unexpected command

	//checking the input validity only digit or alphabet
	public boolean isValidInput(String str)
	{
		return ((!str.equals("")) && (str != null) && (str.matches("^[a-zA-Z]*$")) || (str.matches("^[0-9]*$")));
	}


	//doing operations
	public void doOperation(String operation)
	{
		String argument1 = null, argument2;

		if(operation.equals("ASSIGN") == true)
		{
			argument1 = myValues.remove();
			argument2 = myValues.remove();

			//checking the 2nd input is variable or digit			
			if(isStringOnlyAlphabet(argument2))
			{
				// if variable checking if it is in the dictionary already
				if(!myVariables.containsKey(argument2))
				{
					System.out.println("UNEXPECTED COMMAND");
					flag = 1;
					return;
				}
				// convert integer to string
				argument2 = myVariables.get(argument2).toString();
			}

			if(isStringOnlyAlphabet(argument1))
			{
				myVariables.put(argument1, Integer.parseInt(argument2));
				// adding if x 100 x = 100
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

					if(myOperations.isEmpty() && !myValues.isEmpty())
					{
						while(!myValues.isEmpty())
						{
							myVariables.put(argument1, myVariables.get(argument1) + Integer.parseInt(myValues.remove()));
						}		
					}					
					myValues.addFirst(argument1);
					System.out.println("SUCCESS");
				}
				else
				{
					System.out.println("NO VALUE ASSIGN TO " + argument1);
					return;
				}
			}
			else // if all the values are integer and there is varibale
			{
				int result = Integer.parseInt(argument1) + Integer.parseInt(argument2);
				while(!myValues.isEmpty())
				{
					result += Integer.parseInt(myValues.remove());
				}

				System.out.println(result);
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
					System.out.println("No value found for  " + argument1);
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
					if(myOperations.isEmpty() && !myValues.isEmpty())
					{
						while(!myValues.isEmpty())
						{
							myVariables.put(argument1, myVariables.get(argument1) * Integer.parseInt(myValues.remove()));
						}		
					}	
					myValues.addFirst(argument1);
					System.out.println("SUCCESS");
				}
				else
				{
					System.out.println("NO VALUE ASSGIN TO " + argument1);
				}
			}
			else // if all the inputs are digit and no variable to parse
			{
				int result = Integer.parseInt(argument1) * Integer.parseInt(argument2);
				while(!myValues.isEmpty())
				{
					result *= Integer.parseInt(myValues.remove());
				}

				System.out.println(result);
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
				System.out.println(Integer.parseInt(argument1) / Integer.parseInt(argument2));
				System.out.println("SUCCEESS");
			}

		}
		else
		{
			//System.out.println(myValues.pop() - myValues.pop());
			System.out.println("NOTHING MATCHED");
		}


	}

	//checking only alphabet
	public static boolean isStringOnlyAlphabet(String str) 
	{ 
		return ((!str.equals("")) && (str != null) && (str.matches("^[a-zA-Z]*$")));
	}

	//checking only digits 
	public static boolean isStringOnlyDigits(String str) 
	{ 
		return ((!str.equals("")) && (str != null) && (str.matches("^[0-9]*$")));
	} 


	//parsing the tokens
	public void parseToken()
	{
		//checking the stack is empty or not, will continue until the stack is empty
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

		//spliting the input against space and comma
		String [] tokens = str.split(" |,");

		for (int i = 0; i < tokens.length; i++) {

			tokens[i] = tokens[i].toUpperCase();

			//checking the first token validity
			if(i==0 && operationSet.contains(tokens[i]) == false)
			{
				System.out.println("UNEXPECTED COMMAND");
				flag = 1;
				return;
			}

			//add the valid operation in stack
			if(operationSet.contains(tokens[i]) == true)
			{

				myOperations.push(tokens[i]);
			}
			else{

				//adding valid input in de queue
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



	public static void main(String[] args) 
	{
		Scanner myScanner = new Scanner(System.in);

		String inputLine ;
		myCompiler compiler = new myCompiler();

		//to get continuous input 
		while (true)
		{	
			//taking string input as line
			inputLine = myScanner.nextLine();

			//intializing the data structure
			flag = 0;
			compiler.myOperations = new Stack<>();
			compiler.Variables = new Stack<>();
			compiler.myValues = new ArrayDeque<>();

			// tokenize the input
			compiler.makeToken(inputLine);

			if(flag == 0)
			{
				//parsing the input
				compiler.parseToken();
			}
		}
	}

}
