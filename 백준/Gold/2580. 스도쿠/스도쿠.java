

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int[][]map;
    static class location{
        int r,c;
        location(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static List<location> blank = new LinkedList<>();
    static boolean backtracking(int idx){
        if(idx == blank.size()){ // 빈칸을 모두 채웠다면
            print();
            return true;
        }

        // 1) 현재 빈칸을 가져오기
        location curr = blank.get(idx);

        // 2) 빈칸에 1~9까지 넣어보면서 탐색
        // 가로, 세로, 3*3 한꺼번에 탐색해야함
        for(int num = 1; num <= 9; num++){
            if(check(curr.r,curr.c, num)){ // 일단 넣어도 되는 숫자라면
                map[curr.r][curr.c] = num; // 숫자를 배치하고

                // 예를 들어 backtracking(0)에서 유효성 검사 후 어떤 숫자를 넣어서
                // backtracking(1)로 갔는데 모든 숫자가 불가능 하다면 false를 반환하고 return(종료)됨
                // 이 때 다시 backtracking(0)으로 돌아가면 if조건이 false가 된 것이므로
                // 0으로 원상복구한 다음 다른 숫자를 탐색함 (이 숫자는 못 쓰는 숫자니까)
                // 계속 재귀해서 파고들어갔는데도 다 true면 true반환하고 종료하면 됨
                if(backtracking(idx+1)) return true;

                map[curr.r][curr.c] = 0; // 원상복구해서 다음 숫자 탐색
            }
        }

        return false;
    }
    static void print(){
        for(int i = 0; i <9; i++){
            for(int j = 0; j<9; j++){
                System.out.print(map[i][j]+" ");
            }System.out.println();
        }
    }
    static boolean check(int r, int c, int num){
        // 1) 가로, 세로 체크
        for(int i = 0; i < 9; i++){
            if(map[r][i] == num || map[i][c] == num) return false; // 다른 행/열에 이미 해당 숫자가 있으면 false
        }

        // 2) 3*3 행렬 탐색
        // 일단 몇번째 박스인지부터 찾아야함
        // 각 박스의 첫번째(왼쪽위) r,c
        int box_r = ( r / 3 ) * 3;
        int box_c = ( c / 3 ) * 3;
        for(int i = 0; i <3; i++){ // 해당 박스영역안에서
            for(int j = 0; j <3; j++){
                if(map[box_r+i][box_c+j] == num) return false; // 이미 해당 숫자가 있다면 false
            }
        }
        return true; //  없으면 true
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new int[9][9];
        for(int i =0; i <9; i++){
            for(int j = 0; j <9; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 0){
                    blank.add(new location(i,j)); // 빈칸 저장
                }
            }
        }
        // 1) 가로줄, 2) 세로줄, 3) 3*3 영역 확인
        backtracking(0);
    }
}
