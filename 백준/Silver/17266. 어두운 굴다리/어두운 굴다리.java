

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static boolean[]bridge;
    static int[]location;
    static int binarySearch(){
        int left = 0;
        int right = N; // 최대 N만큼 되면 어디에 있든 다 비출 수 있음
        int result = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            if(check(mid)){ // 다 밝아졌으면
                result = mid; // 일단 정답 후보임
                right = mid-1;
            }else {
                left = mid +1;
            }
        }
        return result;
    }
    static boolean check(int H){
        // bridge배열을 만들어서 일일이 다 돌리면 O(M * N)의 연산이 발생 → 100,000 * 100,000 = 10^10 시간초과남 
        int prev = 0; // 현재까지 커버해온 위치 (이전까지 커버한 위치. 0에서 시작)
        for(int i = 0; i <M; i++){ // 각 가로등에 대해서 (오름차순으로 정렬되어 있으니까 오른쪽으로 가면서 체크)
            int left = location[i] - H; // 가로등이 밝힐 수 있는 왼쪽 최대 위치
            int right = location[i] + H; // 가로등이 밝힐 수 있는 오른쪽 최대 위치

            if(left > prev){ // 이전까지 커버해온 위치보다 큰 위치까지만 불 밝힐 수 있으면
                // 중간에 불 못 밝히는 곳이 있다는 뜻이므로 false
                return false;
            }

            prev = right; // right까지 붉을 밝힐 수 잇음
        }
        // 그렇게 마지막 가로등까지 불 밝혀 봤을 때 밝혀진 위치가 N 이상이면 다 밝혔다는 뜻이므로 true
        // N보다 작다면 불 못 밝힌 곳이 있다는 뜻이므로 false
        return (prev >= N);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine()); // 굴다리 길이
        M = Integer.parseInt(br.readLine()); // 가로등 개수
        // 굴다리 중 N도 밝아져야함!!!!
        // 예) 굴다리길이가 5이면 5번째도 밝아져야하므로 bridge길이는 N+1로 둬야함!

        location = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i <M; i++){
            location[i] = Integer.parseInt(st.nextToken()); // 오름차순으로 주어짐
        }

        // 가로등 최소 높이 H에 따라 왼쪽 H, 오른쪽 H만큼 주위를 비춤
        System.out.println(binarySearch());

    }
}
