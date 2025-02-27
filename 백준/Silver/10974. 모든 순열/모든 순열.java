

import java.util.Scanner;

public class Main {
    static int N;
    static boolean[] visited;
    static void backtracking(int depth, String result){
        if(depth == N){
            System.out.println(result.trim()); // 그냥 result하면 문자열 앞에 붙은 공백 제거 안됨 
            return;
        }

        for(int i =1; i <=N; i++){
            if(!visited[i]){
//                System.out.print(i+" "); // 선택된 i를 출력하고
                visited[i] = true;
                backtracking(depth+1, result +" "+i);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visited = new boolean[N+1];
        backtracking(0, " ");
    }
}
