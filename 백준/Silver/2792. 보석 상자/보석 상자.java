

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N,M;
    static int[]colors;
    static int binarySearch(){
        // 가장 많은 보석 개수 == 질투심 를 찾기
        int left = 1; // 최소 1개
        int right = colors[colors.length-1]; // 마지막 수가 최대
        int result = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            if(check(mid) <= N){ // mid일 때 나눠주는 아이수가 N명 이하라면
                result = mid; // 정답 후보!
                right = mid -1; // 더 적은 값도 되는지 탐색
            }else { // N명이 넘는다면 기존 애들보다 더 많이 나눠줘야된다는 말 = 너무 잘게 쪼갰다!
                // 더 큰 값이 최대개수다!
                left = mid +1; // 하방을 올려주기
            }
        }
        return result;
    }
    static int check(int mid){
        int cnt = 0; // 나눠주는 학생 수
        for(int i = 0; i <M; i++){ // 각 색상에 대해서
            // 나눗셈의 몫을 올림하기
            // 예를 들어 최댓값(mid)을 4로 받아왔을 때
            // colors개수가 1이면 통째로 1명에게 줘야함
            // 7이라면 7/4 의 올림인 2명에게 줘야함
            // 근데 자바에서는 int/int는 자동 버림이 되어서 Math.ceil을 해도 버린수에서 올림하므로 원하는 결과가 안나옴!
            // 따라서 double로 형변환해서 올림값을 구한후 다시 int로 변환하기
            cnt += (int) Math.ceil((double) colors[i] / mid);

        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 아이들의 수
        M = sc.nextInt(); // 색상 수
        // 보석은 모두 나눠줘야함
        // 학생은 못 받아도 오키
        // 1 4 4 7 7
        // 1, 4, 4, 3, 4, 3, 4
        colors = new int[M];
        for(int i = 0; i <M; i++){
            colors[i] = sc.nextInt();
        }
        Arrays.sort(colors);
        System.out.println(binarySearch());


    }
}
