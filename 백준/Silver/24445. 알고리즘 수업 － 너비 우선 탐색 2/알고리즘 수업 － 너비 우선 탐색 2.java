
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int R;
    static boolean[]visited;
    static int []order;
    static int visitCnt = 1;
    static HashMap<Integer, List<Integer>> map = new HashMap<>();
    static void bfs(int node){
        Queue<Integer> que = new LinkedList<>();
        que.offer(node);
        visited[node] = true;

        while(!que.isEmpty()){
            int curr = que.poll();
            order[curr] = visitCnt++; // 큐에서 꺼낼 때 방문순서도 체크해주고!

            for(int neighbor : map.getOrDefault(curr, new ArrayList<>())){
                if(!visited[neighbor]){
                    que.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N =sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();

        visited = new boolean[N+1];
        order = new int[N+1];

        // 간선 입력 양방향
        for(int i =0; i <M; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();

            map.putIfAbsent(start, new ArrayList<>());
            map.putIfAbsent(end, new ArrayList<>());

            map.get(start).add(end);
            map.get(end).add(start);
        }

        // 인접행렬 내림차순 정렬
        for(List<Integer> neighbors : map.values()){
            Collections.sort(neighbors, Collections.reverseOrder());
        }

        bfs(R);

        for(int i = 1; i <N+1; i++){
            System.out.println(order[i]);
        }

        sc.close();

    }
}
