

import java.util.Arrays;
import java.util.Scanner;
// 1 ≤ N,M ≤ 1,000,000 이므로 int, int[] 사용 가능
// 이분탐색 사용
public class Main {
	static int T; // 테캐 수
	static int N; // 수첩 1에 적어놓은 정수의 개수
	static int[] one;
	static int M; // 수첩 2에 적어놓은 정수의 개수
//	static int[] two;
	static boolean binarySearch(int target, int[]arr) {
		int left = 0;
		int right = arr.length-1;
		while(left <= right) {
			int mid = (left + right)/2;
			if(arr[mid] == target) {
				return true;
			}else if(arr[mid] < target) {
				left = mid +1;
			}else {
				right = mid -1;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int t = 0; t <T; t++) {
			
			N = sc.nextInt();
			one = new int[N];
			for(int i = 0; i <N; i++) {
				one[i] = sc.nextInt();
			}
			Arrays.sort(one);
//			System.out.println(Arrays.toString(one));
			
			M = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i <M; i++) {
				int target = sc.nextInt();
				sb.append(binarySearch(target, one)? 1 : 0);
				if (i < M - 1) {
		            sb.append('\n');
		        }
			}
			System.out.print(sb); // 테스트 케이스 사이에는 공백 줄 추가하지 않음
		    if (t < T - 1) {
		        System.out.println(); // 테스트 케이스 사이에 줄바꿈만 추가
		    }
		}// TC
	}
}
