

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static class Status implements Comparable<Status>{
		int id;
		// ability는 소수도 있으니까 duble? float?
		double ability;
		
		public Status(int id, double ability) {
			this.id = id;
			this.ability = ability;
		}
		
		// 여러사람이 같은 장르여도 되므로 
		// 오로지 능력 내림차순으로만 정렬하면 됨 
		@Override
		public int compareTo(Status o) {
			return Double.compare(o.ability, this.ability);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		
		// pq에 다 집어넣기 
		// Map, Set과 혼동하지 말것!!
		// 얘를 들어 1번이 1번 장르에서 3.0 2번장르에서 2.0이라면
		// (1, 3.0) (1, 2.0) 이렇게 둘 다 저장됨 
		// (1, 5.0) 이 되거나 (합산 로직 없음)
		// (1, 2.0)새로운 값으로 갱신되거나 하지 않음 
		PriorityQueue<Status> pq = new PriorityQueue<>();
		for(int i =0; i <M; i++) {
			for(int j = 0; j <N; j++) {
				int id = sc.nextInt();
				double ability = sc.nextDouble();
				pq.add(new Status(id, ability));
			}
		}
		
		// 이미 뽑힌 참가자는 빼기 위해 
		// 뽑힌 참가자를저장할 set
		HashSet<Integer> set = new HashSet<>();
		// 뽑힌 후보자 수 
		int candidate = 0;
		// 총 능력치 합 
		double sum = 0; 

		// pq가 비어있지 않고
		// 후보가 K미만이면
		while(!pq.isEmpty() && candidate < K ) {
			Status top = pq.poll();
			
			// 이미 set에 있는 참가자 번호는 제외 
			if(!set.contains(top.id)) {
				// 총 능력치 합에 추가 
				sum += top.ability;
				// set에 아이디 저장 
				set.add(top.id);
				// 뽑힌 후보자 수 증가시키기 
				candidate++;
			}
		}
		
		System.out.printf("%.1f\n", sum);
		
		sc.close();
	}//main
}
