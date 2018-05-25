package topics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BFS {
	
//	static FileWriter fileWriter = new FileWriter(new File("src/output.txt"));
	
	static class point{
		int x, y;
		int cost;
		point(int i , int j, int c)
		{
			x = i;
			y = j;
			cost = c;
		}
	}
	
	static int [][] arr;
	static int [][] visited;	
	static point [] queue = new point[100];
	
	static int [] dx = { 0, -1, 0, 1};
	static int [] dy = {-1,  0, 1, 0};
	
	static int front, rear, N, M;

	public static void ClearQueue()
	{
		front = rear = -1;
	}
	
	public static void pushQueue(int i, int j, int c)
	{
		queue[++rear] = new point(i,j,c);
	}
	
	public static point popQueue()
	{
		if(rear>front)
			return queue[++front];
		return null;
	}
	
	public static int bfs()
	{
		int sourceX =0 , sourceY = 0;
		int destX = N-1, destY = M-1;
		
		pushQueue(sourceX, sourceY, 1);
		visited[sourceX][sourceY] = 1;
		
		while(front != rear)
		{
			point currentpoint = popQueue();
			
			if(currentpoint.x == destX && currentpoint.y == destY)
			{
				return currentpoint.cost;
			}
			
			for (int k = 0; k < 4; k++) 
			{
				int x = currentpoint.x + dx[k];
				int y = currentpoint.y + dy[k];
				
				if(isValid(x, y) && visited[x][y] == 0)
				{
					pushQueue(x, y, currentpoint.cost + 1);
					visited[x][y] =  currentpoint.cost + 1;
				}
			}
		}
		
		return 0;
	}
	
	public static void printData(int a [][])
	{
		for (int i = 0; i < a.length; i++) 
		{
			for (int j = 0; j < a[0].length; j++) 
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static boolean isValid(int i, int j)
	{
		return i>=0 && i<N && j>=0 && j<M && (arr[i][j] == 1);
	}

	public static void main(String[] args) throws IOException  {
//		Scanner sc = new Scanner(new File("D:\\professional_training\\Workspace\\problem-solving\\src\\problem\\list\\input.txt"));
		Scanner sc = new Scanner(new File("src/input.txt"));
	
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int [N][M];
		visited = new int [N][M];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		printData(arr);		
		printData(visited);
		ClearQueue();
		
		System.out.println("The distance : " + bfs());
		
		printData(arr);		
		printData(visited);
	}

}
