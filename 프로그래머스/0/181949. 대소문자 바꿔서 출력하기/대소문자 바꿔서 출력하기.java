import java.util.Scanner;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        // 대/소문자 변환 방법
        // String 타입인 경우 str.toUpperCase()
        // char 타입인 경우 Character.toUpperCase(ch[i])
        
        // 1. str을 쪼개서 char배열 타입으로 받기 
        int N = str.length();
        char[] ch = new char[N];
        
        for(int i = 0; i <N; i++){
            ch[i] = str.charAt(i);
        }
        
        // 2. 대/소문자 변환하기 
        for(int i = 0; i <N; i++){
            // 소문자인 경우 
            if('a' <= ch[i] && ch[i] <='z'){
                // 원본 배열을 변경하지 않으므로 갱신해주기
                ch[i] = Character.toUpperCase(ch[i]);
                
            }else { // 대문자인 경우
                ch[i]  = Character.toLowerCase(ch[i]);
            }
        }
        
        // 3. 출력하기
        for(int i = 0; i <N; i++){
            System.out.print(ch[i]);
        }
        
    }
}