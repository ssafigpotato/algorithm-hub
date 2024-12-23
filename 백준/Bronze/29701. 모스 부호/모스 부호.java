
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //문자열 길이 
		HashMap<String, String> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i <N; i++) {
			
			String str = sc.next();
			if(str.equals(".-")) {
	//			map.put("A", str);
				sb.append("A");
			}else if(str.equals("-...")) {
	//			map.put("B", str);
				sb.append("B");
			}else if(str.equals("-.-.")) {
				map.put("C", str);
				sb.append("C");
			}else if(str.equals("-..")) {
				map.put("D", str);
				sb.append("D");
			}else if(str.equals(".")) {
				map.put("E", str);
				sb.append("E");
			}else if(str.equals("..-.")) {
				map.put("F", str);
				sb.append("F");
			}else if(str.equals("--.")) {
				map.put("G", str);
				sb.append("G");
			}else if(str.equals("....")) {
				map.put("H", str);
				sb.append("H");
			}else if(str.equals("..")) {
				map.put("I", str);
				sb.append("I");
			}else if(str.equals(".---")) {
				map.put("J", str);
				sb.append("J");
			}else if(str.equals("-.-")) {
				map.put("K", str);
				sb.append("K");
			}else if(str.equals(".-..")) {
				map.put("L", str);
				sb.append("L");
			}else if(str.equals("--")) {
				map.put("M", str);
				sb.append("M");
			}else if(str.equals("-.")) {
				map.put("N", str);
				sb.append("N");
			}else if(str.equals("---")) {
				map.put("O", str);
				sb.append("O");
			}else if(str.equals(".--.")) {
				map.put("P", str);
				sb.append("P");
			}else if(str.equals("--.-")) {
				map.put("Q", str);
				sb.append("Q");
			}else if(str.equals(".-.")) {
				map.put("R", str);
				sb.append("R");
			}else if(str.equals("...")) {
				map.put("S", str);
				sb.append("S");
			}else if(str.equals("-")) {
				map.put("T", str);
				sb.append("T");
			}else if(str.equals("..-")) {
				map.put("U", str);
				sb.append("U");
			}else if(str.equals("...-")) {
				map.put("V", str);
				sb.append("V");
			}else if(str.equals(".--")) {
				map.put("W", str);
				sb.append("W");
			}else if(str.equals("-..-")) {
				map.put("X", str);
				sb.append("X");
			}else if(str.equals("-.--")) {
				map.put("Y", str);
				sb.append("Y");
			}else if(str.equals("--..")) {
				map.put("Z", str);
				sb.append("Z");
			}else if(str.equals(".----")) {
				map.put("1", str);
				sb.append("1");
			}else if(str.equals("..---")) {
				map.put("2", str);
				sb.append("2");
			}else if(str.equals("...--")) {
				map.put("3", str);
				sb.append("3");
			}else if(str.equals("....-")) {
				map.put("4", str);
				sb.append("4");
			}else if(str.equals(".....")) {
				map.put("5", str);
				sb.append("5");
			}else if(str.equals("-....")) {
				map.put("6", str);
				sb.append("6");
			}else if(str.equals("--...")) {
				map.put("7", str);
				sb.append("7");
			}else if(str.equals("---..")) {
				map.put("8", str);
				sb.append("8");
			}else if(str.equals("----.")) {
				map.put("9", str);
				sb.append("9");
			}else if(str.equals("-----")) {
				map.put("0", str);
				sb.append("0");
			}else if(str.equals("--..--")) {
				map.put(",", str);
				sb.append(",");
			}else if(str.equals(".-.-.-")) {
				map.put(".", str);
				sb.append(".");
			}else if(str.equals("..--..")) {
				map.put("?", str);
				sb.append("?");
			}else if(str.equals("---...")) {
				map.put(":", str);
				sb.append(":");
			}else if(str.equals("-....-")) {
				map.put("-", str);
				sb.append("-");
			}else if(str.equals(".--.-.")) {
				map.put("@", str);
				sb.append("@");
			}
		}
		System.out.println(sb.toString());
		
		
	}
}
