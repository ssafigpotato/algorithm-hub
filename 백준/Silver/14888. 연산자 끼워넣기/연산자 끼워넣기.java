

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N;
    static int[]num;
    static int[]operator; // 연산자 개수
    static List<Integer>order= new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    // 전체에서 N-1개를 뽑는 경우의 수 -> 순열. 중복 가능
    // 단, 개수는 -1해주다가 0이되면 못씀
    static void permutation(int depth){
        if(depth == N-1){
            // System.out.println(order);
            int sum = calculation();
            min = Math.min(min, sum);
            max = Math.max(max,sum);
            return;
        }
        for(int i = 0; i <4; i++){ //operator배열에서
            if(operator[i] != 0){ // 0이 아니면 뽑을 수 있음
                order.add(i);
                operator[i] -= 1; // 쓸 수 있는 개수 하나 줄여주고
                permutation(depth+1);
                order.remove(order.size()-1);
                operator[i] += 1; //???
            }
        }
    }
    static int calculation(){
        int sum = num[0];
        for(int i = 0; i <N-1; i++){
            if(order.get(i) == 0){ // 0번째면 더하기
                sum += num[i+1];
            }else if(order.get(i) == 1){ //1번째면 빼기
                sum -= num[i+1];
            }else if(order.get(i) == 2){ // 2번째면 곱하기
                sum *= num[i+1];
            }else { // 3번째면 나누기
                if(num[i] < 0){  // 음수이면
                    sum /= num[i+1];
                    sum = -sum; // 나눠주고 몫은 음수처리
                }else { // 양수이면 그대로 나누기
                   sum /= num[i+1];
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        num = new int[N];
        for(int i = 0; i <N; i++){
            num[i] = sc.nextInt();
        }


        // 쓸 수 있는 연산자의 개수는 N-1개
        // operator각 원소 합은 N-1개
        operator = new int[4];
        for(int i = 0; i <4; i++){
            operator[i] = sc.nextInt();
        }
        permutation(0);
        System.out.println(max);
        System.out.println(min);
    }
}
