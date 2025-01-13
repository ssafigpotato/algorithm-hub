

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N; // 노드 개수
    static HashMap<Integer, List<Integer>> map = new HashMap<>();
    static boolean[]visited;
    static int[]parent; // 부모 노드 저장 배열
    static void dfs(int node){
        visited[node] = true;

        for(int neighbor : map.getOrDefault(node, new ArrayList<>())){
            if(!visited[neighbor]){
                parent[neighbor] = node; // 부모 노드를 찾아야하므로 node와 그 인접행렬의 원소 중 현재 방문한 노드를 이렇게 입력
                dfs(neighbor);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visited = new boolean[N+1];
        parent = new int[N+1]; // i번째 노드의 부모를 값으로 저장
        // 간선 입력. 양방향이라고 생각해야하는듯
        for(int i = 0; i <N-1; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();

            map.putIfAbsent(start, new ArrayList<>());
            map.putIfAbsent(end, new ArrayList<>());
            map.get(start).add(end);
            map.get(end).add(start);
        }

        dfs(1);

        for(int i = 2; i <N+1; i++){
            System.out.println(parent[i]);
        }
        sc.close();
    }
}
