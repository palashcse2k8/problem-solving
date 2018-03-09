package HackerRankProblems;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class SubArrayDiff1 {
	
	static int arr[], N;
	public static int findMaxLength()
	{
		Arrays.sort(arr);
		
		int initial = -1, current = -1;
		int Maxlength = 0;
		int currentMax = 0;
		
		for (int i = 0; i < arr.length; i++) 
		{
			if(i==0)
			{
				initial = current = arr[i];
				currentMax++;
			}
			else
			{
				if(Math.abs(arr[i]-initial)<=1)
				{
					current = arr[i];
					currentMax++;
				}
				else {
					
					if (Maxlength<currentMax)
					{
						Maxlength = currentMax;
						currentMax = 1;
					}
					initial = current;
					
					if(Math.abs(arr[i]-initial)<=1)
					{
						current = arr[i];
						currentMax++;
					}
					else {
						initial = current = arr[i];
					}
				}
			}
		}
		
		if (Maxlength<currentMax)
		{
			Maxlength = currentMax;
			currentMax = 1;
		}
		
		return Maxlength;
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream(new File("src/input.txt")));
		//System.setOut(new PrintStream( new File("src/output.txt")));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < arr.length; i++) 
		{
			arr[i] = sc.nextInt();
		}
		
		int value = findMaxLength();
		
		System.out.println("Array Size: " + arr.length + " max length is: " + value);
		
		sc.close();
	}

}
