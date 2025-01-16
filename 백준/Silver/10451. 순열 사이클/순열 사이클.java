

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int T;
    static HashMap<Integer, List<Integer>> map;
    static boolean[]visited;
    static void dfs(int node){
        visited[node] = true;

        for(int neighbor : map.getOrDefault(node, new ArrayList<>())){
            if(!visited[neighbor]){
                dfs(neighbor);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for(int i = 0; i <T; i++){
            int N = sc.nextInt(); // 순열 크기
            map = new HashMap<>();
            visited = new boolean[N+1];
            int ans = 0;
            // 단방향으로 사이클
            for(int j = 0; j <N; j++){
                int start = j+1;
                int end = sc.nextInt();

                map.putIfAbsent(start, new ArrayList<>());
                map.get(start).add(end);
            }

            // 1번부터 N까지 DFS를 돌고 DFS자체를 몇 번 돌았는지 return
            for(int k = 1; k <= N; k++){
                if(!visited[k]){
                    dfs(k);
                    ans++;
                }
            }

            System.out.println(ans);

        }


    }
}
