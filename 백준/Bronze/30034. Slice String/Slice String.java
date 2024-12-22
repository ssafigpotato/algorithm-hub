import java.util.HashSet;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// List를 Character로 설정해두어야 str에서 한 글자씩(Character) 검사하기 쉬움 
		HashSet<Character> set = new HashSet<>();

		// 문자 구분자 
		int N = sc.nextInt();
		for(int i = 0 ; i <N; i++) {
			// sc.next()는 String이므로 charAt(0)을 하면 Character로 저장됨
			// 구분자와 병합자는 모두 한글자 
			set.add(sc.next().charAt(0));
		}
		
		// 숫자 구분자 
		int M = sc.nextInt();
		for(int i = 0; i <M; i++) {
			set.add(sc.next().charAt(0));
		}
		
		// 공벡도 구분자로 설정
		set.add(' ');
		
		// 병합자 
		int K = sc.nextInt();
		for(int i = 0; i <K; i++) {
			char s = sc.next().charAt(0);
			set.remove(s);
		}
		
		
		int len = sc.nextInt();
		sc.nextLine(); // 개행 제거 
		String str = sc.nextLine();
		
		// 문자열 분리 
		// 구분자 또는 공백을 만날 때까지 문자열을 임시적으로 담는 공간
		StringBuilder sb = new StringBuilder();
		// 결과를 출력할 sb
		StringBuilder res = new StringBuilder();
		
		// 확인 
//		System.out.println(list);
//		System.out.println(str);
		
		// 아래 처럼 하면 원하는대로 안 나옴 
//		String[]arr = new String[10];
//		for(int i = 0; i <list.size(); i++) {
//			arr = str.split(list.get(i));
//			System.out.println(Arrays.toString(arr));
//		}
		
		for(char ch : str.toCharArray()) {
			if(set.contains(ch)) { // 구분자일 경우
				if(sb.length() > 0) {
					res.append(sb.toString()).append("\n"); // 현재까지 저장된 문자열 입력
					sb.setLength(0); // 길이 0으로 초기화 
				} // sb.length()가 0일 때, 즉 처음부터 구분자가 나오면 아무것도 안하면 됨 
				// res에 넣거나 sb에 넣거나 이런것들 안하면 됨 
			} else { // 구분자가 아니면 sb에 줄줄이 넣기 
				sb.append(ch);
			}
		}
		
		// 마지막 문자열 추가 (남아있는거 다 꺼내야함)
        if (sb.length() > 0) {
            res.append(sb.toString());
        }
		
		// 결과 출력
        System.out.println(res);
	
        sc.close();
	}//main
}
