package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Queue10845 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    Deque<Integer> queue = new LinkedList<>();

    int N = Integer.parseInt(br.readLine());
    String[] operation;
    while (N-- > 0) {
      operation = br.readLine().split(" ");
      switch (operation[0]) {
        case "push": queue.offerFirst(Integer.parseInt(operation[1])); break;
        case "pop": sb.append(queue.peekLast() == null ? -1 : queue.pollLast()).append("\n"); break;
        case "size": sb.append(queue.size()).append("\n"); break;
        case "empty": sb.append(queue.isEmpty() ? 1 : 0).append("\n"); break;
        case "front": sb.append(queue.peekLast() == null ? -1 : queue.peekLast()).append("\n"); break;
        case "back": sb.append(queue.peekFirst() == null ? -1 : queue.peekFirst()).append("\n"); break;
      }
    }
    System.out.println(sb);
  }

}
