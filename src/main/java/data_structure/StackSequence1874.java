package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackSequence1874 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());

    Stack<Integer> stack = new Stack<>();

    int target;
    int lastPushed = 0;
    while (N-- > 0) {
      target = Integer.parseInt(br.readLine());

      while (lastPushed < target) {
        lastPushed++;
        stack.push(lastPushed);
        sb.append("+\n");
      }

      if (stack.peek() == target) {
        stack.pop();
        sb.append("-\n");
      } else {
        System.out.println("NO");
        return;
      }

    }
    System.out.println(sb);
  }

}
