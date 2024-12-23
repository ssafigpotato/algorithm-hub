

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashMap<String, Integer> map = new HashMap<>();
//		boolean hasWorker = false; // 근무자가 있는지 확인
		sc.nextLine();
		// 4,6,4,10
		for(int i = 0; i <N; i++) {
			for(int j = 0; j <4; j++) {
				String schedule = sc.nextLine();
				String[]ppl = new String[7];
				ppl = schedule.split(" ");
//				System.out.println(Arrays.toString(ppl));
				// 08:00~12:00 근무 또는 18:00~22:00근무일 경우 
				if(j == 0 || j == 2) {
					for(String p : ppl) {
						if(!p.equals("-")) {
//							hasWorker = true; // 근무자가 있음
							map.put(p, map.getOrDefault(p, 0)+4);
						}
					}
				}else if (j == 1) { // 12:00~18:00 근무일 경우
					for(String p : ppl) {
						if(!p.equals("-")) {
//							hasWorker = true; // 근무자가 있음
							map.put(p, map.getOrDefault(p, 0)+6);
						}
					}
				}else { // 22:00 ~ 08:00 근무일 경우 
					for(String p : ppl) {
						if(!p.equals("-")) {
//							hasWorker = true; // 근무자가 있음
							map.put(p, map.getOrDefault(p, 0)+10);
						}
					}
				}
			
			}
		}// for i
		
		// 근무자가 없을 경우
//        if (!hasWorker) {
//            System.out.println("Yes");
//            return;
//        }
		
		Set<String> keySet = map.keySet();
		int max = 0;
		int min = Integer.MAX_VALUE; 
		for(String key : keySet ) {
//			System.out.println(key+" "+map.get(key));
			max = Math.max(max, map.get(key));
			min = Math.min(min, map.get(key));
		}
//		System.out.println(max+" "+min);
		if((max-min) > 12) {
			System.out.println("No");
		}else {
			System.out.println("Yes");
		}
	}
}
