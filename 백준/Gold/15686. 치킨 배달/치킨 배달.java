

import java.util.*;

public class Main {
    static int N,M; // N*N크기의 맵, 뽑아야하는 치킨집 개수
    static int[][]map; // 지도
    static List<location> chicken = new ArrayList<>(); // 치킨집 전체 저장
    static List<location> house = new ArrayList<>(); // 집 전체 저장
    static class location{
        int r,c;
        location(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static location[] pick; // 뽑은 치킨집 조합을 저장
    static int[]dr = {-1,0,1,0}; // 델타배열
    static int[]dc = {0,1,0,-1};
    static int min = Integer.MAX_VALUE; // 최종적으로 구해야할 치킨거리의 최솟값
    // 1. list.size()개의 치킨집 중에 M개를 뽑아서 -> 조합
    // 도시의 치킨거리를 구하기
    static void combination( int at, int depth){
        if(depth == M){ // M개의 치킨집을 선택했으면
            calculate();// bfs를 돌려서 각 조합의 치킨거리 중 최솟값 구하기
            return;
        }

        for(int i = at; i < chicken.size(); i++){
            pick[depth] = chicken.get(i);
            combination(i+1, depth+1);
        }
    }

    // 2. 어차피 맨해튼 거리이므로 house와 pick사이의 거리를 구해서 최솟값으로 갱신
    private static void calculate() {
        int local_min = 0;

        for(location h : house){  // 각 집에 대해서
            int m_distance = Integer.MAX_VALUE;

            for(location c : pick){ // 선택된 치킨집 중 가장 가까운 거리를 저장 -> 치킨 거리
                int d = Math.abs(h.r - c.r) + Math.abs(h.c - c.c);
                m_distance = Math.min(m_distance, d);
            }

            local_min += m_distance; // 각 집의 치킨 거리를 더해서 도시의 치킨 거리 구하기
        }

        // calculate메소드를 돌릴 때마다 더 작은 값으로 갱신 -> 최소값
        min = Math.min(min, local_min);
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //N*N
        M = sc.nextInt(); // 골라야할 치킨집 개수
        map = new int[N][N];
        pick = new location[M]; // 고른 치킨집 저장

        for(int i = 0; i <N; i++){
            for(int j = 0; j <N; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 2){
                    chicken.add(new location(i,j)); // 치킨집 전체 저장
                }else if(map[i][j] == 1){
                    house.add(new location(i,j));
                }
            }
        }// 입력 끝

        // 0. 치킨집을 고르는 로직 -> combination
        // 1. 각 치킨집 조합에 대해 그 때의 치킨거리를 구하기 -> 최솟값 갱신

        combination( 0,0);
        System.out.println(min);

    }
}
