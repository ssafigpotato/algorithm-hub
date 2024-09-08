
import java.util.Scanner;
// 같은 숫자를 방문 할 수 없음(같은 디저트 종류)
// 하나만 방문 할 수 없음
// 왔던 길을 돌아가면 안됨
// 첫 시작한 곳으로 돌아와야함
// 가능한 경로 중 최대 경로의 길이

public class Solution {
	static int T; // 총 TC 수
	static int N; // 지역의 한 변의 길이
	static boolean[]dessert; // 방문한 디저트종류 체크
	static boolean[][]visited; // 방문한 경로 체크
	static int [][]map; // 디저트 카페 지역
	// 대각선으로 돌아야함
	static int []dr = {1,1,-1,-1};
	static int []dc = {1,-1,-1,1};
	static int max; // 디저트를 가장 많이 먹을 때의 디저트 수
	static void dfs(int r, int c, int startR, int startC, int len, int dir) {
		
	
//		for(int d = 0; d<4; d++) {
		for(int d = dir; d <= dir +1; d++) {
			if(d >= 4) break;
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// 사각형을 완성하고 시작점으로 돌아온 경우 return 
			if(nr == startR && nc == startC && len >0) {
				max = Math.max(max, len);
//				System.out.println("원래대로 돌아왓는데 max: "+max);
				return;
			}

			// 범위를 벗어나지 않으면서 이미 먹은 디저트 종류가 아니면 재귀
			if(nr >= 0 && nr < N && nc >=0 && nc <N) {
						
				// 경로를 방문한 적이 없고, 디저트도 먹은 적이 없으면 그 방향으로 계속 탐색
				if(!visited[nr][nc] && !dessert[map[nr][nc]]) {
					visited[nr][nc] = true; // 방문한 경로 체크해주고
					dessert[map[nr][nc]] = true; // 먹은 디저트 종류 체크
					dfs(nr, nc, startR, startC, len+1, d);
					// 다른 경로 탐색해주고, 거기서 디저트도 먹어야하니까
					dessert[map[nr][nc]] = false;
					visited[nr][nc] = false;
				}
			}
		}// for 4방탐색
//		return;
	}// dfs
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int t = 1; t <=T; t++) {
			
			N = sc.nextInt();
			map = new int[N][N];
			for(int i = 0; i <N; i++) {
				for(int j = 0; j <N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			// 입력 끝
			max = -1; // 초기화
			
			for(int i = 0; i <N; i++) {
				for(int j = 0; j <N; j++) {
					visited = new boolean[N][N];
					dessert = new boolean[101];
					visited[i][j] = true;
					dessert[map[i][j]] = true;
					dfs(i,j,i,j,1,0);
//				
				}
			}
			
			
			
			System.out.println("#"+t+" "+max);
		}// tc
	}//main
	
}
