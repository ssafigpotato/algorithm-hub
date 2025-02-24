import java.util.Scanner;

public class Main {
	static int N;
	static int []arr	;
	static int cnt = 0;
	static void nQueen(int depth) {
		if(depth == N) {
			cnt++;
			return;
		}
		for(int i = 0; i <arr.length; i++) {
			arr[depth] = i;
			if(possibility(depth)) { //가능한 거면 
				nQueen(depth+1); // 그 다음으로 
			}
		}
	}
	static boolean possibility(int col) {
		for(int i = 0; i <col; i++) {
			// 1. 같은 행에 존재할 경우 ->false
			if(arr[col] == arr[i]) { // 해당 열의 행과 i열의 행이 일치할 때 (같은 행에 존재할 경우)
				return false;
			}
			// 2. 대각선상에 놓인 경우 ->flase
			else if(Math.abs(col-i) == Math.abs(arr[col]- arr[i])) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		nQueen(0);
		System.out.println(cnt);
	}
}