

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N; // 카드 개수
	static int M; // 카드 합체를 몇 번 하는지 
	// 카드 합체 ㅣ 
	// x, y 카드를 뽑아서 x = x + y, y = x+y로 갱신
	// m번 후 점수를 가장 작게 만들기 
	// 더하다보면 x,y 둘다 long이 될 수 있음!!! 주의!!! 
	static PriorityQueue<Status> pq;
	static class Status implements Comparable<Status>{
		long r;  // long!! 
		Status(long r){
			this.r = r;
		}
		
		// 오름차순 
		@Override
		public int compareTo(Status o) {
			return Long.compare(this.r, o.r);  // long!
		}
	}
	// 확인용
	// pq.size를 for 범위로 넣으면 반복문 돌때마다 사이즈가 줄어듦
	// 따라서 size = pq.size()로 두고, size를 범위로 해야함!! 
	static void print() {
		int size = pq.size();
		for(int i = 0; i <size; i++) {
			System.out.print(pq.poll().r+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		pq = new PriorityQueue<Status>();
		
		for(int i= 0; i < N; i++) {
			int num = sc.nextInt();
//			System.out.println(num);
			pq.add(new Status(num));
		}// 입력 끝
		
		
//		print();
		
		// 1. arr내에서 가장 작은 수 두개를 뽑아서 더하고 갱신
		// 근데 매 연산마다 배열내에서 가장 작은 수 두개를 뽑을 수는 없음 -> 시간 초과
		// 따라서 priorityQueue에 넣고 poll()*2번 해서 연산 후 다시 집어넣기 m번 반복
		for(int i = 0; i <M; i++) {
			long x = pq.poll().r;
			long y = pq.poll().r;
//			System.out.println(i+1+"번째 작은 수: "+x+" "+y);
			long sum = x + y;
			pq.add(new Status(sum));
			pq.add(new Status(sum));
			// print사용시 pq에서 빠져버리기 때문에 남겨두면 안됨 주의!!
//			print();
		}
		
		long ans = 0;
		int size = pq.size(); 
		for(int i = 0; i <size; i++) {
			ans += pq.poll().r;
		}
		System.out.println(ans);
		sc.close();
	}
}
