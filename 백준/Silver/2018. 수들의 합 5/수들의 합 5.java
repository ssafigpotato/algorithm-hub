

import java.util.Scanner;

public class Main {
    static int N;
    public static void main(String[] args) {
//        어떠한 자연수 N은, 몇 개의 연속된 자연수의 합으로 나타낼 수 있다
        // 따라서 시작지점과 끝지점을 설정하고 합과 N을 대소 비교해서 오른쪽으로 한 칸 밀기
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 자연수 N

        int start = 1; // 자연수만 이니까 1부터 시작!!
        int end = 1; // 끝도 처음에는 같은 1
        int sum = 1; // 처음에 1을 더한 상태로 시작
        int cnt = 0; // 만족하는 수 배열 개수

        while(start <= N){
            if(sum == N){ // 수들의 합이 N과 같으면
                cnt++; // 개수에 더해주고
                sum -= start; // 시작지점을 한 칸 오른쪽으로 밀고 기존 시작지점은 빼줌
                start++;
            }else if(sum < N) { // 합이 N보다 작으면
                end++; // 끝지점을 한 칸 오른쪽으로 밀고
                sum += end; // sum에다 끝지점을 더 추가해줌
            }else { // 합이 N을 넘으면
                sum -= start; // 기존 시작지점은 빼주고
                start++; // 시작지점을 한 칸 오른쪽으로 밀기
            }
        }

        System.out.println(cnt);
        sc.close();
    }
}
