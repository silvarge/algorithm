package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BalancedWorld4949 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    Stack<Character> stack;

    boolean isBalanced;
    String s = "";

    while (true) {
      s = br.readLine();
      isBalanced = true;
      if (s.equals(".")) break;

      stack = new Stack<>();

      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);

        if(c == '(' || c == '[') {
          stack.push(c);
        } else if(c == ')') {
          if(stack.isEmpty() || stack.peek() != '(') {
            isBalanced = false;
          }else {
            stack.pop();
          }
        } else if(c == ']') {
          if(stack.isEmpty() || stack.peek() != '[') {
            isBalanced = false;
          }else {
            stack.pop();
          }
        }
      }

      if (isBalanced && stack.isEmpty()) {
        sb.append("yes\n");
      } else {
        sb.append("no\n");
      }
    }
    System.out.println(sb);
  }
}
