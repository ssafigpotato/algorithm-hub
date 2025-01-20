

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    /**
     * 만약, U층 위, 또는 D층 아래에 해당하는 층이 없을 때는, 엘리베이터는 움직이지 않는다
     * 강호가 G층에 도착하려면, 버튼을 적어도 몇 번 눌러야 하는지 구하는 프로그램을 작성하시오.
     * 만약, 엘리베이터를 이용해서 G층에 갈 수 없다면, "use the stairs"를 출력한다.
     * */
    static int F,S,G,U,D;
    static int[]dr;
    static boolean[]visited;
    static long[]ans;
    static void bfs(int start){
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visited[start]  = true;

        while(!que.isEmpty()){
            int curr = que.poll(); // 백만이니까 integer
            if(curr == G){
                return;
            }
           //  System.out.println("curr: "+curr);
            // 인접행렬 : curr로부터 갈 수 있는 곳
            for(int i = 0; i <2; i++){
                int nr = curr + dr[i]; // 백만 + 백만 이면 이백만이니까 Integer
                // System.out.println("nr: "+nr);
                if(nr > 0 && nr < F+1){ // 건물은 1층부터 시작함!!!!
                    if(!visited[nr]){
                        que.offer(nr);
                        ans[nr] = ans[curr] +1; // nr층에 도달하기 위해 눌러야하는 버튼 횟수
//                        System.out.println("nr: "+nr+"일 때 버튼 횟수: "+ans[nr]);
                        visited[nr] = true;
                    }
                }
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        F = sc.nextInt(); // 고층 건물 층 수
        S = sc.nextInt(); // 강호가 지금 있는 위치
        G = sc.nextInt(); // 스타트링크가 있는 곳의 위치 target
        U = sc.nextInt(); // 위로 U층을 가는 버튼
        D = sc.nextInt(); // 아래로 D층을 가는 버튼

        dr = new int[] {U, -D};
        visited = new boolean[F+1]; // 총 층수가 F니까 범위를 이렇게 하면 효율적임!! 백만이렇게 하지 말고
        ans = new long[F+1]; // i층에 도달하기 위해 버튼을 눌러야하는 횟수
        ans[G] = -1; // 기본값
        bfs(S);

        if(ans[G] == -1){
            if(S == G){
                System.out.println(0);
            }
            else {
                System.out.println("use the stairs");
            }
        }else {
            System.out.println(ans[G]);
        }
        sc.close();
    }
}
