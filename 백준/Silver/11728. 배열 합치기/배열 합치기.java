

import java.util.Scanner;

public class Main {
    static int N,M;
    static int[] arrA;
    static int[] arrB;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arrA = new int[N];
        arrB = new int[M];
        for(int i = 0; i < N; i++){
            arrA[i] = sc.nextInt();
        }
        for(int i = 0; i < M; i++){
            arrB[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;

        while(i <N && j <M){
            if(arrA[i] <= arrB[j]){ // 비교해서
                sb.append(arrA[i++]).append(" "); // 더 작은 쪽을 먼저 집어넣고 한칸 밀기
            }else {
                sb.append(arrB[j++]).append(" ");
            }
        }

        // 비교해서 집어넣고 어느 한 쪽 배열의 원소들만 남아있다면
        while(i <N) sb.append(arrA[i++]).append(" ");
        while(j <M) sb.append(arrB[j++]).append(" ");

        System.out.println(sb);
    }
}
