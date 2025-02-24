

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N;
    static class Node{ // 노드 클래스 생성
        String value;
        Node left, right;

        Node(String value){
            this.value = value;
        }
    }
    static HashMap<String, Node> tree = new HashMap<>();
    static void preorder(Node node){ // 전위순회
        if(node == null) return;

        System.out.print(node.value); // 루트 출력
        preorder(node.left);
        preorder(node.right);
    }
    static void inorder(Node node){
        if(node == null) return;

        inorder(node.left); // 왼쪽자식
        System.out.print(node.value); // 루트
        inorder(node.right); // 오른쪽자식
    }
    static void postorder(Node node){
        if(node == null) return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i = 0; i <N; i++){
            String p = sc.next();
            String left = sc.next();
            String right = sc.next();

            tree.putIfAbsent(p, new Node(p)); // 부모 노드 생성

            // 1) 왼쪽 자식 추가
            if(!left.equals(".")){ // .이 아니라면
                tree.putIfAbsent(left, new Node(left)); // 자식노드(왼쪽)를 생성하고
                tree.get(p).left = tree.get(left); // 해당 부모노드의 왼쪽자식에 윗줄의 그 노드를 입력
            }
            // 2) 오른쪽 자식 추가
            if(!right.equals(".")){
                tree.putIfAbsent(right, new Node(right));
                tree.get(p).right = tree.get(right);
            }
        }

        Node root = tree.get("A"); // 최상단 루트는 A
        
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);

    }
}
