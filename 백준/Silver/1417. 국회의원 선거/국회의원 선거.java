
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static class Candidate implements Comparable<Candidate>{
		int id;
		int cnt;
		
		Candidate(int id, int cnt){
			this.id = id;
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(Candidate o) {
			// 득표수 기준 내림차순 정렬 
			return Integer.compare(o.cnt, this.cnt);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int dasom = sc.nextInt(); // 다솜이 득표수 
		PriorityQueue<Candidate> pq = new PriorityQueue<>();
		
		for(int i= 1; i <N; i++) {
			pq.add(new Candidate(i+1, sc.nextInt()));
		}// 득표수 기준으로 정렬됨
		
		int num = 0; // 매수한 사람 
		
		// pq가 비어있지 않고, 현재 pq의 cnt가 다솜이의 득표수보다 높다면
		// pq.peek().cnt < dasomVotes가 되면, 다솜이의 득표수가 모든 후보보다 많아졌으므로 종료.
		while(!pq.isEmpty() && pq.peek().cnt >= dasom) {
			// 가장 득표수가 높은 후보 가져오기 
			Candidate top = pq.poll();
			
			// 매수 (가장 높은 후보의 득표수 감소, 다솜이 득표수 증가)
			top.cnt--;
			dasom++;
			num++;
			
			// 매수 후 후보를 다시 PriorityQueue에 삽입
            pq.add(top);
		}// while
		
		System.out.println(num);
		sc.close();
	}
}
