package topics;

import java.util.Scanner;


class Graph
{
	
	class AdjlistNode
	{
		int vertex;
		AdjlistNode next;
		
		public AdjlistNode(int v)
		{
			vertex = v;
			next = null;
		}
	}
	
	class AdjList
	{
		int num_members;
		AdjlistNode head;
		AdjlistNode tail;
		
		public AdjList()
		{
			num_members = 0;
			head = tail = null;
		}
	}
	
	int num_vertices;
	AdjList []adjListArr;
	
	public Graph(int n)
	{
		num_vertices = n;
		adjListArr = new AdjList[n];
		for (int i = 0; i < n; i++)
		{
			adjListArr[i] = new AdjList();
		}
	}
	
	void addEdge(int src, int dest)
	{
		AdjlistNode newNode = new AdjlistNode(dest);
		if (adjListArr[src].tail != null)
		{
			adjListArr[src].tail.next = newNode;
			adjListArr[src].tail = newNode;
		}
		else 
		{
			adjListArr[src].head = adjListArr[src].tail = newNode;
		}
		adjListArr[src].num_members++;
		
		newNode = new AdjlistNode(src);
		if (adjListArr[dest].tail != null)
		{
			adjListArr[dest].tail.next = newNode;
			adjListArr[dest].tail = newNode;
		}
		else 
		{
			adjListArr[dest].head = adjListArr[dest].tail = newNode;
		}
		adjListArr[dest].num_members++;
	}
	
	void display(int i)
	{
		AdjlistNode adjList = adjListArr[i].head;
		while (adjList != null)
		{
			System.out.print(adjList.vertex);
			adjList = adjList.next;
		}
		System.out.println();
	}
}
	

public class GraphBuilding
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++)
		{
			int V = sc.nextInt();
			int E = sc.nextInt();
			int Q = sc.nextInt();
			Graph graph = new Graph(V);
			for (int i = 0; i < E; i++)
			{
				int sv = sc.nextInt();
				int ev = sc.nextInt();
				graph.addEdge(sv, ev);
			}
			System.out.println(test_case);
			for (int i = 0; i < Q; i++)
			{
				int sv = sc.nextInt();
				graph.display(sv);
			}
		}
		sc.close();
	}
}