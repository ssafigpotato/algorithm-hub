

import java.util.Scanner;

public class Main {
    static int N;
    static int[][] flavor;
    static int min = Integer.MAX_VALUE;
    static void backtracking(int idx, int sour, int bitter, int cnt){ // 0~N까지 재료번호, 신맛연산, 쓴맛연산, 재료개수
        if(idx == N){ // 모든 재료를 다 탐색했다면
            if(cnt>0){ // 재료 한가지이상 선택
                min = Math.min(min, Math.abs(sour - bitter));
                return; // <- 여기에 리턴을 넣으면 cnt=0일 때는 return이 안되어서 계속 선택됨 <- 여기다가 넣고싶으면 여기도 넣고 아래도 넣어줘야함
//                System.out.println(min);
            }
            return;
        }

        // 재료 선택o
        backtracking(idx+1, sour*flavor[idx][0], bitter+flavor[idx][1], cnt+1);

        // 재료 선택x
        backtracking(idx+1, sour, bitter, cnt);


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        flavor = new int[N][2];
        for(int i = 0; i <N; i++){
            flavor[i][0] = sc.nextInt(); // 신맛
            flavor[i][1] = sc.nextInt(); // 쓴맛
        }

        backtracking(0,1,0,0); // sour의 초기값 1(곱하기니까) bitter의 초기값 0(더하기니까)
        System.out.println(min);

    }
}
