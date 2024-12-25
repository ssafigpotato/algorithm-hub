

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		// Hash의 짧은 검색시간을 활용하는 문제!!
		// for문으로도 할 수 잇겠지만(이중포문...) 그렇게 되면 시간초과 날듯
		HashSet<Integer> ASet = new HashSet<>();
		HashSet<Integer> BSet = new HashSet<>();
		
		for(int i =0; i <A; i++) {
			ASet.add(sc.nextInt());
		}
		for(int i =0; i <B; i++) {
			BSet.add(sc.nextInt());
		}// 입력 끝
		// 확인. 아래처럼 바로 출력가능
//		System.out.println(ASet);
//		System.out.println(BSet);
		
		int AMinusB = ASet.size();
		for(int val : ASet) {
			if(BSet.contains(val)) {
				AMinusB--;
			}
		}
		int BMinusA = BSet.size();
		for(int val : BSet) {
			if(ASet.contains(val)) {
				BMinusA--;
			}
		}
//		System.out.println(BMinusA);
//		System.out.println(AMinusB);
		System.out.println(BMinusA + AMinusB);
		
		
	}
}
