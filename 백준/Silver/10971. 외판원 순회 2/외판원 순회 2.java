

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // 도시 N개를 돌아서 처음으로 돌아와야함
    // 방문 순서 예) 1 - 2  - 3  - 4 - 1 이런식...
    // 일단 순열로 줄세우고!
    static int N;
    static int[][]cost;
    static boolean[]visited;
    static int min = Integer.MAX_VALUE;
    // start, curr, sum까지 한 번에 넘겨주기
    static void backtracking(int depth, int start, int curr, int sum){
        if(depth == N){
           if(cost[curr][start] != 0){
               // 시작 도시로 돌아올 ㅅ ㅜ있으면 갱신
               min = Math.min(min, sum + cost[curr][start]);
           }
            return;
        }

        for(int next = 0; next <N; next++){
            if(!visited[next] && cost[curr][next] != 0){ // cost가 0인경우(=이동할 수 없는 경우) 여기서 걸러주기
                visited[next] = true;
                backtracking(depth+1, start, next, sum+cost[curr][next]);
                visited[next] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        visited = new boolean[N]; // 도시 0~N-1번 방문 여부 저장
        cost = new int[N][N];
        for(int i = 0; i <N; i++){
            for(int j = 0; j <N; j++){
                cost[i][j] = sc.nextInt();
            }
        }
        // 0번도시에서 시작하는 걸로 고정!
        // 순환하니까 0 1 2 3 이나 1 2 3 0이나 같으니까
        // 어느점에서 출발하든 똑같음!
        // 처음에 0번 도시 방문처리와 depth를 1로 안 해주면)
        // 첫 if문에서 cost에 걸리게 되어 앞으로도 계속 visited[0] = true;로 해줄 기회가 없어짐 -> 그럼 꼬이겠지
        // depth도 0으로 하면 두번째도시를 방문하고서야 depth가 1이되어서 총 N+1개를 방문해야하는데(돌아오는것포함)
        // N만 방문하게 되어 계산이 꼬임
        visited[0] = true;
        backtracking(1,0,0,0); // 0번도시 하나 방문함
        System.out.println(min);
    }
}
