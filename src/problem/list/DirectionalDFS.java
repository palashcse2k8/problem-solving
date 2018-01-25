package problem.list;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DirectionalDFS {
	
	static int [][] arr;
	static int [][] visited;
	
	static int [] dx = { 0, -1, -1, -1, 0, 1, 1,  1 };
	static int [] dy = {-1, -1,  0,  1, 1, 1, 0, -1 };
	
	
	static int N, M;
	
	public static boolean isValid (int i, int j)
	{
		return i>=0 && i<N && j>=0 && j<M && arr[i][j] == 1;
	}
	
	public static void directiondfs(int i, int j, int direction)
	{
		arr[i][j] = 0;
		int x, y;
		for (int k = 0; k < 8; k++) {
			x = i + dx[k];
			y = j + dy[k];
			
			if(isValid(x, y))
			{
				directiondfs(x,y,k);
			}
		}
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

	public static void main(String[] args) throws FileNotFoundException {
		
		 System.out.println("I'am fine");
		 
		 Scanner sc = new Scanner(new File("src/input.txt"));
		 
		 N = sc.nextInt();
		 M = sc.nextInt();
		 
		 arr = new int[N][M];
		 visited = new int[N][M];
		 
		 for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		 
		 printData(arr);
		 directiondfs(0,0,0);
		 printData(arr);
		 
	}

}
