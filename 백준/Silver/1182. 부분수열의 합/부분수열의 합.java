

import java.util.Scanner;

public class Main {
	static int N;
	static int S;
	// 1. 모든 부분수열을 찾기
	// 2. 부분수열의 합이 S인지 판단
	static int[]num; // 입력값 저장 배열 
	static int cnt = 0; // 조건을 만족하는 부분수열 개수
	// 순서 상관 x, 중복 불허 -> 조합
	static int[]out; // 출력값 저장 배열(부분 수열 배열)
	static void combination(int depth, int at, int target) {
		if(depth == target) {
			int sum = 0;
//			for(int o : out) {
//				System.out.print(o+" ");
//			} // 확인용 
			for(int o : out) {
				sum += o;
			}
			if(sum == S) { // 수열의 합계가 S면 cnt++
				cnt++;
			}
//			System.out.println("sum은: "+sum); // 확인용
			return;
		}
		
		for(int i = at; i <N; i++) {
			out[depth] = num[i]; 
			combination(depth+1, i+1, target);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N =sc.nextInt();
		S = sc.nextInt();
		num = new int[N];
		for(int i = 0; i <N; i++) {
			num[i] = sc.nextInt();
		}
		
		// N개에서 x개 뽑기
		// x는 1~ N개가 될 수 있음
		// (0개를 뽑아서 S가 될 수 있는 경우는 없음)
		for(int i = 1; i <=N; i++) {
			// x개를 뽑는 연산을 할 때마다 out배열은 새롭게 초기화
			out = new int[i];

//			System.out.println("**뽑는 개수가 "+i+"개 일 때"); // 확인용
			// target은 i
			combination(0,0,i);
//			System.out.println("==============="); // 확인용 
		}
		System.out.println(cnt);
	}
}
