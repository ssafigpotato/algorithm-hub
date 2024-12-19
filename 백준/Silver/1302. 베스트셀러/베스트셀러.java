

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		HashMap<String, Integer> map = new HashMap<>();
		
		// 1. hashmap에 title과 횟수 저장하기 
		for(int i = 0; i <N; i++) {
			String title = sc.next();
			map.put(title, map.getOrDefault(title, 0) + 1);
		}
		// 확인
//		Set<String> keySet = map.keySet();
//		for(String key : keySet) {
//			System.out.println(key+" "+map.get(key));
//		}
//		System.out.println(max);
		
		// 2. 그 중 가장 많이 팔린 책 정렬하기 (수가 같으면 사전순)
		/**
		 * TreeSet이 필요한가? 
		 * HashMap만으로 충분히 해결 가능:
		 * HashMap을 사용하여 책 제목별로 판매 횟수를 저장하면 됩니다.
		 * 이후, 판매 횟수와 제목을 기준으로 정렬하여 가장 많이 팔린 책 제목을 찾을 수 있습니다.
		 * TreeSet은 필요 없음:
		 * TreeSet은 정렬된 상태로 데이터를 유지하는 자료구조로, 중복되지 않는 요소를 저장합니다.
		 * 하지만 이 문제에서는 판매 횟수(값)를 기준으로 정렬해야 하므로, 제목(키)와 판매 횟수(값)를 동시에 다룰 필요가 있습니다.
		 * 따라서 TreeSet보다는 정렬이 가능한 자료구조를 사용하는 것이 적합합니다.
		 * */
		// entrySet()은 Set<Map.Entry<K,V>>를 반환 
		// Collections.max로 가장 큰 map.entry를 찾고, map.entry 객체의 키 반환 
		String bestSeller = Collections.max(
	            map.entrySet(),
	            (a, b) -> {
	                if (!a.getValue().equals(b.getValue())) {
	                    return Integer.compare(a.getValue(), b.getValue());  // 판매 횟수로 비교
	                }
	                return b.getKey().compareTo(a.getKey());                // 판매 횟수가 같으면 사전순 비교
	            }
	        ).getKey();
		
		System.out.println(bestSeller);
	}
}
