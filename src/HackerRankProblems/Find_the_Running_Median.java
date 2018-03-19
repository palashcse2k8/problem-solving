package HackerRankProblems;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Find_the_Running_Median {
	
	static float [] arr, index;
	
	static public void merge(int left, int mid, int right)
	{
		int n1 = mid - left + 1;
		int n2 = right - mid;
		
		float L[] = new float[n1]; 
		float R[] = new float[n2];
		
		for (int i = 0; i < L.length; i++) {
			L[i] =  arr[left + i];
		}
		
		for (int i = 0; i < R.length; i++) {
			R[i] = arr[mid + i + 1];
		}
		
		
		int i = 0, j = 0, k = left;
		
		while (i<n1 && j<n2) 
		{
			if(L[i]<=R[j])
			{
				arr[k++] = L[i++];
			}
			else
			{
				arr[k++] = R[j++];
			}
		}
		
		while(i<n1)
		{
			arr[k++] = L[i++];
		}
		
		while(j<n2)
		{
			arr[k++] = R[j++];
		}
		
	}
	
	static public void sorT(int l, int r)
	{
		if(l<r)
		{
			int m = (l+r)/2;
			sorT(l,m);
			sorT(m + 1, r);
			
			merge(l,m,r);
		}
	}
	
	static public void printArray(float []  ar)
	{
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + " ");
		}
		System.out.println();
	}
	
	static class Min_Heap{
		
		int heapArray [], heapSize;
		
		public Min_Heap(int n) {
			this.heapArray = new int [n];
			this.heapSize = 0;
		}
		
		public void swapData(int from , int to)
		{
			int temp = this.heapArray[from];
			this.heapArray[from] = this.heapArray[to];
			this.heapArray[to] = temp;
		}
		
		public void printHeap()
		{
//			System.out.println("Printing Heap ...");
			for (int i = 0; i < this.heapSize; i++) {
				System.out.print(this.heapArray[i]+ " ");
			}
			System.out.println();
		}
		
		public void push(int data) 
		{
			this.heapArray[this.heapSize] = data;
			
			int currentPosition = this.heapSize++;
			
			while(currentPosition>0 && this.heapArray[(currentPosition-1)/2]>this.heapArray[currentPosition]) 
			{
				swapData((currentPosition-1)/2, currentPosition);
				
				currentPosition = (currentPosition-1)/2;
			}
		}
		
		public int getMin()
		{
			return this.heapArray[0];
		}
		
		public int pop() 
		{
			int value = this.heapArray[0];
			
			if(this.heapSize>0)
				swapData(0, --this.heapSize);
			else
				return value;
			
			int currentPos = 0;
			int nextPosition;
			while(currentPos<this.heapSize)
			{
				if(currentPos*2 + 1< this.heapSize)
				{
					nextPosition = currentPos*2 + 1;
					if(currentPos*2 + 2 < this.heapSize && this.heapArray[currentPos*2 + 1]> this.heapArray[currentPos*2 + 2])
					{
						nextPosition = currentPos*2 + 2;
					}
					
					if(this.heapArray[currentPos]>this.heapArray[nextPosition])
					{
						swapData(currentPos, nextPosition);
						currentPos = nextPosition;
					}
					else {
						break;
					}
				}
				else
				{
					break;
				}
			}
			
			return value;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream(new File("src/input.txt")));
		System.setOut(new PrintStream(new File("src/output.txt")));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Min_Heap myMinHeap = new Min_Heap(N);
		Min_Heap myMaxHeap = new Min_Heap(N);
		
		float first = 0 , second;
		for (int i = 0; i < N; i++)
		{
			
			if(i==0)
			{
				first = sc.nextInt();
				
				System.out.printf("%.1f\n", first);
				
			}
			else if (i==1) 
			{
				second = sc.nextInt();
				
				if(first>second)
				{
					myMinHeap.push((int) first);
					myMaxHeap.push((int) (-1*second));
				}
				else
				{
					myMinHeap.push((int) second);
					myMaxHeap.push((int) (-1*first));
				}
				
				System.out.printf("%.1f\n", (first + second)/2);
				
			}
			else
			{
				int data = sc.nextInt();
				if(data<(myMaxHeap.getMin()*-1))
				{
					myMaxHeap.push(-1*data);
				}
				else {
					myMinHeap.push(data);
				}
				
				if(Math.abs(myMaxHeap.heapSize-myMinHeap.heapSize)>1)
				{
					if(myMaxHeap.heapSize>myMinHeap.heapSize)
					{
						myMinHeap.push(myMaxHeap.pop()*-1);
					}
					else
					{
						myMaxHeap.push(myMinHeap.pop()*-1);
					}
				}
				
				System.out.println("Printing Heap ...");
				myMinHeap.printHeap();
				myMaxHeap.printHeap();
				if(i%2 != 0)
				{
//					System.out.println("myMinHeap.getMin() -> " + myMinHeap.getMin());
//					System.out.println("myMaxHeap.getMin()*-1 -> " + myMaxHeap.getMin()*-1);
					
					float result = (float)(myMinHeap.getMin() + (myMaxHeap.getMin()*-1))/2;
					System.out.printf("%.1f\n", result);
				}
				else{
					float result = (myMaxHeap.getMin() * -1);
					if(myMaxHeap.heapSize<myMinHeap.heapSize)
					{
						result = myMinHeap.getMin();
					}
					System.out.printf("%.1f\n", result);
				}
			}
			
			
		}	
	}

}
