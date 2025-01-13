

import java.util.*;

public class Main {
    static int N;
    static int M;
    static int R;
    static boolean[]visited;
    static int[]order;
    static int visitCnt = 1;
    static HashMap<Integer, List<Integer>> map = new HashMap<>();
    static void bfs(int node){
        Queue<Integer> que = new LinkedList<>();
        visited[node] = true; // 시작 노드 방문 처리
        que.offer(node); // 시작 노드 큐에 추가 
//        order[node] = visitCnt++; // bfs 순서는 큐에서 꺼낼 때 결정되므로 큐에 집어넣을 때 순서를 입력하면 꼬일 우려 있음

        while(!que.isEmpty()){
            int curr = que.poll(); // 현재 노드를 큐에서 꺼내기
            order[curr] = visitCnt++; // 방문 순서 기록

            // 현재 노드의 인접배열을 순회하면서 (오름차순으로 방문)
            for(int neighbor : map.getOrDefault(curr, new ArrayList<>())){
                if(!visited[neighbor]){ // 아직 방문하지 않은 경우
                    que.offer(neighbor); // 큐에 집어넣고
                    visited[neighbor] = true; // 방문 처리
                }
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();

        visited = new boolean[N+1];
        order = new int[N+1];

        // 간선 입력. 양방향
        for(int i =0; i <M; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();

            map.putIfAbsent(start, new ArrayList<>());
            map.putIfAbsent(end, new ArrayList<>());

            map.get(start).add(end);
            map.get(end).add(start);
        }

        // 오름차순 정렬
        for(List<Integer> neighbors : map.values()){
            Collections.sort(neighbors);
        }

        bfs(R);

        for(int i =1; i <N+1; i++){
            System.out.println(order[i]);
        }

        sc.close();
    }
}
