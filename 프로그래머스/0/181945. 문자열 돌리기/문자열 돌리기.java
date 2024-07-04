import java.util.Scanner;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String [] arr = str.split("");
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}