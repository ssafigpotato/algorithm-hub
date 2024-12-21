

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static class Problem {
		boolean isSolved;
		int correctTime;
		int wrongAttempts;
		
		public Problem(boolean isSolved, int correctTime, int wrongAttmepts){
			this.isSolved = isSolved;
			this.correctTime = correctTime;
			this.wrongAttempts = wrongAttmepts;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Problem> map = new HashMap<>();
		int cnt = 0; // 맞춘 문제 개수
		int penalty = 0; // 총 페널티 
		
		// 1. 입력받고, map에 문제 번호에 따른 상태 넣어주기 
		while(sc.hasNext()) {
			// 1-1. 한 줄씩 입력받기 
			String str = sc.nextLine();
			if(str.equals("-1")) break;
			
			// 1-2. parts 분리하기 
			String[]parts = str.split(" ");
			int time = Integer.parseInt(parts[0]);
            String num = parts[1];
            String result = parts[2];
            
            // 1-3. 문제 상태 초기화 (없으면 새로 추가)
            // 처음에는 기본값 넣어주기
            // putIfAbsent는 key가 존재하지 않으면 put하는 메소드 
            // (코드 효율성을 높이고, 불필요한 객체 생성과 중복 작업 방지)
			// key인 num이 이미 존재한다면 map.get(num)을 통해 가져와서 아래에서 연산
            map.putIfAbsent(num, new Problem(false, 0, 0));
			Problem status = map.get(num);
			
			// 1-4. 이미 푼 문제는 넘기기 
			/**
			 * 아래 조건때문에 if(status.isSolved) continue!! 
			 * 대회 룰에 따르면, 
			 * 만일 팀이 어떤 문제를 해결했다면 그 문제에 대한 추가적인 제출은 모두 무시된다
			 * (따라서 로그에도 남지 않는다). 
			 * 제출 시각이 연속적으로 기록되지 않고 이산화되어있기 때문에, 같은 시각에 여러 제출이 있을 수도 있다. 
			 * 하지만 제출 자체는 시간 순으로 이루어졌으므로, 같은 시각에 같은 문제를 제출한 로그가 남아 있다면 
			 * 마지막 제출을 제외한 모든 제출은 오답이었을 것이다.
			 * */
			if(status.isSolved) continue;
			
			// 1-5. result값에 따라 연산
			if(result.equals("wrong")) {
				status.wrongAttempts++;
			}else if (result.equals("right")) {
				status.isSolved = true;
				status.correctTime = time;
				cnt++;
			}
		}// while
		
		// 2. map을 순회하면서 isSolved == true일 때 penalty 계산 
		for(Problem status : map.values()) {
			if(status.isSolved) {
				penalty += status.correctTime + (status.wrongAttempts * 20);
			}
//			System.out.println(status.isSolved+" "+status.correctTime+" "+status.wrongAttempts);
		}
		
		// 3. 출력하기 
		System.out.println(cnt+" "+penalty);
		sc.close();
		
	}//main
}// class
