
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int T; // 총 TC
	static int N; // 구슬 쏠 수 있는 횟수
	static int W, H; // 벽돌 정보
	static int [][]map; // 벽돌 맵
	static int [][]copy; // map 초기화 
	static int []result; // 열 넣기... 무슨 배ㅕㅇㄹ이지??
	static boolean [][]visited; // 방문 체크
	static int []dr = {-1,0,1,0};
	static int []dc = {0,1,0,-1};
	static int ans = Integer.MAX_VALUE;
	static class Location{
		int r;
		int c;
		int power;
		Location(int r, int c, int power){
			this.r = r;
			this.c = c;
			this.power = power;
		}
	}
	// 어떤 줄에 구슬을 쏠 것인지 정하기(중복순열 => 중복 가능하고 순서가 중요하니까)
	static void permutation(int depth) {
		if(ans == 0) return;
		
		if(depth == N) {
			// 초기화 해주기 
			for(int i = 0; i <H; i++) {
				for(int j = 0; j <W; j++) {
					map[i][j] = copy[i][j];
				}
			}
			ans = Math.min(ans, shooting());
			return;
		}
		
		for(int i = 0; i <W; i++) {
			result[depth] = i; // 열 넣어주기 
			permutation(depth+1);
		} 
	}
	
	// 구슬 쏘기 
	static int shooting() {
		int cnt = 0; // 남은 벽돌 개수 카운트
		
		for(int i = 0; i <N; i++) {
			for(int r = 0; r <H; r++) {
				if(map[r][result[i]] != 0) {
					bfs(r,result[i], map[r][result[i]]-1); // i번째 폭발 했으면
					down();
					break;
				}
			}
		}
		
		// 남은 개수 cnt
		for(int i = 0; i <H; i++) {
			for(int j = 0; j <W; j++) {
				if(map[i][j]!= 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	static void bfs(int r, int c, int power) {
		map[r][c] = 0; // 폭발시 0으로 변경
		if(power == 0) return;
		
		Queue<Location> que = new LinkedList<>();
		que.offer(new Location(r,c,power));
//		visited[r][c] = true;
		
		while(!que.isEmpty()) {
			Location curr = que.poll();
			
			for(int p = 1; p <=curr.power; p++) {
				for(int d = 0; d <4; d++) {
					int nr = curr.r + dr[d]*p;
					int nc = curr.c + dc[d]*p;
					// 범위 벗어나면 통과
					if(nr < 0 || nr >=H || nc < 0 || nc >=W) continue;
					// 0이면 통과
					if(map[nr][nc]==0) continue;
					
					// 큐에 집어넣고 터뜨려주기(폭발하면 0으로 변경)
					que.offer(new Location(nr,nc,map[nr][nc] -1));
					map[nr][nc] = 0;
				}
			}
		}
	}// bfs
	// 내리기 
	static void down() {
		for(int j = 0; j <W; j++) {
			int startR = H-1; // 시작점
			
			// 0인 위치 찾기
			for(int i = startR; i >=0; i--) {
				if(map[i][j] == 0) {
					startR = i;
					break;
				}
			}
			
			for(int i = startR-1; i >=0; i--) {
				if(map[i][j] != 0 && map[startR][j] == 0) {
					map[startR][j] = map[i][j];
					map[i][j] = 0;
					startR--;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int t = 1; t <=T; t++) {
			
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			map = new int[H][W];
			copy = new int[H][W];
			result = new int[N];
//			visited = new boolean[H][W];
			for(int i = 0; i <H; i++) {
				for(int j = 0; j <W; j++) {
					map[i][j] = copy[i][j] = sc.nextInt();
				}
			}// 입력 끝
			
			ans = Integer.MAX_VALUE;
			permutation(0);
			System.out.println("#"+t+" "+ans);
					
		
		}// TC
		
		
	}//main
}
