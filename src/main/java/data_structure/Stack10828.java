package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stack10828 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());

    Stack<Integer> stack = new Stack<>();

    String[] operation;
    while (N-- > 0) {
      operation = br.readLine().split(" ");
      switch (operation[0]) {
        case "push": stack.push(Integer.parseInt(operation[1])); break;
        case "pop": sb.append(stack.empty() ? -1 : stack.pop()).append("\n"); break;
        case "top": sb.append(stack.empty() ? -1 : stack.peek()).append("\n"); break;
        case "size": sb.append(stack.size()).append("\n"); break;
        case "empty": sb.append(stack.empty() ? 1 : 0).append("\n"); break;
      }
    }
    System.out.println(sb);
  }

}
