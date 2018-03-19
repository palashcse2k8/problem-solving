package topics;

import java.awt.peer.SystemTrayPeer;
import java.util.Scanner;

public class BinaryConveration {
	
	static String str;
	static int [] arr = new int[32];
	static void binaryUsingBitOperation(int N)
	{
		str = "";
		for (int i = 31; i >= 0; i--) 
		{
			str+= (N>>i) & 1;
		}
		System.out.println(str);
	}
	
	static void binaryUsingBitOperation1(int N)
	{
		int index = 0;
		for (int i = 31; i >= 0; i--) 
		{
			arr[index++]= (N>>i) & 1;
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
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
		binaryUsingBitOperation1(N);
		
		str ="";
		binary(N);
		System.out.println(str);
	}
}
