

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N;
    static int[]num;
    static boolean[]visited;
    static List<Integer> list = new ArrayList<>();
    static int max = 0;
    // 일단 줄세우기 부터 -> 순열! 중복x
    static void backtracking(int depth, int target){
        if(depth == target){
            // System.out.println(list);
            max = Math.max(max,check());
            return;
        }
        for(int i = 0; i <N; i++){ // num[0]~ num[i]에 대해서
            if(!visited[i]){ // 같은 숫자 뽑는것 방지
                visited[i] = true;
                list.add(num[i]);
                backtracking(depth+1, target);
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
    static int check(){
        int sum = 0;
        for(int i = 0; i <list.size()-1; i++){
            sum += Math.abs(list.get(i)-list.get(i+1));
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        num = new int[N];
        visited = new boolean[N];
        for(int i = 0; i <N; i++){
            num[i] = sc.nextInt();
        }

        backtracking(0,N);

        System.out.println(max);
    }
}
