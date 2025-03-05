

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N,M;
    static HashMap<Integer, List<Integer>> map = new HashMap<>();
    static boolean []visited;
    static boolean found = false; // 5명이 연결된 친구관계를 찾았는지 여부
    static void dfs(int depth, int curr){
        if(depth == 4){ // 5명 다 연결되어 잇으면
            found = true;
            return ;
        }

        visited[curr] = true; // 방문 처리해주고

        for(int neighbor : map.getOrDefault(curr, new ArrayList<>())){
            // System.out.println("현재 neighbor: "+neighbor+"depth: "+depth);
            if(!visited[neighbor]){
                dfs(depth+1, neighbor);
                if(found) return; // dfs로 찾고 나왔을 때 found = true이면 더 탐색 ㄴㄴ
            }
        }

        visited[curr] = false; // 다른 경로 탐색을 위해 백트래킹
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 사람수
        M = sc.nextInt(); // 친구관계 수
        visited = new boolean[N];

        for(int i = 0; i <M; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            map.putIfAbsent(start, new ArrayList<>());
            map.putIfAbsent(end, new ArrayList<>());

            map.get(start).add(end);
            map.get(end).add(start);
        }

        for(int i= 0; i < N; i++){
            dfs(0,i);
            if(found) break;
        }

        System.out.println(found? 1: 0 );


    }
}
