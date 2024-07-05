class Solution {
    public String solution(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        
        int length = str1.length();
        
        String [] arr = str1.split("");
        String [] arr2 = str2.split("");
        
        for(int i = 0; i < length; i++ ){
            sb.append(arr[i]);
            sb.append(arr2[i]);
        }
        
        String answer = sb.toString();
        return answer;
    }
}