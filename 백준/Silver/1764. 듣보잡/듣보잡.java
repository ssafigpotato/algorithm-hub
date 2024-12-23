import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		// 1. 듣도 못한 사람
		for(int i = 0; i <N; i++) {
			String name = sc.next();
			map.put(name, map.getOrDefault(name, 0)+1);
		}
		// 2. 보도 못한 사람
		for(int i = 0; i <M; i++) {
			String name = sc.next();
			map.put(name, map.getOrDefault(name, 0)+1);
		}
		
		// 확인
		Set<String> keySet = map.keySet();
		List<String> list = new ArrayList<String>();
		for(String key : keySet) {
//			System.out.println(key+" "+map.get(key));
			if(map.get(key) >=2) {
				list.add(key);
			}
		}
		System.out.println(list.size());
		Collections.sort(list);
		for(int i = 0; i <list.size(); i++) {
			System.out.println(list.get(i));
		}
		

		
	
		
	}
}
