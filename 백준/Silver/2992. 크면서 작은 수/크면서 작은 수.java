
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static String X;
    static char[]num;
    static boolean[]visited;
    static int min = Integer.MAX_VALUE;
    static void backtracking(int depth, String result){
        if(depth == X.length()){
            if(Integer.parseInt(result) > Integer.parseInt(X)){ // X값보다 큰 수 중에서 
                min = Math.min(min, Integer.parseInt(result)); // 가장 최솟값으로 갱신 
            }
            return;
        }

        for(int i = 0; i < X.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                // 결과에다가 num배열 원소(char)를 하나씩 붙여주는 것으로 result를 만들기 
                backtracking(depth+1, result+num[i]); // 바로 charAt(i)로 해도 되겠다! 
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        X = sc.next();
        num = X.toCharArray();
        visited = new boolean[X.length()];
//        System.out.println(Arrays.toString(num));

        backtracking(0,"");
        System.out.println((min == Integer.MAX_VALUE) ? 0 : min);
    }
}
