

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int T;
	static int N, M; // 백만 이하이므로 int 괜춘
	static int[] A;
	static int[] B;
	static int binarySearch(int[]arr, int target) {
		int left = 0;
		int right = arr.length-1;
		int close = arr[0];
		
		while(left <= right) {
			int mid = (left + right)/2;
			
			// Math.abs를 활용한 가장 가까운 값 찾기
			// 현재 값(arr[mid])과 목표 값(target) 사이의 거리를 계산하고, 
			// 가장 가까운 값을 갱신
			if (Math.abs(arr[mid] - target) < Math.abs(close - target) ||
			   // arr[mid]과 closestValue의 거리가 같을 때, 값이 더 작은 쪽을 선택
				(Math.abs(arr[mid] - target) == Math.abs(close - target) && arr[mid] < close)) {
			    close = arr[mid];
			}
			
			// 이진 탐색을 통해 탐색 범위를 좁히는 역할
			if(arr[mid] >= target) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		
		return close;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int t=0; t <T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			A = new int[N];
			for(int i = 0; i <N; i++) {
				A[i] = sc.nextInt();
			}
			
			B = new int[M];
			for(int i = 0; i <M; i++) {
				B[i] = sc.nextInt();
			}
			Arrays.sort(B);
//			System.out.println(Arrays.toString(B));
			long cnt = 0;
			
			for(int i = 0; i <N; i++) {
				cnt += binarySearch(B, A[i]);
			}
			System.out.println(cnt);
			
		}//TC

		sc.close();
	}
}
