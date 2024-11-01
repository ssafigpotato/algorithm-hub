

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int N;
	static String[][] student;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		student = new String[N][4];
		for(int i = 0; i <N; i++) {
			for(int j = 0; j <4; j++) {
				student[i][j] = sc.next();
			}
		}
		
		// 확인
//		for(int i =0; i <N; i++) {
//			for(int j = 0; j <4; j++) {
//				System.out.print(student[i][j]+" ");
//			}System.out.println();
//		}
//		
//		System.out.println("================================");
		
		Arrays.sort(student, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				if(o1[1].equals(o2[1])) { // 국어 점수가 같으면 
					if(o1[2].equals(o2[2])) { // 그리고 영어 점수도 같으면 
						if(o1[3].equals(o2[3])) { // 모든 점수가 같으면
							return o1[0].compareTo(o2[0]); // 이름이 사전 순으로 증가하는 순서로
						}
						// 국어랑 영어 점수만 같으면 
						return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]); // 수학 점수 감소 순
					}
					// 국어 점수만 같으면
					return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]); // 영어 점수 증가 순 
				}
				// 같은 점수 없으면 
				return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]); // 국어 점수 감소 순 
			}
		});
		
		for(int i = 0; i <N; i++) {
			System.out.println(student[i][0]);
		}
		
		// 확인
//		for(int i =0; i <N; i++) {
//			for(int j = 0; j <4; j++) {
//				System.out.print(student[i][j]+" ");
//			}System.out.println();
//		}
		
	}// main
}
