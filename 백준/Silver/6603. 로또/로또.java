

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	// K개에서 6개를 조합으로 고르기(중복x)
	static int K;
	static int[]arr; // 입력 값 저장 배열 
	static int[]out; // 결과 값 저장 배열
	static void combination(int depth, int at) {
		if(depth == 6) {
			for(int v : out) {
				System.out.print(v+" ");
			}System.out.println();
			return;
		}
		for(int i = at; i <K; i++) {
			out[depth] = arr[i];
			combination(depth+1, i+1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			K = sc.nextInt();
			// 첫번째 입력값인 K가 0이면 break
			if(K == 0) break;
			
			// 1. 입력값을 저장하는 배열 
			arr = new int[K];
			// arr을 오름차순으로 정렬 <-- 안해도 됨 문제에서 이미 오름차순으로 주어짐
//			Arrays.sort(arr);
			for(int i = 0; i < K; i++) {
				arr[i] = sc.nextInt();
			}
			
			// 2. out에는 6개의 값을 저장 
			out = new int[6];
			combination(0,0);
			
			// 3. 각 테캐마다 빈 줄 추가
			System.out.println();
			
		}
	}
}
