

import java.util.*;

public class Main {
    static int A,B;
    static HashSet<Long> visited = new HashSet<>(); // 배열대신 방문 체크 세트
    static HashMap<Long, Long> cnt = new HashMap<>(); // 배열대신 연산 횟수 체크 맵 <도달한 숫자, 연산횟수>
    static long bfs(long start){
        Queue<Long> que = new LinkedList<>();
        que.offer(start);
        visited.add(start); // 방문 체크
        cnt.put(start, 1L); // 시작할 때 연산횟수 1번

        while(!que.isEmpty()){
            Long curr = que.poll();
            // 방문할 수 있는 이웃은
            // 1) curr*2 , 2) curr*10+1
            long []neighbor = {curr*2, curr*10+1};
            // System.out.println(Arrays.toString(neighbor));

            for(long n : neighbor){
                if(check(n) && !visited.contains(n)){ // 어차피 배열이 아니라서 에러 안나니까 하나로 합치기
//                  if(){ // 여기서 check(n)을 같이하면 에러남 -> 근데 어차피 얘는 에러 안나겠다...
                    que.offer(n);
                    visited.add(n); // 방문체크
                    // 같은 위계의 이웃 모두에게 prev+1만큼을 연산횟수로 지정
                    long prev = cnt.get(curr);
                    cnt.put(n, prev+1);

                    // 지정후에!!!! n=B라면 cnt.get(n)을 반환
                    if(n == B) {
                        return cnt.get(n);
                    }
//                  }
                }
            }
        }
        return -1;
    }
    static boolean check(long n){
        if(n<A) return false;
        if(n>B) return false;
        // 생각해보니 도달해야하는 곳이 0이나 1 이럴 수도 있잖아? -> 아님 문제 범위에서 A는 최소 1 B는 최소 2임
        // if(n<2) return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt(); // 시작
        B = sc.nextInt(); // 끝

        // 2를 곱하기
        // 1을 가장 오른쪽에 추가하기
        // -> 방문할 수 있는 이웃이 *2 / +1추가한것 = curr*10+1이네!
        System.out.println(bfs(A));
    }
}
