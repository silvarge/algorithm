package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Editor1406 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    Stack<Character> left = new Stack<>();
    Stack<Character> right = new Stack<>();

    char[] s = br.readLine().toCharArray();
    for (int i = 0; i < s.length; i++) {
      left.push(s[i]);
    }
    int M = Integer.parseInt(br.readLine());

    String[] input;
    while (M-- > 0) {
      input = br.readLine().split(" ");
      switch (input[0]) {
        case "L":
          if (!left.isEmpty()) {
            right.push(left.pop());
          }
          break;
        case "D":
          if (!right.isEmpty()) {
            left.push(right.pop());
          }
          break;
        case "B":
          if (!left.isEmpty()) {
            left.pop();
          }
          break;
        case "P":
          left.push(input[1].charAt(0));
      }
    }

    while (!right.isEmpty()) {
      sb.append(right.pop());
    }
    sb.reverse();

    while (!left.isEmpty()) {
      sb.append(left.pop());
    }
    sb.reverse();
    System.out.println(sb);
  }


}
