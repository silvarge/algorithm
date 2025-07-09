package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Parenthesis9012 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());

    char[] arr;
    Stack<Character> stack = new Stack<>();
    boolean flag = true;

    for (int i = 0; i < N; i++) {
      arr = br.readLine().toCharArray();
      for (char c : arr) {
        if (c == '(') {
          stack.push(c);
        } else if (c == ')') {
          if (!stack.isEmpty()) {
            stack.pop();
          } else {
            flag = false;
            break;
          }
        }
      }

      if (flag && stack.isEmpty()) {
        sb.append("YES\n");
      } else {
        sb.append("NO\n");
      }

      flag = true;
      stack.clear();
    }

    System.out.println(sb);
  }

}
