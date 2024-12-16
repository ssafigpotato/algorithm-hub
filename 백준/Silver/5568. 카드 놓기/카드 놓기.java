

import java.util.HashSet;
import java.util.Scanner;

public class Main {
	static int N, K;
	static int[] cards;
	static boolean[]visited;
	static HashSet<String> number = new HashSet<String>();
	static void permutation (int depth, int []arr, int r, boolean[]visited, String curr) {
		if(depth == r) {
			number.add(curr);
			return;
		}
		
		for(int i = 0; i <arr.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				// 숫자는 "1" + "21" = "121" 이런 형태로 더 해지므로, 
				// 선택한 카드를 더한 'curr + arr[i]'를 
				// String curr자리에 넣으면 됨
				permutation(depth+1, arr, r, visited, curr + arr[i]);
				visited[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		cards = new int[N];
		visited = new boolean[N];
		for(int i = 0; i <N; i++) {
			cards[i] = sc.nextInt();
		}
		
		permutation(0, cards, K, visited, "");
		System.out.println(number.size());
	}
}
