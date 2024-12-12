

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N;
	static List<Integer> list;
	static int M;
	
	static int lowerBound(int left, int right, int target, List<Integer> li) {
//		int n = 0;
		// left와 right가 같아질 때까지 
		while(left <right) {
//			n++;
			int mid = (left + right)/2;
			if(list.get(mid) >= target) {
				right = mid;
//				System.out.println(n+"번째, mid: "+mid+" target: "+target+" right: "+right);
			}else {
				left = mid +1;
//				System.out.println(n+"번째, mid: "+mid+" target: "+target+" left: "+left);
			}
		}
//		System.out.println("하한선은: "+left);
//		System.out.println("==========================");
		return left;
	}
	static int upperBound(int left, int right, int target, List<Integer> li) {
//		int n = 0; 
		// left와 right가 같아질 때 까지 
		while(left <right) {
//			n++;
			int mid = (left + right)/2;
			if(list.get(mid) > target) {
				right = mid;
//				System.out.println(n+"번째, mid: "+mid+" target: "+target+" right: "+right);
			}else {
				// list.get(mid) == target일 때는 
				// 그 중에서 가장 나중에 오는 원소까지 left를 옮기기 
				left = mid +1;
//				System.out.println(n+"번째, mid: "+mid+" target: "+target+" left: "+left);
			}
		}
//		System.out.println("상한선은: "+left);
//		System.out.println("==========================");
		return left;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		list = new ArrayList<Integer>();
		for(int i = 0; i <N; i++) {
			list.add(sc.nextInt());
		}
		Collections.sort(list);
//		System.out.println(list);
		
		M = sc.nextInt();

		StringBuilder sb = new StringBuilder();
		// 해당하는 원소의 개수를 구하기 위해 
		// 해당 원소 위치의 상한선 - 하한선으로 개수를 구함 
		for(int i = 0; i <M; i++) {
			int num = sc.nextInt();
			sb.append(upperBound(0, list.size(), num, list) - lowerBound(0, list.size(), num, list)).append(' ');
		}
		System.out.println(sb);
	}// main

}
