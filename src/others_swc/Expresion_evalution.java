package others_swc;

import java.util.Scanner;

public class Expresion_evalution {
	
	static class Node {
		char sign;
		int divisor;
		int expression;
		
		Node nextNode;
		
		public Node() {
			sign = '+';
			divisor = 1;
			expression = 1;
			nextNode = null;
		}
	}
	
	static class ExpressionHandler
	{
		int totoalDivisor;
		int possitiveNumber;
		int negetiveNumber;
		int totalDividend;
		String ans;
		Node root;
		
		public ExpressionHandler() 
		{
			totoalDivisor = 1;
			possitiveNumber = 0;
			negetiveNumber = 0;
			totalDividend = 0;
			ans = "";
			this.root = new Node();
		}
		
		public void insertNode(Node newNode)
		{
			if(root == null)
			{
				root = newNode;
			}
			else
			{
				newNode.nextNode = root;
				root = newNode;
			}
		}
		
		
		public void simplifyExp()
		{
			Node currentNode = this.root;
			
			while(currentNode != null)
			{
				if(currentNode.sign == '+')
				{
					this.possitiveNumber += currentNode.expression;
				}
				else {
					this.negetiveNumber += currentNode.expression;
				}
				currentNode = currentNode.nextNode;
			}
			
			this.totalDividend = this.possitiveNumber - this.negetiveNumber;
			
			System.out.println(this.totalDividend + "/" + this.totoalDivisor);
			
			int result = this.divideNumbers(this.totalDividend, this.totoalDivisor);
			ans += result;
				
			int reminder = this.totalDividend - (result*this.totoalDivisor);
			
			ans += '.';
			int cnt = 0;
			while(reminder>0)
			{
				if(cnt>=30)
				{
					break;
				}
				reminder = reminder*10;
				result = this.divideNumbers(reminder, this.totoalDivisor);
				ans += result;
				reminder = reminder - (result*this.totoalDivisor);
				cnt++;
			}
		}
		
		
		public void addExpression(String exp)
		{
			
			int currentNumber = 0;
			int div = 0;
			for (int i = 0; i < exp.length(); i++) 
			{
				if(exp.charAt(i) == '*')
				{
					if(div == 1 )
					{
						this.root.divisor *= currentNumber;
						totoalDivisor *= currentNumber;
						currentNumber = 0;
						div = 0;
					}
					else
					{
						this.root.expression *= currentNumber;
						currentNumber = 0;
					}
				}
				else if(exp.charAt(i) == '/')
				{
					if(div == 1)
					{
						this.root.divisor *= currentNumber;
						totoalDivisor *= currentNumber;
						currentNumber = 0;
					}
					else{
						div = 1;
						this.root.expression *= currentNumber;
						currentNumber = 0;
					}
					
				}
				else if(exp.charAt(i) == '+' || exp.charAt(i) == '-')
				{
					if(div == 1 )
					{
						this.root.divisor *= currentNumber;
						totoalDivisor *= currentNumber;
						div = 0;
						currentNumber = 0;				
					}
					else
					{
						this.root.expression *= currentNumber;
						currentNumber = 0;
					}
					
					Node tempNode = new Node();
					tempNode.sign = exp.charAt(i);
					insertNode(tempNode);	
				}
				else 
				{
					currentNumber = currentNumber*10 + (exp.charAt(i) - '0');
				}
			}
			
			if(div == 1 )
			{
				this.root.divisor *= currentNumber;
				totoalDivisor *= currentNumber;
				currentNumber = 0;	
				div = 0;
			}
			else
			{
				this.root.expression *= currentNumber;
				currentNumber = 0;
			}
			
			
//			printExpresiion();
			
			Node currentNode = this.root;
			
			while(currentNode != null)
			{
				currentNode.expression *= totoalDivisor/currentNode.divisor;
				currentNode = currentNode.nextNode;
			}
		}
		
		public void printExpresiion()
		{
			Node currentNode = this.root;
			
			while(currentNode != null)
			{
				System.out.println(currentNode.sign);
				System.out.println(currentNode.expression + "/" + currentNode.divisor);
				currentNode = currentNode.nextNode;
			}
		}
		
		public int addNumbers(int number1, int number2)
		{
			return number1+number2;
		}
		
		public int subtructNumbers(int number1, int number2)
		{
			return number1-number2;
		}
		
		public int multiplyNumbers(int number1, int number2)
		{
			return number1*number2;
		}
		
		public int divideNumbers(int number1, int number2)
		{
			return number1/number2;
		}
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		String expression = sc.nextLine();
		
		ExpressionHandler myExpression = new ExpressionHandler();
		
		myExpression.addExpression(expression);
		myExpression.simplifyExp();
		System.out.println(myExpression.ans);
//		myExpression.printExpresiion();
	}

}
