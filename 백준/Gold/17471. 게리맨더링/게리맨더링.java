

import java.util.*;

public class Main {
    static int N;
    static int[] num;
    static HashMap<Integer, List<Integer>> map = new HashMap<>(); // 노드 번호와 각 노드에 연결된 인접행렬
    static List<Integer> group1, group2;
    static int min = Integer.MAX_VALUE;
    // 중복 x, 걍 뽑는거라 순서 안 중요 -> 조합
    static void combination(int depth, int at, int target){ // 부분집합 구하기
        if(depth == target){
            group2 = new ArrayList<>(); // group2를 명시적으로 초기화
            for (int i = 1; i <= N; i++) {
                if (!group1.contains(i)) {
                    group2.add(i); // group1에 없는 노드는 group2에 추가
                }
            }
            check();
            return;
        }

        for(int i = at; i < N+1; i++){
            group1.add(i); // i를 그룹1에 넣은 경우에
            combination(depth+1, i+1, target); // 쭉쭉 재귀돌리면서 경우 파악
            group1.remove(group1.size()-1); // 재귀 끝나면 i를 그룹1에서 빼고
            // (가장 최근에 넣었으니까 리스트 마지막에 있음)
            // 백트래킹
        }
    }
    static void check(){
        if(bfs(group1) && bfs(group2)){
            int sum1 = 0;
            int sum2 = 0;

            for(int node: group1){
                sum1 += num[node];
            }
            for(int node: group2){
                sum2 += num[node];
            }

            min = Math.min(min, Math.abs(sum1-sum2));
        }
    }
    static boolean bfs(List<Integer> list){ // 그룹이 bfs 할 수 있는지(연결되어 있는지) 확인
        if(list.isEmpty()) return false; // 각 그룹은 노드를 하나 이상 포함해야하므로
        // 비어있다면 바로 false

        Queue<Integer> que = new LinkedList<>();
        boolean[]visited = new boolean[N+1];
        que.offer(list.get(0));
        visited[list.get(0)] = true;

        int cnt = 1; // 방문한 곳 개수
        // 방문한 곳 개수가 그룹사이즈와 같아야 함!
        // 그래야 그룹내 모든 곳이 연결되어있다는 뜻
        while(!que.isEmpty()){
            int curr = que.poll();
            // curr의 인접행렬들
            for(int neighbor : map.getOrDefault(curr, new ArrayList<>())){
                // curr의 인접행렬이 group이 포함하면서 방문한적 없는 곳인지
                if(list.contains(neighbor) && !visited[neighbor]){
                    que.offer(neighbor);
                    visited[neighbor] = true;
                    cnt++;
                }
            }
        }
        return cnt == list.size();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 노드의 수
        num = new int[N+1]; // 각 구역의 인구 수

        for(int i = 1; i <N+1; i++){
            num[i] = sc.nextInt();
        }

        for(int i = 1; i <N+1; i++){ // 노드 N개에 대해서
            int K = sc.nextInt(); // 각 노드에서 인접한 노드의 수
            map.putIfAbsent(i, new ArrayList<>());

            for(int j = 0; j <K; j++){
                map.get(i).add(sc.nextInt());
            }
        }

        // 브루트포스로 걍 다 나눠보기...?
        // 부분집합으로 2개로 나누고
        // 각 부분 bfs해보고 -> 되면 인구차이 구하기
        // 되는 것 중에 최솟값 출력
        // N개에서 x개 뽑기
        for(int i = 1; i <= N/2; i++){
            group1 = new ArrayList<>(); // x개를 뽑는 연산할 떄마다 초기화
            combination(0,1,i);
        }

        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(min);
        }
    }
}
