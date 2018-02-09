package topics;

import java.util.Scanner;

public class BinaryConveration {
	
	static String str;
	
	static void binaryUsingBitOperation(int N)
	{
		str = "";
		for (int i = 31; i >= 0; i--) 
		{
			str+= (N>>i) & 1;
		}
		System.out.println(str);
	}
	
	static void binary(int n){
		
		if(n>1)
		{
			binary(n/2);
		}
		str += n%2;
	}

	public static void main(String args [])
	{
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		binaryUsingBitOperation(N);
		
		str ="";
		binary(N);
		System.out.println(str);
	}
}
