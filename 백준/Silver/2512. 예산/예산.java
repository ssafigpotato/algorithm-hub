

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int []budgets;
    static int M;
    static int BinarySearch(){
        int left = 0;
        int right = budgets[budgets.length-1]; // 될 수 있는 최대는 가장 마지막 수
        int result = 0;

        while(left <= right){
            int mid = (left + right) /2;

            // mid값으로 상한액을 정했을 때 예산 합이 M에 못 미친다면 하방값을 올려줘야겠지
            // 예산 합이 M 보다 크다면 right를 낮춰줘야겠지
            if(check(mid) <= M){
                result = mid; // 일단 M보다 작으니까 답이 될 여지가 있음
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return result;
    }
    static int check(int max){
        int sum = 0; // 예산 합
        for(int i = 0; i <N; i++){
            if(budgets[i] <= max){ // max보다 작거나 같은 값이면 그대로 반영
                sum += budgets[i];
            }else { // 크면 max값으로 반영
                sum += max;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 예산 수
        budgets = new int[N];
        for(int i = 0; i < N; i++){
            budgets[i] = sc.nextInt();
        }
        M = sc.nextInt(); // 총 예산

        // 1. budgets를 오름차순으로 정렬
        Arrays.sort(budgets); // <-- 굳이 필요없을 듯 왜냐면 budgets의 값 중에서 찾는것이 아니니까
        // 아 아님 이것 때문에 budgets이 오름차순으로 정렬되어서 right가 마지막값이 된것임

        // 2. 이분탐색으로 상한가 탐색
        // 해당 상한가에서 각 예산의 합이 M보다 작거나 같은 최대의 수여야함
        System.out.println(BinarySearch());
    }
}
