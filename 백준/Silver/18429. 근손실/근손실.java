

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N, K;
    static int[]num;
    static boolean[]visited;
    static List<Integer> order; // 운동 키트 적용 순서
    static int cnt = 0; // 조건을 만족하는 경우의 수
    // 순열로 줄 세우기 -> 500이상 되는지 체크
    static void backtracking(int depth, int target ){
        if(depth == target){
            // System.out.println(order);
            if(check()){
                cnt++;
            };
            return;
        }

        for(int i = 1; i <N+1; i++){ // 1번~ N번 운동키트에 대해서
            if(!visited[i]){
                visited[i] = true; // 같은 숫자를 선택하는 중복 방지
                order.add(i);
                backtracking(depth+1, target);
                order.remove(order.size()-1); // 이게 없으면 리스트가 계속 추가됨...
                visited[i] = false;
            }
        }
    }
    static boolean check(){
        int weight = 500;
        for(int i = 0; i <N; i++){
            weight += num[order.get(i)] - K; // 리스트에 저장된 운동키트의 중량 - K만큼 더하기
            // System.out.println(i+1+"일차 중량: "+weight);
            if(weight <500){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 일수, N개의 운동키트
        K = sc.nextInt(); // 감소량
        num = new int[N+1];
        visited = new boolean[N+1];
        for(int i = 1; i <N+1; i++){
            num[i] = sc.nextInt();
        }

        order = new ArrayList<>();
        backtracking(0,N);
        System.out.println(cnt);
    }
}
