

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static int N;
    static HashSet<Integer> set = new HashSet<>();
    static int[]out;
    static int[]nums = {1,5,10,50};
    static boolean[]visited;
    static void backtracking(int depth, int at){
        if(depth == N){
            int cnt = 0;
            for(int o : out){
                cnt += o;
            }
            set.add(cnt);
            return;
        }

        for(int i =at; i <4; i++){
           out[depth] = nums[i];
           backtracking(depth+1, i);
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1,5,10,50 중에 N개를 가지고 만들 수 있는 숫자의 개수! -> 중복 조합
        N = sc.nextInt();
        visited = new boolean[4];
        out = new int[N];
        backtracking(0,0);
        System.out.println(set.size());

    }
}
