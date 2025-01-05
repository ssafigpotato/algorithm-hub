

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[]arr;
	static void combination(int at, int depth) {
		// 현재 depth(깊이)가 M에 도달하면, 배열에 저장된 숫자를 출력하고 종료
		if(depth == M) {
			for(int v : arr) {
				System.out.print(v+" ");
			}System.out.println();
			return;
		}
		
		// at은 탐색할 위치 
		// visited 배열을 대신하면서
		// 몇 번째 원소부터 탐색할지를 정해줌
		// ex)0번째 원소면 1, 1번째 원소면 2, 2번째 원소면 3...
		// 조합은 중복을 허용하지 않으므로, at부터 시작하여
	    // 선택한 숫자 이후의 숫자들만 탐색
		for(int i = at; i < N; i++ ) {
			
			arr[depth] = i+1; // 현재 선택한 숫자(현재 위치의 숫자)를 배열에 저장
//			System.out.println("depth: "+depth+"일 때"+Arrays.toString(arr));
			
			combination(i+1, depth+1); // 다음 depth로 진행, 위치는 i+1부터 탐색
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		
		combination(0, 0);
	}
}
