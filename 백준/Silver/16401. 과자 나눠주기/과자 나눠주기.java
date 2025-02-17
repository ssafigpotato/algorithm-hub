

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int M,N;
    static int []snacks;
    static int binarySearch(){
        int left = 1; // 길이는 최소 1
        int right = snacks[snacks.length-1]; // 마지막 원소
        int result = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            // mid보다 크거나 같은 B가 M개 이상이거나
            // 큰 거를 쪼개서 여러개 만들어서 M개 이상이 나오거나
            if(check(mid) >=M){
                result = mid; // 일단 정답 후보
                left = mid +1; // 더 큰 범위가 되는지 탐색
            }else { // 적게 나눠줄 수 있다 = 과자가 너무 크다!
                right = mid -1; // 될 수 있는 과자 범위 줄이기
            }
        }
        return result;

    }
    static int check(int mid){ // 길이가 mid일 때 나눠줄 수 있는 사람의 수
        int cnt = 0;
        for(int i =0; i <N; i++){ // 각 스낵에 대해서
            if(snacks[i] < mid) continue; // 작으면 연산할 필요도 없음 <-- 이 코드를 넣으면 효율이 개선될까? 
            cnt += snacks[i] / mid; // snacks[i]를 mid길이로 나눈 몫만큼의 사람에게 배분 가능
            // 예 snacks[i]가 15이고, mid가 7이면 2명 분
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); // 조카의 수
        N = sc.nextInt(); // 과자의 수
        snacks = new int[N];
        for(int i = 0; i <N; i++){
            snacks[i] = sc.nextInt();
        }
        Arrays.sort(snacks);
        System.out.println(binarySearch());

    }
}
