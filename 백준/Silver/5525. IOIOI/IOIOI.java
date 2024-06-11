
import java.util.Arrays;
import java.util.Scanner;
//예시)
// P1 = IOI			I:2, O:1
// P2 = IOIOI		I:3, O:2
// P3 = IOIOIOI		I:4, O:3...
public class Main {
	static int N;  // N+1게의 I와 N개의 O로 이루어진 문자열 Pn
	static int M; // S의 길이
	static String S; // I와 O로 이루어진 문자열
	static String[] arr; // S를 문자열 배열로 쪼갠 것
	static String P;
	static int cnt = 0; // Pn의 개수
	// Pn을 만드는 메서드 
	static String Pn(int N) {
		String init = "IO";
		P = init.repeat(N)+"I";
		return P;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		S = sc.next(); // 입력 끝
		
		arr = new String[M];
		arr = S.split("");
		Pn(N);
		
		// arr을 돌면서 조건에 맞으면 cnt++해주기
		for(int i = 0; i <= M-P.length(); i++) {
			if(arr[i].equals("I")) {
				
				boolean isPattern = false;
				for(int j = 0; j < P.length(); j++) {
					if(j %2 == 0) {
						if(arr[i+j].equals("I")) {
							isPattern = true;
						}else {
							isPattern = false;
							break;
						}
					}else {
						if(arr[i+j].equals("O")) {
							isPattern = true;
						} else {
							isPattern = false;
							break;
						}
					}
				}//for j문
				if (isPattern == true) cnt++;
			}
			
		}// for i문
		System.out.println(cnt);
		
	}// main
}
