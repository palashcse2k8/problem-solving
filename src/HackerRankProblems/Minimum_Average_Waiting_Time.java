package HackerRankProblems;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Minimum_Average_Waiting_Time {

	public static class PriorityQueue {
		
		static class Heap
		{
			int startTime; 
			int waitTime;
			
			public Heap(int i, int j) {
				startTime = i;
				waitTime = j;
			}
		}
		
		static Heap [] heap;
		static int heapSize;
		
		
		public PriorityQueue(int n) {
			heap = new Heap[n];
			heapSize = 0;
		}
		
		static void swapData(int from, int to)
		{
			Heap temp = heap[from];
			heap[from] = heap[to];
			heap[to] = temp;
		}
		void push_heap(Heap data)
		{
			heap[heapSize] = data;
			
			int currentPosition = heapSize;
			int nextPosition = (currentPosition - 1)/2;
			
			while(currentPosition>0 && heap[currentPosition].waitTime<heap[nextPosition].waitTime)
			{
				swapData(currentPosition, nextPosition);
				
				currentPosition = nextPosition;
				nextPosition = (currentPosition - 1)/2;
			}
			
			heapSize++;
		}
		
		static int findSmaller(int first, int second)
		{
			if(second<heapSize && heap[first].waitTime>heap[second].waitTime)
			{
				return second;
			}
			return first;		
		}
		
		Heap pop_heap()
		{
			Heap value = heap[0];
			heap[0] = heap[--heapSize];
			heap[heapSize] = value;
			
			int currentPosition = 0;
			
			while(currentPosition<heapSize)
			{
				int smaller = findSmaller(2*currentPosition + 1, 2*currentPosition + 2);
				if(smaller<heapSize && heap[currentPosition].waitTime>heap[smaller].waitTime){
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
		
		Boolean isEmpty()
		{
			if(PriorityQueue.heapSize>0)
				return false;
			
			return true;
			
		}
		
		static void printHeap(Heap [] arr)
		{
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i].startTime + " " + arr[i].waitTime);
			}
			
			System.out.println();
		}
	}
	
    static int minimumAverage(int[][] customers) {
		
    	PriorityQueue myPQueue = new PriorityQueue(customers.length);
    	int currentTime = 0;
    	int waitingtime = 0;
    	PriorityQueue.Heap tempData;
    	for (int i = 0; i < customers.length; i++) {
    		if(i==0 || customers[i][0] <= currentTime)
    		{
    			tempData = new PriorityQueue.Heap(customers[i][0], customers[i][1]);
    			myPQueue.push_heap(tempData);
    		}
    		
    		else if (!myPQueue.isEmpty())
    		{
    			while(!myPQueue.isEmpty() && currentTime > customers[i][0])
    			{
    				tempData = myPQueue.pop_heap();
    				currentTime += tempData.waitTime;
    				waitingtime += currentTime - tempData.startTime;
    			}
    			
    			tempData = new PriorityQueue.Heap(customers[i][0], customers[i][1]);
    			if(myPQueue.isEmpty())
    				currentTime = Math.max(currentTime, customers[i][0]);
    			myPQueue.push_heap(tempData);
    		}
		}
    	
    	while(!myPQueue.isEmpty())
		{
			tempData = myPQueue.pop_heap();
			currentTime += tempData.waitTime;
			waitingtime += currentTime - tempData.startTime;
		}
    	
//    	System.out.println( "waitingtime : " + waitingtime );
    	return waitingtime/customers.length;
    }


    public static void main(String[] args) throws IOException {

    	Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] customers = new int[n][2];

        for (int i = 0; i < customers.length; i++) {
			customers[i][0] = scanner.nextInt();
			customers[i][1] = scanner.nextInt();
		}

        int result = minimumAverage(customers);
        
        System.out.println(result);

        scanner.close();
    }
}
