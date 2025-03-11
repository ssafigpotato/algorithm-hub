

import java.util.Scanner;

public class Main {
    static int N, M, K;
    static long[][] dp = new long[201][201]; // 조합수를 저장할 DP 배열
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 'a' 개수
        M = sc.nextInt(); // 'z' 개수
        K = sc.nextInt(); // K번째 문자열

        sc.close();

        // 조합수를 미리 계산 (nCr 값)
        calcCombinations();

        // K번째 문자열이 가능한지 체크
        if (dp[N + M][N] < K) { // N개의 'a'와 M개의 'z'로 만들 수 있는 문자열 수보다 K가 크면 불가능
            System.out.println(-1);
        } else {
            findKthString(N, M, K);
            System.out.println(sb.toString());
        }
    }

    // 조합수를 미리 계산하는 메서드
    static void calcCombinations() {
        for (int i = 0; i <= 200; i++) {
            dp[i][0] = dp[i][i] = 1; // nC0 = 1, nCn = 1
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1] + dp[i - 1][j], 1_000_000_000); // 오버플로우 방지
            }
        }
    }

    // K번째 문자열을 찾아서 sb에 저장하는 재귀 함수
    static void findKthString(int a, int z, int k) {
        if (a == 0) { // 'a'가 다 사용되었으면 'z'만 채움
            while (z-- > 0) sb.append('z');
            return;
        }
        if (z == 0) { // 'z'가 다 사용되었으면 'a'만 채움
            while (a-- > 0) sb.append('a');
            return;
        }

        // a를 먼저 배치했을 때 남은 문자열의 개수
        long leftCount = dp[a + z - 1][a - 1]; // (a+z-1)C(a-1) → 'a'를 배치했을 때 남은 조합 수

        if (k <= leftCount) { // K가 'a'를 배치한 경우의 수보다 작거나 같으면 'a'를 배치
            sb.append('a');
            findKthString(a - 1, z, k);
        } else { // K가 'a'를 배치한 경우의 수보다 크다면, 'z'를 배치하고 K에서 그만큼 감소
            sb.append('z');
            findKthString(a, z - 1, k - (int) leftCount);
        }
    }
}
