
import java.util.HashMap;
import java.util.Scanner;
class TrieNode {
    // <문자열, 다음 노드>
    HashMap<Character, TrieNode> children = new HashMap<>();
    // 단어의 끝인지 여부 - 기본값은 false
    boolean end = false;
}
class Trie {
    // root는 언제 생성되나?
    // Trie trie = new Trie(); 실행 시, root가 1회 생성됨
    // 그 이후 insert()를 하면 root 아래에 데이터를 저장함
    // startsWith()는 root를 새로 만들지 않고 root를 따라 내려가면서 검색
    //
    // 즉, root는 딱 하나만 존재하며, Trie 전체 데이터를 저장하는 노드
    // startsWith()에서는 root에서 출발하여 기존 Trie 구조를 탐색하는 것뿐
    private final TrieNode root;

    public Trie(){
        root = new TrieNode(); // root 노드 생성 TrieNode 타입
    }

    // 아래 두 메소드 모두 root를 가리킴
    // 문자열 삽입
    public void insert(String word){ // 단어 하나를 통째로 집어넣으면
        TrieNode currNode = root;
        for(char c : word.toCharArray()){
            // 각 c와 새 노드(다음노드)를 현재노드의 children에 넣기
            currNode.children.putIfAbsent(c, new TrieNode());
            currNode = currNode.children.get(c); // 현재노드를 다음 새 노드로 갱신
        }
        currNode.end = true; // 마지막 문자열 c는 단어의 끝이므로 end가 true가 됨
    }

    // 접두사인지 확인
    public boolean check(String prefix){ // 검사할 문자열을 집어넣어서 접두사인지 확인
        TrieNode currNode = root; // 항상 root부터 시작
        // 새로운 TrieNode currNode 변수를 선언하지만 currNode는 root를 가리키는 참조변수일 뿐 새로운 root를 만들지는 않음!
        // 즉, 기존 root에서 탐색하는 거지 root를 새로 생성하지 않음
        // 그리고 이걸 사용하지 않고 바로 root부터 냅다 확인해버리면 root의 직속자식만 확인하고
        // 다음 노드를 돌지 못함. 다음 노드 다음 노드.. 이렇게 갱신되면서 가야하는데 이걸 못한다는 것

        for(char c : prefix.toCharArray()){ // prefix의 문자열 하나하나를 돌면서
            if(!currNode.children.containsKey(c)){ // currNode도
                return false;
            }
            currNode = currNode.children.get(c); // 다음 노드로 현재 노드 갱신
        }
        return true; // 접두사이면 true

    }
}
public class Main {
    static int N,M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 문자열 개수
        M = sc.nextInt(); // 검사해야하는 문자열 수

        Trie trie = new Trie(); // 새로운 Trie 객체 생성
        // 이것 실행시 Trie 내부에서 root = new TrieNode()가 실행됨
        // 즉 trie내부에 root노드가 포함됨 -> 모든 데이터는 이 root부터 시작하는 트리에 저장됨 (모든 단어가 다 수가지 형태로 저장되는거임)

        // 문자열 trie에 삽입
        for(int i = 0; i <N; i++){
            trie.insert(sc.next());
        }

        // 접두사인지 카운트
        int cnt = 0;

        for(int i = 0; i <M; i++){
            if(trie.check(sc.next())){
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}
