import java.util.*;
class Solution {
    static int min = Integer.MAX_VALUE;
    static List<Integer> list; 
    static boolean[][][] visited; // 물건번호, A누적합, B누적합 

    static void backtracking(int index, int sumA, int sumB, int[][]info, int n, int m) {
        // 범위 초과 시 실패
        if (sumA >= n || sumB >= m) return;

        // 모든 물건을 처리했을 때 (조건도 만족하고, 물건 다 훔침) 
        // min 갱신
        if (index == info.length) {
            min = Math.min(min, sumA);
            return;
        }

        // 이미 이 상태 방문했으면 패스
        if (visited[index][sumA][sumB]) return;
        visited[index][sumA][sumB] = true;

        // A가 이 물건을 훔치는 경우
        backtracking(index + 1, sumA + info[index][0], sumB, info, n, m);

        // B가 이 물건을 훔치는 경우
        backtracking(index + 1, sumA, sumB + info[index][1], info, n, m);
    }
    
    public int solution(int[][] info, int n, int m) {
        // sol) 누가 물건을 훔치든 훔치긴해야함
        // A가 훔칠 물건 조합을 고르고
        // 그 때의 A흔적누적개수와 B흔적누적개수가 n,m보다 작은지 판단하고
        // 그걸 만족한다면 A 흔적누적개수를 Math.min하는식으로 계산... -> 백트래킹  
        // 이긴한데, 전부 다 백트래킹으로 하면 시간초과나니까 중간에 메모이제이션 필요
        
        visited = new boolean[info.length][n][m]; 

        backtracking(0,0,0,info,n,m);
        
        return (min == Integer.MAX_VALUE) ? -1 : min ;
    }
}