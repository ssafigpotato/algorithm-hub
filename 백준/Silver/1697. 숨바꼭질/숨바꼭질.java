

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, K;
    // 최단거리니까 BFS
    static boolean[]visited;
    static int[]dr;
    static int []sec;
//    static int ans = 0;
    static void bfs(int node){
        visited[node] = true;
        Queue<Integer> que = new LinkedList<>();
        que.offer(node);

        while(!que.isEmpty()){
            int curr = que.poll();
//            ans++; // <-- 이거는 단순히 que에서 뽑아내는 횟수임 이렇게 하면 안됨!
            if(curr == K){
                return;
            };

            // 인접행렬: curr에서 도달할 수 있는 점 => X-1, X+1, 2*X
            dr = new int[]{curr - 1, curr + 1, 2 * curr};
            for(int i = 0; i <3; i++){
                int nr = dr[i];

                if(nr>=0 && nr <100001){
                    if(!visited[nr]){
                        que.offer(nr);
                        sec[nr] = sec[curr]+1; // nr까지 가는 데에 걸리는 시간 저장
                        visited[nr] = true;
                    }
                }
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 수빈 위치
        K = sc.nextInt(); // 동생 위치

        visited = new boolean[100001]; // i번째 위치에 방문했는지 여부 저장
        sec = new int[100001]; // i번째 위치까지 가는데 걸리는 최소 시간 저장
        bfs(N);
       //  System.out.println(Arrays.toString(sec)); // 확인
        System.out.println(sec[K]); // K번째 위치까지 가는 데에 걸리는 최소 시간
        sc.close();
    }
}
