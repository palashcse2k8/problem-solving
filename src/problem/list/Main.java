package problem.list;

public class Main {

	public static void main (String args[])
	{
		int A = 10;
		int B = 5;
		
		System.out.println(A + " " + B);
		A = A^B;
		B = A^B;
		A = A^B;
		
		System.out.println(A + " " + B);
	}
}
