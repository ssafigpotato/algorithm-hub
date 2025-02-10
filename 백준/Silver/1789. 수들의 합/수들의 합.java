

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long S = sc.nextLong();
        // S에서 1부터 차례대로 빼준다
        // 정확한 수를 구하는게 아니라 개수!!를 구하는 것임
        int N = 1; // 빼줄값
        while(true){
            if(S >= N){
                // System.out.println("S: "+S+", N: "+N+"이므로 S에서 N만큼 빼준다.");
                S -= N;
            }else {
                // System.out.println("S: "+S+", N: "+N+" 이므로 break");
                break;
            }
            N++;


        }
        // 예) S가 200일경우
        // 마지막 숫자는 빼주면 안되는 숫자이므로 1부터 19까지 19개 -> N-1
        // 예) S가 210일경우
        // 1~20까지 쓸 수 있음. else에 걸릴 때 이미 N은 21이 되므로 -1
        System.out.println(N-1);

    }
}
