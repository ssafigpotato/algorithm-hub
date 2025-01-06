

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static boolean[]visited; // 중복x니까
	static int[]num; // 입력값 저장 배열
	static int[]out; // 출력값 저장 배열
	static void permutation(int depth) {
		if(depth == M) {
			for(int v : out) {
				System.out.print(v+" ");
			}System.out.println();
			return;
		}
		for(int i = 0; i <N; i++) { // 순서 고려해야하니까 항상 0번째 원소부터 탐색
			if(!visited[i]) {
				visited[i] = true;
				out[depth] = num[i]; // 해당 depth에서 num의 i번째 값을 집어넣기 
				permutation(depth+1);
				visited[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		num = new int[N];
		for(int i =0; i <N; i++) {
			num[i] = sc.nextInt();
		}
		
		// 여기서 미리 오름차순으로 정렬해두기
		Arrays.sort(num);
		
		visited = new boolean[N];
		out = new int[M];
		permutation(0);
	}
}
