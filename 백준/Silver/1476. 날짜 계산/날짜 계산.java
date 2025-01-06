

import java.util.Scanner;

public class Main {
	// 1<= E <= 15 --1도 1, 16도 1, 31도 1... 자기자신 + 15*n 
	// ==> year % 15 = E라고 할 수 잇음!! 
	// 1<= S <= 28 -- 1도 1, 29도 1, 57도 1... 자기자신 + 28*n
	// 1<= M <= 19 -- 1eh 1, 20도 1, 39도 1... 자기자신 + 19*n
	static int E;
	static int S;
	static int M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		E = sc.nextInt();
		S = sc.nextInt();
		M = sc.nextInt();
		int e = 0;
		int s = 0;
		int m = 0;
		int year = 0;
//		while(true) {
//			year++;
//			e++;
//			s++;
//			m++;
//			if(e == 16) e = 1;
//			if(s == 29) s = 1;
//			if(m == 20) m = 1;
//			if(e == E && s == S && m == M) break;
//		}
		while(true) {
			year++;
//			if(E == 16) E = 1;
//			if(S == 29) S = 1;
//			if(M == 20) M = 1;
			// 15 28 19일 때는 나머지 0 인데, ESM은 0이 아님 
			// 따라서 이렇게 바꿔줘야함
			if(E == 15) E = 0;
			if(S == 28) S = 0;
			if(M == 19) M = 0;
			
			if(year % 15 == E && year % 28 == S && year % 19 == M) {
				System.out.println(year);
				return;
			}
		}
		
	
	}
}
