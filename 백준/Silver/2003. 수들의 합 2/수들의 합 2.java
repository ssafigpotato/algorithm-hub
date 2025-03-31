

import java.util.Scanner;

public class Main {
    static int N,M;
    static int[]arr;
    static int twoPointer(){
        int start = 0; // 시작 지점
        int end = 0; // 끝 지점
        int sum = 0; // 합
        int cnt = 0; // 경우의 수

        while(true){ // start가 N을 넘으면 종료

            if(sum >= M){ // 합이 M보다 크거나 같으면
                sum -= arr[start]; // 합계에서 기존 start위치 원소를 뺴주고
                start++; // 시작지점을 한 칸 오른쪽으로 밀기
            } else if(end == N){ // end가 N이 되면 indexoutofbounds error나므로
                break; // 탈출
            } else { // sum < M이고 end <N이면 
                sum += arr[end]; // 끝지점위치 원소를 더해주고 
                end++; // end 한 칸 밀기 
            }

            if(sum == M){
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        for(int i = 0; i <N; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(twoPointer());


    }
}
