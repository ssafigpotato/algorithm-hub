

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N; // 정점 개수
    static int a,b; // 경로를 구하는 노드
    static int m; // 간선의 개수
    static HashMap<Integer, List<Integer>> map = new HashMap<>();
    static boolean[] visited;
    static int ans = -1;
    static void dfs(int node, int depth){ // 깊이(촌수)도 같이 전달하기!!!
        visited[node] = true; // 현재 노드 방문 표시
        if(node == b) {
            ans = depth; // 현재의 촌수를 결과값으로 저장
            return; // b에 도달하면  return;
        }
       // 재귀횟수가 촌수인줄 알았는데, 그게 아니라 b에 도달할때의 깊이가 촌수네

        // 인접 행렬 방문
        for(int neighbor : map.getOrDefault(node, new ArrayList<>())){
            if(!visited[neighbor]){ // 방문하지 않았다면
                dfs(neighbor, depth+1);  // 재귀로 방문
            }
        }

    }
    public static void main(String[] args) {
        // a -> b로 가기까지 몇 번 가야하는지를 출력하면 될듯
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[N+1];

        for(int i = 0; i <m; i++){
            int parent = sc.nextInt();
            int son = sc.nextInt();

            // son에서 parent로 가는 것만 넣으면 어케 되지?
            map.putIfAbsent(parent, new ArrayList<>());
            map.putIfAbsent(son, new ArrayList<>());
            map.get(parent).add(son);
            map.get(son).add(parent);
        }// hashmap에 간선 입력


        dfs(a, 0);
        System.out.println(ans);

        sc.close();

    }
}
