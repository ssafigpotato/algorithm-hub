

import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[]arr;
	static void combination(int depth, int at) {
		if(depth == M) {
			for(int v : arr) {
				System.out.print(v+" ");
			}System.out.println();
			return;
		}
		
		for(int i = at; i <N; i++) {
			arr[depth] = i+1;
			// 자기자신도 포함하는 거니까 i+1이 아닌 i를 넣어서 돌리기 
			combination(depth+1, i); 
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		combination(0,0);
	}
}
