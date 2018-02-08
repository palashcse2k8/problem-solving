package topics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PriorityQueue {

	static int [] heap;
	static int N, heapSize;
	
	static void intiHeapSize()
	{
		heapSize = 0;
	}
	
	
	static void swapData(int from, int to)
	{
		int temp = heap[from];
		heap[from] = heap[to];
		heap[to] = temp;
	}
	static void push_heap(int data)
	{
		heap[heapSize] = data;
		
		int temp;
		int currentPosition = heapSize;
		int nextPosition = (currentPosition - 1)/2;
		
		while(currentPosition>0 && heap[currentPosition]<heap[nextPosition])
		{
			swapData(currentPosition, nextPosition);
			
			currentPosition = nextPosition;
			nextPosition = (currentPosition - 1)/2;
		}
		
		heapSize++;
	}
	
	static int findSmaller(int first, int second)
	{
		if(second<heapSize && heap[first]>heap[second])
		{
			return second;
		}
		return first;		
	}
	
	static int pop_heap()
	{
		int value = heap[0];
		heap[0] = heap[--heapSize];
		heap[heapSize] = value;
		
		int currentPosition = 0;
		
		while(currentPosition<heapSize)
		{
			int smaller = findSmaller(2*currentPosition + 1, 2*currentPosition + 2);
			if(smaller<heapSize && heap[currentPosition]>heap[smaller]){
				swapData(currentPosition, smaller);
				
				currentPosition = smaller;
			}
			else
			{
				break;
			}
			
		}
		return value;
	}
	
	static void printHeap(int [] arr)
	{
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream(new File("src/input.txt")));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		heap = new int[N];
		
		intiHeapSize();
		for (int i = 0; i < heap.length; i++) {
			
			push_heap(sc.nextInt());
		}
		
		printHeap(heap);
		
		for (int i = 0; i < heap.length; i++) 
		{		
			System.out.print(pop_heap() + " ");
		}
		System.out.println();
		
		printHeap(heap);
	}

}
