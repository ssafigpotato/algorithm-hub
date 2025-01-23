

import java.util.*;

public class Main {
    static int T;
    static int n; // 맥주를 파는 편의점 개수
    static boolean[]visited;
    static class Location { // 위치 클래스
        int r;
        int c;
        Location(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static List<Location> loc; // 집, 편의점, 페스티벌 좌표들
    static boolean bfs(){
        Queue<Location> que = new LinkedList<>();
        que.offer(loc.get(0)); // 시작이 집 좌표
        visited[0] = true;

        while(!que.isEmpty()){
            Location curr = que.poll();

            // curr의 인접행렬 =>
            // 다음 장소로 이동할 때 거리가  1000이내면 ㅇㅋ인거잖아?
            // 현 위치에서 페스티벌에 갈 수 잇으면 return true
            // loc.get(loc.size()-1) = loc.getLast()라고 인텔리제이에서 알려줬는데
            // 백준에서는 못알아먹음 
            if(distance(curr, loc.get(loc.size()-1)) <= 1000) { // 탈출 조건
                return true;
            }

            for(int i = 1; i < loc.size(); i++){
                if(!visited[i] && distance(curr, loc.get(i)) <= 1000){ // 방문한적이 없고, curr로 부터 맨하튼 거리가 1000 이내라면
                    visited[i] = true; // 방문 표시 해주고
                    que.offer(loc.get(i)); // 해당 위치 큐에 넣기, 다음으로 이동
                }
            }

        }
        return false; // 위에서 탈출못했으면 못가는 것임
    }
    // 멘하튼 거리 계산 메소드
    static int distance(Location curr, Location next){
       return (Math.abs(curr.r - next.r) + Math.abs(curr.c - next.c));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt(); // 테캐 수

        for(int t = 0; t <T; t++){
            // 각 테캐마다 map 초기화
//            map = new int[70000][70000]; // 필요없음. 메모리초과됨
//            visited = new boolean[70000][70000];
            // 편의점 개수대로 입력받기
            n = sc.nextInt();
            visited = new boolean[n+2]; // 각 좌표 방문 확인 배열
            loc = new ArrayList<>(); // 리스트 초기화 loc의 사이즈도 n+2일것임

            // 1. 집 좌표 loc 리스트에 넣기
            int h_x = sc.nextInt(); // 집 좌표
            int h_y = sc.nextInt();
            loc.add(new Location(h_x, h_y));

            // 2. 편의점 좌표들 loc 리스트에 넣기
            for(int i = 0; i < n; i++){
                int c_x = sc.nextInt();
                int c_y = sc.nextInt();
                loc.add(new Location(c_x,c_y));
            }

            // 3. 페스티벌 좌표 loc 리스트에 넣기
            int r_x = sc.nextInt(); // 페스티벌 좌표
            int r_y = sc.nextInt();
            loc.add(new Location(r_x, r_y));



            if(bfs()){
                System.out.println("happy");
            }else {
                System.out.println("sad");
            }




        }

    }
}
