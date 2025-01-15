

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N, M;
    static HashMap<Integer, List<Integer>> map = new HashMap<>();
    static boolean[]visited;
    static void dfs(int node){
        visited[node] = true;

        for(int neighbor : map.getOrDefault(node, new ArrayList<>())){
            if(!visited[neighbor]){
                visited[neighbor] = true;
                dfs(neighbor);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 총 노드 수
        M = sc.nextInt(); // 간선 개수

        // 연결 요소의 개수 == 나누어진 그래프의 수
        for(int i = 0; i <M; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();

            map.putIfAbsent(start, new ArrayList<>());
            map.putIfAbsent(end, new ArrayList<>());

            map.get(start).add(end);
            map.get(end).add(start);
        }

        visited = new boolean[N+1];

        // 전체 노드를 돌면서 방문하지 않은 곳만 방문하고, 그 횟수를 return 하면 되지 않을까?
        // visitied는 전체적으로 공유하고
        int ans = 0;
        for(int i = 1; i <=N; i++){
            if(!visited[i]){
                dfs(i);
                ans++;
            }
        }

        System.out.println(ans);

        sc.close();
    }
}
