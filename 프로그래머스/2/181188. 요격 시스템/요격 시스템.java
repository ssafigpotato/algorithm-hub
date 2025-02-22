import java.util.*;
class Solution {
    // 그리디 알고리즘!
    public int solution(int[][] targets) {
        // 1. 일단 e!!!!를 기준으로 오름차순 정렬하고..
        // Arrays.sort(targets, Comparator.comparingInt((int[] o) -> o[1]));
        Arrays.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[]o1, int[]o2){
                if(o1[1] == o2[1]){
                    return Integer.compare(o1[0], o2[0]);
                }
                return Integer.compare(o1[1], o2[1]); 
            } 
        });
        // 2. 가장 처음나오는 끝지점 (-0.1) 정도에 미사일을 날림 
        // 끝지점에 쏴도 됨 어느 위치에서 쏘는지는 실제로 답에 영향을 안 주니까 끝지점근처에서 쐈다고 가정
        int curr = 0; // 요격 후 위치 (끝자리로 옮겨줌)
        int answer = 0;
        
        for(int i = 0; i < targets.length; i++){
            // 시작지점이 현재 위치보다 큰 애들은 미사일로 요격된 대상
            if(targets[i][0]>= curr){
                // System.out.println("현재: "+curr+", 시작점: "+targets[i][0]+"이므로 미사일쏘기");
                // 해당 묶음들 다 요격됨
                answer++;
                // 현재 위치를 끝위치로 갱신
                // 그러면 if조건에 안걸리는 애들은 이미 요격되었다는 뜻 
                curr = targets[i][1];
            }
        }
        
        return answer;
    }
}