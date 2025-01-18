

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[]visited;
    static HashMap<Integer, List<Integer>> map = new HashMap<>();
    static int[]dis;
    static boolean isReach;
    static void bfs(int node){
      Queue<Integer> que = new LinkedList<>();
      que.offer(node);
      visited[node] = true;

      while(!que.isEmpty()){
          int curr = que.poll();

          // 아 bfs는 최대한 넓게 퍼져나가니까 겉운 인접 배열에 있는 neighbor를 모두 탐색하고
          // 다음으로 큐에 넣었던걸 탐색하는구나!!!
          // 그래서 최단거리구나!!
          // 예) curr = 1 이고, curr의 인접행렬이 2,3,4라면
          // 첫 neighbor인 2를 탐색하고 dis[1](=1부터 1까지의 거리는 0임) + 1인 1을 거리로 설정
          // 여기서 dfs처럼 2에 딸린 인접행렬을 탐색하지 않고
          // 1의 다른 neighbor인 3을 탐색하고 똑같이 dis[curr=1]+1 인 1을 거리로 설정
          // 마찬가지로 4도 dis[4] = 1로 설정됨. 그래서 최단거리구나!!
          for(int neighbor : map.getOrDefault(curr, new ArrayList<>())){
              if(!visited[neighbor]){
                  visited[neighbor] = true;
                  dis[neighbor] = dis[curr] + 1;
                  que.offer(neighbor);
              }
          }
      }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 헛간 개수
        M = sc.nextInt();
        visited = new boolean[N+1]; // 노드 (헛간)방문 표시
        dis = new int[N+1]; // 각 노드(헛간)의 1로부터의 거리 저장 배열
        for(int i = 0; i <M; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();

            map.putIfAbsent(start, new ArrayList<>());
            map.putIfAbsent(end, new ArrayList<>());

            map.get(start).add(end);
            map.get(end).add(start);
        }// map에 인접행렬 집어넣기

        bfs(1);
        // System.out.println(Arrays.toString(dis)); // 확인

        int max_v = 0;
        int max_id = 0;
        for(int i = 1; i <=N; i++){
            if(max_v < dis[i]){ // 여기서 항상 <일 때만 max갱신! =일때는 뺴고!
                max_v = dis[i];
                max_id = i;
            }
        }
        int cnt = 0;
        for(int i = 1; i <=N; i++){
            if(dis[i] == max_v){
                cnt++;
            }
        }

        System.out.println(max_id+" "+max_v+" "+cnt);

        sc.close();



    }
}
