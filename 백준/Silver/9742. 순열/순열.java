

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    static String N;
    static int idx;
    static boolean[] visited;
    static int n;
    static String result;

    static boolean backtracking(int depth, StringBuilder res) {
        if (depth == N.length()) {
            n++;
            if (n == idx) {
                result = res.toString();
                return true; // 정답 찾았으므로 즉시 리턴
            }
            return false;
        }

        for (int i = 0; i < N.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                res.append(N.charAt(i)); // StringBuilder 사용

                if (backtracking(depth + 1, res)) return true; // 정답 찾으면 모든 재귀 종료

                res.deleteCharAt(res.length() - 1); // 원상 복구
                visited[i] = false;
            }
        }
        return false; // 해당 루트에서 정답을 찾지 못함
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            N = sc.next();
            idx = sc.nextInt();
            visited = new boolean[N.length()];
            n = 0;
            result = null;

            System.out.print(N + " " + idx + " = ");
            backtracking(0, new StringBuilder());

            System.out.println(result != null ? result : "No permutation");
        }
        sc.close();
    }
}


