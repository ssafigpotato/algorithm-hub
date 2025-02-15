

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static String[] titles;
    static int[] powers;
    static String binarySearch(int power){
        int left = 0;
        int right = N;
        int result = 0;

        while(left <= right){
            int mid = (left + right) / 2;

            if(powers[mid] >= power){
                result = mid; // 일단 정답 후보
                right = mid - 1; //  상방 낮춰주기
            }else {
                left = mid + 1; // 한참 모자라면 하방 땡겨주기
            }
        }
        return titles[result];

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        titles = new String[N];
        powers = new int[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            titles[i] = st.nextToken();
            powers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(powers);

        for(int i = 0; i < M; i++){
            int num = Integer.parseInt(br.readLine());
            sb.append(binarySearch(num)).append("\n");
        }

        System.out.println(sb);

    }
}
