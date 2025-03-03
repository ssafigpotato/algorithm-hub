

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N;
    static List<Integer> weight = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static void backtracking(int depth, int energy){
//        if(depth == N-2){ // 구슬 N-2개 골랐으면 더이상 고를 수 없음
            // 최종 두 개 남으면 각각 첫번째, 마지막 에너지 구슬이므로
        if(weight.size() == 2){ // 에너지 구슬이 두개 남으면 종료!
            max = Math.max(max, energy);
            return;
        }

//        for(int i= 1; i <= N-1; i++){ // weight사이즈가 계속 줄어드니까 weight.size를 기준으로 해야함!
        for(int i = 1; i <weight.size()-1; i++){ // 첫번째와 마지막 구슬 제외!
            // 리스트에서 한 원소를 제거하면 idx가 다시 조정이 되니까
            // visited배열같은건 필요없을듯

            // i번째 구슬 선택시 얻는 에너지
            int add = weight.get(i-1) * weight.get(i+1);
            // 현재 구슬 제거
            int remove = weight.remove(i);

            backtracking(depth+1, energy + add);

            weight.add(i, remove); // 롤백! 없앴던 그 위치(원 위치)에 다시 추가!
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i = 0; i <N; i++){
            weight.add(sc.nextInt());
        }

        backtracking(0,0);
        System.out.println(max);
    }
}
