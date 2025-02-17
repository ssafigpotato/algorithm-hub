

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int T, N, M;
    static int[]A;
    static int[]B;
    static int binarySearch(int a){
        int left = 0;
        int right = M-1;
        int result = -1; // a가 먹을 수 있는 b의 개수 -> 최대 위치임!!!
        // a가 먹을 수 있는 최댓값의 위치를 찾아서 -> upperbound 찾기!
        // 최댓값 위치+1 반환
        // 그보다 작은 건 다 먹을 수 잇다는 뜻이니까

        while(left <= right){
            int mid = (left + right) / 2;
            if(B[mid] >= a){ // 이렇게 되면 너무 커서 못 먹는다는 뜻
                right = mid -1;
            }else { // 먹을 수 잇으므로 더 큰 것도 먹을 수 있는지 탐색
                result = mid; // 먹을 수 있는 최대 위치 갱신
                // 이 위치 + 이 위치보다 작은 것들은 다 먹을 수 있음 -> 정답 후보
                left = mid +1;
            }
        }

        // 암 것도 못 먹는 경우는 -1+1 해서 0이되고
        // 그 이외는 먹을 수 잇는 최대 위치가 나오므로 +1 하면 개수가 됨
        // System.out.println(a+"일 때 먹을 수 있는 B개수: "+(result+1));
        return result+1;


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt(); // 테캐 수
        for(int t = 0; t <T; t++){
            N = sc.nextInt(); // A의 수
            M = sc.nextInt(); // B의 수
            A = new int[N];
            B = new int[M];

            for(int i = 0; i <N; i++){
                A[i] = sc.nextInt();
            }

            for(int i= 0; i <M; i++){
                B[i] = sc.nextInt();
            }
            Arrays.sort(A);
            Arrays.sort(B);

            int total = 0; // 총 쌍의 개수
            for(int i = 0; i <N; i++){
                total += binarySearch(A[i]); // 각 A의 원소에 대해서 먹을 수 있는 B 개수 누적
            }
            System.out.println(total);

        }

    }
}
