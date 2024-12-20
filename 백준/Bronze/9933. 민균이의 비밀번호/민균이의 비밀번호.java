

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		HashMap<String, String> map = new HashMap<>();
		String ans = "";
		for(int i = 0; i <N; i++) {
			String num = sc.next();
			String[]arr = num.split("");
			// 아래 방법을 쓰면 사전순으로 뒤집어버림 
//			Arrays.sort(arr, Collections.reverseOrder());
			String []reverse = new String[arr.length];
			for(int j = 0; j <arr.length; j++) {
				reverse[j] = arr[arr.length-j-1];
			}
			String reverseNum = String.join("", reverse);
//			System.out.println("오리지널비번: "+ num);
//			System.out.println("뒤집은비번: "+reverseNum);
			
			if(num.equals(reverseNum)){
				ans = num; 		
			}
			if( num.equals(map.get(reverseNum)) ) { 
				ans = num;
			}
			map.put(num,reverseNum);
		}
		System.out.print(ans.length()+" ");
		String[]res = ans.split("");
		System.out.print(res[ans.length()/2]);
	
	}//main
}
