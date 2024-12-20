

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0; i <N; i++) {
			String fruit = sc.next();
			int num = sc.nextInt();
			// 아래 처럼 하면 처음 들어가는 과일은 get을 햇을 때 NPE발생
//			map.put(fruit, map.get(fruit)+num);
			map.put(fruit, map.getOrDefault(fruit, 0)+num);
		}
		String ans = "";
		Set<String> keyset = map.keySet();
		// 확인
//		for(String key : keyset) {
//			System.out.println(key+" "+map.get(key));
//		}
		for(String key : keyset) {
			if (map.get(key) == 5) {
				ans = "YES";
				break;
			}else {
				ans = "NO";
			}
		}
		System.out.println(ans);
		
	}
}
