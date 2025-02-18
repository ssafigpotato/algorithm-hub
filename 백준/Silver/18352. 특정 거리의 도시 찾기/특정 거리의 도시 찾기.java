

import java.util.*;

public class Main {
    static int N,M,K,X;
    static HashMap<Integer, List<Integer>> map = new HashMap<>();
    static int[]distance; // 시작도시(X)부터 각 도시까지의 최단 거리 저장
    static List<Integer> answer;
    public static List<Integer> bfs(int start){
        Queue<Integer> que = new LinkedList<>();
        distance = new int[N+1]; // 도시 수 만큼
        Arrays.fill(distance, -1); // 방문하지 않았음 초기화
        answer = new ArrayList<>();

        que.offer(start);
        distance[start] = 0; // 시작점의 거리는 0 (자기에서 자기는 0)

        while(!que.isEmpty()){
            int curr = que.poll();
            for(int neighbor : map.getOrDefault(curr, new ArrayList<>())){ // curr의 각 이웃 도시(연결된 도시)에 대해서
                if(distance[neighbor] == -1){ // 방문하지 않았다면
                    distance[neighbor] = distance[curr] + 1; // 가중치가 1이므로 이렇게 최단 거리 갱신
                    que.offer(neighbor);
                }
            }
        }

        // while을 돌고나면 X부터 각 도시까지의 최단 거리가 저장됨
        for(int i = 1; i < N+1; i++){
            if(distance[i] == K){ // 최단 거리가 K인 도시 번호 저장
                answer.add(i);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //도시 개수
        M = sc.nextInt(); // 도로개수
        K = sc.nextInt(); // 거리 정보
        X = sc.nextInt(); // 출발 도시의 정보

        for(int i = 0; i <M; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            map.putIfAbsent(start, new ArrayList<>());
            map.get(start).add(end);
        }

        List<Integer> result = bfs(X);

        if(result.isEmpty()){
            System.out.println(-1);
        }else {
            Collections.sort(result); // 오름차순 정렬
            for(int c : result){ // 최단 거리가 K인 도시 번호 오름차순 출력
                System.out.println(c);
            }
        }

    }
}
