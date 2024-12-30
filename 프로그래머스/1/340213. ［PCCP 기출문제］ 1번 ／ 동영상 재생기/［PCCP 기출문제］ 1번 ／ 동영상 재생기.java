class Solution {
    static int len;
    static int curr;
    static int op_s;
    static int op_e;
    
    public int change(String str){
        String[] arr = str.split(":");
        int minute = Integer.parseInt(arr[0]);
        int second = Integer.parseInt(arr[1]);
        int time = minute*60 + second;
        return time;
    }
    public String back(int t){
        int minute = t / 60;
        int second = t % 60;
        String m ="";
        String s ="";
        String ans = "";
        if(minute < 10){
            m = "0"+minute;
        } else {
            m = ""+minute;
        }
        if(second < 10){
            s = "0"+second;
        }else {
            s = ""+second;
        }
        ans = m+":"+s;
      
        return ans;
    }
    public boolean isOP(int t){
        if(t >= op_s && t <= op_e){
            return true;
        }else {
            return false;
        }
    }
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 0. "00:00"을 초단위로 변경
        len = change(video_len);
        curr = change(pos);
        op_s = change(op_start);
        op_e = change(op_end);
        
        // System.out.println(len);
        // System.out.println(curr);
        // System.out.println(op_s);
        // System.out.println(op_e);
        
        // 1. 현재 구간이 op인 경우 curr = op_e로 갱신
        if(curr >= op_s && curr <= op_e){
            curr = op_e;
            // System.out.println("오프닝구간! op_e로 이동"+curr);
        }
        
        // 2. commands에 따라 연산 수행 
        // 연산 중에도 오프닝 구간이면 이동해줘야함! 
        for(String s : commands){
            if(s.equals("prev")){
                if(curr <= 10){ // 10인경우도 어차피 0
                    curr = 0;
                    // System.out.println("현재 위치 10초 이하임 0으로 이동 "+curr);
                }else {
                    curr -= 10;
                    // System.out.println("현재 위치 -10초 "+curr);
                }
            }else {
                if(len - curr <= 10){ // 10인 경우도 어차피 영상 끝으로 가야함
                    curr = len;
                    // System.out.println("남은시간 10초 이하! 영상 끝으로 이동"+ curr);
                }else {
                    curr += 10;
                    // System.out.println("현재 위치 + 10초 "+curr);
                }
            }
            if(isOP(curr)){
                curr = op_e;
                // System.out.println("오프닝구간! op_e로 이동"+curr);
            }
        }// for
        
        // System.out.println(curr);
        String answer = back(curr);
        
        return answer;
    }
}