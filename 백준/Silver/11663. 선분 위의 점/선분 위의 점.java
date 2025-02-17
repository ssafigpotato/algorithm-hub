

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[]dots;
    static int binarySearch(int target, int flag ){
        int left = 0;
        int right = dots.length-1;
        if(flag == 0){ // 최소 위치를 찾음 -> lowerbound?
            while(left <= right){
                int mid = (left + right) / 2;
                // 최소 위치를 찾을 때는 left를 반환해야함
                // 최소 위치가 될 수 있는 범위보다 작으므로 최소 시작위치(left)를 땡겨줌
                if(dots[mid] < target){ // =를 포함하면 dots[mid] = traget일 때 left가 mid보다 +1이 되어서 정답 범위에 포함을 안해줌
                    left = mid +1;
                }else {
                    right = mid -1;
                }
            }
            return left;
        }else { // 최대 위치를 찾음 -> upperbound?
            while(left <= right){
                int mid = (left + right) / 2;
                // 최대 위치를 찾을 때는 right를 반환해야함
                // 최대 위치가 될 수 있는 범위보다 크므로(벗어났으므로) 최대 끝 위치를 땡겨줌
                if(dots[mid] > target){ // 여기도 마찬가지 =를 포함해버리면 딱 target이랑 일치할 때 right가 mid보다 적게 되어서 범위에 포함이 안 됨
                    right = mid -1;
                }else {
                    left = mid +1;
                }
            }
            return right;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 점의 개수
        M = Integer.parseInt(st.nextToken()); // 선분 M개
        dots = new int[N];


        st = new StringTokenizer(br.readLine());
        for(int i = 0; i <N; i++){

            dots[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(dots);
        // System.out.println(Arrays.toString(dots));


        for(int i = 0; i <M; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int st_idx = binarySearch(start, 0);
            int end_idx = binarySearch(end, 1);

            // System.out.println(st_idx+" "+end_idx); // 위치가 0,2인거면 포함 개수는 (2-0) +1이므로  +1해주기
            sb.append(end_idx- st_idx+1).append("\n");
        }
        System.out.println(sb);



    }
}
