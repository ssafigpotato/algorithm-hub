import java.util.*;

public class Main {
    static int N;
    static int M;
    static int R;
    static HashMap<Integer, List<Integer>> map = new HashMap<>();
    static boolean[]visited; // 노드 방문 표시
    static int []order; // 방문 순서 표시
    static int visitcnt = 1; // 젤 처음 방문은 1
    static void dfs(int node){
        visited[node] = true;
        order[node] = visitcnt++; // 방문 순서 기록

        // 인접 노드를 오름차순으로 방문
        // 인접 노드가 있으면 그 배열(neighbors)을 불러오고,
        // 없다면 빈 ArrayList 반환
        for(int neighbor : map.getOrDefault(node, new ArrayList<>())){
            if(!visited[neighbor]){ // 방문하지 않은 이웃에 대해서 dfs
                dfs(neighbor);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();
        visited = new boolean[N+1];
        order = new int[N+1];

        // 간선의 개수대로 간선 입력
        // 양방향 고려!
        for(int i = 0; i <M; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            map.putIfAbsent(start, new ArrayList<>());
            map.putIfAbsent(end, new ArrayList<>());

            map.get(start).add(end);
            map.get(end).add(start);
        }

        // 인접리스트를 오름차순으로 정렬해주기
        // 오름차순으로 방문할 수 있도록
        for(List<Integer> neighbors : map.values()){
            Collections.sort(neighbors);
        }

        // 시작 정점인 R부터 dfs 시작
        dfs(R);

        for(int i = 1; i <N+1; i++){
            System.out.println(order[i]);
        }



    }
}