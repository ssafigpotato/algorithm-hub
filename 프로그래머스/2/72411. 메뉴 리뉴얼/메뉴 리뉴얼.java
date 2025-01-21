import java.util.*;
class Solution {
    static TreeSet<Character> set = new TreeSet<>(); // 트리셋에 넣어서 중복 제거하고, 자동 오름차순 정렬
    static List<Character> list;
    static char[]out;
    static int max;
    static HashMap<Integer, List<String>> resMap = new HashMap<>(); // <코스길이(target), 그 때 해당하는 코스요리들 list>
    
    public static void combination(int depth, int target, int at, String[]orders){
        if(depth == target){
            
            int cnt = check(orders);
            String combi = new String(out); // char배열을 생성자를 이용해 String으로 변환 
            
            // for(char c : out){
            //     System.out.print(c+" ");
            // }System.out.print(", cnt: "+cnt); // 확인용
            // System.out.println();
            
            if(cnt>= 2){ // 최소 2번 이상 주문했을 때로 한정!!!!!!!! 
                if(max < cnt){
                    max = cnt; 
                    // max일 때의 out배열을 result에 담으면 됨!!! 
                    resMap.put(target, new ArrayList<>() ); // 새로운 맥스를 발견하면 List를 초기화해주고
                    resMap.get(target).add(combi); // 해당 요리조합을 넣어줌
                }else if(max == cnt){ // 또 같은 cnt를 가지는 요리조합이 나왔을 때는 추가 
                    resMap.get(target).add(combi);
                }
             }
            
            return;
        }
        
        for(int i= at; i < list.size(); i++){
            out[depth] = list.get(i);
            combination(depth+1, target, i+1, orders);
        }
        
    }
    public static int check(String[] orders){ // orders 배열의 각 원소가 out배열의 원소를 몇 개 가지고 있는지 반환
        int cnt = 0;
        
//         for(int i = 0; i < orders.length; i++){
//             String str = orders[i];
//             HashSet<Character> hashset = new HashSet<>();
//             boolean isContain = true; // out배열을 모두 포함하는지? 
            
//             for(int s = 0; s < str.length(); s++){
//                 hashset.add(str.charAt(s));
//             }
//             for(int j = 0; j < out.length; j++){
//                 if(!hashset.contains(out[j])) {
//                     isContain = false;
//                     break; // j를 모두 포함하지 않는다면 
//                 }
//             }
//             if(isContain) {
//                // System.out.println(hashset);
//                 cnt++;
//             }
//         }
        
        
        for(String order : orders){
            boolean isContain = true;
            
            for(char o : out){
                if(!order.contains(Character.toString(o))){ // out배열의 원소들을 모두 포함하는가? 
                    isContain = false; // 아니라면 flag를 false로 바꾸고 빠져나가기 
                    break;
                }
            }
            if(isContain){ // 모두 포함했을 때만 cnt++;
                cnt++; 
            }
        }
        return cnt;
        
    }
    public String[] solution(String[] orders, int[] course) {
        // 각 orders에서 course 원소 개수에 맞게 조합으로 뽑기 -> 가장 많은 조합을 return(최대 개수가 같으면 같이 result에 추가)
        // -> 가 아니라 orders에 잇는 전체 알파벳을 TreeSet에 넣고,
        // TresSet의 알파벳들로 각 course 개수에 맞는 알파벳 조합을 만들고
        // 각 조합이 orders에 몇개 포함되어있는지 확인하는 게 빠르겠군
        for(int i = 0; i < orders.length; i++){
            String str = orders[i];
            for(int j = 0; j <str.length(); j++){
                set.add(str.charAt(j));
            }
        }
        
        // System.out.println(set);
        list = new ArrayList<>(set); // list에 set집어넣기 
        // System.out.println(list);
        
        for(int i = 0; i < course.length; i++){
            out = new char[course[i]];
            max = 0; 
            combination(0, course[i], 0, orders);
            // System.out.println(course[i]+"개 일 때===============");
        }
        
        
        // 결과 리스트
        List<String> res = new ArrayList<>();
        for(List<String> v : resMap.values()){
           //  System.out.print(v+" ");
            res.addAll(v);
        }
       
        // 사전 오름차순 정렬 
        Collections.sort(res);
        System.out.println(res);
        
        // 리스트를 배열로 바꾸기 (new 생성자 이용. 자바 11부터는 크기를 명확하게 지정해주지 않아도 toArray메서드가 자동으로 적절한 크기로 변환해줌 )
        String[] answer = res.toArray(new String[0]);
        return answer;
    }
}