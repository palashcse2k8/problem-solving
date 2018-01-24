package problem.list;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BFS {
	
//	static FileWriter fileWriter = new FileWriter(new File("src/output.txt"));
	
	static int [][] arr;
	static int [][] visited;
	
	static int front, rear, N, M;

	
	public void bfs(int i , int j)
	{
		
	}
	
	public static void printData(int a [][])
	{
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				
//				outputfile.
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
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
		front = rear = 0;
	}

}
