

import java.util.Scanner;

public class Main {
    static int n;
    static int []nums;
    static int []operator;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static void backtracking(int depth, int sum){ // 중복순열!
        if(depth == n){ // +1 된 값이 마지막 depth가 되니까 n-1이 아닌 n이 될 떄 return1
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for(int i = 0; i <4; i++){
            if(depth >= nums.length){ // depth가 nums의 index임 num길이보다 커지면 반복문 탈출!
                break;
            }

            if(operator[i] > 0) {
                if(i == 0){ // 0이면 더하기
                    operator[i] -= 1;
                    backtracking(depth+1, sum+nums[depth]);
                } else if(i == 1){ // 1이면 빼기
                    operator[i] -= 1;
                    backtracking(depth+1, sum-nums[depth]);
                } else if(i == 2){ // 2면 곱하기
                    operator[i] -= 1;
                    backtracking(depth+1, sum*nums[depth]);
                } else { // 3이면 나누기
                    operator[i] -= 1;
                    backtracking(depth+1, sum/nums[depth]);
                }

                operator[i] += 1; // 다시 원상복귀시켜줘야지! 롤백!
            }



        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        operator = new int[4];
        for(int i =0; i <4; i++){
            operator[i] = sc.nextInt();
        }

        backtracking(1,nums[0]); // depth에 1을 해야 nums[0]에 nums[1]부터 연산할 수 있음!
        System.out.println(max);
        System.out.println(min);
    }
}
