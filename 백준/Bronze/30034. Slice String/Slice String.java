import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// List를 Character로 설정해두어야 str에서 한 글자씩(Character) 검사하기 쉬움 
		List<Character >list = new ArrayList<>();

		// 문자 구분자 
		int N = sc.nextInt();
		for(int i = 0 ; i <N; i++) {
			// sc.next()는 String이므로 charAt(0)을 하면 Character로 저장됨
			// 구분자와 병합자는 모두 한글자 
			list.add(sc.next().charAt(0));
		}
		
		// 숫자 구분자 
		int M = sc.nextInt();
		for(int i = 0; i <M; i++) {
			list.add(sc.next().charAt(0));
		}
		
		// 공벡도 구분자로 설정
		list.add(' ');
		
		// 병합자 
		int K = sc.nextInt();
		for(int i = 0; i <K; i++) {
			char s = sc.next().charAt(0);
			// 중복된 애들을 다 제거 
			while(list.contains(s)) {
				/**
				 * ArrayList에서 remove 메서드를 호출할 때 IndexOutOfBoundsException이 발생.
				 * list.remove(s)를 호출했을 때, remove 메서드가 s를 인덱스 값으로 처리하려고 시도하기 때문

				 * list.remove(s)는 두 가지 오버로드 메서드 가지고 있음
				 * remove(int index) : 인덱스를 제거.
				 * remove(Object o) : 객체를 제거.
				 * list의 타입이 List<Character>이더라도, char 값(s)은 기본적으로 int로 취급되기 때문에 
				 * remove(int index) 메서드를 호출하려고 함 
				 * 이로 인해 IndexOutOfBoundsException이 발생
				 * 
				 * 해결 방법
				 * remove(Object o)를 명시적으로 호출해야 함.
				 * 이를 위해 Character 타입으로 캐스팅
				 * list.remove((Character) s);
				 * */
				list.remove((Character) s);
			}
		}
		
		
		int len = sc.nextInt();
		sc.nextLine(); // 개행 제거 
		String str = sc.nextLine();
		
		// 문자열 분리 
		// 구분자 또는 공백을 만날 때까지 문자열을 임시적으로 담는 공간
		StringBuilder sb = new StringBuilder();
		// 결과를 출력할 list
		List<String> res = new ArrayList<>();
		
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
			if(list.contains(ch)) { // 구분자일 경우
				if(sb.length() > 0) {
					res.add(sb.toString()); // 현재까지 저장된 문자열 입력
					sb.setLength(0); // 길이 0으로 초기화 
				} // sb.length()가 0일 때, 즉 처음부터 구분자가 나오면 아무것도 안하면 됨 
				// res에 넣거나 sb에 넣거나 이런것들 안하면 됨 
			} else { // 구분자가 아니면 sb에 줄줄이 넣기 
				sb.append(ch);
			}
		}
		
		// 마지막 문자열 추가 (남아있는거 다 꺼내야함)
        if (sb.length() > 0) {
            res.add(sb.toString());
        }
		
		// 결과 출력
        for (String r : res) {
            System.out.println(r);
        }
	
        sc.close();
	}//main
}
