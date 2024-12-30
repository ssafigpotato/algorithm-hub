import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        // dp[i][j] 가 오른쪽 아래 꼭지점일 때 
        // 만들 수 있는 최대 정사각형의 한 변 길이 = dp[i][j];
        int[][]dp = new int[park.length][park[0].length];
        int max = 0; 
        
        // DP 계산
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length; j++) {
                if (park[i][j].equals("-1")) { // -1이면 
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1; // 가장자리의 경우
                    } else {// 가장자리가 아닌 경우 
                        // 위, 왼쪽, 왼쪽 위를 비교해서 가장 작은 값 + 1
                        dp[i][j] = Math.min(
                            Math.min(dp[i - 1][j], dp[i][j - 1]),
                            dp[i - 1][j - 1]
                        ) + 1;
                    }
                    max = Math.max(max, dp[i][j]); // 최대 크기 갱신
                }
            }
        }
        
        System.out.println(max);
        
        // 돗자리 크기 중 최대값 확인
        // Arrays.sort(mats, Collections.reverseOrder()); 는 동작하지 않음
        // Collections.~~는 Integer타입일때만 작동
        Arrays.sort(mats); // 오름차순 정렬
        for (int i = mats.length - 1; i >= 0; i--) {
            if (mats[i] <= max) {
                return mats[i]; // 가장 큰 돗자리 크기 반환
            }
        }

        // 깔 수 있는 돗자리가 없으면 -1 반환
        return -1;
        
        // int answer = 0;
        // return answer;
    }
}