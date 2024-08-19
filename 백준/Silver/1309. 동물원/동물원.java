

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N; // 우리의 크기 
	static int [][]dp; 
	// 사자를 배치하는 경우의 수를 9901로 나눈 나머지를 출력
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// 위에서부터 누적해서 경우가 내려오게 하면 됨
		// 아무것도 선택하지 않은 경우, 왼쪽에 사자 두는 것을 선택한 경우, 오른쪽에 사자 두는 것을 선택한 경우
	
		dp = new int [N+1][3]; 
		// i번째행에서 아무도 선택x dp[i][0], 왼쪽 선택 dp[i][1], 오른쪽 선택 dp[i][2] 
		// XX, XO, OX
		Arrays.fill(dp[1],1);
		// 초항 셋팅(첫번째줄)
		// 첫번째 줄에서 아무칸에도 사자x, 왼쪽 사자, 오른쪽 사자 두는 경우 각각 1개 
		
		// i = 2부터는 0,1,2 각각 케이스 더해주기 
		for(int i = 2; i <N+1; i++) {
			// i번째 항에서 아무것도 선택하지 않는 경우
			// 그 위의 항은 세 가지 경우 중 어디에 둬도 가능하므로 경우 다 더해주기 
			dp[i][0] = ( dp[i-1][0] + dp[i-1][1] + dp[i-1][2] ) % 9901; 
			// i번째 항에서 왼쪽에 두는 걸 선택한 경우
			// 그 위의 항은 아무것도 선택하지 않거나, 오른쪽을 선택했어야함
			dp[i][1] = ( dp[i-1][0] + dp[i-1][2] ) % 9901; 
			// i번째 항에서 오른쪽에 두는 걸 선택한 경우
			// 그 위의 항은 아무것도 선택하지 않거나, 왼쪽을 선택했어야함
			dp[i][2] = ( dp[i-1][0] + dp[i-1][1] ) % 9901; 
		}
		
		
		System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % 9901);
		
		
	}
}
