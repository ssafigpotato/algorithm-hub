

import java.util.Scanner;

public class Main {
    // 내구도, 무게 맵 필요 -> ㄴㄴ 클래스를 만드는게 나을듯
    static class Egg{

        int strength;
        int weight;

        Egg(int strength, int weight){
            this.strength = strength;
            this.weight = weight;
        }

        boolean isBroken(){ // 계란의 깨짐 여부는 내구도가 변할 때마다 달라지는 동적인 값이므로 메소드가 유리
        //  필드로 두게 되면 isBroken 필드 값을 따로 매번 수동으로 업데이트해줘야 함!!
            return strength <= 0;
        }
    }
    static int N;
    static Egg[] eggs;
    static int max = 0;
    static void backtracking(int idx){
    // idx번째의 계란을 들고
    // (idx자체를 이번에 손에 든 계란으로 두기!! 이걸 계속 +1 시켜주며 N이 되었을 때 종료)

        if(idx == N){ // 모든 계란을 다 들어봤다면 종료
            int broken = 0;
            for(Egg e : eggs){ // 계란 탐색해보며 깨진것이 있으면 broken++
                if(e.isBroken()) broken++;
            }
            max = Math.max(max, broken);
            return;
        }

        // 단, (1) 손에 든 계란이 깨졌거나 (2) 깨지지 않은 다른 계란이 없으면 치지 않고 넘어간다.  이거에 유의!!!
        if(eggs[idx].isBroken()){ // (1) 상황: 이번에 손에 든 게 이미 깨진 계란이면 바로 다음계란으로 넘기기
            backtracking(idx+1);
            return; // 이거 없으면 아래 for문이랑 계속 실행하게됨 (깨진 계란으로 다른 계란 침)
        }

        boolean hit = false; // 이번 턴에서 다른 계란을 쳤는지 여부
        // 이번에 손에 든 건 깨지지 않았기에 아직 칠 가능성이 있음

        for(int i = 0; i < N; i++){ // idx를 제외한 나머지 계란에 대해서
            if(i == idx || eggs[i].isBroken()) continue;
            // 단, 손에 든 계란이 깨졌거나 깨지지 않은 다른 계란이 없으면 치지 않고 넘어간다. -> 이거 아님!!
            // 자기자신이거나 손에 든거말고 해당 계란(i)가 깨져있을때는 다른 계란 탐색해라는 뜻!

            hit = true; // 유효한 공격 대상이 있으므로 쳐보기
            // 손에 든 거 말고 깨지지 않은 다른 계란이 있기에 쳤음

            // 계란끼리 서로 부딪히기
            eggs[idx].strength -= eggs[i].weight;
            eggs[i].strength -= eggs[idx].weight;

            backtracking(idx + 1); // 다음 계란으로 넘어가기

            // 복구 시키기(백트래킹)
            eggs[idx].strength += eggs[i].weight;
            eggs[i].strength += eggs[idx].weight;
        }

        if(!hit){ // (2) 상황: for문을 도는 동안 다른 계란 아무것도 치지 못했다면  (깨지지 않은 다른 계란이 없음)
            backtracking(idx+1); // 칠 수 있는 계란이 없다는 뜻이므로 다음 계란으로 넘기기
        }
    }
    public static void main(String[] args) {
        // 순서대로 백트래킹을 진행
        // 예) 1 2 3 / 1 3 2 -> 2 3 1 ...
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        eggs = new Egg[N];

        for(int i = 0; i <N; i++){
            int s = sc.nextInt();
            int w = sc.nextInt();
            eggs[i] = new Egg(s,w);
        }

        backtracking(0);
        System.out.println(max);
        sc.close();
    }
}
