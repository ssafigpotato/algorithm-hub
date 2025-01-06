

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][]map;
	static int[]out; // 사람 뽑은 결과값 저장할 배열
	static boolean[]visited; // N명 중복...
	static int[]arr = new int[2]; // 능력치를 계산하기 위해 한 팀 안에서 2명을 뽑은 값을 저장  
	static int min_ab = Integer.MAX_VALUE; // 능력치 차이 최솟값 
	// 사람을 먼저 뽑고,
	// 사람간에 조합을 구해서 능력치의 합을 구해야할듯 
	// N에서 N/2개를 뽑는 경우
	// 1,2번을 뽑거나 2,1번을 뽑거나 같음 -> 조합. 중복 x
	static void pickPerson(int depth, int at) {
		if(depth == N/2) {
//			for(int o : out) {
//				System.out.print(o+" ");
//			}
//			System.out.println(); // 확인용
			ability();
			return;
		}
		
		for(int i = at; i < N; i++) { // 사람 번호를 뽑음
			if(!visited[i]) {
				visited[i] = true;
				out[depth] = i+1;
				pickPerson(depth+1, i+1);
				visited[i] = false;
			}
		}
	}
	
	// 사람들 중 2명을 뽑아서 능력치 합 구하기 
	static void ability() {

		List<Integer> STeam = new ArrayList<Integer>();
		List<Integer> LTeam = new ArrayList<Integer>();
		int s = 0; // Start 팀 능력치
		int l = 0; // Link 팀 능력치 합 
		
		for(int i = 0; i <N; i++) { // N명중에서 
			if(visited[i]) { // 방문한 배열, 그러니까 out 배열에 있는 사람이면 Start팀
				STeam.add(i);
			}else {// 아니면 Link 팀
				LTeam.add(i);
			}
		}
		
		// Start팀중에서 두명씩 뽑아서 능력치 합 구하기 
		for(int i = 0; i <STeam.size(); i++) {
			for(int j = 0; j <STeam.size(); j++) {
				if(i !=j ) {
					s += map[STeam.get(i)][STeam.get(j)];
				}
			}
		}
		
		// Link팀중에서 두명씩 뽑아서 능력치 합 구하기 
		for(int i = 0; i <LTeam.size(); i++) {
			for(int j = 0; j <LTeam.size(); j++) {
				if(i !=j ) {
					l += map[LTeam.get(i)][LTeam.get(j)];
				}
			}
		}
		
		// 능력치 차이 갱신
		int diff = Math.abs(s-l);
		min_ab = Math.min(min_ab, diff);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		out = new int[N/2];
		visited = new boolean[N]; 
		for(int i = 0; i <N; i++) {
			for(int j = 0; j <N; j++) {
				map[i][j] = sc.nextInt();
			}
		}// 입력 끝
		
		pickPerson(0,0);
		System.out.println(min_ab);
		
	}
}
