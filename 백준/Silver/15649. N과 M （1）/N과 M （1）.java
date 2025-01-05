

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int[]arr; // 출력할 배열
	static boolean[]visited; // 해당 숫자에 방문했는지 표시하는 배열
	static void permutation(int depth) {
		// 깊이가 M에 도달하면 재귀 멈추기 
		if(depth == M) {
			for(int v : arr) {
				System.out.print(v+" ");
			}
			System.out.println();
			return;
		}
		
		//
		for(int i = 0; i <N; i++) {
			
			// 방문하지 않았다면
			if(!visited[i]) {
				visited[i] = true; // 해당 노드 방문 표시
				arr[depth] = i+1; // 해당 깊이에서 선택한 값, i+1값을 출력배열에 저장 
//				System.out.println("depth: "+depth+"일 때"+Arrays.toString(arr));
				
				permutation(depth+1); // 자식노드 방문 위해 depth+1하면서 재귀호출 (깊이 증가)
				
				// 자식 노드 방문 끝나고 돌아오면 방문노드를 방문하지 않은 상태로 변경
				visited[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		visited = new boolean[N]; // 방문 표시
		arr = new int [M]; // 값을 담는 배열
		
		permutation(0);
	}
	
}
