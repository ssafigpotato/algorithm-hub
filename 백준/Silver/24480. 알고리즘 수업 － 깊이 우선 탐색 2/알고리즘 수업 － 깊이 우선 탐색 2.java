

import java.util.*;

public class Main {
    static int N;
    static int M;
    static int R;
    static HashMap<Integer, List<Integer>> map = new HashMap<>();
    static boolean[]visited;
    static int[]order;
    static int visitCnt = 1;
    static void dfs(int node){
        visited[node] = true;
        order[node] = visitCnt++;

        for(int neighbor : map.getOrDefault(node, new ArrayList<>())){
            if(!visited[neighbor]){
                dfs(neighbor);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();

        visited = new boolean[N+1]; // 방문 여부 체크
        order = new int[N+1]; // 방문 순서 체크

        // 간선 입력. 양방향
        for(int i = 0; i <M; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();

            map.putIfAbsent(from, new ArrayList<>());
            map.putIfAbsent(to, new ArrayList<>());

            map.get(from).add(to);
            map.get(to).add(from);
        }

        // 인접 배열 내림차순 정렬
        for(List<Integer> neighbors : map.values()){
            Collections.sort(neighbors, Collections.reverseOrder());
        }

        // R부터 dfs
        dfs(R);

        // order배열 print
        for(int i =1; i <N+1; i++){
            System.out.println(order[i]);
        }

        sc.close();
    }
}
