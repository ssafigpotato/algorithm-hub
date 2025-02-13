

import java.util.Scanner;

public class Main {
    public static long BinarySearch(long n){
        long left = 0;
        long right = n;
        long result = 0;

        while(left <= right){ // 여기서는 결국 left == right가 되는 일치값을 찾아야함
            long mid = (left + right) / 2;

            // 문제에서 무엇을 찾으라고 했는지 생각해보셈
            // n <= q*q를 만족하는 가장 작은 q를 찾아라고 했음
            // left와 right를 왔다갔다하고, 그에 따라 mid도 왔다갔다할 것임
            // 그럼 mid*mid값이 n보다 같거나 커지면 그 때 mid값은 result가 될 수 있고,
            // 그 중 가장 작은 것은 아니고 암튼 n보다 큰거니까 right값을 줄여줌
            // 그 중 가장 최솟값이 나온다면 그 땐 left == right가 될 거니까
            if(n<= Math.pow(mid,2)){
                // n <= mid * mid로 하면 오버플로우나서 이상한 값 나옴
                // Math.pow는 double로 계산하므로 long보다 훨씬 큰 값을 처리할 수 있음
                // 다만, 부동소수점 오차로 인해 정확하지 않을 수 있으므로 mid <= n / mid 이 느낌으로 해주는게 더 좋음! -> sol2
                result = mid;
                right = mid-1;
               
            }else {
                left = mid + 1; // 아직 도달 못햇으므로 하방값 올려주기
            }

        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        System.out.println(BinarySearch(N));
    }
}
