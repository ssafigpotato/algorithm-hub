

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Status implements Comparable<Status>{
		int id; // 참가자 번호 
		int score;
		int cnt;
		int time;
		
		Status(int id, int score, int cnt, int time){
			this.id = id;
			this.score = score;
			this.cnt = cnt;
			this.time = time;
		}
		
		@Override
		public int compareTo(Status o) {
			// 1. 점수 내림차순 (점수가 높을 수록 더 높은 우선순위)
			if(this.score != o.score) {
				return Integer.compare(o.score, this.score);
			}
			// 2. (점수 총합이 같은 경우)
			// 제출 횟수 오름차순 
			// (제출 횟수가 적을수록 더 높은 우선순위)
			if(this.cnt != o.cnt) {
				return Integer.compare(this.cnt, o.cnt);
			}
			// 3. (점수 총합, 제출횟수 같은 경우)
			// 이것까지 같은 경우는 없음
			// 마지막 점수 획득 시간 오름차순
			return Integer.compare(this.time, o.time);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //참가자수
		PriorityQueue<Status> pq = new PriorityQueue<>();
		for(int i = 0; i <N; i++) {
			pq.add(new Status(i+1, sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		
		// 확인용
		// 아래는 잘못된 출력방법임
//		while(!pq.isEmpty()) {
//			System.out.println(pq.poll().id +" "+pq.poll().score+" "+pq.poll().cnt+" "+pq.poll().time);
//		}
		
		// 올바른 출력
//		while (!pq.isEmpty()) {
//		    Status current = pq.poll(); // 한 번에 하나의 요소를 가져옴
//		    System.out.println(current.id + " " + current.score + " " + current.cnt + " " + current.time);
//		}

		
		
		System.out.println(pq.poll().id);
		
		sc.close();
	}
}
