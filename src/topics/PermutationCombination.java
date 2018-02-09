package topics;

import java.util.Scanner;

public class PermutationCombination {

	static String str = "";

	static int[] data, used;

	static int N, K, last = -1;

	public static void permutation(int index) {

		if (index == N) {
			printString();
			return;
		}

		for (int i = 0; i < N; i++) {

			if (used[i] == 0) {
				used[i] = 1;
				data[index] = i;
				permutation(index + 1);
				used[i] = 0;
			}
		}
	}

	public static void combination(int index) {

		if (index == K) {
			printString();
			return;
		}

		for (int i = last + 1; i < N; i++) {
			data[index] = i;
			last = i;
			combination(index + 1);
		}
	}

	private static void printString() {

		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		for (int i = 1; i <= testCase; i++) {
			N = sc.nextInt();
			used = new int[N];
			data = new int[N];
			System.out.println("#" + i);
			permutation(0);
			System.out.println();
			K = sc.nextInt();
			data = new int[K];
			combination(0);
		}
	}
}
