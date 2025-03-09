

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N;
    static List<Long> decreasingNum = new ArrayList<>(); // 그냥 감소하는 수를 다 집어넣기
    static void backtracking(long num, int lastNum){
        decreasingNum.add(num);

        // 마지막에 사용한 숫자보다 작은 숫자만 추가 가능
        for(int i = lastNum-1; i>= 0; i--){
            backtracking(num * 10 + i, i);
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        // 322 이런 숫자도 감소하는 숫자가 아님(중복x라는 뜻)
        // 최대 9876543210, 최소 0임!!

        // 0~9까지 한자리수를 먼저 추가하고, 그 숫자로 시작하는 감소하는 수들이 백트래킹 값으로 나옴!
        // 예) 5 -> 5, 54, 543, 5432, 54321, 543210 
        for(int i = 0; i <= 9; i++){
            backtracking(i,i);
        }

        Collections.sort(decreasingNum);
        // 정렬을 해줘야 N번째로 정확한 순서가 나옴 

        if(N < decreasingNum.size()){
            System.out.println(decreasingNum.get(N));
        }else {
            System.out.println(-1);
        }


    }
}
