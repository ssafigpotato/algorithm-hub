

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N; // 나무 수 백만 이하 
	static int M; // 집으로 가져가려는 나무 길이 20억 이하
	static int[]tree;
	static int binarySearch(int[]arr, int target) {
		// 이번에는 tree배열 안에서 찾는 것이 아니라 
		// 0~가장 높은 나무길이 중에서 찾는 것임! 
		int left = 0;
		int right = arr[arr.length-1];
		while(left <= right) {
			int mid = (left + right)/2;
			
			long sum = 0;
			for(int i = 0; i <N; i++) {
				if(arr[i] > mid) {
					sum += arr[i] - mid;
				}
			}
			if(sum >= target) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return right; 
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		tree = new int[N];
		for(int i = 0; i <N; i++) {
			tree[i] = sc.nextInt();
		}
		
		Arrays.sort(tree);
		System.out.println(binarySearch(tree,M));
		
	}
}
